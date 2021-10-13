package com.zombieclothing.testCases;

import java.util.Random;

import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.HomePageNavigation;
import com.zombieclothing.utilities.ReadConfig;

public class TCs_HomePageNavigation extends BaseClass{

	ReadConfig readconfig= new ReadConfig();
	@Var
	private String browserArr[]= {"firefox", "chrome", "opera"};
	
	private String siteArr[]= {
			
	                       "/blogs/news",										
	                      "/collections/quan",
	                     "/collections/set",
	                    "/collections/ao",
	                   "/blogs/news?page=2",
	                  "/pages/chinh-sach-doi-tra", 
	                 "/pages/chinh-sach-bao-mat",
	                "/pages/dieu-khoan-dich-vu",
	               "/pages/about-us",
	              "/collections/sweater-hoodie",
	             "/collections/ao-thun-so-mi",
	            "/collections/san-pham-moi",
	           "/collections/phu-kien",
	          "/collections/quan-short",
	         "/collections/quan-dai",
	        "/blogs/news/bai-viet-mau",
	       "/blogs/news/summer-beach-mua-he-voi-bien-ca",
	      "/blogs/news/trua-18-5-them-85-ca-mac-covid-19-moi",
	     "/products/1-extended-tee-long-tee-white",
	    "/products/zombie-hoodie-in-black",
	   "/products/python-printed-leather-set",
	  "/products/zombie-corduroy-tracksuit-purple",							
	 "/blogs/news/thu-kinh-doanh-local-brand-mot-hanh-trinh-bi-hai",
	"/blogs/news/cac-dan-choi-truyen-tay-nhau-bo-anh-cuc-chat-ve-van-hoa-duong-pho-vi",							
	
							};
						      
	private String brRandom= browserArr[new Random().nextInt(browserArr.length)];
	private String siteRandom= siteArr[new Random().nextInt(siteArr.length)];
	
	private String IMG_MAIN_LOCATOR= "//div[normalize-space(@class)=\"item\"]//child::a//child::img";
	private String LBL_NEWS_LOCATOR= "//div[@class=\"heading-page clearfix\"]//descendant::h1";
	private String LBL_ABOUT_US_LOCATOR= "//div[@class=\"heading-page\"]//child::h1";
	
	@Test (groups= {"001"})
	public void homePageNavigationTest1() {
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("Homepage is opened on web browser \r\r");
		
		HomePageNavigation hpn= new HomePageNavigation(driver);
		hpn.clickHomePageNav();
		log.info("Clicked Homepage navigation successfully \r\r");
		
		//assertion
		if (hpn.checkIfElementIsDisplayed(IMG_MAIN_LOCATOR, driver, webelement)==true) {
			log.info("Navigated to Homepage successfully \r\r");
			log.info("Test case 001 is passed! \r\r");
		}
		else {
			log.info("Test case 001 is failed! \r\r");
		}
		
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test (groups= {"002"})
	public void homePageNavigationTest2() {
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("Homepage is opened on web browser \r\r");
		
		driver.get(readconfig.getApplicationBaseURL()+ siteRandom);
		log.info("Redirected to a different site from Homepage \r\r");
		
		HomePageNavigation hpn= new HomePageNavigation(driver);
		hpn.clickHomePageNav();
		log.info("Clicked Homepage navigation successfully \r\r");
		
		//assertion
		if (hpn.checkIfElementIsDisplayed(IMG_MAIN_LOCATOR, driver, webelement)==true) {
			log.info("Navigated to Homepage successfully \r\r");
			log.info("Test case 002 is passed! \r\r");
		}
		else {
			log.info("Test case 002 is failed! \r\r");
		}
		
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test (groups= {"003"})
	public void homePageNavigationTest3() {
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("Homepage is opened on web browser \r\r");
		
		driver.get(readconfig.getApplicationBaseURL()+ siteRandom);
		log.info("Redirected to a different site from Homepage \r\r");
		
		HomePageNavigation hpn= new HomePageNavigation(driver);
		hpn.clickBlogNav();
		log.info("Clicked Homepage navigation successfully \r\r");
		
		//assertion
		if (hpn.checkIfElementIsDisplayed(LBL_NEWS_LOCATOR, driver, webelement)==true) {
			log.info("Navigated to Blog page successfully \r\r");
			log.info("Test case 003 is passed! \r\r");
		}
		else {
			log.info("Test case 003 is failed! \r\r");
		}
		
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test (groups= {"004"})
	public void homePageNavigationTest4() {
		setUp(readconfig.getApplicationBaseURL(), brRandom);
		log.info("Homepage is opened on web browser \r\r");
		
		driver.get(readconfig.getApplicationBaseURL()+ siteRandom);
		log.info("Redirected to a different site from Homepage \r\r");
		
		HomePageNavigation hpn= new HomePageNavigation(driver);
		hpn.clickAboutUsNav();
		log.info("Clicked Homepage navigation successfully \r\r");
		
		//assertion
		if (hpn.checkIfElementIsDisplayed(LBL_ABOUT_US_LOCATOR, driver, webelement)==true) {
			log.info("Navigated to About Us page successfully \r\r");
			log.info("Test case 004 is passed! \r\r");
		}
		else {
			log.info("Test case 004 is failed! \r\r");
		}
		
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
}
