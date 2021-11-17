package com.zombieclothing.pageObjects;

import com.zombieclothing.testCases.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class PaymentPage extends BaseClass {

    public boolean checkPoint;
    public Actions actions;
    public WebDriverWait wait;

    WebDriver ldriver;
    private int pageNumber;
    transient String BTN_NEXT_LOCATOR= "//following::a[@class=\"next\"]";
    transient By nextButtonLocator= By.xpath(BTN_NEXT_LOCATOR);

    public PaymentPage(WebDriver rdriver) {
        ldriver= rdriver;
        PageFactory.initElements(rdriver, this);
        actions= new Actions(rdriver);
        wait= new WebDriverWait(rdriver, 50);
    }

    @FindBy (xpath= "//div[@id=\"nav\"]//nav")
    @CacheLookup
    WebElement NAV_PARENT;

    @FindBy(xpath= "//nav//descendant::a[contains(@href,\"/\") and @title=\"Trang chủ\" or @title=\"Sản phẩm\" or @title=\"Giới thiệu\" or @title=\"Blog\"]")
    @CacheLookup
    WebElement NAV_CHILDREN;

    public void clickSanPhamNav(String str, WebDriver dr) {
        WebElement listElement= dr.findElement(By.xpath("//div[@id=\"nav\"]//nav"));
        List<WebElement> childNavElements= listElement.findElements(By.xpath("//nav//descendant::a[contains(@href,\"/\") and @title=\"Trang chủ\" or @title=\"Sản phẩm\" or @title=\"Giới thiệu\" or @title=\"Blog\"]"));
        for (int index=0; index< childNavElements.size(); index++) {
            if (childNavElements.get(index).getText().equals(str) || childNavElements.get(index).getText().contains(str)) {
                childNavElements.get(index).click();
                break;
            }
        }
    }

    @FindBy(xpath = "//a[@title=\"Sản phẩm\"]")
    @CacheLookup
    WebElement NAV_SAN_PHAM;

    public void clickToSanPhamNav(WebDriver dr) {
        if (NAV_SAN_PHAM.isDisplayed()) {
            actions.moveToElement(NAV_SAN_PHAM).click().perform();
        }
    }

    public void pauseWithTryCatch(int timeSecond) {
        try {
            Thread.sleep(timeSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public enum pageIndex {
        firstPage,
        secondPage,
        thirdPage,
        fourthPage,
        fifthPage,
        sixthPage,
        seventhPage,
        eighthPage,
        ninthPage,
        tenthPage,
                    eleventhPage,
                    twelfthPage,
                    thirteenPage,
                    fourteenthPage,
                    fifteenthPage,
                    sixteenthPage,
                    seventeenthPage,
                    eighteenthPage,
                    nineteenthPage
    }

    public void getPageFromEnumeration() {
        int lottoResult= new Random().nextInt(371);
//        int lottoResult=55;
        if (1<= lottoResult && lottoResult<= 20) {
            pageIndex firstPage= pageIndex.firstPage;
            this.pageNumber= 1;
        }
        if (21<= lottoResult && lottoResult<= 40) {
            pageIndex secondPage= pageIndex.secondPage;
            this.pageNumber= 2;
        }
        if (41<= lottoResult && lottoResult<= 60) {
            pageIndex thirdPage= pageIndex.thirdPage;
            this.pageNumber= 3;
        }
        if (61<= lottoResult && lottoResult<= 80) {
            pageIndex fourthPage= pageIndex.fourthPage;
            this.pageNumber= 4;
        }
        if (81<= lottoResult && lottoResult<= 100) {
            pageIndex fifthPage= pageIndex.fifthPage;
            this.pageNumber= 5;
        }
        if (101<= lottoResult && lottoResult<= 120) {
            pageIndex sixthPage= pageIndex.sixthPage;
            this.pageNumber= 6;
        }
        if (121<= lottoResult && lottoResult<= 140) {
            pageIndex seventhPage= pageIndex.seventhPage;
            this.pageNumber= 7;
        }
        if (141<= lottoResult && lottoResult<= 160) {
            pageIndex eighthPage= pageIndex.eighthPage;
            this.pageNumber= 8;
        }
        if (161<= lottoResult && lottoResult<= 180) {
            pageIndex ninthPage= pageIndex.ninthPage;
            this.pageNumber= 9;
        }
        if (181<= lottoResult && lottoResult<= 200) {
            pageIndex tenthPage= pageIndex.tenthPage;
            this.pageNumber= 10;
        }
        if (201<= lottoResult && lottoResult<= 220) {
            pageIndex eleventhPage= pageIndex.eleventhPage;
            this.pageNumber= 11;
        }
        if (221<= lottoResult && lottoResult<= 240) {
            pageIndex twelfthPage= pageIndex.twelfthPage;
            this.pageNumber= 12;
        }
        if (241<= lottoResult && lottoResult<= 260) {
            pageIndex thirteenPage= pageIndex.thirteenPage;
            this.pageNumber= 13;
        }
        if (261<= lottoResult && lottoResult<= 280) {
            pageIndex fourteenthPage= pageIndex.fourteenthPage;
            this.pageNumber= 14;
        }
        if (281<= lottoResult && lottoResult<= 300) {
            pageIndex fifteenthPage= pageIndex.fifteenthPage;
            this.pageNumber= 15;
        }
        if (301<= lottoResult && lottoResult<= 320) {
            pageIndex sixteenthPage= pageIndex.sixteenthPage;
            this.pageNumber= 16;
        }
        if (321<= lottoResult && lottoResult<= 340) {
            pageIndex seventeenthPage= pageIndex.seventeenthPage;
            this.pageNumber= 17;
        }
        if (341<= lottoResult && lottoResult<= 360) {
            pageIndex eighteenthPage= pageIndex.eighteenthPage;
            this.pageNumber= 18;
        }
        if (361<= lottoResult && lottoResult<= 371) {
            pageIndex nineteenthPage= pageIndex.nineteenthPage;
            this.pageNumber= 19;
        }
    }

    public static void executeScrollingDown(WebDriver dr, JavascriptExecutor js, int scrollUnit) {
        ((JavascriptExecutor)dr).executeScript("scroll(0,"+scrollUnit+")");
    }

    public void relocateToThePage() {

        switch (pageNumber) {
            case 1:
                System.out.println("---//-----##-------the first page------//-----##---".toUpperCase());
                executeScrollingDown(driver, javascript, 3000);
                break;
            case 2:
                System.out.println("---//-----##-------the second page------//-----##---".toUpperCase());
                for (int index=1; index<2; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 3000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 3:
                System.out.println("---//-----##-------the third page------//-----##---".toUpperCase());
                for (int index=1; index<3; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 4:
                System.out.println("---//-----##-------the fourth page------//-----##---".toUpperCase());
                for (int index=1; index<4; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 5:
                System.out.println("---//-----##-------the fifth page------//-----##---".toUpperCase());
                for (int index=1; index<5; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 6:
                System.out.println("---//-----##-------the sixth page------//-----##---".toUpperCase());
                for (int index=1; index<6; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 7:
                System.out.println("---//-----##-------the seventh page------//-----##---".toUpperCase());
                for (int index=1; index<7; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 8:
                System.out.println("---//-----##-------the eighth page------//-----##---".toUpperCase());
                for (int index=1; index<8; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 9:
                System.out.println("---//-----##-------the ninth page------//-----##---".toUpperCase());
                for (int index=1; index<9; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 10:
                System.out.println("---//-----##-------the tenth page------//-----##---".toUpperCase());
                for (int index=1; index<10; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 11:
                System.out.println("---//-----##-------the eleventh page------//-----##---".toUpperCase());
                for (int index=1; index<11; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 12:
                System.out.println("---//-----##-------the twelfth page------//-----##---".toUpperCase());
                for (int index=1; index<12; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 13:
                System.out.println("---//-----##-------the thirteenth page------//-----##---".toUpperCase());
                for (int index=1; index<13; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 14:
                System.out.println("---//-----##-------the fourteenth page------//-----##---".toUpperCase());
                for (int index=1; index<14; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 15:
                System.out.println("---//-----##-------the fifteenth page------//-----##---".toUpperCase());
                for (int index=1; index<15; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 16:
                System.out.println("---//-----##-------the sixteenth page------//-----##---".toUpperCase());
                for (int index=1; index<16; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 17:
                System.out.println("---//-----##-------the seventeenth page------//-----##---".toUpperCase());
                for (int index=1; index<17; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 18:
                System.out.println("---//-----##-------the eighteenth page------//-----##---".toUpperCase());
                for (int index=1; index<18; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;
            case 19:
                System.out.println("---//-----##-------the nineteenth page------//-----##---".toUpperCase());
                for (int index=1; index<19; index++) {
                    WebElement nextButton= driver.findElement(nextButtonLocator);
                    executeScrollingDown(driver, javascript, 4000);
                    pauseWithTryCatch(500);
                    actions.moveToElement(nextButton).click().perform();
                }
                break;

        }


    }


}
