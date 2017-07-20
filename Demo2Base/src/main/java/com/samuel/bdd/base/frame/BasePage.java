package com.samuel.bdd.base.frame;

import com.samuel.bdd.base.Configurations;
import com.samuel.bdd.base.Constants;
import com.samuel.bdd.base.browser.MyDriver;
import com.samuel.bdd.base.browser.DriverFactory;
import com.samuel.bdd.base.wait.MyElementLocatorFactory;
import com.samuel.bdd.base.wait.WaitUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BasePage {

	protected MyDriver myDriver;

	public final static String TARGET_URL = Configurations.getConfiguration(Constants.SELENIUM_TARGETURL);

	public BasePage() {
		this.myDriver = DriverFactory.getBrowser();
		waitPageLoadIdentifier();
		PageFactory.initElements(new MyElementLocatorFactory(myDriver), this);
	}

	private void waitPageLoadIdentifier() {
		WaitUtil.waitOn(myDriver).untilPageDown();
		List<String> pageIdentitfierList = getLoadIdentifier();
		for (String pageIdentitfier : pageIdentitfierList) {
			WaitUtil.waitOn(this.myDriver).untilAdded(By.id(pageIdentitfier));
		}
	}

	protected List<String> getLoadIdentifier() {
		return Collections.emptyList();
	}

	public void scrollMoveToElement(WebElement we) {
		scrollToTop();
		int y = we.getLocation().getY();
		String script = "return screen.availHeight;";
		Object obj = myDriver.executeScript(script);
		int screenAvailHeight = Integer.valueOf(obj.toString());
		int move = y - (screenAvailHeight / 3);

		if (move <= 0) {
			move = 1;
		}
		windowScrollToTop(move);
	}

	public void scrollToTop() {
		windowScrollToTop(1);
	}

	private void windowScrollToTop(int move) {
		String setscroll = "$(window).scrollTop(" + move + ");";
		myDriver.executeScript(setscroll);
	}

	public String currentHandle;

	public boolean switchToWindowByUrl(String windowUrl) {
		boolean flag = false;
		try {
			currentHandle = myDriver.getWindowHandle();
			Set<String> handles = myDriver.getWindowHandles();
			for (String s : handles) {
				if (isCurrentUrl(windowUrl)) {
					flag = true;
					break;
				}

				if (s.equals(currentHandle)) {
					continue;
				} else {
					myDriver.switchTo().window(s);
					if (isCurrentUrl(windowUrl)) {
						flag = true;
						break;
					} else
						continue;
				}
			}
		} catch (NoSuchWindowException e) {
			flag = false;
		}
		return flag;
	}

	private boolean isCurrentUrl(String windowUrl) {
		String currentUrl = myDriver.getCurrentUrl();
		if (currentUrl.contains("?")) {
			currentUrl = currentUrl.substring(0, currentUrl.indexOf("?"));
		}
		return currentUrl.endsWith(windowUrl);
	}

	public boolean closeCurrentWindow() {
		String currentUrl = myDriver.getCurrentUrl();
		currentUrl = currentUrl.substring(currentUrl.lastIndexOf("/"));
		return closeWindowByUrl(currentUrl);
	}

	public boolean closeWindowByUrl(String windowUrl) {
		if (switchToWindowByUrl(windowUrl)) {
			myDriver.close();
			Set<String> handles = myDriver.getWindowHandles();
			myDriver.switchTo().window(handles.iterator().next());
			return true;
		}
		return false;
	}

	public void switchToIframe(String framId) {
		if (framId == null) {
			myDriver.switchTo().defaultContent();
		} else {
			myDriver.switchTo().frame(framId);
		}
	}

	public void refreshPage() {
		myDriver.navigate().refresh();
	}
}
