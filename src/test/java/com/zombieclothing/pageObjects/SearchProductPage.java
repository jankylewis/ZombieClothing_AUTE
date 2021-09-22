package com.zombieclothing.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Builder.Default;

public class SearchProductPage {
	
	@Default
	WebDriver ldriver;
	public SearchProductPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath= "//form[@class=\"search-page\"]//child::input[3][@type =\"text\" ][@class= \"search_box\"]")
	@CacheLookup
	WebElement TXT_SEARCH_PRODUCT;
	
	@FindBy(xpath= "//form[@class=\"search-page\"]//preceding::input[@type= \"submit\"]")
	@CacheLookup
	WebElement BTN_SEARCH_PRODUCT;
	
	public void setSearchProductKey(String searchKey) {
		if (TXT_SEARCH_PRODUCT.isDisplayed()==true) {
			TXT_SEARCH_PRODUCT.clear();
			TXT_SEARCH_PRODUCT.sendKeys(searchKey);
		}
	}
	
	public void clickSpyGlassButton() {
		if (BTN_SEARCH_PRODUCT.isEnabled()==true) {
			BTN_SEARCH_PRODUCT.click();
		}
	}
}
