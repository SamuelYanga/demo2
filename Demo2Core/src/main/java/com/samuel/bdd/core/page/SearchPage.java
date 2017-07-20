package com.samuel.bdd.core.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.samuel.bdd.base.frame.BasePage;

public class SearchPage extends BasePage {

	// product items
	public static final String PRODUCT_LIST_CSS = ".product-listing.product-list.grid-view .product-item";
	@FindBy(css = PRODUCT_LIST_CSS)
	private List<WebElement> productList;

	// product id of one product item
	public static final String PRODUCT_ITEM_PROID_CSS = "p.proID span";

	// product title of one product item
	public static final String PRODUCT_ITEM_PROTITLE_CSS = "a.proTitle";

	/**
	 * get product element by product id from the product list
	 * @param product
	 * @return
	 */
	private WebElement getProductById(String product) {
		for (WebElement element : productList) {
			WebElement proIdElement = element.findElement(By.cssSelector(PRODUCT_ITEM_PROID_CSS));
			String value = proIdElement.getText();
			if (product.equals(value.trim())) {
				return element;
			}
		}
		return null;
	}

	/**
	 * get the title of product by id
	 * @param product
	 * @return
	 */
	public String getProductNmaeById(String product) {
		WebElement productElement = getProductById(product);
		WebElement proTitleElement = productElement.findElement(By.cssSelector(PRODUCT_ITEM_PROTITLE_CSS));
		return proTitleElement.getText();
	}

}
