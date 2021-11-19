package com.zombieclothing.testCases;


import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.SortProductPage;
import com.zombieclothing.utilities.ReadConfig;
import lombok.EqualsAndHashCode;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


    /* Mapped to Abstract Class --| */
    @Listeners(BaseTestListeners.class)
	public class TCs_SortProduct extends BaseClass{

    ReadConfig readConfig= new ReadConfig();
    private WebDriver dr;
    private boolean checkPointIfTheTestCaseIsPassed; ; ; ; ;
    private boolean checkPointIfTheTestCaseIsFailed;

    @Var
    private String ascendingProduct= "Giá: Tăng dần";
    private String descendingProduct= "Giá: Giảm dần";
    private String alphabeticalProductName= "Tên: A-Z";
    private String nonAlphabeticalProductName= "Tên: Z-A";
        private String selAscendingValue= "price-ascending";
        private String selDescendingValue= "price-descending";
        private String selTitleAscendingValue= "title-ascending";
        private String selTitleDescendingValue= "title-descending";

            @EqualsAndHashCode.Include
            private List<Integer> productsPriceArray= new ArrayList<Integer>();
            private List<Character> productsNameArray= new ArrayList<Character>();

    private String BTN_NEXT_LOCATOR= "//following::a[@class=\"next\"]";
    private By nextButtonLocator= By.xpath(BTN_NEXT_LOCATOR);

    private String PAR_LIST_PRODUCT_LOCATOR= "//div[contains(normalize-space(@class),\"filter clearfix\")]";
    private String CHI_LIST_PRODUCT_LOCATOR= "//p[contains(normalize-space(@class),\"pro-price\")]//span";

    private String CHI_LIST_PRODUCT_NAME_LOCATOR= "//h3//child::a[@title][1]";
    private String PAR_SEL_LOCATOR= "//following::select";

        @Test (groups= {"001", "ascending"},
                priority = -1)
        public void sortProductAscendingly() throws InterruptedException {

            setUp(readconfig.getApplicationBaseURL(), "chrome");

            SortProductPage spp= new SortProductPage(driver);
            spp.clickTatcaspNavigationLink();
            driver.navigate().refresh();
            spp.executeScrollingDown(driver, javascript,300);
//            spp.selectAscending(driver, PAR_SEL_LOCATOR, selAscendingValue);
            spp.clickOnSortCriterion(driver, javascript, 0, ascendingProduct);

            int indexLocator= 0; ; ;   ; ; ;   ; ; ;   ; ; ; int indexProductPriceArray= 0;

            assertProducTList: 	/**/    for (int index= 1; index<362; index+=1) {

                if (index<361) {
                    WebElement listResultsElement= driver.findElement(By.xpath(PAR_LIST_PRODUCT_LOCATOR));
                    List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHI_LIST_PRODUCT_LOCATOR));
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    String productPrice= childResultsElements.get(indexLocator).getText();

                    //***-----------***        HANDLING SUBSTRING, SPLIT, PARSEINT, REGEX

                    String trimTheLastCharacter= productPrice.substring(0, (productPrice.length()-1));
                    String[] splitTheCommaCharacter= trimTheLastCharacter.split(",");
                    String combinePartitions= splitTheCommaCharacter[0]+ splitTheCommaCharacter[1];
                    int getProductPrice= Integer.parseInt(combinePartitions);

                    printTheIndexToConsole: System.out.println(getProductPrice+ "\n"+ " - product number: "+ index);
                    productsPriceArray.add(getProductPrice);
                    System.out.println(productsPriceArray);
                    if (indexProductPriceArray>0) {
                        if (productsPriceArray.get(indexProductPriceArray)>= productsPriceArray.get(indexProductPriceArray-1)) {
                            log.info("Assert the ascending product price successfully!!"+ "\n\n");
                            checkPointIfTheTestCaseIsPassed=true;
                            Assert.assertFalse(false);
                        }
                        else {
                            log.error("Assert the ascending product price unsuccessfully due to an error!!");
                            checkPointIfTheTestCaseIsFailed=true;
                            Assert.assertFalse(true);
                        }
                    }
                    indexProductPriceArray++;
                    spp.executeScrollingDown(driver, javascript,3000);;;;;;;;;;;;;;;
                    if (index%20==0 && index!=0) {
                        indexLocator-=20;
                        System.out.println("-----------\\--***THE NEXT PAGE***--\\-------------\n\n");
                        if (nextButton.isDisplayed()==true) {
                            nextButton.click();
                            spp.pauseWithTryCatch(350);
                        }
                    }
                    driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
                    indexLocator++;
                    spp.pauseWithTryCatch(20);

                }
                if (index> 360) {  			//LAST PAGE: the product number 361 => 373
                    System.out.println("-----------\\--***THE LAST PAGE***--\\-------------\n\n");
                    int indexLocatorLastPage= 0;

                    WebElement listResultsElement= driver.findElement(By.xpath(PAR_LIST_PRODUCT_LOCATOR));
                    List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHI_LIST_PRODUCT_LOCATOR));
                    System.out.println(childResultsElements.size()+ ": size");

                    loopForLastPage: for(int indexLastPage= 1;
                                         indexLastPage< (childResultsElements.size())+1;
                                         indexLastPage+=1) {

                        String productPrice= childResultsElements.get(indexLocatorLastPage).getText();
//                    System.out.println(indexLocator+ " - indexLocator");

                        //***-----------***        HANDLING SUBSTRING, SPLIT, PARSEINT, REGEX
                        String trimTheLastCharacter= productPrice.substring(0, (productPrice.length()-1));
                        String[] splitTheCommaCharacter= trimTheLastCharacter.split(",");
                        String combinePartitions= splitTheCommaCharacter[0]+ splitTheCommaCharacter[1];
                        int getProductPrice= Integer.parseInt(combinePartitions);

                        printTheIndexToConsole: System.out.println(getProductPrice+ "\n"+ " - product number: "+ index);

                        productsPriceArray.add(getProductPrice);
                        System.out.println(productsPriceArray);
                        if (indexProductPriceArray>0) {
                            if (productsPriceArray.get(indexProductPriceArray)>= productsPriceArray.get(indexProductPriceArray-1)) {
                                log.info("Assert the ascending product price successfully!!"+ "\n\n");
                                checkPointIfTheTestCaseIsPassed=true;
                                Assert.assertFalse(false);
                            }
                            else {
                                log.error("Assert the ascending product price unsuccessfully due to an error!!");
                                checkPointIfTheTestCaseIsFailed=true;
                                Assert.assertFalse(true);
                            }
                        }
                        plus:   index++;
                        plus:        indexProductPriceArray++;
                        plus:            indexLocator+=2-1;
                        plus:               indexLocatorLastPage+=2-1;
                    }
                }
            }
            if (checkPointIfTheTestCaseIsPassed==true || checkPointIfTheTestCaseIsFailed!=true) {
                Assert.assertFalse(false);
                log.info("\\--------------**---------"+"TEST CASE 001 IS PASSED!"+ "\\-----------**----------");
            }
            else if (checkPointIfTheTestCaseIsFailed==true || checkPointIfTheTestCaseIsPassed!=true){
                Assert.assertFalse(true);
                log.error("\\--------------**---------"+"TEST CASE 001 IS FAILED!"+ "\\-----------**----------");
            }
            tearDown();
            log.warn("//----------------**--TERMINATED TEST CASE 001--**------------------//!!");
    }


        @Test (groups= {"002", "descending"},
                priority = 0)
        public void sortProductDescendingly() throws InterruptedException {

            setUp(readconfig.getApplicationBaseURL(), "chrome");

            SortProductPage spp= new SortProductPage(driver);
            spp.clickTatcaspNavigationLink();
            driver.navigate().refresh();
            spp.executeScrollingDown(driver, javascript,300);
            spp.selectAscending(driver, PAR_SEL_LOCATOR, selDescendingValue);
//        spp.clickOnSortCriterion(driver, javascript, 0, ascendingProduct);

            int indexLocator= 0; ; ;   ; ; ;   ; ; ;   ; ; ; int indexProductPriceArray= 0;

            assertProducTList: 	/**/    for (int index= 1; index<362; index+=1) {

                if (index<361) {
                    WebElement listResultsElement= driver.findElement(By.xpath(PAR_LIST_PRODUCT_LOCATOR));
                    List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHI_LIST_PRODUCT_LOCATOR));
                    WebElement nextButton= driver.findElement(By.xpath(BTN_NEXT_LOCATOR));
                    String productPrice= childResultsElements.get(indexLocator).getText();

                    //***-----------***        HANDLING SUBSTRING, SPLIT, PARSEINT, REGEX

                    String trimTheLastCharacter= productPrice.substring(0, (productPrice.length()-1));
                    String[] splitTheCommaCharacter= trimTheLastCharacter.split(",");
                    String combinePartitions= splitTheCommaCharacter[0]+ splitTheCommaCharacter[1];
                    int getProductPrice= Integer.parseInt(combinePartitions);

                    printTheIndexToConsole: System.out.println(getProductPrice+ "\n"+ " - product number: "+ index);

                    productsPriceArray.add(getProductPrice);
                    System.out.println(productsPriceArray);
                    if (indexProductPriceArray>0) {
                        if (productsPriceArray.get(indexProductPriceArray)<= productsPriceArray.get(indexProductPriceArray-1)) {
                            log.info("Assert the descending product price successfully!!"+ "\n\n");
                            checkPointIfTheTestCaseIsPassed=true;
                            Assert.assertFalse(false);
                        }
                        else {
                            log.error("Assert the descending product price unsuccessfully due to an error!!");
                            checkPointIfTheTestCaseIsFailed=true;
                            Assert.assertFalse(true);
                        }
                    }
                    indexProductPriceArray++;
                    spp.executeScrollingDown(driver, javascript,3000);;;;;;;;;;;;;;;
                    if (index%20==0 && index!=0) {
                        indexLocator-=20;
                        System.out.println("-----------\\--***THE NEXT PAGE***--\\-------------\n\n");
                        if (nextButton.isDisplayed()==true) {
                            nextButton.click();
                            spp.pauseWithTryCatch(350);
                        }
                    }
                    driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
                    indexLocator++;
                    spp.pauseWithTryCatch(20);

                }
                if (index> 360) {  			//LAST PAGE: the product number 361 => 373
                    System.out.println("-----------\\--***THE LAST PAGE***--\\-------------\n\n");
                    int indexLocatorLastPage= 0;

                    WebElement listResultsElement= driver.findElement(By.xpath(PAR_LIST_PRODUCT_LOCATOR));
                    List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHI_LIST_PRODUCT_LOCATOR));
                    System.out.println(childResultsElements.size()+ ": size");

                    loopForLastPage: for(int indexLastPage= 1;
                                         indexLastPage< (childResultsElements.size())+1;
                                         indexLastPage+=1) {

                        String productPrice= childResultsElements.get(indexLocatorLastPage).getText();
//                    System.out.println(indexLocator+ " - indexLocator");

                        //***-----------***        HANDLING SUBSTRING, SPLIT, PARSEINT, REGEX
                        String trimTheLastCharacter= productPrice.substring(0, (productPrice.length()-1));
                        String[] splitTheCommaCharacter= trimTheLastCharacter.split(",");
                        String combinePartitions= splitTheCommaCharacter[0]+ splitTheCommaCharacter[1];
                        int getProductPrice= Integer.parseInt(combinePartitions);

                        printTheIndexToConsole: System.out.println(getProductPrice+ "\n"+ " | product number: "+ index);

                        productsPriceArray.add(getProductPrice);
                        System.out.println(productsPriceArray);
                        if (indexProductPriceArray>0) {
                            if (productsPriceArray.get(indexProductPriceArray)<= productsPriceArray.get(indexProductPriceArray-1)) {
                                log.info("Assert the descending product price successfully!!"+ "\n\n");
                                checkPointIfTheTestCaseIsPassed=true;
                                Assert.assertFalse(false);
                            }
                            else {
                                log.error("Assert the descending product price unsuccessfully due to an error!!");
                                checkPointIfTheTestCaseIsFailed=true;
                                Assert.assertFalse(true);
                            }
                        }
                        plus:   index++;
                        plus:        indexProductPriceArray++;
                        plus:            indexLocator+=2-1;
                        plus:               indexLocatorLastPage+=2-1;
                    }
                }
            }
            if (checkPointIfTheTestCaseIsPassed==true || checkPointIfTheTestCaseIsFailed!=true) {
                Assert.assertFalse(false);
                log.info("\\--------------**---------"+"TEST CASE 002 IS PASSED!"+ "\\-----------**----------");
            }
            else if (checkPointIfTheTestCaseIsFailed==true || checkPointIfTheTestCaseIsPassed!=true){
                Assert.assertFalse(true);
                log.error("\\--------------**---------"+"TEST CASE 002 IS FAILED!"+ "\\-----------**----------");
            }
            tearDown();
            log.warn("//----------------**--TERMINATED TEST CASE--**------------------//!!");
        }

        @Test (groups= {"003", "alphabetical order"},
                priority = 1)
        public void sortProductAlphabetically() throws InterruptedException {

            setUp(readconfig.getApplicationBaseURL(), "chrome");

            SortProductPage spp= new SortProductPage(driver);
            spp.clickTatcaspNavigationLink();
            driver.navigate().refresh();
            spp.executeScrollingDown(driver, javascript,300);
            spp.selectAscending(driver, PAR_SEL_LOCATOR, selTitleAscendingValue);

            int indexLocator= 0; ; ;   ; ; ;   ; ; ;   ; ; ; int indexProductNameArray= 0;

            assertProducTList: 	/**/    for (int index= 1; index<362; index+=1) {

                if (index<361) {
                    WebElement listResultsElement= driver.findElement(By.xpath(PAR_LIST_PRODUCT_LOCATOR));
                    List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHI_LIST_PRODUCT_NAME_LOCATOR));
                    WebElement nextButton= driver.findElement(By.xpath(BTN_NEXT_LOCATOR));
                    String productName= childResultsElements.get(indexLocator).getText();

                    //***-----------***        HANDLING SUBSTRING

                    char firstLetterOfProductName= productName.charAt(0);
                    printTheIndexToConsole: System.out.println(productName+ ""+ " | product number: "+ index);

                    productsNameArray.add(firstLetterOfProductName);
                    System.out.println(productsNameArray);
                    if (indexProductNameArray>0) {
                        if (productsNameArray.get(indexProductNameArray).compareTo(productsNameArray.get(indexProductNameArray-1))>0
                            /*orCondition:    --*/     || productsNameArray.get(indexProductNameArray).compareTo(productsNameArray.get(indexProductNameArray-1))==0) {
                            log.info("Asserted the product name ascending (==alphabetical order) successfully!!"+ "\n\n");
                            checkPointIfTheTestCaseIsPassed=true;
                            if (checkPointIfTheTestCaseIsPassed==true) {

                                Assert.assertFalse(false);

                            }
                        }
                        else {
                            log.error("Assert the product name ascending (!=alphabetical order) unsuccessfully due to an error!!");
                            checkPointIfTheTestCaseIsFailed=true;
                            if (checkPointIfTheTestCaseIsFailed!=false) {

                                Assert.assertFalse(true);

                            }
                        }
                    }
                    indexProductNameArray++;
                    spp.executeScrollingDown(driver, javascript,3000);;;;;;;;;;;;;;;
                    if (index%20==0 && index!=0) {
                        indexLocator-=20;
                        System.out.println("-----------\\--***THE NEXT PAGE***--\\-------------\n\n");
                        if (nextButton.isDisplayed()==true) {
                            nextButton.click();
                            spp.pauseWithTryCatch(350);
                        }
                    }
                    driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
                    indexLocator++;
                    spp.pauseWithTryCatch(20);

                }
                if (index> 360) {  			//LAST PAGE: the product number 361 => 373
                    System.out.println("-----------\\--***THE LAST PAGE***--\\-------------\n\n");
                    int indexLocatorLastPage= 0;

                    WebElement listResultsElement= driver.findElement(By.xpath(PAR_LIST_PRODUCT_LOCATOR));
                    List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHI_LIST_PRODUCT_NAME_LOCATOR));
                    System.out.println(childResultsElements.size()+ ": size");

                    loopForLastPage: for(int indexLastPage= 1;
                                         indexLastPage< (childResultsElements.size())+1;
                                         indexLastPage+=1) {

                        String productName= childResultsElements.get(indexLocator).getText();

                        //***-----------***        HANDLING SUBSTRING
                        char firstLetterOfProductName= productName.charAt(0);

                        printTheIndexToConsole: System.out.println(productName+ ""+ " - product number: "+ index);

                        productsNameArray.add(firstLetterOfProductName);
                        System.out.println(productsNameArray);
                        if (indexProductNameArray>0) {
                            if (productsNameArray.get(indexProductNameArray).compareTo(productsNameArray.get(indexProductNameArray-1))>0
        /*orCondition:    --*/     || productsNameArray.get(indexProductNameArray).compareTo(productsNameArray.get(indexProductNameArray-1))==0) {
                                log.info("Asserted the product name ascending (==alphabetical order) successfully!!"+ "\n\n");
                                checkPointIfTheTestCaseIsPassed=true;
                                if (checkPointIfTheTestCaseIsPassed==true) {

                                    Assert.assertFalse(false);

                                }
                            }
                            else {
                                log.error("Assert the product name ascending (!=alphabetical order) unsuccessfully due to an error!!");
                                checkPointIfTheTestCaseIsFailed=true;
                                if (checkPointIfTheTestCaseIsFailed!=false) {

                                    Assert.assertFalse(true);

                                }
                            }
                        }
                        plus:   index++;
                        plus:        indexProductNameArray++;
                        plus:            indexLocator+=2-1;
                        plus:               indexLocatorLastPage+=2-1;
                    }
                }
            }

            if (checkPointIfTheTestCaseIsPassed==true || checkPointIfTheTestCaseIsFailed!=true) {
                Assert.assertFalse(false);
                log.info("\\--------------**---------"+"TEST CASE 003 IS PASSED!"+ "\\-----------**----------");
            }
            else if (checkPointIfTheTestCaseIsFailed==true || checkPointIfTheTestCaseIsPassed!=true){
                Assert.assertFalse(true);
                log.error("\\--------------**---------"+"TEST CASE 003 IS FAILED!"+ "\\-----------**----------");
            }
            tearDown();
            log.warn("//----------------**--TERMINATED TEST CASE 003--**------------------//!!");
        }

        @Test (groups= {"004", "non-alphabetic order"},
                priority = 2)
        public void sortProductNonAlphabetically() throws InterruptedException {

    triggerBrowser: setUp(readconfig.getApplicationBaseURL(), "chrome");

            SortProductPage spp= new SortProductPage(driver);
            spp.clickTatcaspNavigationLink();
            driver.navigate().refresh();
            spp.executeScrollingDown(driver, javascript,300);
            spp.selectAscending(driver, PAR_SEL_LOCATOR, selTitleDescendingValue);

            int indexLocator= 0; ; ;   ; ; ;   ; ; ;   ; ; ; int indexProductNameArray= 0;

            assertProducTList: 	/**/    for (int index= 1; index<362; index+=1) {

                if (index<361) {
                    WebElement listResultsElement= driver.findElement(By.xpath(PAR_LIST_PRODUCT_LOCATOR));
                    List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHI_LIST_PRODUCT_NAME_LOCATOR));
                    WebElement nextButton= driver.findElement(By.xpath(BTN_NEXT_LOCATOR));
                    String productName= childResultsElements.get(indexLocator).getText();

                    //***-----------***        HANDLING SUBSTRING

                    char firstLetterOfProductName= productName.charAt(0);
                    printTheIndexToConsole: System.out.println(productName+ ""+ " | product number: "+ index);

                    productsNameArray.add(firstLetterOfProductName);
                    System.out.println(productsNameArray);
                    if (indexProductNameArray>0) {
                        if (productsNameArray.get(indexProductNameArray).compareTo(productsNameArray.get(indexProductNameArray-1))==0
                                /*orCondition:    --*/     || productsNameArray.get(indexProductNameArray).compareTo(productsNameArray.get(indexProductNameArray-1))<0) {
                            log.info("Asserted the product name ascending (==alphabetical order) successfully!!"+ "\n\n");
                            checkPointIfTheTestCaseIsPassed=true;
                            if (checkPointIfTheTestCaseIsPassed==true) {

                                Assert.assertFalse(false);

                            }
                        }
                        else {
                            log.error("Assert the product name ascending (!=alphabetical order) unsuccessfully due to an error!!");
                            checkPointIfTheTestCaseIsFailed=true;
                            if (checkPointIfTheTestCaseIsFailed!=false) {

                                Assert.assertFalse(true);

                            }
                        }
                    }
                    indexProductNameArray++;
                    spp.executeScrollingDown(driver, javascript,3000);;;;;;;;;;;;;;;
                    if (index%20==0 && index!=0) {
                        indexLocator-=20;
                        System.out.println("-----------\\--***THE NEXT PAGE***--\\-------------\n\n");
                        if (nextButton.isDisplayed()==true) {
                            nextButton.click();
                            spp.pauseWithTryCatch(350);
                        }
                    }
                    driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
                    indexLocator++;
                    spp.pauseWithTryCatch(20);

                }
                if (index> 360) {  			//LAST PAGE: the product number 361 => 373
                    System.out.println("-----------\\--***THE LAST PAGE***--\\-------------\n\n");
                    int indexLocatorLastPage= 0;

                    WebElement listResultsElement= driver.findElement(By.xpath(PAR_LIST_PRODUCT_LOCATOR));
                    List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHI_LIST_PRODUCT_NAME_LOCATOR));
                    System.out.println(childResultsElements.size()+ ": size");

                    loopForLastPage: for(int indexLastPage= 1;
                                         indexLastPage< (childResultsElements.size())+1;
                                         indexLastPage+=1) {

                        String productName= childResultsElements.get(indexLocator).getText();

                        //***-----------***        HANDLING SUBSTRING
                        char firstLetterOfProductName= productName.charAt(0);

                        printTheIndexToConsole: System.out.println(productName+ ""+ " - product number: "+ index);

                        productsNameArray.add(firstLetterOfProductName);
                        System.out.println(productsNameArray);
                        if (indexProductNameArray>0) {
                            if (productsNameArray.get(indexProductNameArray).compareTo(productsNameArray.get(indexProductNameArray-1))<0
                                    /*orCondition:    --*/     || productsNameArray.get(indexProductNameArray).compareTo(productsNameArray.get(indexProductNameArray-1))==0) {
                                log.info("Asserted the product name ascending (==alphabetical order) successfully!!"+ "\n\n");
                                checkPointIfTheTestCaseIsPassed=true;
                                if (checkPointIfTheTestCaseIsPassed==true) {

                                    Assert.assertFalse(false);

                                }
                            }
                            else {
                                log.error("Assert the product name ascending (!=alphabetical order) unsuccessfully due to an error!!");
                                checkPointIfTheTestCaseIsFailed=true;
                                if (checkPointIfTheTestCaseIsFailed!=false) {

                                    Assert.assertFalse(true);

                                }
                            }
                        }
                        plus:   index++;
                        plus:        indexProductNameArray++;
                        plus:            indexLocator+=2-1;
                        plus:               indexLocatorLastPage+=2-1;
                    }
                }
            }
            if (checkPointIfTheTestCaseIsPassed==true || checkPointIfTheTestCaseIsFailed!=true) {
                Assert.assertFalse(false);
                log.info("\\--------------**---------"+"TEST CASE 004 IS PASSED!"+ "\\-----------**----------");
            }
            else if (checkPointIfTheTestCaseIsFailed==true || checkPointIfTheTestCaseIsPassed!=true){
                Assert.assertFalse(true);
                log.error("\\--------------**---------"+"TEST CASE 004 IS FAILED!"+ "\\-----------**----------");
            }
            tearDown();
            log.warn("//----------------**--TERMINATED TEST CASE--**------------------//!!");
        }
}
