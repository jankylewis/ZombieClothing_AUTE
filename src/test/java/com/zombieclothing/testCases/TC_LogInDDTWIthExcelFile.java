package com.zombieclothing.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.zombieclothing.pageObjects.LogInPage;
import com.zombieclothing.utilities.ExcelReader;

public class TC_LogInDDTWIthExcelFile extends BaseClass{
	
	@Test(dataProvider= "LogInData_1")
	public void LogInDDT(String email, String pwd) throws InterruptedException {
		
		setUp(readconfig.getApplicationBaseURL()+ "/account/", "chrome");
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
		if (isAlertPresent()==true) {
			log.warn("Log in test case is failed");
//			Assert.assertTrue(false);
		}
		else if (isAlertPresent()==false){
//			Assert.assertTrue(true);
			log.info("Log in test case is passed");
			lp.clickLogout();
			log.info("Logged out successfully");
			Thread.sleep(1000);
		}
		//repel driver
		tearDown();
	}
			
	public boolean isAlertPresent() {
		if (driver.findElement(By.xpath("//form[@id=\"customer_login\"]//div//ul//preceding-sibling::li")).isDisplayed()==true) {
			return true;
		}
		else if (driver.findElement(By.xpath("//form[@id=\"customer_login\"]//div//ul//preceding-sibling::li")).isDisplayed()!=true){
			return false;
		}return false;
	}
	
	@DataProvider(name="LogInData_1")
	public String [][] getData() throws IOException {
		String path= System.getProperty("user.dir")+ "/src/test/java/com/zombieclothing/testData/LogInData_1.xlsx";
		int rownum= ExcelReader.getRowCount(path, "LogIn_TestData");
		int colcount= ExcelReader.getCellCount(path, "LogIn_TestData", 1);
		String logindata[][]= new String[rownum][colcount];	
		
		for(int i=1; i<= rownum; i++) {
			for (int j=0; j< colcount; j++) {
				//starting from 1
				logindata[i-1][j]= ExcelReader.getCellData(path, "LogIn_TestData", i, j);
			}
		}
		return logindata;
	}
}
