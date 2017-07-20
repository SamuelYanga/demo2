package com.samuel.bdd.core.page;

import org.apache.log4j.Logger;

import com.samuel.bdd.base.Configurations;
import com.samuel.bdd.base.Constants;
import com.samuel.bdd.base.browser.DriverFactory;
import com.samuel.bdd.base.browser.MyDriver;
import com.samuel.bdd.base.frame.BasePage;
import com.samuel.bdd.core.component.HeaderComponent;

public class HomePage extends BasePage {

	public HomePage() {
		headerComponent = new HeaderComponent();
	}

	private final static Logger LOGGER = Logger.getLogger(HomePage.class);

	private HeaderComponent headerComponent;

	public HeaderComponent getHeaderComponent() {
		return headerComponent;
	}

	public void setHeaderComponent(HeaderComponent headerComponent) {
		this.headerComponent = headerComponent;
	}

	public static HomePage open() {
		MyDriver browser = DriverFactory.getBrowser();
		LOGGER.info("#############HomePage.openHomePage start.");
		browser.get(Configurations.getConfiguration(Constants.SELENIUM_TARGETURL));
		browser.skipSSLValidation();
		// browser.switchToAlert();
		browser.manage().window().maximize();
		return new HomePage();
	}

}
