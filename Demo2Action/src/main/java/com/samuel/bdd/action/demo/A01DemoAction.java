package com.samuel.bdd.action.demo;

import org.junit.Assert;

import com.samuel.bdd.core.component.RegisterBannerComponent;
import com.samuel.bdd.core.page.HomePage;
import com.samuel.bdd.core.page.SearchPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class A01DemoAction {

	@Given("Open the home page.")
	public void openHomePage() {
		HomePage.open();
	}

	@And("Close the register banner.")
	public void closeRegisterBanner() {
		RegisterBannerComponent registerBannerComponent = new RegisterBannerComponent();
		registerBannerComponent.closeRegisterBanner();
	}

	@And("Search one product. \"(.*)\"")
	public void searchProduct(String product) {
		HomePage homePage = new HomePage();
		homePage.getHeaderComponent().searchProduct(product);
	}

	@Then("The product is display on search page. \"(.*)\", \"(.*)\"")
	public void showProduct(String product, String productName) {

		SearchPage searchPage = new SearchPage();
		String value = searchPage.getProductNmaeById(product);

		Assert.assertTrue(productName.equals(value));
	}

}
