package com.zombieclothing.testCases;

import java.io.IOException;
import java.util.Random;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.SignUpPage;

public class TC_SignUpTest_001 extends BaseClass{
	
	@Var
	public int randomNum= new Random().nextInt(50000);
	public String lastName= "Tran";
	public String firstName= "Vinh";
	public String birthday= "2/9/2000";
	public String email= "vinhtranak02092k"+ String.valueOf(randomNum)+ "@gmail.com";
	public String password= "Raul123";
	protected String expFullName= lastName+ " "+ firstName;
	protected String expEmail= email;
	
	@Test
	public void signUpTest() throws IOException {
		setUp(baseURL+ "/account/register/");
		log.info("Register page is opened on browser\n");
		
		SignUpPage su= new SignUpPage(driver);
		su.setLastName(lastName);
		log.info("Inputted last name successfully\n");
		
		su.setFirstName(firstName);
		log.info("Inputted first name successfully\n");
		
		su.setMaleGender();
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
