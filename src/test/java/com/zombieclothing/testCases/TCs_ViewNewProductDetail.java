package com.zombieclothing.testCases;

import java.util.Random;
import java.util.concurrent.TimeoutException;

import com.zombieclothing.pageObjects.TestListenersPage;
import org.apache.batik.gvt.font.AWTGlyphGeometryCache;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.ViewNewProductDetailPage;
import com.zombieclothing.utilities.ReadConfig;


@Listeners(TestListenersPage.class)
public class TCs_ViewNewProductDetail extends BaseClass{

	ReadConfig readconfig= new ReadConfig();
	@Var
	private String browserArr[]= {"firefox", "chrome", "opera"};
	private String brRandom= browserArr[new Random().nextInt(browserArr.length)];
	private String frProductName= "White Rose Mesh Net Shirt"; String expFrProductName= frProductName;
	private String secProductName= "Black Rose Mesh Net Shirt"; String expSecProductName= secProductName;
	private String thrProductName= "ZB Printed Jacket In Black"; String expThrProductName= thrProductName;
	private String foProductName= "ZOMBIE Tube Top - White"; String expFoProductName= foProductName;
	private String fiProductName= "ZOMBIE Tube Top - Black"; String expFiProductName= fiProductName;
	private String siProductName= "#1 Jacket In Black"; String expSiProductName= siProductName;
	private String sevProductName= "Leopard Print Long-Sleeve Shirt"; String expSevProductName= sevProductName;
	private String eigProductName= "Polo Tee In Brown"; String expEigProductName= eigProductName;
	private String ninProductName= "ZOMBIE Reversible Jacket"; String expNinProductName= ninProductName;
	private String tenProductName= "Striped Sweater In Brown"; String expTenProductName= tenProductName;
	private String eleProductName= "Stripes Sweater In W.Black"; String expEleProductName= eleProductName;
	private String tweProductName= "Comfy Pants In Grey"; String expTweProductName= tweProductName;
	private String thirProductName= "Oversew Sides Tanktop"; String expThirProductName= thirProductName;
	private String fourProductName= "ZOMBIE Hoodie In Black"; String expFourProductName= fourProductName;
	private String fifProductName= "ZOMBIE® Deconstructed Layer Tanktop"; String expFifProductName= fifProductName;
	private String sixProductName= "ZOMBIE® Lines Pants - White"; String expSixProductName= sixProductName;
	
	private String LBL_PRODUCT_TITLE_LOCATOR= "//div[@class=\"product-title\"]//h1";
	
	@Test(groups= {"001"})
	
	public void viewProductTest001() throws InterruptedException {
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);
		vpdg.selectProductByText(frProductName, driver, javascript, 1000);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actFrProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		if (actFrProductName.equals(expFrProductName)==true) {
			log.info("Product name is asserted successfully\n\n");
			log.info("\n\n\nTest case 001 is passed!!\n\n");
		}
		else {
			log.error("\r\r\rTest case 001 is failed due to an error...\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"002"})
	
	public void viewProductTest002() throws InterruptedException {
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);
		vpdg.selectProductByText(secProductName, driver, javascript, 1000);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actSecProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		if (actSecProductName.equals(expSecProductName)==true) {
			log.info("Product name is asserted successfully\n\n");
			log.info("\n\n\nTest case 002 is passed!!\n\n");
		}
		else {
			log.error("\r\r\rTest case 002 is failed due to an error...\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"003"})
	
	public void viewProductTest003() throws InterruptedException {
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);
		vpdg.selectProductByText(thrProductName, driver, javascript, 1000);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actThrProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		if (actThrProductName.equals(expThrProductName)==true) {
			log.info("Product name is asserted successfully\n\n");
			log.info("\n\n\nTest case 003 is passed!!\n\n");
		}
		else {
			log.error("\r\r\rTest case 003 is failed due to an error...\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"004"})
	
	public void viewProductTest004() throws InterruptedException {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);
		vpdg.selectProductByText(foProductName, driver, javascript, 2000);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actFoProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		if (actFoProductName.equals(expFoProductName)==true) {
			log.info("Product name is asserted successfully\n\n");
			log.info("\n\n\nTest case 004 is passed!!\n\n");
		}
		else {
			log.error("\r\r\rTest case 004 is failed due to an error...\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"005"})
	
	public void viewProductTest005() throws InterruptedException {
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);
		vpdg.selectProductByText(fiProductName, driver, javascript, 1200);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actFiProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		if (actFiProductName.equals(expFiProductName)==true) {
			log.info("Product name is asserted successfully\n\n");
			log.info("\n\n\nTest case 005 is passed!!\n\n");
		}
		else {
			log.error("\r\r\rTest case 005 is failed due to an error...\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"006"})
	
	public void viewProductTest006() throws InterruptedException {
		
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);
//		vpdg.pauseWithTryCatch(3000);
//		vpdg.closeChatPopup();
		vpdg.selectProductByText(siProductName, driver, javascript, 1250);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actSiProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		if (actSiProductName.equals(expSiProductName)==true) {
			log.info("Product name is asserted successfully\n\n");
			log.info("\n\n\nTest case 006 is passed!!\n\n");
		}
		else {
			log.error("\r\r\rTest case 006 is failed due to an error...\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"007"})
	
	public void viewProductTest007() throws InterruptedException {
		
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);
		vpdg.selectProductByText(sevProductName, driver, javascript, 1250);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actSevProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		if (actSevProductName.equals(expSevProductName)==true) {
			log.info("Product name is asserted successfully\n\n");
			log.info("\n\n\nTest case 007 is passed!!\n\n");
		}
		else {
			log.error("\r\r\rTest case 007 is failed due to an error...\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"008"})
	
	public void viewProductTest008() throws InterruptedException {
		
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);
		
		vpdg.selectProductByText(eigProductName, driver, javascript, 1850);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actEigProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		System.out.println(actEigProductName);
		if (actEigProductName.equals(expEigProductName)==true) {
			log.info("Product name is asserted successfully\n\n");
			log.info("\n\n\nTest case 008 is passed!!\n\n");
		}
		else {
			log.error("\r\r\rTest case 008 is failed due to an error...\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"009"})
	
	public void viewProductTest009() throws TimeoutException {
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);		
		vpdg.selectProductByText(ninProductName, driver, javascript, 1950);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actNinProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		
		if (actNinProductName.equals(expNinProductName)==true) {
			log.info("Product name is asserted successfully\n\n");
			log.info("\n\n\nTest case 009 is passed!!\n\n");
		}
		else {
			log.error("\r\r\rTest case 009 is failed due to an error...\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"010"})
	
	public void viewProductTest010() throws InterruptedException {
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);		
		vpdg.selectProductByText(tenProductName, driver, javascript, 1950);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actTenProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		
		if (actTenProductName.equals(expTenProductName)==true) {
			log.info("Product name is asserted successfully\n\n");
			log.info("\n\n\nTest case 010 is passed!!\n\n");
		}
		else {
			log.error("\r\r\rTest case 010 is failed due to an error...\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"011"})
	
	public void viewProductTest011() throws InterruptedException {
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);		
		vpdg.selectProductByText(eleProductName, driver, javascript, 2250);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actEleProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		
		if (actEleProductName.equals(expEleProductName)==true) {
			
			log.info("Product name is asserted successfully\n\n");
			log.info("Test case 011 is passed\n\n");
			
		}
		
		else {
			log.error("\r\r\rTest case 011 is failed due to an error\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"012"})
	
	public void viewProductTest012() throws InterruptedException {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);		
		vpdg.selectProductByText(tweProductName, driver, javascript, 2150);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actTweProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		
		if (actTweProductName.equals(expTweProductName)==true) {
			log.info("Product name is asserted successfully\n\r");
			log.info("\r\r\rTest case 012 is passed\n\r");
		}
		
		else {
			log.error("\r\r\rTest case 012 is failed due to an error\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"013"})
	
	public void viewProductTest013() throws InterruptedException {
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);		
		vpdg.selectProductByText(thirProductName, driver, javascript, 2150);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actThirProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		
		if (actThirProductName.equals(expThirProductName)==true) {
			log.info("Product name is asserted successfully\n\r");
			log.info("\r\r\rTest case 013 is passed!!\r\r");
		}
		
		else {
			log.error("\r\r\rTest case 013 is failed due to an error\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"014"})
	
	public void viewProductTest014() throws InterruptedException {
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);		
		vpdg.selectProductByText(fourProductName, driver, javascript, 2100);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actFourProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		log.info("\n\n"+ actFourProductName+ "\r\r");
		
		if (actFourProductName.equals(expFourProductName)==true) {
			log.info("Product name is asserted successfully\n\r");
			log.info("\r\r\rTest case 014 is passed!!\n\r");
		}
		else {
			log.error("\r\r\rTest case 014 is failed due to an error...\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"015"})
	
	public void viewProductTest015() throws InterruptedException {
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);		
		vpdg.selectProductByText(fifProductName, driver, javascript, 2100);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actFifProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		log.info("\r\r"+ actFifProductName+ "\r\r");
		
		if (actFifProductName.equals(expFifProductName)==true) {
			log.info("Product name is asserted successfully\n\n");
			log.info("\n\n\nTest case 015 is passed!!\n\n");
		}
		else {
			log.error("\r\r\rTest case 015 is failed due to an error...\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"016"})
	
	public void viewProductTest016() throws InterruptedException {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("URL is opened on web browser\n");
		
		ViewNewProductDetailPage vpdg= new ViewNewProductDetailPage(driver);		
		vpdg.selectProductByText(sixProductName, driver, javascript, 2300);
		vpdg.pauseWithTryCatch(1000);
		log.info("Clicked product by name successfully\n");
		
		vpdg.pauseWithTryCatch(200);
		((JavascriptExecutor)driver).executeScript("scroll(0,150)");
		log.info("Scroll down a little\n");
		vpdg.pauseWithTryCatch(150);
		
		String actSixProductName= driver.findElement(By.xpath(LBL_PRODUCT_TITLE_LOCATOR)).getText();
		if (actSixProductName.equals(expSixProductName)==true) {
			log.info("Product name is asserted successfully\n\n");
			log.info("\n\n\nTest case 016 is passed!!\n\n");
		}
		else {
			log.error("\r\r\rTest case 016 is failed due to an error...\n\r");
			tearDown();
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
}
