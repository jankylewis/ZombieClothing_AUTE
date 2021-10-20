package com.zombieclothing.testCases;

import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.AddToCartPage;
import com.zombieclothing.utilities.ReadConfig;

public class TCs_AddToCart extends BaseClass{

	ReadConfig readconfig= new ReadConfig();
	private WebDriver dr;
	
	@Var
	private String LBL_PRODUCT_TITLE_ADD_TO_CART_LOCATOR= "//div[@class=\"product-title\"]//h1";
	private String LBL_PRODUCT_TITLE_VIEW_IN_CART_LOCATOR= "//td[@class=\"item\"]//h3//a";
	private String LBL_PRODUCT_QUANTITY_LOCATOR= "//div//input[@data-price and @size]";
	private String LBL_PRODUCT_PRICE_LOCATOR= "//p[@class=\"price\"]//descendant::span[2]"; 
	private String LBL_PRODUCT_TOTAL_PRICE_LOCATOR= "//div[contains(@class, \"order_total\")]//span[contains(@class, \"total-price\")]";
	private String BTN_PREVIOUS_LOCATOR= "//div[@class=\"owl-nav\"][1]//button[@class=\"owl-prev\"]";
	private String BTN_ADD_TO_CART_LOCATOR= "//button[@type=\"button\" and @id=\"add-to-cart\"]";
	private String BTN_LINK_TO_CART_LOCATOR= "//div[@class=\"cart-view-total\"]//a[contains(@class, \"cart\")]";
		
		private String productTitleArray[];
		private String productTitleRandom;
	
			private String assertTextInCartPage;
			private String assertProductQuantityInCartPage;
			private String assertNoteInCartPage;
			private String assertOrderInforInCartPage;
			
			
				
	@Test (groups= {"001"}, 
			enabled = true, 
				invocationCount = 1, 
					priority = -1)
	public void addToCartTest1() throws TimeoutException {
		
		this.productTitleArray= new String[] {
				
												"White Rose Mesh Net Shirt",
													"Black Rose Mesh Net Shirt",

											};
		this.productTitleRandom= productTitleArray[new Random().nextInt(productTitleArray.length)];
		System.out.println("\r\r"+ productTitleRandom.toLowerCase()+ "\r\r");
		
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("Search URL is opened on browser\n");
		
		AddToCartPage atcp= new AddToCartPage(this.driver);
		atcp.clickOnProductByText(productTitleRandom, driver, javascript, 1000);
		atcp.clickOnDesiredButton(driver, BTN_ADD_TO_CART_LOCATOR);
		atcp.clickOnDesiredButton(driver, BTN_LINK_TO_CART_LOCATOR);;;;;
		
		//assertion
		
		System.out.println(driver.findElement(By.xpath(LBL_PRODUCT_TITLE_VIEW_IN_CART_LOCATOR)).getText());
		if (driver.findElement(By.xpath(LBL_PRODUCT_TITLE_VIEW_IN_CART_LOCATOR)).getText().equals(productTitleRandom)==true
				|| driver.findElement(By.xpath(LBL_PRODUCT_TITLE_VIEW_IN_CART_LOCATOR)).getText().contains(productTitleRandom)==true) {
			
			log.info("Product name in view cart page is asserted successfully\n\n");
			log.info("\n\n\nTest case 001 is passed!!\n\n");
		}
		else {
			log.error("\r\r\rTest case 001 is failed due to an error...\n\r");
			tearDown();
		}
			
	}
		
//		tearDown();
		
}

