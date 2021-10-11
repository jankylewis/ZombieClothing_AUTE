package com.zombieclothing.testCases;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.LogInPage;
import com.zombieclothing.utilities.ReadConfig;
import com.zombieclothing.utilities.XLUtils;

import freemarker.debug.EnvironmentSuspendedEvent;
import freemarker.log.Logger;

public class TCs_LogIn extends BaseClass{
	
	ReadConfig readconfig= new ReadConfig();
	@Var
//	public String email= readconfig.getEmail();
//	public String password= readconfig.getPassword();
	
	private String browserArr[]= {"firefox", "chrome", "opera"};
	private String brRandom= browserArr[new Random().nextInt(browserArr.length)];
	
	private String email= "vinhtranak02092k@gmail.com";
	private String password= "Raul123";
	private String alertMessageText= "Thông tin đăng nhập không hợp lệ.";
	private String emailRequiredMessage= "Please fill out this field.";
	private String passwordRequiredMessage= "Please fill out this field.";
	
	private String nonAtDomainEmail= "vinhtranak02092k";
	private String nonDomainEmail= "vinhtranak02092k@";
	private String emailInvalidMessageNonAt= "Please include an '@' in the email address. "+ "'"+ nonAtDomainEmail+ "'"+ " is missing an '@'.";
	private String emailInvalidMessageNon= "Please enter a part following '@'. "+ "'"+ nonDomainEmail+ "'"+ " is incomplete.";
	
	
	@Test(groups= {"001"})
	public void logInTest1() {
		setUp(readconfig.getApplicationBaseURL()+ "/account/", brRandom);
		log.info("URL is opened on web browser\n");
		
		LogInPage lp= new LogInPage(driver);
		lp.performBtnLoginMouseHover();
		
		log.info("Hovered Login button successfully\n");
		log.info("Test case 001 is passed! \n\n");	
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"002"}, priority= 1)
	public void logInTest2() throws IOException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/", brRandom);
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
			log.info("\n\n==>>-----------/*---Test case 002 is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---Test case 002 is failed due to an error---*/-----------\n");
		}
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
		    
	@Test(groups= {"003"})
	public void logInTest3() throws TimeoutException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/", brRandom);
		log.info("URL is opened on "+ brRandom+ " browser\n");
		
		LogInPage lp= new LogInPage(driver);
		lp.leaveEmailBlank();
		log.info("Left Email field blank\n");
		
		lp.setPassword(password);
		log.info("Inputted user password\n");
		
		lp.clickSubmit();
		log.info("Clicked login button\n");
				
		if (lp.checkIfEmailAlertIsExisted(driver, emailRequiredMessage)==true) {
			log.info("Email alert is present \n\n");
			log.info("Asserted alert successfully \n\n");
			log.info("Test case 003 is passed! \n\n");
		}
		else {
			log.warn("Asserted alert unsuccessfully due to the presence of the alert \n\n");
			log.info("Test case 003 is failed! \n\n");
		}

		lp.pauseWithTryCatch(500);
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();		
	}
	
	@Test(groups= {"004"})
	public void logInTest4() throws TimeoutException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/", brRandom);
		log.info("URL is opened on "+ brRandom+ " browser\n");
		
		LogInPage lp= new LogInPage(driver);
		lp.setUserEmail(email);;
		log.info("Inputted user email\n");
		
		lp.leavePasswordBlank();
		log.info("Left Password field blank\n");
		
		lp.clickSubmit();
		log.info("Clicked login button\n");
				
		if (lp.checkIfPasswordAlertIsExisted(driver, passwordRequiredMessage)==true) {
			log.info("Password alert is present \n\n");
			log.info("Asserted alert successfully \n\n");
			log.info("Test case 004 is passed! \n\n");
		}
		else {
			log.warn("Asserted alert unsuccessfully due to the presence of the alert \n\n");
			log.info("Test case 004 is failed! \n\n");
		}

		lp.pauseWithTryCatch(500);
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();		
	}
	
	@Test(groups= {"005"})
	public void logInTest5() throws TimeoutException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/", brRandom);
		log.info("URL is opened on "+ brRandom+ " browser\n");
		
		LogInPage lp= new LogInPage(driver);
		lp.leaveEmailBlank();
		log.info("Left Email field blank\n");
		
		lp.leavePasswordBlank();
		log.info("Left Password field blank\n");
		
		lp.clickSubmit();
		log.info("Clicked login button\n");
		
		lp.pauseWithTryCatch(100);
		if (lp.checkIfPasswordAlertIsExisted(driver, passwordRequiredMessage)==true && lp.checkIfEmailAlertIsExisted(driver, emailRequiredMessage)==true) {
			log.info("Email alert is present \n\n");
			log.info("Password alert is present \n\n");
			log.info("Asserted required alerts successfully \n\n");
			log.info("Test case 005 is passed! \n\n");
		}

		else if (lp.checkIfEmailAlertIsExisted(driver, emailRequiredMessage)!=true && lp.checkIfPasswordAlertIsExisted(driver, passwordRequiredMessage)!=true) {
			log.warn("Asserted alerts unsuccessfully due to the presence of the alert \n\n");
			log.info("Test case 005 is failed! \n\n");
		}

		lp.pauseWithTryCatch(500);
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();		
	}
	
	
	@Test(groups= {"006 => 008"}, dataProvider= "LogInData_1")
	public void logInDDT(String email, String pwd) throws InterruptedException {
		
		System.out.println("//--------//====//--------//"+ brRandom+ "//--------//====//--------//\n");
		setUp(readconfig.getApplicationBaseURL()+ "/account/", brRandom);
		log.info("URL is opened\n");
		
		LogInPage lp= new LogInPage(driver);
		lp.setUserEmail(email);
		log.info("Email provided\n");
		lp.setPassword(pwd);
		log.info("Password provided\n");
		lp.clickSubmit();
		log.info("Clicked log in button\n");
		
		//procrastination in 250 milliseconds
		Thread.sleep(250);
		
		if (lp.isAlertPresent(driver, alertMessageText)==true) {
			log.info("Log in unsuccessfully \n");
			log.warn("Log in test case is passed \n");
//			Assert.assertTrue(false);
		}
		else if (lp.isAlertPresent(driver, alertMessageText)==false){
//			Assert.assertTrue(true);
			log.info("Log in test case is failed\n");
			lp.clickLogout();
			log.info("Logged out successfully\n");
			Thread.sleep(1000);
		}
//		else {
//			tearDown();
//		}
		//repel driver
		tearDown();
	}
				
	@DataProvider(name="LogInData_1")
	public String [][] getData() throws IOException {
		String path= System.getProperty("user.dir")+ "/src/test/java/com/zombieclothing/testData/LogInData_1.xlsx";
		int rownum= XLUtils.getRowCount(path, "LogIn_TestData");
		int colcount= XLUtils.getCellCount(path, "LogIn_TestData", 1);
		String logindata[][]= new String[rownum][colcount];	
		
		for(int i=1; i<= rownum; i++) {
			for (int j=0; j< colcount; j++) {
				//starting from 1
				logindata[i-1][j]= XLUtils.getCellData(path, "LogIn_TestData", i, j);			
			}
		}
		return logindata;
	}
	
	@Test(groups= {"009"})
	public void logInTest9() throws TimeoutException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/", brRandom);
		log.info("URL is opened on "+ brRandom+ " browser\n");
		
		LogInPage lp= new LogInPage(driver);
		lp.setUserEmail(nonAtDomainEmail);
		log.info("Inputted user email \n\n");
		
		lp.setPassword(password);
		log.info("Inputted user password \n\n");
		
		lp.pauseWithTryCatch(500);
		lp.clickSubmit();
		log.info("Clicked login button \n\n");
		lp.pauseWithTryCatch(1000);
				
		if (lp.checkIfEmailInvalidMessageIsExisted(driver, emailInvalidMessageNonAt, nonAtDomainEmail)==true) {
			log.info("Email alert is present \n\n");
			log.info("Asserted alert successfully \n\n");
			log.info("Test case 009 is passed! \n\n");
		}
		else {
			log.warn("Asserted alert unsuccessfully due to the presence of the alert \n\n");
			log.info("Test case 009 is failed! \n\n");
		}

		lp.pauseWithTryCatch(500);
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();		
	}
	
	@Test(groups= {"010"})
	public void logInTest10() throws TimeoutException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/", brRandom);
		log.info("URL is opened on "+ brRandom+ " browser\n");
		
		LogInPage lp= new LogInPage(driver);
		lp.setUserEmail(nonDomainEmail);
		log.info("Inputted user email \n\n");
		
		lp.setPassword(password);
		log.info("Inputted user password \n\n");
		
		lp.pauseWithTryCatch(500);
		lp.clickSubmit();
		log.info("Clicked login button\n\n");
		lp.pauseWithTryCatch(1000);
				
		if (lp.checkIfEmailInvalidMessageIsExisted(driver, emailInvalidMessageNon, nonDomainEmail)==true) {
			log.info("Email alert is present \n\n");
			log.info("Asserted alert successfully \n\n");
			log.info("Test case 010 is passed! \n\n");
		}
		else {
			log.warn("Asserted alert unsuccessfully due to the presence of the alert \n\n");
			log.info("Test case 010 is failed! \n\n");
		}

		lp.pauseWithTryCatch(500);
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();		
	}
	
}
