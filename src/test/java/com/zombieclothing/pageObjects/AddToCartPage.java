package com.zombieclothing.pageObjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.Builder.Default;

public class AddToCartPage {
	
	
	public Actions action;
	public WebDriverWait wait;
	public WebElement element;
//	public JavascriptExecutor js;
	public Alert alert;
	
	
	@Default
	WebDriver ldriver;
	JavascriptExecutor js= (JavascriptExecutor) ldriver;
	public AddToCartPage(WebDriver rdriver) {
		
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		action= new Actions(rdriver);
		wait= new WebDriverWait(rdriver, 50);
		
	}
	//table[@id="cart-view"]//p[@class="pro-title"]//a
	@FindBy(xpath= "//div[contains(normalize-space(@class),\"block-banner-category\")]//img[contains(normalize-space(@class),\"lazyautosizes ls-is-cached lazyloaded\")]")
	@CacheLookup
	WebElement LBL_CHILDREN_PRODUCTS_BANNER_LOCATOR;
	
	@FindBy(xpath= "//div[contains(@class,\"banner\")][1]//div[@class=\"owl-stage-outer\"]//child::div[@class=\"owl-stage\"]")
	@CacheLookup
	WebElement IMG_FOREFATHER_PRODUCTS_BANNER_LOCATOR;
	
	@FindBy(xpath= "//button[@type=\"button\" and @id=\"add-to-cart\"]")
	@CacheLookup
	WebElement BTN_ADD_TO_CART_LOCATOR;
	
	@FindBy(xpath= "//div[@class=\"cart-view-total\"]//a[contains(@class, \"cart\")]")
	@CacheLookup
	WebElement BTN_LINK_TO_CART_LOCATOR;
	
	@FindBy(xpath= "//*[name()=\"svg\" and @fill=\"none\"]")
	@CacheLookup
	WebElement BTN_CLOSE_POPUP_LOCATOR;
	
	@FindBy(xpath= "//div[@class=\"owl-nav\"][1]//button[@class=\"owl-prev\"]")
	@CacheLookup
	WebElement BTN_PREVIOUS_BUTTON_LOCATOR;
	
	public void pauseWithTryCatch(int timeSecond) {
		try {
			Thread.sleep(timeSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void executeScrollingDown(WebDriver dr, JavascriptExecutor js, int scrollUnit) {
		((JavascriptExecutor)dr).executeScript("scroll(0,"+scrollUnit+")");
	}
	
	public void clickOnProductByText(String productName, WebDriver dr, JavascriptExecutor js, int scrollUnit) {
		WebElement listProductElement= dr.findElement(By.xpath("//div[@class=\"clearfix content-product-list\"]"));
		List<WebElement> childProductElements= listProductElement.findElements(By.xpath("//div[@class=\"box-pro-detail\"]//h3//following-sibling::a"));
		for (int index=0; index< childProductElements.size(); index++) {
			if (childProductElements.get(index).getText().equals(productName)) {
				((JavascriptExecutor)dr).executeScript("scroll(0,"+scrollUnit+")");
				action.moveToElement(childProductElements.get(index)).click().perform();
				break;
			}
		}
	}
	
	public void clickOnDesiredButton(WebDriver dr, String desiredLocator) {
		
		WebElement desiredLocated= dr.findElement(By.xpath(desiredLocator));
		
		if (desiredLocated.isDisplayed()==true || desiredLocated.isEnabled()==true) {
			
			dr.findElement(By.xpath("//body")).sendKeys(Keys.F5);
			action.moveToElement(desiredLocated).click().perform();
			
		}
	}
	
	public void clickOnClosePopupButton(WebDriver dr) {
		
		dr.findElement(By.xpath("//body")).sendKeys(Keys.F5);
		if (BTN_CLOSE_POPUP_LOCATOR.isDisplayed()==true) {
			System.out.println("AB");
		}
		action.moveToElement(BTN_CLOSE_POPUP_LOCATOR).click().perform();
	}
}
