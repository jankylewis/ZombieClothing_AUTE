package com.zombieclothing.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Builder.Default;

public class ViewProductPage {

	Actions action;
	
	@Default
	WebDriver ldriver;
	public ViewProductPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		action= new Actions(rdriver);
	}
	
	@FindBy(xpath= "//nav[@class=\"main-nav text-center\"]//preceding-sibling::li[4]//child::a[@title=\"Áo\"]")
	@CacheLookup
	WebElement NAV_AO;
	
	@FindBy(xpath= "//nav[@class=\"main-nav text-center\"]//preceding-sibling::li[1]//ancestor::a[@title=\"Sản phẩm\"]")
	@CacheLookup
	WebElement NAV_TAT_CA_SP;
	
	public void performMouseHoverTatcasp() {
		if (NAV_TAT_CA_SP.isDisplayed()==true) {
			action.moveToElement(NAV_TAT_CA_SP).build().perform();
		}
	}
	
	public void clickAoNavigationLink() {
		if (NAV_AO.isDisplayed()==true) {
			action.moveToElement(NAV_AO).click().perform();
		}
	}
	
}
