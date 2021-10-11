package com.zombieclothing.testCases;

import java.io.IOException;
import java.util.Random;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.SignUpPage;
import com.zombieclothing.utilities.ReadConfig;

public class TCs_SignUp extends BaseClass{
	
	ReadConfig readconfig= new ReadConfig();
	@Var
//	public String lastName= readconfig.getLastName();
//	public String firstName= readconfig.getFirstName();
//	public String birthday= readconfig.getBirthday();
//	public String email= readconfig.getLocalPart()+ String.valueOf(randomNum)+ readconfig.getDomainPart();
//	public String password= readconfig.getPassword();
//	protected String expFullName= lastName+ " "+ firstName;
//	protected String expEmail= email;
	
	private int randomNum= new Random().nextInt(50000);
	private String browserArr[]= {"firefox", "chrome", "opera"};
	private String brRandom= browserArr[new Random().nextInt(browserArr.length)];
	
	private String lastName= "Tran";
	private String firstName= "Vinh";
	private String birthday= "2/9/2000";
	private String email= "vinhtranak02092k"+ String.valueOf(randomNum)+ "@gmail.com";
	private String password= "Raul123";
	
	private String expFullName= lastName+ " "+ firstName;
	private String expEmail= email;
	
	private String lastNameRequiredMessage= "Please fill out this field.";
	private String firstNameRequiredMessage= "Please fill out this field.";
	private String emailRequiredMessage= "Please fill out this field.";
	private String passwordRequiredMessage= "Please fill out this field.";
	
	private String TXT_LAST_NAME_LOCATOR= "//div[@id=\"form-last_name\"]//descendant::input[@id=\"last_name\" and @class]";
	private String TXT_FIRST_NAME_LOCATOR= "//div[@id=\"form-first_name\"]//child::input[@id=\"first_name\" and @class]";
	private String TXT_EMAIL_LOCATOR= "//div[@id=\"form-email\"]//following::input[@id=\"email\" and @type=\"email\"]";
	private String TXT_PASSWORD_LOCATOR= "//div[@id=\"form-password\"]//following::input[1][@id=\"password\" or @type=\"password\"]";
	private String LBL_ACT_FULL_NAME_LOCATOR= "//div[@id=\"customer_sidebar\"]//following::h2[@class=\"name_account\"]";
	private String LBL_ACT_EMAIL_LOCATOR= "//div[@id=\"customer_sidebar\"]//following::p[contains(normalize-space(@class),\"email\")]";
	
	@Test (groups= {"001"})
	public void signUpTest1() throws IOException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/register/", brRandom);
		log.info("Register page is opened on browser \r\r");
		
		SignUpPage su= new SignUpPage(driver);
		su.setLastName(lastName);
		log.info("Inputted last name successfully \r\r");
		
		su.setFirstName(firstName);
		log.info("Inputted first name successfully \r\r");
		
		su.selectGender("Nam", driver);
		log.info("Selected gender successfully \r\r");
		
		su.setBirthday(birthday);
		log.info("Inputted birthday successfully \r\r");
		
		su.setEmail(email);
		log.info("Inputted email successfully \r\r");
		
		su.setPassword(password);
		log.info("Inputted password successfully \r\r");
		
		su.executeScrollingDown(driver, javascript, 300);
		su.pauseWithTryCatch(500);
		su.clickRegister();
		log.info("Clicked register button successfully \r\r");
		
		//assertions
		String actFullName= driver.findElement(By.xpath(LBL_ACT_FULL_NAME_LOCATOR)).getText();
		String actEmail= driver.findElement(By.xpath(LBL_ACT_EMAIL_LOCATOR)).getText();
		log.info("Getting text facilitates assertion");
		
		System.out.println("\n"+ actFullName+ "\n");
		System.out.println(actEmail+ "\n");
		
		if (actFullName.equals(expFullName) && actEmail.equals(expEmail)) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---Sign up test case is passed---*/-----------\n");
		}
		else {
			Assert.assertTrue(false);
			log.error("\n\n==>>-----------/*---Sign up test case is failed---*/-----------\n");
		}
		
		su.pauseWithTryCatch(1500);
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}

	@Test (groups= {"002"})
	public void signUpTest2() throws IOException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/register/", brRandom);
		log.info("Register page is opened on browser \r\r");
		
		SignUpPage su= new SignUpPage(driver);
		su.setLastName(lastName);
		log.info("Inputted last name successfully \r\r");
		
		su.setFirstName(firstName);
		log.info("Inputted first name successfully \r\r");
		
//		su.selectGender("Nam", driver);
		log.info("Skipped selecting gender successfully \r\r");
		
		su.setBirthday(birthday);
		log.info("Inputted birthday successfully \r\r");
		
		su.setEmail(email);
		log.info("Inputted email successfully \r\r");
		
		su.setPassword(password);
		log.info("Inputted password successfully \r\r");
		
		su.executeScrollingDown(driver, javascript, 300);
		su.pauseWithTryCatch(500);
		su.clickRegister();
		log.info("Clicked register button successfully \r\r");
		
		//assertions
		String actFullName= driver.findElement(By.xpath(LBL_ACT_FULL_NAME_LOCATOR)).getText();
		String actEmail= driver.findElement(By.xpath(LBL_ACT_EMAIL_LOCATOR)).getText();
		log.info("Getting text facilitates assertion");
		
		System.out.println("\n"+ actFullName+ "\n");
		System.out.println(actEmail+ "\n");
		
		if (actFullName.equals(expFullName) && actEmail.equals(expEmail)) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---Sign up test case is passed---*/-----------\n");
		}
		else {
			Assert.assertTrue(false);
			log.error("\n\n==>>-----------/*---Sign up test case is failed---*/-----------\n");
		}
		
		su.pauseWithTryCatch(1500);
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test (groups= {"003"})
	public void signUpTest3() throws IOException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/register/", brRandom);
		log.info("Register page is opened on browser \r\r");
		
		SignUpPage su= new SignUpPage(driver);
		su.setLastName(lastName);
		log.info("Inputted last name successfully \r\r");
		
		su.setFirstName(firstName);
		log.info("Inputted first name successfully \r\r");
		
		su.selectGender("Nam", driver);
		log.info("Selected gender successfully \r\r");
		
		su.setBirthday(birthday);
		log.info("Inputted DOB successfully \r\r");
		
		su.setEmail(email);
		log.info("Inputted email successfully \r\r");
		
		su.setPassword(password);
		log.info("Inputted password successfully \r\r");
		
		su.executeScrollingDown(driver, javascript, 300);
		su.pauseWithTryCatch(500);
		su.clickRegister();
		log.info("Clicked register button successfully \r\r");
		
		//assertions
		String actFullName= driver.findElement(By.xpath(LBL_ACT_FULL_NAME_LOCATOR)).getText();
		String actEmail= driver.findElement(By.xpath(LBL_ACT_EMAIL_LOCATOR)).getText();
		log.info("Getting text facilitates assertion");
		
		System.out.println("\n"+ actFullName+ "\n");
		System.out.println(actEmail+ "\n");
		
		if (actFullName.equals(expFullName) && actEmail.equals(expEmail)) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---Sign up test case is passed---*/-----------\n");
		}
		else {
			Assert.assertTrue(false);
			log.error("\n\n==>>-----------/*---Sign up test case is failed---*/-----------\n");
		}
		
		su.pauseWithTryCatch(1500);
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test (groups= {"004"})
	public void signUpTest4() throws IOException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/register/", brRandom);
		log.info("Register page is opened on browser \r\r");
		
		SignUpPage su= new SignUpPage(driver);
		su.setLastName(lastName);
		log.info("Inputted last name successfully \r\r");
		
		su.setFirstName(firstName);
		log.info("Inputted first name successfully \r\r");
		
//		su.selectGender("Nam", driver);
		log.info("Skipped selecting gender successfully \r\r");
		
//		su.setBirthday(birthday);
		log.info("Skipped inputting DOB successfully \r\r");
		
		su.setEmail(email);
		log.info("Inputted email successfully \r\r");
		
		su.setPassword(password);
		log.info("Inputted password successfully \r\r");
		
		su.executeScrollingDown(driver, javascript, 300);
		su.pauseWithTryCatch(500);
		su.clickRegister();
		log.info("Clicked register button successfully \r\r");
		
		//assertions
		String actFullName= driver.findElement(By.xpath(LBL_ACT_FULL_NAME_LOCATOR)).getText();
		String actEmail= driver.findElement(By.xpath(LBL_ACT_EMAIL_LOCATOR)).getText();
		log.info("Getting text facilitates assertion");
		
		System.out.println("\n"+ actFullName+ "\n");
		System.out.println(actEmail+ "\n");
		
		if (actFullName.equals(expFullName) && actEmail.equals(expEmail)) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---Sign up test case is passed---*/-----------\n");
		}
		else {
			Assert.assertTrue(false);
			log.error("\n\n==>>-----------/*---Sign up test case is failed---*/-----------\n");
		}
		
		su.pauseWithTryCatch(1500);
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test (groups= {"005"})
	public void signUpTest5() throws IOException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/register/", brRandom);
		log.info("Register page is opened on browser \r\r");
		
		SignUpPage su= new SignUpPage(driver);
//		su.setLastName(lastName);
		log.info("Skipped entering last name successfully \r\r");
		
		su.setFirstName(firstName);
		log.info("Inputted first name successfully \r\r");
		
		su.selectGender("Nam", driver);
		log.info("Selected gender successfully \r\r");
		
		su.setBirthday(birthday);
		log.info("Entered DOB successfully \r\r");
		
		su.setEmail(email);
		log.info("Inputted email successfully \r\r");
		
		su.setPassword(password);
		log.info("Inputted password successfully \r\r");
		
		su.executeScrollingDown(driver, javascript, 300);
		su.pauseWithTryCatch(500);
		su.clickRegister();
		log.info("Clicked register button successfully \r\r");
		
		//assertions
		if (su.checkIfFieldRequiredAlertIsPresent(driver, lastNameRequiredMessage, TXT_LAST_NAME_LOCATOR, "Last Name")==true) {
			log.info("Last name required alert is present \n\n");
			log.info("Asserted alert successfully \n\n");
			log.info("Test case 005 is passed! \n\n");
		}
		else {
			log.warn("Asserted alert unsuccessfully due to the presence of the alert \n\n");
			log.info("Test case 005 is failed! \n\n");
		}

		su.pauseWithTryCatch(1500);
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test (groups= {"006"})
	public void signUpTest6() throws IOException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/register/", brRandom);
		log.info("Register page is opened on browser \r\r");
		
		SignUpPage su= new SignUpPage(driver);
		su.setLastName(lastName);
		log.info("Inputted last name successfully \r\r");
		
//		su.setFirstName(firstName);
		log.info("Skipped entering first name successfully \r\r");
		
		su.selectGender("Nam", driver);
		log.info("Selecting gender successfully \r\r");
		
		su.setBirthday(birthday);
		log.info("Inputted DOB successfully \r\r");
		
		su.setEmail(email);
		log.info("Inputted email successfully \r\r");
		
		su.setPassword(password);
		log.info("Inputted password successfully \r\r");
		
		su.executeScrollingDown(driver, javascript, 300);
		su.pauseWithTryCatch(500);
		su.clickRegister();
		log.info("Clicked register button successfully \n\n");
		
		//assertions
		if (su.checkIfFieldRequiredAlertIsPresent(driver, firstNameRequiredMessage, TXT_FIRST_NAME_LOCATOR, "First Name")==true) {
			log.info("First name required alert is present \n\n");
			log.info("Asserted alert successfully \n\n");
			log.info("Test case 006 is passed! \n\n");
		}
		else {
			log.warn("Asserted alert unsuccessfully due to the presence of the alert \n\n");
			log.info("Test case 006 is failed! \n\n");
		}

		su.pauseWithTryCatch(1500);
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test (groups= {"007"})
	public void signUpTest7() throws IOException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/register/", brRandom);
		log.info("Register page is opened on browser \r\r");
		
		SignUpPage su= new SignUpPage(driver);
		su.setLastName(lastName);
		log.info("Inputted last name successfully \r\r");
		
		su.setFirstName(firstName);
		log.info("Inputted first name successfully \r\r");
		
		su.selectGender("Nam", driver);
		log.info("Selected gender successfully \r\r");
		
		su.setBirthday(birthday);
		log.info("Inputted DOB successfully \r\r");
		
//		su.setEmail(email);
		log.info("Skipped inputting email successfully \r\r");
		
		su.setPassword(password);
		log.info("Inputted password successfully \r\r");
		
		su.executeScrollingDown(driver, javascript, 300);
		su.pauseWithTryCatch(500);
		su.clickRegister();
		log.info("Clicked register button successfully \n\n");
		
		//assertions
		if (su.checkIfFieldRequiredAlertIsPresent(driver, emailRequiredMessage, TXT_EMAIL_LOCATOR, "Email")==true) {
			log.info("Email required alert is present \n\n");
			log.info("Asserted alert successfully \n\n");
			log.info("Test case 007 is passed! \n\n");
		}
		else {
			log.warn("Asserted alert unsuccessfully due to the presence of the alert \n\n");
			log.info("Test case 007 is failed! \n\n");
		}

		su.pauseWithTryCatch(1500);
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test (groups= {"008"})
	public void signUpTest8() throws IOException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/register/", brRandom);
		log.info("Register page is opened on browser \r\r");
		
		SignUpPage su= new SignUpPage(driver);
		su.setLastName(lastName);
		log.info("Inputted last name successfully \r\r");
		
		su.setFirstName(firstName);
		log.info("Inputted first name successfully \r\r");
		
		su.selectGender("Nam", driver);
		log.info("Selected gender successfully \r\r");
		
		su.setBirthday(birthday);
		log.info("Inputted DOB successfully \r\r");
		
		su.setEmail(email);
		log.info("Inputted email successfully \r\r");
		
//		su.setPassword(password);
		log.info("Skipped entering password successfully \r\r");
		
		su.executeScrollingDown(driver, javascript, 300);
		su.pauseWithTryCatch(500);
		su.clickRegister();
		log.info("Clicked register button successfully \n\n");
		
		//assertions
		if (su.checkIfFieldRequiredAlertIsPresent(driver, passwordRequiredMessage, TXT_PASSWORD_LOCATOR, "Password")==true) {
			log.info("Password required alert is present \n\n");
			log.info("Asserted alert successfully \n\n");
			log.info("Test case 008 is passed! \n\n");
		}
		else {
			log.warn("Asserted alert unsuccessfully due to the presence of the alert \n\n");
			log.info("Test case 008 is failed! \n\n");
		}

		su.pauseWithTryCatch(1500);
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test (groups= {"009"})
	public void signUpTest9() throws IOException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/register/", brRandom);
		log.info("Register page is opened on browser \r\r");
		
		SignUpPage su= new SignUpPage(driver);
//		su.setLastName(lastName);
		log.info("Skipped inputting last name successfully \r\r");
		
//		su.setFirstName(firstName);
		log.info("Skipped inputting first name successfully \r\r");
		
//		su.selectGender("Nam", driver);
		log.info("Skipped choosing gender successfully \r\r");
		
//		su.setBirthday(birthday);
		log.info("Skipped inputting DOB successfully \r\r");
		
//		su.setEmail(email);
		log.info("Skipped inputting email successfully \r\r");
		
//		su.setPassword(password);
		log.info("Skipped entering password successfully \r\r");
		
		su.executeScrollingDown(driver, javascript, 300);
		su.pauseWithTryCatch(500);
		su.clickRegister();
		log.info("Clicked register button successfully \n\n");
		
		//assertions
		if (su.checkIfFieldRequiredAlertIsPresent(driver, lastNameRequiredMessage, TXT_LAST_NAME_LOCATOR, "Last Name")==true
				&& su.checkIfFieldRequiredAlertIsPresent(driver, firstNameRequiredMessage, TXT_FIRST_NAME_LOCATOR, "First Name")==true
					&& su.checkIfFieldRequiredAlertIsPresent(driver, emailRequiredMessage, TXT_EMAIL_LOCATOR, "Email")==true
						&& su.checkIfFieldRequiredAlertIsPresent(driver, passwordRequiredMessage, TXT_PASSWORD_LOCATOR, "Password")==true) {
			log.info("Last name required alert is present \n\n");
			log.info("First name required alert is present \n\n");
			log.info("Email required alert is present \n\n");
			log.info("Password required alert is present \n\n");
			log.info("Asserted alerts successfully \n\n");
			log.info("Test case 009 is passed! \n\n");
		}
		else {
			log.warn("Asserted alerts unsuccessfully due to the presence of the alerts \n\n");
			log.info("Test case 009 went wrong! \n\n");
		}

		su.pauseWithTryCatch(1500);
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test (groups= {"010"}, priority= 1)
	
	public void signUpTest10() {
		setUp(readconfig.getApplicationBaseURL()+ "/account/register/", brRandom);
		log.info("Triggered web browser \r\r");
		
		SignUpPage su= new SignUpPage(driver);
		
		su.executeScrollingDown(driver, javascript, 400);
		su.clickComeBackHomePage();
		log.info("Clicked come back homepage link successfully \r\r");
		
		//assertion
		su.pauseWithTryCatch(1500);
		if (su.checkIfImageIsPresent()==true) {
			log.info("Navigated to Home page successfully \r\r");
			log.info("Test case 010 is passed! \r\r");
		}
		else if (su.checkIfImageIsPresent()!=true) {
			log.error("Test case 010 is failed! \r\r");
		}
		
		su.pauseWithTryCatch(1500);
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
}
