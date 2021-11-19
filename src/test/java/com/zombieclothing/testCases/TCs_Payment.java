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
    private             int lottoResult= new Random().nextInt(369);
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
                invocationCount = 1)
    public void paymentTest01() throws InterruptedException{

        PaymentPage pm= new PaymentPage(driver);
        pm.clickSanPhamNav("Sản phẩm", driver);
        pm.getPageFromEnumeration(362);
        pm.relocateToThePage(362);





    }



}



