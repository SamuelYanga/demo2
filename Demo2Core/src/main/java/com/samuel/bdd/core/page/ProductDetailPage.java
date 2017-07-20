package com.samuel.bdd.core.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.samuel.bdd.base.frame.BasePage;

public class ProductDetailPage extends BasePage {

	// productImgBox
	public static final String PRODUCT_IMG_CSS = ".productImgBox";
	@FindBy(css = PRODUCT_IMG_CSS)
	private WebElement productImage;

	// .product-info .product-head .name span
	public static final String PRODUCT_NAME_CSS = ".product-info .product-head .name span";
	@FindBy(css = PRODUCT_NAME_CSS)
	private WebElement productName;

	//
	public static final String PRODUCT_PRICE_CSS = ".product-info .psection .direct-price .price";
	@FindBy(css = PRODUCT_PRICE_CSS)
	private WebElement productPrice;

	// .addToCartComp .js-qty-selector-input
	public static final String PRODUCT_SIZE_CSS = ".addToCartComp .js-qty-selector-input";
	@FindBy(css = PRODUCT_SIZE_CSS)
	private WebElement productSize;

	//
	public static final String RELATED_PRODUCT_LIST_CSS = ".addToCartComp .js-qty-selector-input";
	@FindBy(css = RELATED_PRODUCT_LIST_CSS)
	private List<WebElement> relatedProductList;

	public boolean checkProductDetailIsDisplayed() {
		return productImage.isDisplayed() && productName.isDisplayed() && productPrice.isDisplayed()
				&& productSize.isDisplayed() && relatedProductList != null && relatedProductList.size() > 0;
	}

}
