package com.zombieclothing.pageObjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Builder.Default;

public class SearchProductPage {
	
	@Default
	WebDriver ldriver;
	JavascriptExecutor js= (JavascriptExecutor) ldriver;
	
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
	
	public void executeScrollingDown(WebDriver dr, JavascriptExecutor js, int scrollUnit) {
		((JavascriptExecutor)dr).executeScript("scroll(0,"+scrollUnit+")");
	}
	
	public void pauseWithTryCatch(int timeSecond) {
		try {
			Thread.sleep(timeSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isElementVisible(WebDriver dr, String verifiedLocator) {
	    try {
	        if (dr.findElement(By.xpath(verifiedLocator)).isDisplayed()) {
	            return true;
	        }
	    }
	    catch(Exception e) {       
	        return false;
	    }       
	    return false;
	}
	public void paginationLocator(int index, WebElement ele) {
		WebElement pagXpath= ele.findElement(By.xpath("//div[@id=\'pagination\']//a[contains(normalize-space(),\'"+ (index+2)+ "\')]"));
		pagXpath.click();
	}
	
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
