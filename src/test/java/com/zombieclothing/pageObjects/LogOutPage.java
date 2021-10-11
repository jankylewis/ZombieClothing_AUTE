package com.zombieclothing.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Builder.Default;

public class LogOutPage {
	
	public Actions action;
	
	@Default
	WebDriver ldriver;
	public LogOutPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		action= new Actions(rdriver);
	}
	
	@FindBy(xpath= "//form[@id=\"customer_login\"]//div//following-sibling::input[@id=\"customer_email\" and @type and @name=\"customer[email]\"]")
	@CacheLookup
	WebElement TXT_EMAIL;
	
	@FindBy(xpath= "//form[@id=\"customer_login\"]//div//following-sibling::input[@id=\"customer_password\" and @type=\"password\" and @name=\"customer[password]\"]")
	@CacheLookup
	WebElement TXT_PASSWORD;
	
	@FindBy(xpath= "//form[@id=\"customer_login\"]//div//input[@type=\"submit\"]")
	@CacheLookup
	WebElement BTN_LOGIN;
	
	@FindBy(xpath= "//div//following::li[@class=\"last\"]//a")
	@CacheLookup
	WebElement LNK_LOGOUT;
	
	@FindBy(xpath= "//div[@class=\"header-page clearfix\"]//descendant::h1")
	@CacheLookup
	WebElement LBL_LOGIN;
	
	@FindBy(xpath= "//div[normalize-space(@class)=\"item\"]//child::a//child::img")
	@CacheLookup
	WebElement IMG_MAIN;
	
	public void setUserEmail(String email) {
		TXT_EMAIL.clear();
		TXT_EMAIL.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		TXT_PASSWORD.clear();
		TXT_PASSWORD.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		BTN_LOGIN.click();
	}
	
	public void performLnkLogoutMouseHover() {
		if (LNK_LOGOUT.isDisplayed()==true && LNK_LOGOUT.isEnabled()==true) {
			action.moveToElement(LNK_LOGOUT).build().perform();
		}
	}
	
	public void clickLogout() {
		LNK_LOGOUT.click();
	}
	
	public boolean checkIfImageIsPresent() {
		if (IMG_MAIN.isDisplayed()==true && IMG_MAIN.isEnabled()==true) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
