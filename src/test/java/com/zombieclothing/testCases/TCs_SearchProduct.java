package com.zombieclothing.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.SearchProductPage;
import com.zombieclothing.utilities.ReadConfig;
import lombok.EqualsAndHashCode.Include;
import net.bytebuddy.implementation.bind.annotation.Super;

public class TCs_SearchProduct extends BaseClass{
	
	ReadConfig readconfig= new ReadConfig();
	@Var
//	private String searchProductKey= readconfig.getSearchProductKey();
	
	@SuppressWarnings("just in case of testing search value")
	private String searchProductKey;
	
	private String textDisplayedAfterSearch;
	private String searchProductGreaterThanOnePageKey[];
	private String searchProductOnePageKey[];
	private String searchProductWithNoResultsFound[];
	private String searchProductOnePageKeyRandom;
	private String searchProductGreaterThanOnePageKeyRandom;
	private String searchProductWithNoResultsFoundRandom;
	
	@Include
	private List<String> resultsArray= new ArrayList<String>();
	
	private String noResultsFoundTextUpSide= "Không tìm thấy nội dung bạn yêu cầu";
	private String noResultsFoundTextDownSide= "Vui lòng kiểm tra chính tả, sử dụng các từ tổng quát hơn và thử lại!";
	
	private String LBL_NO_RESULT_FOUND_UP_SIDE= "//div[@id=\"search\"]//h2";
	private String LBL_NO_RESULT_FOUND_DOWN_SIDE_RIGHT= "//div[@class=\"subtext\"]//span[2]";
	private String LBL_NO_RESULT_FOUND_DOWN_SIDE_LEFT= "//div[@class=\"subtext\"]//span[1]";
	private String LBL_TEXT_DISPLAYED_AFTER_SEARCH_LOCATOR= "//div[@class=\"content-page\" and @id=\"search\"]//p//strong";
	private String LBL_TOTAL_RESULTS_LOCATOR= "//div[@class=\"heading-page\"]//child::span";
	private String CHILD_LIST_RESULTS_LOCATORS= "//div//h3[@class=\"pro-name\"]//child::a[@title]";
	private String LIST_RESULTS_LOCATORS= "//div[contains(normalize-space(@class),\"search-list-results row\")]";
	private String BTN_NEXT_LOCATOR= "//following::a[@class=\"next\"]";
	
	@Test (groups= {"001"}, 
			enabled = true, 
				invocationCount = 1, 
					priority = -1)
	public void searchProductTest1() throws InterruptedException {
		
		this.searchProductOnePageKey= new String[] {
													
													"a",
													"fa",
													"u",
													"pl",
													"Car",
													"go",
													"Hi",
													"sA",
													"cAp",
													"hit",
													"M",
													"rose",
													"do",
													"dots",
														"hoodie in black",
													  	"jacket in",
													  	"TiEDye I",
													  	"long Sleeve",
													  	"bOmbEr",
													  	"pRinTed ShiRt",
													  	"lEoPaRd",
													  	"tanktop",
													  	"in red",
													  	"jOggEr In",
													  	"tech",
													  	"reflection",
													  	"short pants",
													  	"velvet",
													  	"Rollercoaster",
													  	"zombie black",
													  	"be",
													  	                   
												   };
		this.searchProductOnePageKeyRandom= searchProductOnePageKey[new Random().nextInt(searchProductOnePageKey.length)];
		System.out.println("\r\r"+ "The search keyword: "+ searchProductOnePageKeyRandom+ "\r\r");
		
		setUp(readconfig.getApplicationBaseURL()+ "/search/", brRandom);
		log.info("Search URL is opened on browser\n");
		
		SearchProductPage spp= new SearchProductPage(driver);
		spp.setSearchProductKey(searchProductOnePageKeyRandom);
		log.info("Inputted search product key\n");
		
		spp.executeScrollingDown(driver, javascript, 300);
		
		spp.clickSpyGlassButton();
		log.info("Clicked spy glass button");
		
		this.textDisplayedAfterSearch= driver.findElement(By.xpath(LBL_TEXT_DISPLAYED_AFTER_SEARCH_LOCATOR)).getText();
		
		//assertions
		int proCounterPerPage= driver.findElements(By.xpath("//ancestor::h3[@class=\"pro-name\"]//a")).size();
		System.out.println("\n"+ "Number of items per page: "+ proCounterPerPage);
		String resultCounter= driver.findElement(By.xpath(LBL_TOTAL_RESULTS_LOCATOR)).getText();
		String[] partitions= resultCounter.split(" ");
		int totalResult= Integer.parseInt(partitions[0]);
		System.out.println("The total number of products that needs to be found is: "+ totalResult+ "\r");
		
		boolean assertTestCase= false;
		
		//assertion if result is less than 10 => the site does not display the pagination
		
		if (totalResult<= 10 && 
								this.textDisplayedAfterSearch.contains(searchProductOnePageKeyRandom)) {
			
			for(int index= 0; index< proCounterPerPage; index++) {
				
				WebElement listResultsElement= driver.findElement(By.xpath(LIST_RESULTS_LOCATORS));
				List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHILD_LIST_RESULTS_LOCATORS));
				
				String productName= childResultsElements.get(index).getText();
				System.out.println(childResultsElements.get(index).getText()+ "\r\r");
//				System.out.println((result.toLowerCase()).contains(searchProductKey)+ "\r\r");
				
				if ((productName.toLowerCase()).contains(searchProductOnePageKeyRandom.toLowerCase())==true) {
					assertTestCase= true;
					log.info("Assert the returned products successfully \r\r");
					log.info("The product number "+ (index+1) + " is passed! "+ "\r\r");
				}
				else {
					log.info("The product number "
							 	+ (index+1)+ " is passed, "
							 		+ "but the product name"+ "\n"+ "is not matching with "
							 			+ "the inputted search text regarding word order, "
							 				+ "or the product name contains the search text entirely"+ "\r\r");
				}
			}
		}
		
		System.out.println("The total number of products found is: "+ totalResult+ "\r\r");
		
		if (assertTestCase==true) {
			log.info("Test case 001 is passed! \r\r");
		}
		else {
			log.error("Test case 001 is failed! \r\r");
		}
		
		
		spp.pauseWithTryCatch(50);
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test (groups= {"002"}, 
			enabled = true, 
				invocationCount = 1, 
					priority = 0)
	
	public void searchProductTest2 () throws InterruptedException {
		
		this.searchProductKey= "h";
		this.searchProductGreaterThanOnePageKey= new String[] {
				
															   "b", 
															   "h",
															   "ba",
															   "j",
															   "c",
															   "p",
															   "lo",
															   "kh",
															   "7",
															"fIt",
															"trouSer",
															"sTraiGht",
															"Sweater",
															"lOnG",
															"sHiRt",				
															"BLaCk",	
															"tEe",
															"zombie",
				
															  };
		this.searchProductGreaterThanOnePageKeyRandom= searchProductGreaterThanOnePageKey[new Random().nextInt(searchProductGreaterThanOnePageKey.length)];
		System.out.println("\r\r"+ "The search keyword: "+ searchProductGreaterThanOnePageKeyRandom+ "\r\r");
		
		setUp(readconfig.getApplicationBaseURL()+ "/search/", brRandom);
		log.info("Search URL is opened on browser\n");
		
		SearchProductPage spp= new SearchProductPage(driver);
		spp.setSearchProductKey(searchProductGreaterThanOnePageKeyRandom);
		log.info("Inputted search product key\n");
		
		spp.executeScrollingDown(driver, javascript, 300);
		
		spp.clickSpyGlassButton();
		log.info("Clicked spy glass button");
		
		this.textDisplayedAfterSearch= driver.findElement(By.xpath(LBL_TEXT_DISPLAYED_AFTER_SEARCH_LOCATOR)).getText();
		
		//assertions
		int proCounterPerPage= driver.findElements(By.xpath("//ancestor::h3[@class=\"pro-name\"]//a")).size();
		System.out.println("\n"+ "Number of items per page: "+ proCounterPerPage);
		String resultCounter= driver.findElement(By.xpath(LBL_TOTAL_RESULTS_LOCATOR)).getText();
		String[] partitions= resultCounter.split(" ");
		int totalResult= Integer.parseInt(partitions[0]);
		System.out.println("The total number of products that needs to be found is: "+ totalResult+ "\r");
		
		boolean assertTestCase= false;
		
		//assertion if result is greater than 10 => the site displays the pagination
		
		if (totalResult>10 && 
							  this.textDisplayedAfterSearch.contains(searchProductGreaterThanOnePageKeyRandom)) {
			spp.executeScrollingDown(driver, javascript, 3000);
			spp.pauseWithTryCatch(2000);
				
			@Var
			int indexLocator=0;
			int indexClick=0;
				
			@SuppressWarnings("this variable will be false when product is no longer")
			boolean checkIfProductIsReachedLimit= false;
				
			for (int index= 1; index< totalResult; index++) {
						
				WebElement listResultsElement= driver.findElement(By.xpath(LIST_RESULTS_LOCATORS));
				List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHILD_LIST_RESULTS_LOCATORS));
				WebElement nextButton= driver.findElement(By.xpath(BTN_NEXT_LOCATOR));
			
				String productName= childResultsElements.get(indexLocator).getText();
				System.out.println(childResultsElements.get(indexLocator).getText()+ "\r\r");
			
				if ((productName.toLowerCase()).contains(searchProductGreaterThanOnePageKeyRandom.toLowerCase())==true) {
					assertTestCase=true;
					log.info("Assert the returned products successfully \r\r");
					log.info("The product number "+ index+ " is passed! "+ "\r\r");
				}
				else {
					log.info("The product number "
						 	+ (index+1)+ " is passed, "
						 		+ "but the product name"+ "\n"+ "is not matching with "
						 			+ "the inputted search text regarding word order, "
						 				+ "or the product name contains the search text entirely"+ "\r\r");
				}
			
				resultsArray.add(childResultsElements.get(indexLocator).getText());
				System.out.println("Element number "+ (index)+ " is added to the array: "+ resultsArray+ "\r");
				indexLocator++;
//				System.out.println(index);
				spp.executeScrollingDown(driver, javascript, 3000);
						
				int totalResultReminder= totalResult%10;
//				System.out.println(totalResultReminder);
						
				if (totalResult-index== totalResultReminder) {
								
					System.out.println("\r-----------\\\\-------------------\\\\------------------------***\\--THE LAST PAGE--\\***------------------------\\\\-------------------\\\\-------------\n\r");
					nextButton.click();
					spp.executeScrollingDown(driver, javascript, 300);
					for (int indexFinalAssertedResultPage= 0; 
							indexFinalAssertedResultPage< totalResultReminder; 
								indexFinalAssertedResultPage++) {
								
						driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
						WebElement listResultsElementLastPage= driver.findElement(By.xpath(LIST_RESULTS_LOCATORS));
						List<WebElement> childResultsElementsLastPage= listResultsElementLastPage.findElements(By.xpath(CHILD_LIST_RESULTS_LOCATORS));
					
						String productNameLastPage= childResultsElementsLastPage.get(indexFinalAssertedResultPage).getText();
						System.out.println(childResultsElementsLastPage.get(indexFinalAssertedResultPage).getText()+ "\r\r");
						if ((productNameLastPage.toLowerCase()).contains(searchProductGreaterThanOnePageKeyRandom.toLowerCase())==true) {
							log.info("Assert the returned products successfully \r\r");
							log.info("The product number "+ ((index+indexFinalAssertedResultPage)+ 1)+ " is passed! "+ "\r\r");
						}
						else {
//							log.error("The product number "+ (index+indexFinalAssertedResultPage)+ 1+ " is failed! "+ "\r\r");
							log.info("The product number "
								 	+ ((index+indexFinalAssertedResultPage)+ 1)+ " is passed, "
								 		+ "but the product name/n is not matching with "
								 			+ "the inputted search text regarding word order, "
								 				+ "or the product name contains the search text entirely"+ "\r\r");
						}
					
						resultsArray.add(childResultsElementsLastPage.get(indexFinalAssertedResultPage).getText());
						System.out.println("Element number "+ ((index+1)+ indexFinalAssertedResultPage)+ " is added to the array "+ resultsArray+ "\r");
//						System.out.println(((index+1)+ indexFinalAssertedResultPage));
								
						if (indexFinalAssertedResultPage== totalResultReminder-1) {
							System.out.println("\r//---------//---DONE---//---------\r\r");
							checkIfProductIsReachedLimit= true;
						}
					}
				}
						
				if (checkIfProductIsReachedLimit==true) {
					break;
				}
						
				if ((index)%10==0 && index!=0) {
					indexLocator-=11;
					System.out.println("-----------\\--***THE NEXT PAGE***--\\-------------\n\n");
					if (nextButton.isDisplayed()==true) {
						nextButton.click();
						indexClick++;
					}
							
					driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
					indexLocator++;
					spp.pauseWithTryCatch(200);
							}
						}//for loop
					}
		System.out.println("The total number of products found is: "+ totalResult+ "\r\r");
		
		if (assertTestCase==true) {
			log.info("Test case 002 is passed! \r\r");
		}
		else {
			log.error("Test case 002 is failed! \r\r");
		}
		
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test (groups= {"003"}, 
			enabled = true, 
				invocationCount = 1, 
					priority = 1)
	public void searchProductTest3() throws InterruptedException {
		
		this.searchProductWithNoResultsFound= new String[] {
				
															"cargo jeans fountain",
														"max Shirt",
													"Quadra",
												"tron",
															      
												           };
		this.searchProductWithNoResultsFoundRandom= 
				searchProductWithNoResultsFound
					[new Random().nextInt(searchProductWithNoResultsFound.length)];
		
		System.out.println("\r\r"+ "The search keyword: "+ searchProductWithNoResultsFoundRandom+ "\r\r");
		
		setUp(readconfig.getApplicationBaseURL()+ "/search/", brRandom);
		log.info("Search URL is opened on browser\n");
		
		SearchProductPage spp= new SearchProductPage(driver);
		spp.setSearchProductKey(searchProductWithNoResultsFoundRandom);
		log.info("Inputted search product key\n");
		
		spp.pauseWithTryCatch(150);
		spp.executeScrollingDown(driver, javascript, 2500);
		
		spp.clickSpyGlassButton();
		log.info("Clicked spy glass button\n");
		
		String noTextResultsFoundDownSide_getText= driver.findElement(By.xpath(LBL_NO_RESULT_FOUND_DOWN_SIDE_RIGHT)).getText();
		String noTextResultsFoundUpSide_getText= driver.findElement(By.xpath(LBL_NO_RESULT_FOUND_UP_SIDE)).getText();
		String noTextResultsFoundDownSideLeft_getText= driver.findElement(By.xpath(LBL_NO_RESULT_FOUND_DOWN_SIDE_LEFT)).getText();
		
		if (noTextResultsFoundUpSide_getText.equals(noResultsFoundTextUpSide)==true 
				&& noTextResultsFoundDownSide_getText.equals(noResultsFoundTextDownSide)==true 
					&& noTextResultsFoundDownSideLeft_getText.contains(searchProductWithNoResultsFoundRandom)==true) {
			
			log.info("Test case 003 is passed! \r\r");
			
		}
		else {
			log.error("Test case 003 is failed! \r\r");
		}
		
		tearDown();
		log.warn("\n\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
		
		private String[] append(String[] resultsArr, WebElement webElement) {
			return resultsArr;
		}
	}

