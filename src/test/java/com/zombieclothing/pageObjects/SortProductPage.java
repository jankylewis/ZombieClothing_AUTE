package com.zombieclothing.pageObjects;

import lombok.Builder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SortProductPage {

    public WebDriverWait wait;
    public WebElement element;
    public Actions action;

    @Builder.Default
    WebDriver ldriver;
    JavascriptExecutor js= (JavascriptExecutor) ldriver;

    public SortProductPage( WebDriver rdriver) {
        ldriver= rdriver;
        PageFactory.initElements(rdriver, this);
        wait= new WebDriverWait(rdriver, 50);

        action= new Actions(rdriver);
    }

    public void pauseWithTryCatch(int timeSecond) {
        try {
            Thread.sleep(timeSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void executeScrollingDown(WebDriver dr, JavascriptExecutor js, int scrollUnit) {
        ((JavascriptExecutor)dr).executeScript("scroll(0,"+scrollUnit+")");
    }

    @FindBy(xpath = "//nav[@class=\"main-nav text-center\"]//preceding-sibling::li[1]//ancestor::a[@title=\"Sản phẩm\"]")
    @CacheLookup
    WebElement NAV_TAT_CA_SAN_PHAM;

    public void clickOnSortCriterion(WebDriver dr, JavascriptExecutor js, int scrollUnit, String sortCriterion) {
//        executeScrollingDown(dr, js, scrollUnit);
        WebElement listSortCriteriaElement= dr.findElement(By.xpath("//following::select[1][1]"));
        List<WebElement> childSortCriteriaElements= listSortCriteriaElement.findElements(By.xpath("//following::select[1][1]//option"));
        for (int index= 0; index<childSortCriteriaElements.size(); index+=1) {
            if (childSortCriteriaElements.get(index).getText().equals(sortCriterion)) {
                System.out.println(childSortCriteriaElements+ "\r\r");
                (childSortCriteriaElements.get(index)).click();
                break;
            }
        }
    }

    public void selectAscending(WebDriver dr, String expLocator, String expValue) {
        Select sel= new Select(dr.findElement(By.xpath("//following::select")));
        sel.selectByValue(expValue);
    }
    
    public void listWebElement(String expChiLocator, String expParLocator, WebDriver dr) {
    	WebElement listResultsElement= dr.findElement(By.xpath(expParLocator));
		List<WebElement> childResultsElements= listResultsElement.findElements(By.xpath(expChiLocator));
    }

    public void clickTatcaspNavigationLink() {
        if (NAV_TAT_CA_SAN_PHAM.isDisplayed()==true) {
            NAV_TAT_CA_SAN_PHAM= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class=\"main-nav text-center\"]//preceding-sibling::li[1]//ancestor::a[@title=\"Sản phẩm\"]")));
            NAV_TAT_CA_SAN_PHAM.click();
        }
    }
}
