package com.zombieclothing.pageObjects;

import com.zombieclothing.testCases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class PaymentPage extends BaseClass {

    boolean checkPoint;
    Actions actions;
    WebDriverWait wait;

    WebDriver ldriver;
    private int pageNumber;

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

    public void clickToElement(By elementLocator, WebDriver dr) {
        WebElement elementToClick= dr.findElement(elementLocator);
        if (elementToClick.isDisplayed()) {
            actions.moveToElement(elementToClick).click().perform();
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
//        int lottoResult= 3;
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

    public void relocateToThePage() {
        switch (pageNumber) {
            case 1:
                System.out.println("---//-----##-------the first page------//-----##---".toUpperCase());
                break;
            case 2:
                System.out.println("---//-----##-------the second page------//-----##---".toUpperCase());
                break;
            case 3:
                System.out.println("---//-----##-------the third page------//-----##---".toUpperCase());
                break;
            case 4:
                System.out.println("---//-----##-------the fourth page------//-----##---".toUpperCase());
                break;
            case 5:
                System.out.println("---//-----##-------the fifth page------//-----##---".toUpperCase());
                break;
            case 6:
                System.out.println("---//-----##-------the sixth page------//-----##---".toUpperCase());
                break;
            case 7:
                System.out.println("---//-----##-------the seventh page------//-----##---".toUpperCase());
                break;
            case 8:
                System.out.println("---//-----##-------the eighth page------//-----##---".toUpperCase());
                break;
            case 9:
                System.out.println("---//-----##-------the ninth page------//-----##---".toUpperCase());
                break;
            case 10:
                System.out.println("---//-----##-------the tenth page------//-----##---".toUpperCase());
                break;
            case 11:
                System.out.println("---//-----##-------the eleventh page------//-----##---".toUpperCase());
                break;
            case 12:
                System.out.println("---//-----##-------the twelfth page------//-----##---".toUpperCase());
                break;
            case 13:
                System.out.println("---//-----##-------the thirteenth page------//-----##---".toUpperCase());
                break;
            case 14:
                System.out.println("---//-----##-------the fourteenth page------//-----##---".toUpperCase());
                break;
            case 15:
                System.out.println("---//-----##-------the fifteenth page------//-----##---".toUpperCase());
                break;
            case 16:
                System.out.println("---//-----##-------the sixteenth page------//-----##---".toUpperCase());
                break;
            case 17:
                System.out.println("---//-----##-------the seventeenth page------//-----##---".toUpperCase());
                break;
            case 18:
                System.out.println("---//-----##-------the eighteenth page------//-----##---".toUpperCase());
                break;
            case 19:
                System.out.println("---//-----##-------the nineteenth page------//-----##---".toUpperCase());
                break;

        }


    }


}
