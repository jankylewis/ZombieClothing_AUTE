package com.zombieclothing.testCases;

import java.util.Random;

import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.LogOutPage;
import com.zombieclothing.utilities.ReadConfig;

public class TCs_LogOut extends BaseClass{

	ReadConfig readconfig= new ReadConfig();
	
	@Var
	private String browserArr[]= {"opera", "chrome", "firefox"};
	private String brRandom= browserArr[new Random().nextInt(browserArr.length)];
	private String email= "vinhtranak02092k@gmail.com";
	private String password= "Raul123";
	
	@Test(groups= {"001"}, priority= 1)
	
	public void logOutTest1() {
		setUp(readconfig.getApplicationBaseURL()+ "/account/", brRandom);
		log.info("URL is triggered \r\r");
		
		LogOutPage lp= new LogOutPage(driver);
		lp.setUserEmail(email);
		log.info("Entered user email successfully \r\r");
		
		lp.setPassword(password);
		log.info("Entered user password successfully \r\r");
		
		lp.clickSubmit();
		log.info("Clicked login button successfully \r\r");
		
		lp.performLnkLogoutMouseHover();
		log.info("Hovered logout link successfully \r\r");
		log.info("Test case 001 is passed! \r\r");	
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"002"}, priority= 1)
	
	public void logOutTest2() {
		setUp(readconfig.getApplicationBaseURL()+ "/account/", brRandom);
		log.info("URL is triggered \r\r");
		
		LogOutPage lp= new LogOutPage(driver);
		lp.setUserEmail(email);
		log.info("Entered user email successfully \r\r");
		
		lp.setPassword(password);
		log.info("Entered user password successfully \r\r");
		
		lp.clickSubmit();
		log.info("Clicked login button successfully \r\r");
		
		lp.clickLogout();
		log.info("Clicked login button successfully \r\r");
		
		if (lp.checkIfImageIsPresent()==true) {
			log.info("Being navigated to Login page successfully! \r\r");
			log.info("Test case 002 is passed! \r\r");
		}
		else {
			log.error("Test case 002 is failed because of malfunction! \r\r");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
}

