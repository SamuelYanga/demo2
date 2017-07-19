package com.samuel.bdd.core.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.samuel.bdd.base.frame.CommonPage;
import com.samuel.bdd.base.wait.WaitUtil;

public class RegisterBannerComponent extends CommonPage {

	// register-banner
	public static final String REGISTER_BANNER_CLOSE_ID = "close";
	@FindBy(id = REGISTER_BANNER_CLOSE_ID)
	private WebElement registerBannerClose;

	public void closeRegisterBanner() {
		registerBannerClose.click();
		WaitUtil.waitOn(myDriver).untilHidden(By.id(REGISTER_BANNER_CLOSE_ID));
	}

}
