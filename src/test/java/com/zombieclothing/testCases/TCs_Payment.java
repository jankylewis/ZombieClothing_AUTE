package com.zombieclothing.testCases;

import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.PaymentPage;
import com.zombieclothing.utilities.ReadConfig;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;


@Listeners({BaseTestListeners.class})
public class TCs_Payment extends BaseClass{

    ReadConfig rcf= new ReadConfig();
    @Var
    private By ADS_LOCATOR= By.xpath("//div[@id=\"popup-contact\"]");
    private int lottoResult= new Random().nextInt(371);

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
        pm.getPageFromEnumeration();
        pm.relocateToThePage();
    }


}
