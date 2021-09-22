package com.zombieclothing.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.SearchProductPage;
import com.zombieclothing.utilities.ReadConfig;

public class TC_SearchProduct_001 extends BaseClass{
	
	ReadConfig readconfig= new ReadConfig();
	@Var
	private String searchProductKey= readconfig.getSearchProductKey();
	
	@Test
	public void searchProductTest() {
		setUp(readconfig.getApplicationBaseURL()+ "/search/", "chrome");
		log.info("Search URL is opened on browser\n");
		
		SearchProductPage spp= new SearchProductPage(driver);
		spp.setSearchProductKey(searchProductKey);
		log.info("Inputted search product key\n");
		
		spp.clickSpyGlassButton();
		log.info("Clicked spy glass button");
		
		//assertions
		
		int xpathCounter= driver.findElements(By.xpath("//ancestor::h3[@class=\"pro-name\"]//a")).size();
		System.out.println("\n"+ xpathCounter+ "\n");
		
		//for loop
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
}
