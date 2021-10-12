package com.zombieclothing.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import lombok.Builder.Default;

public class HomePageNavigation {
	
	public Actions action;
	public WebDriverWait wait;
	
	@Default
	WebDriver ldriver;
	JavascriptExecutor js= (JavascriptExecutor) ldriver;
	
	public HomePageNavigation(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		action= new Actions(rdriver);
		wait= new WebDriverWait(rdriver, 15);
	}
	
	@FindBy(xpath= "//div//nav[@class=\"main-nav text-center\"]//ul//li//child::a[@title=\"Trang chủ\"]")
	@CacheLookup
	WebElement NAV_HOMEPAGE;
	
	@FindBy(xpath= "//div//nav[@class=\"main-nav text-center\"]//ul//li//child::a[@title=\"Blog\"]")
	@CacheLookup
	WebElement NAV_BLOG;
	
	@FindBy(xpath= "//div//nav[@class=\"main-nav text-center\"]//ul//li//child::a[@title=\"Giới thiệu\"]")
	@CacheLookup
	WebElement NAV_ABOUT_US;
	
	public void clickHomePageNav() {
		if (NAV_HOMEPAGE.isDisplayed()==true && NAV_HOMEPAGE.isEnabled()==true) {
			action.moveToElement(NAV_HOMEPAGE).click().perform();
		}
	}
	
	public void clickBlogNav() {
		if (NAV_BLOG.isDisplayed()==true && NAV_BLOG.isEnabled()==true) {
			action.moveToElement(NAV_BLOG).click().perform();
		}
	}
	
	public void clickAboutUsNav() {
		if (NAV_ABOUT_US.isDisplayed()==true && NAV_ABOUT_US.isEnabled()==true) {
			action.moveToElement(NAV_ABOUT_US).click().perform();
		}
	}
	
	public boolean checkIfElementIsDisplayed(String ELEMENT_LOCATOR, WebDriver dr, WebElement we) {
		WebElement LOCATED_ELEMENT_LOCATOR= dr.findElement(By.xpath(ELEMENT_LOCATOR));
		if (LOCATED_ELEMENT_LOCATOR.isDisplayed()==true || LOCATED_ELEMENT_LOCATOR.isEnabled()==true) {
			if (LOCATED_ELEMENT_LOCATOR.getText().isBlank()==false) {
				System.out.println("The text that needs to be asserted: "+ LOCATED_ELEMENT_LOCATOR.getText()+ "\r\r");
			}
			else {
				System.out.println("Element does not has any text to assert! \r\r");
			}
			return true;
		}
		else {
			return false;
		}
	}
}
