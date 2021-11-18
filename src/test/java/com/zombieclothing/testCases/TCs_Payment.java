package com.zombieclothing.testCases;

            import com.google.errorprone.annotations.Var;
            import com.zombieclothing.pageObjects.PaymentPage;
            import com.zombieclothing.utilities.ReadConfig;
            import org.openqa.selenium.By;
            import org.openqa.selenium.Keys;
            import org.openqa.selenium.WebElement;
            import org.testng.annotations.AfterMethod;
            import org.testng.annotations.BeforeMethod;
            import org.testng.annotations.Listeners;
            import org.testng.annotations.Test;

            import java.util.ArrayList;
            import java.util.List;
            import java.util.Random;


@Listeners({BaseTestListeners.class})
public class TCs_Payment extends BaseClass{

    ReadConfig rcf= new ReadConfig();
    @Var
    private             int lottoResult= new Random().nextInt(371);
    private             String BTN_NEXT_LOCATOR= "//following::a[@class=\"next\"]";
    private             By nextButtonLocator= By.xpath(BTN_NEXT_LOCATOR);
    private final       By ADS_LOCATOR= By.xpath("//div[@id=\"popup-contact\"]");
    private final       By resetSourceBody= By.xpath("//body");

    private             List<String> productsNameArray= new ArrayList<String>();

    private             String PAR_LIST_PRODUCT_LOCATOR= "//div[contains(normalize-space(@class),\"filter clearfix\")]";
    private             String CHI_LIST_PRODUCT_NAME_LOCATOR= "//h3//child::a[@title][1]";

    @BeforeMethod(alwaysRun = true,
            enabled = true,
            description = "Trigger web browser")
    public void be4PaymentMethod() throws Exception {
        setUp(rcf.getApplicationBaseURL(), "chrome");
        log.info("TRIGGERED WEB BROWSER \n");
    }

    @AfterMethod(alwaysRun = true,
            enabled = true,
            description = "Repel the driver")
    public void afPaymentMethod() {
//        tearDown();
        log.warn("REPELLED THE DRIVER \n");
        log.warn("TERMINATED TEST CASE \n");
    }

    @Test(groups = "001", alwaysRun = true,
                invocationCount = 5)
    public void paymentTest01() throws InterruptedException{

        PaymentPage pm= new PaymentPage(driver);
        pm.clickSanPhamNav("Sản phẩm", driver);
//        pm.getPageFromEnumeration();
//        pm.relocateToThePage();

        int indexLocator= 0;
        int indexProductNameArray= 0;

        for (int index= 1; index<362; index+=1) {
            if (index< 361) {
                /*getTheDynamicListElements*/
                WebElement listResultsElement= driver.findElement(By.xpath(PAR_LIST_PRODUCT_LOCATOR));
                List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHI_LIST_PRODUCT_NAME_LOCATOR));
                WebElement nextButton= driver.findElement(By.xpath(BTN_NEXT_LOCATOR));
                String productName= childResultsElements.get(indexLocator).getText();

                printTheIndexToConsole: System.out.println(productName+ ""+ " | product number: "+ index);
                                        productsNameArray.add(productName);
                                        System.out.println(productsNameArray);
                                        indexProductNameArray++;
                                        pm.executeScrollingDown(driver, javascript,3000);

                if (index%20==0 && index!=0) {
                    indexLocator-=20;
                    System.out.println("-----------\\--***\"THE NEXT PAGE\"***--\\-------------\n\n");
                    if (nextButton.isDisplayed() || nextButton.isEnabled()) {
                        nextButton.click();
                        pm.pauseWithTryCatch(350);
                    }
                }
                driver.findElement(resetSourceBody).sendKeys(Keys.F5);
                indexLocator++;
                pm.pauseWithTryCatch(50);
            }

            if (index>360) {
                System.out.println("-----------\\--***\"THE LAST PAGE\"***--\\-------------\n\n");
                int indexLocatorLastPage= 0;
                WebElement listResultsElement= driver.findElement(By.xpath(PAR_LIST_PRODUCT_LOCATOR));
                List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(CHI_LIST_PRODUCT_NAME_LOCATOR));
                System.out.println(childResultsElements.size()+ ": size");
                for(int indexLastPage= 1;
                    indexLastPage< (childResultsElements.size())+1;
                    indexLastPage+=1) {
                    String productName= childResultsElements.get(indexLocator).getText();

                    printTheIndexToConsole: System.out.println(productName+ ""+ " | product number: "+ index);
                                            productsNameArray.add(productName);
                                            System.out.println(productsNameArray);

                    index++;
                    indexProductNameArray++;
                    indexLocator+=2-1;
                    indexLocatorLastPage+=2-1;
                }
            }
        }


    }



}



