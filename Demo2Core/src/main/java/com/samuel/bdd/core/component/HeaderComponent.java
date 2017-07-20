package com.samuel.bdd.core.component;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.samuel.bdd.base.frame.BasePage;
import com.samuel.bdd.base.wait.WaitUtil;
import com.samuel.bdd.base.wait.WaitUtil.UntilEvent;;

public class HeaderComponent extends BasePage {

	// search input
	public static final String SEARCH_INPUT_ID = "js-site-search-input";
	@FindBy(id = SEARCH_INPUT_ID)
	private WebElement searchInput;

	// search button
	public static final String SEARCH_BUTTON_CSS = ".input-group-btn .btn-link";
	@FindBy(css = SEARCH_BUTTON_CSS)
	private WebElement search;

	// 1st level menu items
	public static final String LEVEL_1ST_MENU_CSS = ".js-enquire-offcanvas-navigation .js-offcanvas-links.hidden-xs li.auto";
	@FindBy(css = LEVEL_1ST_MENU_CSS)
	private List<WebElement> level1Menus;

	public static final String LEVEL_1ST_MENU_NAME_CSS = "a";

	public static final String LEVEL_2ST_MENU_CSS = ".sub-navigation-section a";

	public void selectLevel2stMenu(String level1stMenuName, String level2stMenuName) {
		final WebElement level2stMenuElement = getLevel2stMenu(level1stMenuName, level2stMenuName);
		level2stMenuElement.click();
	}
	
	private WebElement getLevel2stMenu(String level1stMenuName, String level2stMenuName) {
		WebElement level1stMenuElement = getLevel1stMenu(level1stMenuName);
		List<WebElement> level2Menus = level1stMenuElement.findElements(By.cssSelector(LEVEL_2ST_MENU_CSS));
		for (WebElement element : level2Menus) {
			String nameValue = element.getText();
			if (level2stMenuName.equals(nameValue)) {
				return element;
			}
		}
		return null;
	}

	public void moveToLevel1stMenu(String level1stMenuName) {
		final WebElement level1stMenuElement = getLevel1stMenu(level1stMenuName);
		Actions action = new Actions(myDriver.getDelegate());
		action.moveToElement(level1stMenuElement).perform();

		WaitUtil.waitOn(myDriver, new UntilEvent() {

			@Override
			public boolean excute() {
				String level1stClass = level1stMenuElement.getAttribute("class");
				if (level1stClass.contains("md-show-sub")) {
					return true;
				}
				return false;
			}
		}).untilEventHappened();
	}

	private WebElement getLevel1stMenu(String level1stMenuName) {
		for (WebElement element : level1Menus) {
			WebElement menuNameElement = element.findElement(By.cssSelector(LEVEL_1ST_MENU_NAME_CSS));
			String value = menuNameElement.getText();
			if (level1stMenuName.equals(value)) {
				return element;
			}
		}
		return null;
	}

	/**
	 * search a product by id
	 * 
	 * @param product
	 */
	public void searchProduct(String product) {
		searchInput.clear();
		searchInput.sendKeys(product);
		search.click();
	}

}
