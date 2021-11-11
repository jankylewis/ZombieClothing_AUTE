package com.zombieclothing.pageObjects;

import java.util.List;
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

public class SignUpPage {
	
	public Actions action;
	public WebDriverWait wait;
	
	@Default
	WebDriver ldriver;
	JavascriptExecutor js= (JavascriptExecutor) ldriver;
	
	public SignUpPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		action= new Actions(rdriver);
		wait= new WebDriverWait(rdriver, 20);
	}
	
	@FindBy(xpath= "//form[@id=\"create_customer\"]//following::input[@id=\"last_name\" and @type=\"text\"]")
	@CacheLookup
	WebElement TXT_LASTNAME;
	
	@FindBy(xpath= "//form[@id=\"create_customer\"]//following::input[@id=\"first_name\" and @type=\"text\"]")
	@CacheLookup
	WebElement TXT_FIRSTNAME;
	
//	@FindBy(xpath= "//form[@id=\"create_customer\"]//div//label[@for=\"radio2\"]")
//	@CacheLookup
//	WebElement RDB_MALE;
	
	@FindBy(xpath= "//form[@id=\"create_customer\"]//following::input[@id=\"birthday\" and @type=\"text\"]")
	@CacheLookup
	WebElement TXT_BIRTHDAY;
	
	@FindBy(xpath= "//form[@id=\"create_customer\"]//div//input[@id=\"email\" and @type=\"email\"]")
	@CacheLookup
	WebElement TXT_EMAIL;
	
	@FindBy(xpath= "//form[@id=\"create_customer\"]//div//input[@id=\"password\" and @type=\"password\"]")
	@CacheLookup
	WebElement TXT_PASSWORD;
	
	@FindBy(xpath= "//form[@id=\"create_customer\"]//div//input[@type=\"submit\"]")
	@CacheLookup
	WebElement BTN_REGISTER;
	
	@FindBy(xpath= "//div[@id=\"form-gender\"]//label")
	@CacheLookup
	WebElement RDB_MALE;
	
	@FindBy(xpath= "//div[@class=\"clearfix req_pass\"]//child::a[contains(normalize-space(@class),\"come-back\")]")
	@CacheLookup
	WebElement LNK_COME_BACK_HOMEPAGE;
	
	@FindBy(xpath= "//div[normalize-space(@class)=\"item\"]//child::a//child::img")
	@CacheLookup
	WebElement IMG_MAIN;
	
//	@FindBy(xpath= "//input[@type=\"radio\"]")
//	@CacheLookup
//	WebElement CHILD_RDB_MALE;
	
	public void setLastName(String lastName) {
		TXT_LASTNAME.clear();
		TXT_LASTNAME.sendKeys(lastName);
	}
	
	public void setFirstName(String firstName) {
		TXT_FIRSTNAME.clear();
		TXT_FIRSTNAME.sendKeys(firstName);
	}
	
	public void setGender() {
		if (RDB_MALE.isSelected()==false) {
			RDB_MALE.click();
		}
	}
	
	public void clickComeBackHomePage() {
		if (LNK_COME_BACK_HOMEPAGE.isDisplayed()==true && LNK_COME_BACK_HOMEPAGE.isEnabled()==true) {
			action.moveToElement(LNK_COME_BACK_HOMEPAGE).click().perform();
		}
	}
	
	public boolean checkIfImageIsPresent() {
		if (IMG_MAIN.isDisplayed()==true && IMG_MAIN.isEnabled()==true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void selectGender(String str, WebDriver dr) {
		WebElement listElement= dr.findElement(By.xpath("//div[@id=\"form-gender\"]"));
		List<WebElement> childGenderElements= listElement.findElements(By.xpath("//div[@id=\"form-gender\"]//descendant::*[(contains(normalize-space(@for),\"radio\"))]"));
		for (int index=0; index< childGenderElements.size(); index++) {
//			System.out.println(dr.findElement(By.xpath("//div[@id=\"form-gender\"]//descendant::*[(contains(normalize-space(@for),\"radio2\"))]")).getText());
			if (childGenderElements.get(index).getText().equals(str)) {
				childGenderElements.get(index).click();
				break;
			}
		}
	}
	
	public boolean checkIfFieldRequiredAlertIsPresent(WebDriver dr, String strFieldRequiredMessage, String TXT_REQUIRED_LOCATOR, String field) {
		String fieldRequiredMessage= dr.findElement(By.xpath(TXT_REQUIRED_LOCATOR)).getAttribute("validationMessage");
		if (fieldRequiredMessage.isEmpty()!=true && fieldRequiredMessage.equals(strFieldRequiredMessage)==true) {
			System.out.println("The required message of "+ field+ " field is: "+ fieldRequiredMessage+ "\n\n");
			return true;
		}
		else {
			return !true;
		}
	}

	public boolean checkRequiredMessageWithJSON(WebDriver dr,
		String requiredMessage,
			By TXT_REQUIRED_LOCATOR,
				String field) {
		String fieldRequiredMessage= dr.findElement(TXT_REQUIRED_LOCATOR).getAttribute("validationMessage");
		if (fieldRequiredMessage.isEmpty()!=true && fieldRequiredMessage.equals(requiredMessage)==true) {
			System.out.println("\nThe required message of "+ field+ " field is: "+ fieldRequiredMessage+ "\n\n");
			return true;
		}
		else {
			return !true;
		}
	}
	
	public boolean checkIfErrorMessageIsAppeared(String REQUIRED_LBL_ERROR_LOCATOR, String REQUIRED_ERROR_MESSAGE, WebDriver dr) {
		String errorMessage= dr.findElement(By.xpath(REQUIRED_LBL_ERROR_LOCATOR)).getText();
		if (dr.findElement(By.xpath(REQUIRED_LBL_ERROR_LOCATOR)).isDisplayed()==true && errorMessage.equals(REQUIRED_ERROR_MESSAGE)==true) {
			System.out.println("The error message is: "+ errorMessage+ "\r\r");
			return !false;
		}
		else {
			return false;
		}
	}
	
	public void executeScrollingDown(WebDriver dr, JavascriptExecutor js, int scrollUnit) {
		((JavascriptExecutor)dr).executeScript("scroll(0,"+scrollUnit+")");
	}
	
	public void setBirthday(String birthday) {
		TXT_BIRTHDAY.clear();
		TXT_BIRTHDAY.sendKeys(birthday);
	}
	
	public void setEmail(String email) {
		TXT_EMAIL.clear();
		TXT_EMAIL.sendKeys(email);
	}
	
	public void setPassword(String password) {
		TXT_PASSWORD.clear();
		TXT_PASSWORD.sendKeys(password);
	}
	
	public void clickRegister() {
		BTN_REGISTER.click();
	}
	
	public void pauseWithTryCatch(int timeSecond) {
		try {
			Thread.sleep(timeSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
