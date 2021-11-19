package com.zombieclothing.testCases;

            import com.google.errorprone.annotations.Var;
            import com.zombieclothing.pageObjects.PaymentPage;
            import com.zombieclothing.utilities.ReadConfig;
            import org.junit.Assert;
            import org.openqa.selenium.By;
            import org.openqa.selenium.Keys;
            import org.openqa.selenium.TimeoutException;
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
    private final       By              LBL_PHONE_ALERT_MESSAGE_LOCATOR= By.xpath("//p[contains(@class, \"error\") and contains(text(), \"Số điện thoại\")]");
    private final       By              LBL_QUANTITY_LOCATOR= By.xpath("//div//following-sibling::span[contains(@class, \"quantity\")]");
    private final       By              LBL_PRICE_LOCATOR= By.xpath("//td[@class=\"product-price\"]//span");
    private final       By              LBL_PROV_PRICE_LOCATOR= By.xpath("//td[@class=\"total-line-name\" and contains(text(),\"Tạm tính\")]//following::span[1]");
    private final       By              LBL_CART_LOCATOR= By.xpath("//h1");


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
    private final       String          txtPhoneAlertMessage= "Số điện thoại không được trống";
    private final       String          txtCart= "Giỏ hàng của bạn";



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
//        tearDown();
        log.warn("REPELLED THE DRIVER \n");
        log.warn("TERMINATED TEST CASE \n");
    }

    @Test(groups = "002", alwaysRun = true,
                invocationCount = 1)
    public void paymentTest01() throws InterruptedException{

        PaymentPage pm= new PaymentPage(driver);
        pm.clickSanPhamNav("Sản phẩm", driver);
        log.info("                              CLICKED ON PRODUCT ON NAVIGATION BAR                              ");
        pm.getPageFromEnumeration(22);
        pm.relocateToThePage(22);
        log.info("                              CLICKED ON THE PAGE CONTAINING PRODUCT                              ");
        pm.pauseWithTryCatch(1500);
        driver.navigate().refresh();
        pm.clickAddToCartButton();
        log.info("                              CLICKED ON ADD TO CART BUTTON                              ");
        pm.clickCheckOutButton();
        log.info("                              CLICKED ON CHECK OUT BUTTON                              ");
        pm.setFullName(txtFullName);
        log.info("                              ENTERED FULL NAME                              ");
        pm.setEmail(txtEmail);
        log.info("                              ENTERED EMAIL                              ");
        pm.setPhone(txtPhone);
        log.info("                              ENTERED MOBILE PHONE                              ");
        pm.setAddress(txtAddress);
        log.info("                              ENTERED SPECIFIC ADDRESS                              ");
        pm.pauseWithTryCatch(400);
        pm.selectProvince(txtProvince, driver);
        log.info("                              SELECTED PROVINCE                              ");
        pm.pauseWithTryCatch(800);
        pm.selectDistrict(txtDistrict, driver);
        log.info("                              SELECTED DISTRICT                              ");
        pm.pauseWithTryCatch(800);
        pm.selectWard(txtWard, driver);
        log.info("                              SELECTED WARD                              ");
        pm.pauseWithTryCatch(800);
        pm.clickContinueCheckOutButton();
        log.info("                              CLICKED ON CONTINUE PAYING PROCESS BUTTON                               ");
        pm.pauseWithTryCatch(1200);
        int getQuantityInt= Integer.parseInt(driver.findElement(LBL_QUANTITY_LOCATOR).getText());
        String getProductPriceStr= driver.findElement(LBL_PRICE_LOCATOR).getText();
        String[] getProductPricePartitions= (getProductPriceStr.substring(0, (getProductPriceStr.length()-1))).split(",");
        int getProductPriceInt= Integer.parseInt(getProductPricePartitions[0]+ getProductPricePartitions[1]);
        log.info("                              GET PRODUCT PRICE SUCCESSFULLY!                              ");

        String getProductProvPriceStr= driver.findElement(LBL_PROV_PRICE_LOCATOR).getText();
        String[] getProductProvPricePartitions= (getProductProvPriceStr.substring(0, (getProductProvPriceStr.length()-1))).split(",");
        int getProductProvPriceInt= Integer.parseInt(getProductProvPricePartitions[0]+ getProductProvPricePartitions[1]);
        log.info("                              GET PROVISIONAL PRICE SUCCESSFULLY!                              ");

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
                    log.info("                              ASSERTED TEST CASE!                              ");
                    Assert.assertFalse(false);
                }
                else if (!this.checkIfTestCaseIsPassed) {
                    this.checkIfTestCaseIsFailed=true;
                    this.checkIfTestCaseIsSkipped=false;
                    this.checkIfTestCaseIsPassed=false;
                    if (!this.checkIfTestCaseIsPassed
                            && !this.checkIfTestCaseIsSkipped
                                && this.checkIfTestCaseIsFailed) {
                        log.info("                              TEST CASE IS FAILED!                              ");
                        Assert.assertFalse(true);
                    }
                }
            }
        }



    }

    @Test(groups = "005", alwaysRun = true,
            invocationCount = 1)
    void paymentTest02() throws TimeoutException {
        PaymentPage pm= new PaymentPage(driver);
        pm.clickSanPhamNav("Sản phẩm", driver);
        log.info("                              CLICKED ON PRODUCT ON NAVIGATION BAR                              ");
        pm.getPageFromEnumeration(23);
        pm.relocateToThePage(23);
        log.info("                              CLICKED ON THE PAGE CONTAINING PRODUCT                              ");
        pm.pauseWithTryCatch(1500);
        driver.navigate().refresh();
        pm.clickAddToCartButton();
        log.info("                              CLICKED ON ADD TO CART BUTTON                              ");
        pm.clickCheckOutButton();
        log.info("                              CLICKED ON CHECK OUT BUTTON                              ");
        pm.clickBackToCartButton();
        log.info("                              CLICKED ON CHECK OUT BUTTON                              ");
        pm.pauseWithTryCatch(600);
        if (driver.findElement(LBL_CART_LOCATOR).getText().equalsIgnoreCase(txtCart)==true
                && driver.findElement(LBL_CART_LOCATOR).getText().contains(txtCart)==true) {
            this.checkIfTestCaseIsPassed=true;
            System.out.println("\n"+                 driver.findElement(LBL_CART_LOCATOR).getText()+      "\n");
            if (this.checkIfTestCaseIsPassed) {
                log.info("                              ASSERTED TEST CASE 005 SUCCESSFULLY!                              ");
                Assert.assertFalse(false);
            }
            else if (!this.checkIfTestCaseIsPassed) {
                this.checkIfTestCaseIsFailed=true;
                this.checkIfTestCaseIsSkipped=false;
                this.checkIfTestCaseIsPassed=false;
                if (!this.checkIfTestCaseIsPassed
                        && !this.checkIfTestCaseIsSkipped
                        && this.checkIfTestCaseIsFailed) {
                    log.info("                              TEST CASE 005 IS FAILED!                              ");
                    Assert.assertFalse(true);
                }
            }
        }
    }

    @Test(groups = "006", alwaysRun = true,
            invocationCount = 1)
void paymentTest03() throws TimeoutException {
        PaymentPage pm= new PaymentPage(driver);
        pm.clickSanPhamNav("Sản phẩm", driver);
        log.info("                              CLICKED ON PRODUCT ON NAVIGATION BAR                              ");
        pm.getPageFromEnumeration(1);
        pm.relocateToThePage(1);
        log.info("                              CLICKED ON THE PAGE CONTAINING PRODUCT                              ");
        pm.pauseWithTryCatch(1500);
        driver.navigate().refresh();
        pm.clickAddToCartButton();
        log.info("                              CLICKED ON ADD TO CART BUTTON              ");
        pm.pauseWithTryCatch(1500);
        pm.clickSanPhamNav("Sản phẩm", driver);
        pm.getPageFromEnumeration(23);
        pm.pauseWithTryCatch(2500);
        driver.navigate().refresh();
        pm.relocateToThePage(23);

//        pm.pauseWithTryCatch(2000);
//        driver.findElement(By.xpath("//*[@id=\"facebook\"]/body/div/svg/svg/g/g/circle")).click();
        pm.pauseWithTryCatch(1500);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart\"]")).click();
        pm.clickCheckOutButton();
        pm.setName("Tống Gia Hạo");
        log.info("                              ENTERED FULL NAME                              ");
        pm.setEmail(txtEmail);
        log.info("                              ENTERED EMAIL                              ");
        pm.setPhone("");
        log.info("                              ENTERED MOBILE PHONE                              ");
        pm.setAddress(txtAddress);
        log.info("                              ENTERED SPECIFIC ADDRESS                              ");
        pm.pauseWithTryCatch(400);
        pm.selectProvince(txtProvince, driver);
        log.info("                              SELECTED PROVINCE                              ");
        pm.pauseWithTryCatch(1300);
        pm.selectDistrict(txtDistrict, driver);
        log.info("                              SELECTED DISTRICT                              ");
        pm.pauseWithTryCatch(1300);
        pm.selectWard(txtWard, driver);
        log.info("                              SELECTED WARD                              ");
        pm.pauseWithTryCatch(1300);
        pm.clickContinueCheckOutButton();
        log.info("                              CLICKED ON CONTINUE PAYING PROCESS BUTTON                               ");
        pm.pauseWithTryCatch(1200);
        WebElement listAssertedElement= driver.findElement(By.xpath("//table[@class=\"product-table\"]"));
        List<WebElement> childAssertedElements= listAssertedElement.findElements(By.xpath("//table[@class=\"product-table\"]//span[contains(@class, \"quantity\")]"));
        for (int index=0; index< childAssertedElements.size(); index++) {
            System.out.println("\nTotal quantity per product: "+ childAssertedElements.get(index).getText().toUpperCase());
        }

        int totalPrice= 0;
        WebElement listAssertedPElement= driver.findElement(By.xpath("//table[@class=\"product-table\"]"));
        List<WebElement> childAssertedPElements= listAssertedPElement.findElements(By.xpath("//td[@class=\"product-price\"]//span"));
        for (int index=0; index< childAssertedPElements.size(); index++) {
            String getProductPriceStr= childAssertedPElements.get(index).getText();
            String[] getProductPricePartitions= (getProductPriceStr.substring(0, (getProductPriceStr.length()-1))).split(",");
            int getProductPriceInt= Integer.parseInt(getProductPricePartitions[0]+ getProductPricePartitions[1]);
            System.out.println("\nTotal price per product: "+ getProductPriceInt);
            totalPrice+=getProductPriceInt;
        }

        String getProductProvPriceStr= driver.findElement(LBL_PROV_PRICE_LOCATOR).getText();
        String[] getProductProvPricePartitions= (getProductProvPriceStr.substring(0, (getProductProvPriceStr.length()-1))).split(",");
        int getProductProvPriceInt= Integer.parseInt(getProductProvPricePartitions[0]+ getProductProvPricePartitions[1]);
        System.out.println("\nTotal price per product: "+ getProductProvPriceInt);

        if ((driver.findElement(LBL_PHONE_ALERT_MESSAGE_LOCATOR).getText().equalsIgnoreCase(txtPhoneAlertMessage)
            || driver.findElement(LBL_PHONE_ALERT_MESSAGE_LOCATOR).getText().contains(txtPhoneAlertMessage))
                && (totalPrice==getProductProvPriceInt)!=false) {
            this.checkIfTestCaseIsPassed=true;
            if (this.checkIfTestCaseIsPassed) {
                log.info("                              ASSERTED TEST CASE 006 SUCCESSFULLY!                              ");
                Assert.assertFalse(false);
            }
            else if (!this.checkIfTestCaseIsPassed) {
                this.checkIfTestCaseIsFailed=true;
                this.checkIfTestCaseIsSkipped=false;
                this.checkIfTestCaseIsPassed=false;
                if (!this.checkIfTestCaseIsPassed
                        && !this.checkIfTestCaseIsSkipped
                        && this.checkIfTestCaseIsFailed) {
                    log.info("                              TEST CASE 006 IS FAILED!                              ");
                    Assert.assertFalse(true);
                }
            }
        }
    }

    @Test(groups = "test", alwaysRun = true,
            invocationCount = 1)
    void paymentTestTest() throws InterruptedException {
        PaymentPage pm= new PaymentPage(driver);
        pm.pauseWithTryCatch(3000);
        driver.findElement(By.xpath("//*[@id=\"popup-contact\"]/div/div/div/button/span/svg")).click();
    }
}












