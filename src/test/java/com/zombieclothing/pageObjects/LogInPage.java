package com.zombieclothing.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Builder.Default;

public class LogInPage {
	
	@Default
	WebDriver ldriver;
	public LogInPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
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
	
}
