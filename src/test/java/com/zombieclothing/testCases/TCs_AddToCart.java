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
	private boolean checkIfTheCaseIfPassed;
	
	@Var
	private String LBL_PRODUCT_TITLE_ADD_TO_CART_LOCATOR= "//div[@class=\"product-title\"]//h1";
	private String LBL_PRODUCT_TITLE_VIEW_IN_CART_LOCATOR= "//td[@class=\"item\"]//h3//a";
	private String LBL_PRODUCT_QUANTITY_IN_CART_LOCATOR= "//div[contains(@class,\"qty quantity\")]//input[@type=\"text\" and @data-price]";;;;;;;;;;;;;;;;;;;;;;;;;
	private String LBL_PRODUCT_PRICE_IN_CART_LOCATOR= "//p[@class=\"price\"]//descendant::span[2]"; 
	private String LBL_PRODUCT_TOTAL_PRICE_IN_CART_LOCATOR= "//div[contains(@class, \"order_total\")]//span[contains(@class, \"total-price\")]";
	private String BTN_PREVIOUS_LOCATOR= "//div[@class=\"owl-nav\"][1]//button[@class=\"owl-prev\"]";
	private String BTN_ADD_TO_CART_LOCATOR= "//button[@type=\"button\" and @id=\"add-to-cart\"]";
	private String BTN_LINK_TO_CART_LOCATOR= "//div[@class=\"cart-view-total\"]//a[contains(@class, \"cart\")]";
	private String LBL_PRODUCT_TITLE_POP_UP_CART_LOCATOR= "//table[@id=\"cart-view\"]//p//a[1]";
	private String LBL_TEXT_VIEW_IN_CART_LOCATOR= "//div[@class=\"header-page\"]//h1";
	private String LBL_HOW_MANY_PRODUCT_TEXT_VIEW_IN_CART_LOCATOR= "//p[@class=\"count-cart\"]";
	
		private String aboveProductTitleArray[];
		private String beneathProductTitleArray[];
		private String chooseArray[];
		private String chooseArrayRandom;
		private String productTitleRandom;
		
			private String assertProductTitleAtViewProductDetailPage;
			private String assertProductTitleAtCartPopUp;
			private String assertProductTitleAtViewInCartPage;
			private String assertTextAtViewInCartPage;
			private String assertTextHowManyProductInCartPage;
			private int assertProductQuantityAtViewInCartPage;
			private String assertPriceAtViewInCartPage;
			private String assertTotalPriceAtViewInCartPage;
			
			private String textAtViewInCartPage= "Giỏ hàng của bạn";
			
			private String howManyProductInCart(int totalProduct) {
				return "Có " +totalProduct+ " sản phẩm trong giỏ hàng";
			}
				
	@Test (groups= {"001"}, 
			enabled = true, 
				invocationCount = 1, 
					priority = -1)
	public void addToCartTest1() throws TimeoutException {
		
		this.aboveProductTitleArray= new String[] {
				
													"White Rose Mesh Net Shirt",
													"Black Rose Mesh Net Shirt",
													"ZB Printed Jacket In Black",
						"ZOMBIE Tube Top - White",
						
														"ZOMBIE Tube Top - Black",
														"#1 Jacket In Black",
														"Leopard Print Long-Sleeve Shirt",
						"Polo Tee In Brown",

											};
		
		/*-----------------------------------------------------------------------------------------------------------*/
		
		this.beneathProductTitleArray= new String[] {
				
													"ZOMBIE Reversible Jacket",
													"Striped Sweater In Brown",
													"Stripes Sweater In W.Black",
							"Comfy Pants In Grey",
													
														"Oversew Sides Tanktop",
														"ZOMBIE Hoodie In Black",
														"ZOMBIE® Deconstructed Layer Tanktop",
					"ZOMBIE® Lines Pants - White",
													
											};
		
		this.chooseArray= new String[] {"aboveArray", "beneathArray"}; 
		this.chooseArrayRandom= chooseArray[new Random().nextInt(chooseArray.length)];
		
		if (this.chooseArrayRandom=="aboveArray") {
			this.productTitleRandom= aboveProductTitleArray[new Random().nextInt(aboveProductTitleArray.length)];
			System.out.println("\r\r"+ productTitleRandom.toLowerCase()+ "\r\r");
			
			setUp(readconfig.getApplicationBaseURL(), brRandom);
			log.info("Search URL is opened on browser\n");
			
			AddToCartPage atcp= new AddToCartPage(this.driver);
			atcp.clickOnProductByText(productTitleRandom, driver, javascript, 1500);
			log.info("Clicked on the product\n");
			
			//ASSERTION AT VIEW PRODUCT DETAIL PAGE
			
			this.assertProductTitleAtViewProductDetailPage= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_ADD_TO_CART_LOCATOR)).getText();
			if (assertProductTitleAtViewProductDetailPage.equals(productTitleRandom)==true
					|| assertProductTitleAtViewProductDetailPage.contains(productTitleRandom)==true) {
				log.info("Assertion at View Product Detail page successfully \r\r");
			}
			else {
				log.error("Assertion at View Product Detail page unsuccessfully \r\r");
				tearDown();
				log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
				log.exit();
			}
			atcp.clickOnDesiredButton(driver, BTN_ADD_TO_CART_LOCATOR);
			
			//ASSERT THE CART POP UP AT VIEW PRODUCT DETAIL PAGE 
			
			this.assertProductTitleAtCartPopUp= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_POP_UP_CART_LOCATOR)).getText().toLowerCase();
			if (assertProductTitleAtCartPopUp.equals(productTitleRandom.toLowerCase())==true
					|| assertProductTitleAtCartPopUp.contains(productTitleRandom.toLowerCase())==true) {
				System.out.println(assertProductTitleAtCartPopUp+ "\r\r");
				log.info("Assertion at Cart Pop Up at View Product Detail page successfully \r\r");
			}
			else {
				System.out.println(assertProductTitleAtCartPopUp+ "\r\r");
				log.error("Assertion at Cart Pop Up at View Product Detail page unsuccessfully \r\r");
				tearDown();
				log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
				log.exit();
			}		
					
			atcp.clickOnDesiredButton(driver, BTN_LINK_TO_CART_LOCATOR);;;;;
			
			//ASSERTION AT THE VIEW IN CART PAGE
			
			this.assertProductTitleAtViewInCartPage= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_VIEW_IN_CART_LOCATOR)).getText();
			this.assertTextAtViewInCartPage= driver.findElement(By.xpath(LBL_TEXT_VIEW_IN_CART_LOCATOR)).getText();
			this.assertTextHowManyProductInCartPage= driver.findElement(By.xpath(LBL_HOW_MANY_PRODUCT_TEXT_VIEW_IN_CART_LOCATOR)).getText();
			
			String getProductQuantity= driver.findElement(By.xpath(LBL_PRODUCT_QUANTITY_IN_CART_LOCATOR)).getAttribute("value");
			this.assertProductQuantityAtViewInCartPage= Integer.parseInt(getProductQuantity);
			this.assertPriceAtViewInCartPage= driver.findElement(By.xpath(LBL_PRODUCT_PRICE_IN_CART_LOCATOR)).getText();
			this.assertTotalPriceAtViewInCartPage= driver.findElement(By.xpath(LBL_PRODUCT_TOTAL_PRICE_IN_CART_LOCATOR)).getText();
			
			System.out.println(assertProductTitleAtViewInCartPage+ "\r\r");
			System.out.println(assertTextHowManyProductInCartPage+ "\r\r");
			System.out.println(assertProductQuantityAtViewInCartPage+ "\r\r");
			System.out.println(assertPriceAtViewInCartPage+ "\r\r");
			System.out.println(assertTotalPriceAtViewInCartPage+ "\r\r");
			if ((assertProductTitleAtViewInCartPage.equals(productTitleRandom)==true
					|| (assertProductTitleAtViewInCartPage.contains(productTitleRandom))==true)
						&& (assertTextAtViewInCartPage.equals(textAtViewInCartPage))==true
							&& (assertTextHowManyProductInCartPage.equals((howManyProductInCart(assertProductQuantityAtViewInCartPage))))
								&& (assertPriceAtViewInCartPage.equals(assertTotalPriceAtViewInCartPage))) {
				
				//CHECK THE BOOLEAN VARIABLE IS TRUE
				this.checkIfTheCaseIfPassed=true;
				
			}
			else {
				this.checkIfTheCaseIfPassed=false;
			}
			if (checkIfTheCaseIfPassed==true) {
				log.info("Product name in view cart page is asserted successfully\n\n");
				log.info("\n\n\nTest case 001 is passed!!\n\n");
			}
			else {
				log.error("\r\r\rTest case 001 is failed due to an error...\n\r");
				tearDown();
			}
		}
		
		if (this.chooseArrayRandom=="beneathArray") {
			this.productTitleRandom= beneathProductTitleArray[new Random().nextInt(beneathProductTitleArray.length)];
			System.out.println("\r\r"+ productTitleRandom.toLowerCase()+ "\r\r");
			
			setUp(readconfig.getApplicationBaseURL(), brRandom);
			log.info("Search URL is opened on browser\n");
			
			AddToCartPage atcp= new AddToCartPage(this.driver);
			atcp.clickOnProductByText(productTitleRandom, driver, javascript, 2250);
			log.info("Clicked on the product\n");
			
			//ASSERTION AT VIEW PRODUCT DETAIL PAGE
			
			this.assertProductTitleAtViewProductDetailPage= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_ADD_TO_CART_LOCATOR)).getText();
			if (assertProductTitleAtViewProductDetailPage.equals(productTitleRandom)==true
					|| assertProductTitleAtViewProductDetailPage.contains(productTitleRandom)==true) {
				log.info("Assertion at View Product Detail page successfully \r\r");
			}
			else {
				log.error("Assertion at View Product Detail page unsuccessfully \r\r");
				tearDown();
				log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
				log.exit();
			}
			atcp.clickOnDesiredButton(driver, BTN_ADD_TO_CART_LOCATOR);;;;;;;;;;;;;;;;;;;;;
			
			//ASSERT THE CART POP UP AT VIEW PRODUCT DETAIL PAGE 
			
			this.assertProductTitleAtCartPopUp= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_POP_UP_CART_LOCATOR)).getText().toLowerCase();
			
			if (assertProductTitleAtCartPopUp.equals(productTitleRandom.toLowerCase())==true
					|| assertProductTitleAtCartPopUp.contains(productTitleRandom.toLowerCase())==true) {
				System.out.println(assertProductTitleAtCartPopUp+ "\r\r");
				log.info("Assertion at Cart Pop Up at View Product Detail page successfully \r\r");
			}
			else {
				System.out.println(assertProductTitleAtCartPopUp+ "\r\r");
				log.error("Assertion at Cart Pop Up at View Product Detail page unsuccessfully \r\r");
				tearDown();
				log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
				log.exit();
			}
			atcp.clickOnDesiredButton(driver, BTN_LINK_TO_CART_LOCATOR);;;;;;;;;;;;;;;;;;;;
			
			//ASSERTION AT THE VIEW IN CART PAGE
			
			this.assertProductTitleAtViewInCartPage= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_VIEW_IN_CART_LOCATOR)).getText();
			this.assertTextAtViewInCartPage= driver.findElement(By.xpath(LBL_TEXT_VIEW_IN_CART_LOCATOR)).getText();
			this.assertTextHowManyProductInCartPage= driver.findElement(By.xpath(LBL_HOW_MANY_PRODUCT_TEXT_VIEW_IN_CART_LOCATOR)).getText();
			
			String getProductQuantity= driver.findElement(By.xpath(LBL_PRODUCT_QUANTITY_IN_CART_LOCATOR)).getAttribute("value");
			this.assertProductQuantityAtViewInCartPage= Integer.parseInt(getProductQuantity);
			
			this.assertPriceAtViewInCartPage= driver.findElement(By.xpath(LBL_PRODUCT_PRICE_IN_CART_LOCATOR)).getText();
			this.assertTotalPriceAtViewInCartPage= driver.findElement(By.xpath(LBL_PRODUCT_TOTAL_PRICE_IN_CART_LOCATOR)).getText();
			
			System.out.println(assertProductTitleAtViewInCartPage+ "\r\r");
			System.out.println(assertTextHowManyProductInCartPage+ "\r\r");
			System.out.println(assertProductQuantityAtViewInCartPage+ "\r\r");
			System.out.println(assertPriceAtViewInCartPage+ "\r\r");
			System.out.println(assertTotalPriceAtViewInCartPage+ "\r\r");
			
			if ((assertProductTitleAtViewInCartPage.equals(productTitleRandom)==true
					|| (assertProductTitleAtViewInCartPage.contains(productTitleRandom))==true)
						&& (assertTextAtViewInCartPage.equals(textAtViewInCartPage))==true
							&& (assertTextHowManyProductInCartPage.equals((howManyProductInCart(assertProductQuantityAtViewInCartPage))))
								&& (assertPriceAtViewInCartPage.equals(assertTotalPriceAtViewInCartPage))) {
				
				//CHECK THE BOOLEAN VARIABLE IS TRUE
				this.checkIfTheCaseIfPassed=true;
				
			}
			else {
				this.checkIfTheCaseIfPassed=false;
			}
			if (checkIfTheCaseIfPassed==true) {
				log.info("Product name in view cart page is asserted successfully\n\n");
				log.info("\n\n\nTest case 001 is passed!!\n\n");
			}
			else {
				log.error("\r\r\rTest case 001 is failed due to an error...\n\r");
				tearDown();
				log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
				log.exit();
			}
		}
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}	
}

