package com.zombieclothing.testCases;

import java.io.IOException;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.LogInPage;
import com.zombieclothing.utilities.ReadConfig;
import com.zombieclothing.utilities.XLUtils;
import freemarker.log.Logger;

public class TCs_LogInTest extends BaseClass{
	
	ReadConfig readconfig= new ReadConfig();
	@Var
//	public String email= readconfig.getEmail();
//	public String password= readconfig.getPassword();
	
	private String browserArr[]= {"firefox", "chrome", "opera"};
	private String brRandom= browserArr[new Random().nextInt(browserArr.length)];
	
	private String email= "vinhtranak02092k@gmail.com";
	private String password= "Raul123";
	private String alertMessageText= "Thông tin đăng nhập không hợp lệ.";
	
	@Test(groups= {"001"})
	public void logInTest1() {
		setUp(readconfig.getApplicationBaseURL()+ "/account/", brRandom);
		log.info("URL is opened on web browser\n");
		
		LogInPage lp= new LogInPage(driver);
		lp.performBtnLoginMouseHover();
		
		log.info("Hovered Login button successfully\n");		
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
	
	@Test(groups= {"003"})
	public void logInTest3() {
		setUp(readconfig.getApplicationBaseURL()+ "/account/", brRandom);
		log.info("URL is opened on "+ brRandom+ " browser\n");
		
		LogInPage lp= new LogInPage(driver);
		lp.setPassword(password);
		log.info("Inputted user password\n");
		
		lp.clickSubmit();
		log.info("Clicked login button\n");
		
		boolean alertMessage= driver.getPageSource().contains("Please fill out this field.");
		if (alertMessage==true) {
			log.info("Asserted message successfully\n");
		}
		else if (alertMessage!=true){
			log.info("Asserted message unsuccessfully\n");
		}
		
//		WebDriverWait w = new WebDriverWait(driver, 5);
//		if (lp.verifyAlertIsPresent(w)==true) {
//			System.out.println("Alert is present!");
//		}
//		else if (lp.verifyAlertIsPresent(w)!=true) {
//			System.out.println("Alert is absent!");
//		}
		
//		if (lp.closeChatWithZombiePopup()==true) {
//			log.info("Closed the chat with zombie popup\n");
//		}
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
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
			log.warn("Log in test case is failed\n");
//			Assert.assertTrue(false);
		}
		else if (lp.isAlertPresent(driver, alertMessageText)==false){
//			Assert.assertTrue(true);
			log.info("Log in test case is passed\n");
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
}
