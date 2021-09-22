package com.zombieclothing.testCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.ViewProductPage;
import com.zombieclothing.utilities.ReadConfig;
import lombok.Builder.Default;

public class TC_ViewProduct_001 extends BaseClass{

	ReadConfig readconfig= new ReadConfig();
	@Var
	//for asserting
	private String productType= readconfig.getViewProductType(); 
	
	@Test
	public void viewProductType() {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("Navigated to homepage\n");
		
		ViewProductPage vpg= new ViewProductPage(driver);
		vpg.performMouseHoverTatcasp();
		log.info("Hovered Tatcasp navigation link\n");
		
		vpg.clickAoNavigationLink();
		log.info("Clicked product type\n");
		
		//assertion
		String expProductType= productType;
		String actProductType= driver.findElement(By.xpath("//ancestor::div//h1[@class=\"title\"]")).getText();
		System.out.println(expProductType+ "\n\n"+ actProductType+ "\n");
		
		if (actProductType.equals(expProductType) && actProductType.isBlank()==false) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---View product by type test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---View product by tpe test case is failed due to an error---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
		
	}
}
