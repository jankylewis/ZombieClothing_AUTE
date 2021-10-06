package com.zombieclothing.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Builder.Default;

public class SignUpPage {
	
	@Default
	WebDriver ldriver;
	public SignUpPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
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
	
	public void setMaleGender(String str, WebDriver dr) {
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
}
