package com.samuel.bdd.action.demo;

import org.junit.Assert;

import com.samuel.bdd.core.component.HeaderComponent;
import com.samuel.bdd.core.page.HomePage;
import com.samuel.bdd.core.page.SearchPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Aghp26Action {

	@Given("Navigate to the HK website by entering the URL or an embedded link from an external Amway site")
	public void openHomePage() {
		HomePage.open();
	}

	@And("Click on any 2nd level Product Category. \"(.*)\" \"(.*)\"")
	public void click2ndLevelMenu(String level1stMenuName, String level2stMenuName) {
		HeaderComponent HeaderComponent = new HeaderComponent();
		HeaderComponent.moveToLevel1stMenu(level1stMenuName);
		HeaderComponent.selectLevel2stMenu(level1stMenuName, level2stMenuName);
	}

	@Then("Check and verify the available bands for the Price filter. \"(.*)\"")
	public void checkProductPriceInFilter(String priceFilter) {

		SearchPage searchPage = new SearchPage();
		searchPage.selectFilter(priceFilter);
		searchPage = new SearchPage();
		Assert.assertTrue(searchPage.checkProductPriceInFilter(priceFilter));
	}
}
