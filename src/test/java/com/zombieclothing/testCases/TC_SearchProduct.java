package com.zombieclothing.testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.SearchProductPage;
import com.zombieclothing.utilities.ReadConfig;

public class TC_SearchProduct extends BaseClass{
	
	ReadConfig readconfig= new ReadConfig();
	@Var
//	private String searchProductKey= readconfig.getSearchProductKey();
	private String searchProductKey= "a";
	
	@Test
	public void searchProductTest() throws InterruptedException {
		setUp(readconfig.getApplicationBaseURL()+ "/search/", "chrome");
		log.info("Search URL is opened on browser\n");
		
		SearchProductPage spp= new SearchProductPage(driver);
		spp.setSearchProductKey(searchProductKey);
		log.info("Inputted search product key\n");
		
		spp.executeScrollingDown(driver, javascript, 300);
		
		spp.clickSpyGlassButton();
		log.info("Clicked spy glass button");
		
		//assertions
		
		int xpathCounter= driver.findElements(By.xpath("//ancestor::h3[@class=\"pro-name\"]//a")).size();
		System.out.println("\n"+ xpathCounter+ "\n");
		List<String> resultsArray= new ArrayList<String>();
		
		String CHILD_LIST_RESULTS_LOCATORS= "//div//h3[@class=\"pro-name\"]//child::a[@title]";
		String LIST_RESULTS_LOCATORS= "//div[contains(normalize-space(@class),\"search-list-results row\")]";
		String BTN_NEXT_LOCATOR= "//following::a[@class=\"next\"]";
		
		WebElement listResultsElement= driver.findElement(By.xpath(LIST_RESULTS_LOCATORS));
		List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHILD_LIST_RESULTS_LOCATORS));
		
		//assertion if result < 10 => the site does not display the pagination
		
			for(int index= 0; index< xpathCounter; index++) {
				
				System.out.println(childResultsElements.get(index).getText());
				String result= childResultsElements.get(index).getText();
				System.out.println((result.toLowerCase()).contains(searchProductKey));
			}
		
//		String BTN_NEXT_LOCATOR= "//following::a[@class=\"next\"]";
//		String LBL_TOTAL_RESULTS_LOCATOR= "//div[@class=\"heading-page\"]//child::span";
//		
//		WebElement btnNext= driver.findElement(By.xpath(BTN_NEXT_LOCATOR));
//		
//		WebElement nextButton= driver.findElement(By.xpath(BTN_NEXT_LOCATOR));

//		}
//		else {
//			String resultCounter= driver.findElement(By.xpath(LBL_TOTAL_RESULTS_LOCATOR)).getText();
//			String[] partitions= resultCounter.split(" ");
//			int totalResult= Integer.parseInt(partitions[0]);
//			spp.executeScrollingDown(driver, javascript, 3000);
//			spp.pauseWithTryCatch(2000);
//			for (int index= 0; index< totalResult; index++) {
//					
//					System.out.println(childResultsElements.get(index).getText());
//				
//					resultsArray.add(childResultsElements.get(index).getText());
//					
//					System.out.println("Element number "+ (index)+ ": "+ resultsArray);
//					
//					spp.executeScrollingDown(driver, javascript, 3000);
//					if ((index)%9==0 && index!=0) {
//						btnNext.click();
//						spp.pauseWithTryCatch(1000);
//						spp.executeScrollingDown(driver, javascript, 300);
//						System.out.println(childResultsElements.get(index-9).getText());
//						
//					}
//					
//					
//			}
//		
//		}			
	
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}

	private String[] append(String[] resultsArr, WebElement webElement) {
		return null;
	}
	
}
