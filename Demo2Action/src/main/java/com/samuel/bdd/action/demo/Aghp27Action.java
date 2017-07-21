package com.samuel.bdd.action.demo;

import org.junit.Assert;

import com.samuel.bdd.core.page.ProductDetailPage;
import com.samuel.bdd.core.page.SearchPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Aghp27Action {

	@And("Navigate to a PDP page as a guest user. \"(.*)\"")
	public void navigateToPdp(String product) {
		SearchPage searchPage = new SearchPage();
		searchPage.navigateToPdp(product);
	}

	@Then("Verify that the following details of a product are displayed to the Guest user on the PDP. \"(.*)\" \"(.*)\"")
	public void checkProductDetail(String productName, String productPrice) {
		ProductDetailPage productDetailPage = new ProductDetailPage();
		Assert.assertTrue(productDetailPage.checkProductName(productName));
		Assert.assertTrue(productDetailPage.checkProductPrice(productPrice));
	}
}
