package com.samuel.bdd.core.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.samuel.bdd.base.Configurations;
import com.samuel.bdd.base.Constants;
import com.samuel.bdd.base.browser.DriverFactory;
import com.samuel.bdd.base.browser.MyDriver;
import com.samuel.bdd.base.frame.CommonPage;

public class HomePage extends CommonPage {

	private final static Logger LOGGER = Logger.getLogger(HomePage.class);

	//js-site-search-input
	public static final String SEARCH_INPUT_ID = "js-site-search-input";
	@FindBy(id = SEARCH_INPUT_ID)
	private WebElement searchInput;
	
	//js-site-search-input
	public static final String SEARCH_BUTTON_CSS = ".input-group-btn .btn-link";
	@FindBy(css = SEARCH_BUTTON_CSS)
	private WebElement search;
	

	public static HomePage open() {
		MyDriver browser = DriverFactory.getBrowser();
		LOGGER.info("#############HomePage.openHomePage start.");
		browser.get(Configurations.getConfiguration(Constants.SELENIUM_TARGETURL));
		browser.skipSSLValidation();
		browser.switchToAlert();
		browser.manage().window().maximize();
		return new HomePage();
	}
	
	public void searchProduct(String product) {
		searchInput.clear();
		searchInput.sendKeys(product);
		search.click();
	}

}
