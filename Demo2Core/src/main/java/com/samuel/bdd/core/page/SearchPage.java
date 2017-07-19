package com.samuel.bdd.core.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.samuel.bdd.base.frame.CommonPage;

public class SearchPage extends CommonPage {

	public static final String PRODUCT_LIST_CSS = ".product-listing.product-list.grid-view .product-item";
	@FindBy(css = PRODUCT_LIST_CSS)
	private List<WebElement> productList;

	public static final String PRODUCT_ITEM_PROID_CSS = "p.proID span";
	public static final String PRODUCT_ITEM_PROTITLE_CSS = "a.proTitle";

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

	public String getProductNmaeById(String product) {
		WebElement productElement = getProductById(product);
		WebElement proTitleElement = productElement.findElement(By.cssSelector(PRODUCT_ITEM_PROTITLE_CSS));
//		WebElement proTitleElement = myDriver.findElement(By.cssSelector(".product-listing.product-list.grid-view .product-item a.proTitle"));
		return proTitleElement.getText();
	}

}
