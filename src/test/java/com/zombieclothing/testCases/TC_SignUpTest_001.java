package com.zombieclothing.testCases;

import java.io.IOException;
import java.util.Random;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.SignUpPage;
import com.zombieclothing.utilities.ReadConfig;

public class TC_SignUpTest_001 extends BaseClass{
	
//	ReadConfig readconfig= new ReadConfig();
	@Var
	public int randomNum= new Random().nextInt(50000);
//	public String lastName= readconfig.getLastName();
//	public String firstName= readconfig.getFirstName();
//	public String birthday= readconfig.getBirthday();
//	public String email= readconfig.getLocalPart()+ String.valueOf(randomNum)+ readconfig.getDomainPart();
//	public String password= readconfig.getPassword();
//	protected String expFullName= lastName+ " "+ firstName;
//	protected String expEmail= email;
	
	private String lastName= "Tran";
	private String firstName= "Vinh";
	private String birthday= "2/9/2000";
	private String email= "vinhtranak02092k"+ String.valueOf(randomNum)+ "@gmail.com";
	private String password= "Raul123";
	
	protected String expFullName= lastName+ " "+ firstName;
	protected String expEmail= email;
	
	@Test
	public void signUpTest() throws IOException {
		setUp(readconfig.getApplicationBaseURL()+ "/account/register/", "chrome");
		log.info("Register page is opened on browser\n");
		
		SignUpPage su= new SignUpPage(driver);
		su.setLastName(lastName);
		log.info("Inputted last name successfully\n");
		
		su.setFirstName(firstName);
		log.info("Inputted first name successfully\n");
		
		su.setMaleGender("Nam", driver);
		log.info("Selected gender successfully\n");
		
		su.setBirthday(birthday);
		log.info("Inputted birthday successfully\n");
		
		su.setEmail(email);
		log.info("Inputted email successfully\n");
		
		su.setPassword(password);
		log.info("Inputted birthday successfully\n");
		
		su.clickRegister();
		log.info("Clicked register button successfully\n");
		
		//assertions
		String actFullName= driver.findElement(By.xpath("//div[@id=\"customer_sidebar\"]//following::h2[@class=\"name_account\"]")).getText();
		String actEmail= driver.findElement(By.xpath("//div[@id=\"customer_sidebar\"]//following::p[contains(normalize-space(@class),\"email\")]")).getText();
		log.info("Getting text facilitates assertion");
		
		System.out.println("\n"+ actFullName+ "\n");
		System.out.println(actEmail+ "\n");
		
		if (actFullName.equals(expFullName) && actEmail.equals(expEmail)) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---Sign up test case is passed---*/-----------\n");
		}
		else {
			Assert.assertTrue(false);
			log.info("\n\n==>>-----------/*---Sign up test case is failed---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}

}
