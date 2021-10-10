package com.zombieclothing.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import lombok.Builder.Default;import net.bytebuddy.asm.Advice.This;

public class ViewNewProductDetailPage {

	public WebDriverWait wait;
	public Actions action;
	
	@Default
	WebDriver ldriver;
	JavascriptExecutor js= (JavascriptExecutor) ldriver;
	public ViewNewProductDetailPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		action= new Actions(rdriver);
		wait= new WebDriverWait(rdriver, 50);
	}
	
	@FindBy(xpath= "//div[@class=\"box-pro-detail\"]//h3//following-sibling::a")
	@CacheLookup
	WebElement LBL_CHILD_LOCATOR;
	
	@FindBy(xpath= "//div[@class=\"clearfix content-product-list\"]")
	@CacheLookup
	WebElement LBL_PARENT_LOCATOR;
	
	@FindBy(xpath= "//following::div//div//div//div//div//div//div[1]//div[3]//div[2]//div//div")
	@CacheLookup
	WebElement BTN_CLOSE_CHAT_POP_UP;
	
	public void selectProductByText(String productName, WebDriver dr, JavascriptExecutor js, int scrollUnit) {
		WebElement listProductElement= dr.findElement(By.xpath("//div[@class=\"clearfix content-product-list\"]"));
		List<WebElement> childProductElements= listProductElement.findElements(By.xpath("//div[@class=\"box-pro-detail\"]//h3//following-sibling::a"));
		for (int index=0; index< childProductElements.size(); index++) {
			if (childProductElements.get(index).getText().equals(productName)) {
				((JavascriptExecutor)dr).executeScript("scroll(0,"+scrollUnit+")");
				action.moveToElement(childProductElements.get(index)).click().perform();
				break;
			}
		}
	}
	
	public void pauseWithTryCatch(int timeSecond) {
		try {
			Thread.sleep(timeSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void closeChatPopup() {
		if (BTN_CLOSE_CHAT_POP_UP.isDisplayed()==true) {
			action.moveToElement(BTN_CLOSE_CHAT_POP_UP).click().perform();
		}
	}
}
