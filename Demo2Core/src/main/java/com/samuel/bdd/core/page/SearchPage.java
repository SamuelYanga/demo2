package com.samuel.bdd.core.page;

import java.math.BigDecimal;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.samuel.bdd.base.frame.BasePage;
import com.samuel.bdd.base.wait.WaitUtil;

public class SearchPage extends BasePage {

	// product items
	public static final String PRODUCT_LIST_CSS = ".product-listing.product-list.grid-view .product-item";
	@FindBy(css = PRODUCT_LIST_CSS)
	private List<WebElement> productList;

	// product id of one product item
	public static final String PRODUCT_ITEM_PROID_CSS = "p.proID span";

	// product title of one product item
	public static final String PRODUCT_ITEM_PROTITLE_CSS = "a.proTitle";

	// product image of one product item
	public static final String PRODUCT_ITEM_IMG_CSS = "a.proImg";

	// the price of one product item
	public static final String PRODUCT_ITEM_PRICE_CSS = ".proPriceAmt span";

	// filter items
	public static final String FILTER_LIST_CSS = ".facet-checkbox-label";
	@FindBy(css = FILTER_LIST_CSS)
	private List<WebElement> filterList;

	/**
	 * verify the product's price is in the filter bands
	 * @param priceFilter
	 * @return
	 */
	public boolean checkProductPriceInFilter(String priceFilter) {
		String[] priceStrs = priceFilter.split("-");
		BigDecimal minPrice = new BigDecimal(priceStrs[0]);
		BigDecimal maxPrice = new BigDecimal(priceStrs[1]);

		for (WebElement element : productList) {
			WebElement priceElement = element.findElement(By.cssSelector(PRODUCT_ITEM_PRICE_CSS));
			BigDecimal price = new BigDecimal(priceElement.getText().trim());
			if (price.compareTo(minPrice) < 0 || price.compareTo(maxPrice) > 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * click one filter (eg. 300-500)
	 * @param filterName
	 */
	public void selectFilter(String filterName) {
		WebElement filterElement = getFiter(filterName);
		filterElement.click();
		WaitUtil.waitOn(myDriver).untilPageDown();
	}

	private WebElement getFiter(String filterName) {
		for (WebElement element : filterList) {
			String nameValue = element.getText();
			if (filterName.equals(nameValue.trim())) {
				return element;
			}
		}
		return null;
	}

	/**
	 * get product element by product id from the product list
	 * 
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
	 * 
	 * @param product
	 * @return
	 */
	public String getProductNmaeById(String product) {
		WebElement productElement = getProductById(product);
		WebElement proTitleElement = productElement.findElement(By.cssSelector(PRODUCT_ITEM_PROTITLE_CSS));
		return proTitleElement.getText();
	}

	public void navigateToPdp(String product) {
		WebElement productElement = getProductById(product);
		WebElement proImgElement = productElement.findElement(By.cssSelector(PRODUCT_ITEM_IMG_CSS));
		proImgElement.click();
	}

}
