package com.samuel.bdd.core.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.samuel.bdd.base.frame.BasePage;

public class HeaderComponent extends BasePage {

	// search input
	public static final String SEARCH_INPUT_ID = "js-site-search-input";
	@FindBy(id = SEARCH_INPUT_ID)
	private WebElement searchInput;

	// search button
	public static final String SEARCH_BUTTON_CSS = ".input-group-btn .btn-link";
	@FindBy(css = SEARCH_BUTTON_CSS)
	private WebElement search;

	/**
	 * search a product by id
	 * @param product
	 */
	public void searchProduct(String product) {
		searchInput.clear();
		searchInput.sendKeys(product);
		search.click();
	}

}
