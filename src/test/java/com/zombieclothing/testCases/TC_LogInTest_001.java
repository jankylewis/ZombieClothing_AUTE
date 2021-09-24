package com.zombieclothing.testCases;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.LogInPage;
import com.zombieclothing.utilities.ReadConfig;
import freemarker.log.Logger;

public class TC_LogInTest_001 extends BaseClass{
	
	ReadConfig readconfig= new ReadConfig();
	@Var
	public String email= readconfig.getEmail();
	public String password= readconfig.getPassword();
	
	@Test
	public void logInTest() throws IOException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/", "IE");
		log.info("URL is opened\n");
		
		LogInPage lp= new LogInPage(driver);	
		lp.setUserEmail(email);
		log.info("Entered user email successfully\n");
		
		lp.setPassword(password);
		log.info("Entered user password successfully\n");
		
		lp.clickSubmit();
		log.info("Clicked login button successfully\n");
		
		//assertions
		String expEmail= email;
		String actEmail= driver.findElement(By.xpath("//div[@id=\"customer_sidebar\"]//preceding-sibling::p[contains(normalize-space(@class),\"email\")]")).getText();
		log.info("Getting text facilitates asserting\n");
		
		if(actEmail.equals(expEmail)) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---Login test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---Login test case is failed due to an error---*/-----------\n");
		}
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
}
