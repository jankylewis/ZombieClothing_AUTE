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

public class TC_SearchProduct extends BaseClass{
	
	ReadConfig readconfig= new ReadConfig();
	@Var
//	private String searchProductKey= readconfig.getSearchProductKey();
	private String searchProductKey= "h";
	
	@Test
	public void searchProductTest() throws InterruptedException {
		setUp(readconfig.getApplicationBaseURL()+ "/search/", brRandom);
		log.info("Search URL is opened on browser\n");
		
		SearchProductPage spp= new SearchProductPage(driver);
		spp.setSearchProductKey(searchProductKey);
		log.info("Inputted search product key\n");
		
		spp.executeScrollingDown(driver, javascript, 300);
		
		spp.clickSpyGlassButton();
		log.info("Clicked spy glass button");
		
		//assertions
		int proCounterPerPage= driver.findElements(By.xpath("//ancestor::h3[@class=\"pro-name\"]//a")).size();
		System.out.println("\n"+ "Number of items per page: "+ proCounterPerPage);
		List<String> resultsArray= new ArrayList<String>();
		
		String LBL_TOTAL_RESULTS_LOCATOR= "//div[@class=\"heading-page\"]//child::span";
		String resultCounter= driver.findElement(By.xpath(LBL_TOTAL_RESULTS_LOCATOR)).getText();
		String[] partitions= resultCounter.split(" ");
		int totalResult= Integer.parseInt(partitions[0]);
		System.out.println("The total number of products that needs to be found is: "+ totalResult+ "\r");
		
		String CHILD_LIST_RESULTS_LOCATORS= "//div//h3[@class=\"pro-name\"]//child::a[@title]";
		String LIST_RESULTS_LOCATORS= "//div[contains(normalize-space(@class),\"search-list-results row\")]";
		String BTN_NEXT_LOCATOR= "//following::a[@class=\"next\"]";
		
		//assertion if result is less than 10 => the site does not display the pagination
		
		if (totalResult<= 10) {
			for(int index= 0; index< proCounterPerPage; index++) {
				
				WebElement listResultsElement= driver.findElement(By.xpath(LIST_RESULTS_LOCATORS));
				List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHILD_LIST_RESULTS_LOCATORS));
				
				String productName= childResultsElements.get(index).getText();
				System.out.println(childResultsElements.get(index).getText()+ "\r\r");
//				System.out.println((result.toLowerCase()).contains(searchProductKey)+ "\r\r");
				
				if ((productName.toLowerCase()).contains(searchProductKey)==true) {
					log.info("Assert the returned products successfully \r\r");
					log.info("The product number "+ index+ " is passed! "+ "\r\r");
				}
				else {
					log.error("The product number "+ index+ " is failed! "+ "\r\r");
				}
			}
		}

		//assertion if result is greater than 10 => the site displays the pagination
		if (totalResult>10) {
			spp.executeScrollingDown(driver, javascript, 3000);
			spp.pauseWithTryCatch(2000);
				
			@Var
			int indexLocator=0;
			int indexClick=0;
				
			@SuppressWarnings("unused")
			boolean checkIfProductIsReachedLimit= false;
				
			for (int index= 1; index< totalResult; index++) {
						
			WebElement listResultsElement= driver.findElement(By.xpath(LIST_RESULTS_LOCATORS));
			List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHILD_LIST_RESULTS_LOCATORS));
			WebElement nextButton= driver.findElement(By.xpath(BTN_NEXT_LOCATOR));
			
			String productName= childResultsElements.get(indexLocator).getText();
			System.out.println(childResultsElements.get(indexLocator).getText()+ "\r");
			
			if ((productName.toLowerCase()).contains(searchProductKey)==true) {
				log.info("Assert the returned products successfully \r\r");
				log.info("The product number "+ index+ " is passed! "+ "\r\r");
			}
			else {
				log.error("The product number "+ index+ " is failed! "+ "\r\r");
			}
			
			resultsArray.add(childResultsElements.get(indexLocator).getText());
			System.out.println("Element number "+ (index)+ " is added to the array: "+ resultsArray+ "\r");
			indexLocator++;
//			System.out.println(index);
			spp.executeScrollingDown(driver, javascript, 3000);
						
			int totalResultReminder= totalResult%10;
//			System.out.println(totalResultReminder);
						
			if (totalResult-index== totalResultReminder) {
								
				System.out.println("-----------\\\\--***THE LAST PAGE***--\\\\-------------\n");
				nextButton.click();
				spp.executeScrollingDown(driver, javascript, 300);
				for (int indexFinalAssertedResultPage= 0; 
						indexFinalAssertedResultPage< totalResultReminder; 
							indexFinalAssertedResultPage++) {
								
					driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
					WebElement listResultsElementLastPage= driver.findElement(By.xpath(LIST_RESULTS_LOCATORS));
					List<WebElement> childResultsElementsLastPage= listResultsElementLastPage.findElements(By.xpath(CHILD_LIST_RESULTS_LOCATORS));
					
					String productNameLastPage= childResultsElementsLastPage.get(indexFinalAssertedResultPage).getText();
					System.out.println(childResultsElementsLastPage.get(indexFinalAssertedResultPage).getText()+ "\r");
					if ((productNameLastPage.toLowerCase()).contains(searchProductKey)==true) {
						log.info("Assert the returned products successfully \r\r");
						log.info("The product number "+ (index+indexFinalAssertedResultPage)+ 1+ " is passed! "+ "\r\r");
					}
					else {
						log.error("The product number "+ (index+indexFinalAssertedResultPage)+ 1+ " is failed! "+ "\r\r");
					}
					
					resultsArray.add(childResultsElementsLastPage.get(indexFinalAssertedResultPage).getText());
					System.out.println("Element number "+ ((index+1)+ indexFinalAssertedResultPage)+ " is added to the array "+ resultsArray+ "\r");
//					System.out.println(((index+1)+ indexFinalAssertedResultPage));
								
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
		
		else {
			spp.pauseWithTryCatch(50);
			tearDown();
		}
		
		System.out.println("The total number of products found is: "+ totalResult+ "\r");
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}

	private String[] append(String[] resultsArr, WebElement webElement) {
		return null;
	}
}
