package com.zombieclothing.testCases;

            import com.google.errorprone.annotations.Var;
            import com.zombieclothing.pageObjects.PaymentPage;
            import com.zombieclothing.utilities.ReadConfig;
            import org.junit.Assert;
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
    private             int             lottoResult= new Random().nextInt(369);
    private             int             quantity= 1;
    private             String          BTN_NEXT_LOCATOR= "//following::a[@class=\"next\"]";
    private             By              nextButtonLocator= By.xpath(BTN_NEXT_LOCATOR);
    private final       By              ADS_LOCATOR= By.xpath("//div[@id=\"popup-contact\"]");
    private final       By              resetSourceBody= By.xpath("//body");
    private final       By              LBL_FULL_NAME_ALERT_MESSAGE_LOCATOR= By.xpath("//div[contains(@class, \"error\")]//child::p");
    private final       By              LBL_QUANTITY_LOCATOR= By.xpath("//div//following-sibling::span[contains(@class, \"quantity\")]");
    private final       By              LBL_PRICE_LOCATOR= By.xpath("//td[@class=\"product-price\"]//span");
    private final       By              LBL_PROV_PRICE_LOCATOR= By.xpath("//td[@class=\"total-line-name\" and contains(text(),\"Tạm tính\")]//following::span[1]");

    private             List<String>    productsNameArray= new ArrayList<String>();

    private             String          PAR_LIST_PRODUCT_LOCATOR= "//div[contains(normalize-space(@class),\"filter clearfix\")]";
    private             String          CHI_LIST_PRODUCT_NAME_LOCATOR= "//h3//child::a[@title][1]";
    private final       String          txtFullName= "";
    private final       String          txtEmail= "giahao@gmail.com";
    private final       String          txtPhone= "0291838172";
    private final       String          txtAddress= "Hoc Mon, HCMC";
    private final       String          txtProvince= "Cà Mau";
    private final       String          txtDistrict= "Thành phố Cà Mau";
    private final       String          txtWard= "Phường 9";
    private final       String          txtFullNameAlertMessage= "Vui lòng nhập họ tên";



    protected           boolean         checkIfTestCaseIsPassed;
    protected           boolean         checkIfTestCaseIsFailed;
    protected           boolean         checkIfTestCaseIsSkipped;

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
        tearDown();
        log.warn("REPELLED THE DRIVER \n");
        log.warn("TERMINATED TEST CASE \n");
    }

    @Test(groups = "001", alwaysRun = true,
                invocationCount = 1)
    public void paymentTest01() throws InterruptedException{

        PaymentPage pm= new PaymentPage(driver);
        pm.clickSanPhamNav("Sản phẩm", driver);
        pm.getPageFromEnumeration(1);
        pm.relocateToThePage(1);
        pm.clickAddToCartButton();
        pm.clickCheckOutButton();
        pm.setFullName(txtFullName);
        pm.setEmail(txtEmail);
        pm.setPhone(txtPhone);
        pm.setAddress(txtAddress);
        pm.pauseWithTryCatch(400);
        pm.selectProvince(txtProvince, driver);
        pm.pauseWithTryCatch(800);
        pm.selectDistrict(txtDistrict, driver);
        pm.pauseWithTryCatch(800);
        pm.selectWard(txtWard, driver);
        pm.pauseWithTryCatch(800);
        pm.clickContinueCheckOutButton();
        pm.pauseWithTryCatch(1200);
        int getQuantityInt= Integer.parseInt(driver.findElement(LBL_QUANTITY_LOCATOR).getText());
        String getProductPriceStr= driver.findElement(LBL_PRICE_LOCATOR).getText();
        String[] getProductPricePartitions= (getProductPriceStr.substring(0, (getProductPriceStr.length()-1))).split(",");
        int getProductPriceInt= Integer.parseInt(getProductPricePartitions[0]+ getProductPricePartitions[1]);

        String getProductProvPriceStr= driver.findElement(LBL_PROV_PRICE_LOCATOR).getText();
        String[] getProductProvPricePartitions= (getProductProvPriceStr.substring(0, (getProductProvPriceStr.length()-1))).split(",");
        int getProductProvPriceInt= Integer.parseInt(getProductProvPricePartitions[0]+ getProductProvPricePartitions[1]);

        if (driver.findElement(LBL_FULL_NAME_ALERT_MESSAGE_LOCATOR).isDisplayed()
                && driver.findElement(LBL_QUANTITY_LOCATOR).isDisplayed()
                    && driver.findElement(LBL_PRICE_LOCATOR).isDisplayed()) {
            if ((driver.findElement(LBL_FULL_NAME_ALERT_MESSAGE_LOCATOR)
                    .getText().equalsIgnoreCase(txtFullNameAlertMessage)==true
                    || driver.findElement(LBL_FULL_NAME_ALERT_MESSAGE_LOCATOR)
                            .getText().contains(txtFullNameAlertMessage)==true)
                        && (getQuantityInt==quantity)==true
                            && (getProductProvPriceInt==getProductPriceInt)!=false) {
                this.checkIfTestCaseIsPassed=true;
                System.out.println("\nAlert message: "+  driver.findElement(LBL_FULL_NAME_ALERT_MESSAGE_LOCATOR).getText());
                System.out.println("\nQuantity: "+  getQuantityInt);
                System.out.println("\nProduct price: "+  getProductPriceInt);
                System.out.println("\nProvisional product price: "+  getProductProvPriceInt);
                if (this.checkIfTestCaseIsPassed) {
                    Assert.assertFalse(false);
                }
                else if (!this.checkIfTestCaseIsPassed) {
                    this.checkIfTestCaseIsFailed=true;
                    this.checkIfTestCaseIsSkipped=false;
                    this.checkIfTestCaseIsPassed=false;
                    if (!this.checkIfTestCaseIsPassed
                            && !this.checkIfTestCaseIsSkipped
                                && this.checkIfTestCaseIsFailed) {
                        Assert.assertFalse(true);
                    }
                }
            }
        }



    }



}



