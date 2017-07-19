package com.samuel.bdd.action;

import org.openqa.selenium.OutputType;
import cucumber.api.Scenario;
import cucumber.api.java.After;

import com.samuel.bdd.base.browser.DriverFactory;

public class Hooks {

	@After(order = 11000)
	public void embedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			scenario.write("Current Page URL is " + DriverFactory.getBrowser().getCurrentUrl());
			byte[] screenshot = DriverFactory.getBrowser().getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
	}

	@After(order = 9000)
	public void clearCookies(Scenario scenario) {
		DriverFactory.clearCookies();
	}

}
