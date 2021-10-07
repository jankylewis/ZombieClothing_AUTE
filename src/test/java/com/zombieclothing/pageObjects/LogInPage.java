package com.zombieclothing.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.Builder.Default;

public class LogInPage {
	
	public Actions action;
	public WebDriverWait wait;
	
	@Default
	WebDriver ldriver;
	public LogInPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		action= new Actions(rdriver);
		//time=>second
		wait= new WebDriverWait(rdriver, 50);
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
	
	@FindBy(xpath = "//div[@aria-label=\"close\"]//following::div[@data-visualcompletion=\"ignore\"]")
	@CacheLookup
	WebElement BTN_CLOSE_CHAT_WITH_ZOMBIE_POPUP;
	
	public boolean closeChatWithZombiePopup() {
		if (BTN_CLOSE_CHAT_WITH_ZOMBIE_POPUP.isDisplayed()==true || BTN_CLOSE_CHAT_WITH_ZOMBIE_POPUP.isEnabled()==true) {
			action.moveToElement(BTN_CLOSE_CHAT_WITH_ZOMBIE_POPUP).click().perform();
//			BTN_CLOSE_CHAT_WITH_ZOMBIE_POPUP.click();
			return true;
		}
		else {
			return !true;
		}
	}
	
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
	
	public void clickLogout() {
		LNK_LOGOUT.click();
	}
	
	public void performBtnLoginMouseHover() {
		if (BTN_LOGIN.isDisplayed()==true && BTN_LOGIN.isEnabled()==true) {
			//hover BTN Login
			action.moveToElement(BTN_LOGIN).build().perform();
		}
	}
	
	public boolean isAlertPresent(WebDriver driver, String alertMessageText) {
		//get locator
		WebElement alertMessageLocator= driver.findElement(By.xpath("//form[@id=\"customer_login\"]//div//ul//preceding-sibling::li"));
		System.out.println("//--------//====//--------//\n\n"+ alertMessageLocator.getText()+ "\n\n//--------//====//--------//\n");
		
		if (alertMessageLocator.isDisplayed()==true && alertMessageLocator.getText().equals(alertMessageText)==true) {
			return true;
		}
		else if (alertMessageLocator.isDisplayed()!=true || alertMessageLocator.getText().equals(alertMessageText)!=true){
			return false;
		} return false;
	}
	
	public boolean isEmailAlertPresent(WebDriver driver) {
		try {
			Alert emailAlert= driver.switchTo().alert();
			String emailAlertMessage= driver.switchTo().alert().getText();
			System.out.println("//--------//====//--------//\n\n"+ emailAlertMessage+ "\n\n//--------//====//--------//\n");
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}
	
	public boolean verifyAlertIsPresent(WebDriverWait w) {
		
		if (w.until(ExpectedConditions.alertIsPresent())==null) {
			return false;
		}
		else {
			return true;
		}	
	}

}
