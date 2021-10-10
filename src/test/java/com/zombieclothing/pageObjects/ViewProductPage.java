package com.zombieclothing.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import lombok.Builder.Default;

public class ViewProductPage {

	public Actions action;
	public WebDriverWait wait;
	
	@Default
	WebDriver ldriver;
	public ViewProductPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		action= new Actions(rdriver);
		wait= new WebDriverWait(rdriver, 50);
	}
		
	@FindBy(xpath= "//nav[@class=\"main-nav text-center\"]//preceding-sibling::li[1]//ancestor::a[@title=\"Sản phẩm\"]")
	@CacheLookup
	WebElement NAV_TAT_CA_SAN_PHAM;
	
	//--------/*/--------AO--------/*/--------
	
	@FindBy(xpath= "//nav[@class=\"main-nav text-center\"]//preceding-sibling::li[4]//child::a[@title=\"Áo\"]")
	@CacheLookup
	WebElement NAV_AO;
	
	@FindBy(xpath= "//nav[@class= \"main-nav text-center\"]//li//a[contains(normalize-space(@title), \"Áo Thun - Sơ Mi\")]")
	@CacheLookup
	WebElement NAV_AO_THUN_SO_MI;
	
	@FindBy(xpath= "//nav[@class= \"main-nav text-center\"]//li//following::a[contains(normalize-space(@title), \"Sweater - Hoodie\")]")
	@CacheLookup
	WebElement NAV_SWEATER_HOODIE;
	
	@FindBy(xpath= "//nav[@class= \"main-nav text-center\"]//li//following::a[contains(normalize-space(@title), \"Sản Phẩm Khác\")]")
	@CacheLookup
	WebElement NAV_SAN_PHAM_KHAC;

	//--------/*/--------QUAN--------/*/--------
	
	@FindBy(xpath= "//nav[@class=\"main-nav text-center\"]//following-sibling::li[2]//child::a[@title=\"Quần\"]")
	@CacheLookup
	WebElement NAV_QUAN;
	
	@FindBy(xpath= "//nav[@class= \"main-nav text-center\"]//preceding-sibling::li[1]//a[contains(normalize-space(@title), \"Quần dài\")]")
	@CacheLookup
	WebElement NAV_QUAN_DAI;
	
	@FindBy(xpath= "//nav[@class= \"main-nav text-center\"]//preceding-sibling::li[2]//a[contains(normalize-space(@title), \"Quần short\")]")
	@CacheLookup
	WebElement NAV_QUAN_SHORT;
	
	//--------/*/--------SET--------/*/--------
	
	@FindBy(xpath= "//nav[@class=\"main-nav text-center\"]//following-sibling::li[3]//child::a[@title=\"Set\"]")
	@CacheLookup
	WebElement NAV_SET;
	
	//--------/*/--------PHU KIEN--------/*/--------
	
	@FindBy(xpath= "//nav[@class=\"main-nav text-center\"]//following-sibling::li[4]//child::a[@title=\"Phụ kiện\"]")
	@CacheLookup
	WebElement NAV_PHU_KIEN;
	
	@FindBy(xpath= "//nav[@class=\"main-nav text-center\"]//following-sibling::li[4]//child::a[@title=\"Phụ kiện\"]//following::a[1][contains(normalize-space(@title), \"Mũ\")]")
	@CacheLookup
	WebElement NAV_MU;
	
	@FindBy(xpath= "//nav[@class=\"main-nav text-center\"]//following-sibling::li[4]//child::a[@title=\"Phụ kiện\"]//following::a[2][contains(normalize-space(@title), \"Kính\")]")
	@CacheLookup
	WebElement NAV_KINH;
	
	@FindBy(xpath= "//nav[@class=\"main-nav text-center\"]//following-sibling::li[4]//child::a[@title=\"Phụ kiện\"]//following::a[3][contains(normalize-space(@title), \"Nhẫn\")]")
	@CacheLookup
	WebElement NAV_NHAN;
	
	@FindBy(xpath= "//nav[@class=\"main-nav text-center\"]//following-sibling::li[4]//child::a[@title=\"Phụ kiện\"]//following::a[4][contains(normalize-space(@title), \"Wallet Chain\")]")
	@CacheLookup
	WebElement NAV_WALLET_CHAIN;
	
	//Tatcasp
	public void performTatcaspMouseHover() {
		if (NAV_TAT_CA_SAN_PHAM.isDisplayed()==true) {
			action.moveToElement(NAV_TAT_CA_SAN_PHAM).build().perform();
		}
	}
	
	public void clickTatcaspNavigationLink() {
		if (NAV_TAT_CA_SAN_PHAM.isDisplayed()==true) {
			NAV_TAT_CA_SAN_PHAM= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class=\"main-nav text-center\"]//preceding-sibling::li[1]//ancestor::a[@title=\"Sản phẩm\"]")));
			action.moveToElement(NAV_TAT_CA_SAN_PHAM).click().perform();
		}
	}
	
	//Ao
	public void performAoMouseHover() {
		if (NAV_AO.isDisplayed()==true) {
			action.moveToElement(NAV_AO).build().perform();
		}
	}
	
	public void clickAoNavigationLink() {
		if (NAV_AO.isDisplayed()==true) {
			action.moveToElement(NAV_AO).click().perform();
		}
		
	}
	
	//Ao children
	public void clickAoThunSoMiNavigationLink() {
		if (NAV_AO_THUN_SO_MI.isDisplayed()==true) {
			action.moveToElement(NAV_AO_THUN_SO_MI).click().perform();
		}
	}
	
	public void clickSweaterHoodieNavigationLink() {
		if (NAV_SWEATER_HOODIE.isDisplayed()==true) {
			action.moveToElement(NAV_SWEATER_HOODIE).click().perform();
		}
	}
	
	public void clickSanPhamKhacNavigationLink() {
		if (NAV_SAN_PHAM_KHAC.isDisplayed()==true) {
			action.moveToElement(NAV_SAN_PHAM_KHAC).click().perform();
		}
	}
	
	//Quan
	public void performQuanMouseHover() {
		if (NAV_QUAN.isDisplayed()==true) {
			action.moveToElement(NAV_QUAN).build().perform();
		}
	}
	
	public void clickQuanNavigationLink() {
		if (NAV_QUAN.isDisplayed()==true) {
			action.moveToElement(NAV_QUAN).click().perform();
		}
	}
	
	//Quan children elements
	public void clickQuanDaiNavigationLink() {
		if (NAV_QUAN_DAI.isDisplayed()==true) {
			action.moveToElement(NAV_QUAN_DAI).click().perform();
		}
	}
	
	public void clickQuanShortNavigationLink() {
		if (NAV_QUAN_SHORT.isDisplayed()==true) {
			action.moveToElement(NAV_QUAN_SHORT).click().perform();
		}
	}
	
	//Set
	public void performSetMouseHover() {
		if (NAV_SET.isDisplayed()==true) {
			action.moveToElement(NAV_SET).build().perform();
		}
	}
	
	public void clickSetNavigationLink() {
		if (NAV_SET.isDisplayed()==true) {
			action.moveToElement(NAV_SET).click().perform();
		}
	}
	
	//Phu kien
	public void performPhuKienMouseHover() {
		if (NAV_PHU_KIEN.isDisplayed()==true) {
			NAV_PHU_KIEN= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nav[@class=\"main-nav text-center\"]//following-sibling::li[4]//child::a[@title=\"Phụ kiện\"]")));
			action.moveToElement(NAV_PHU_KIEN).build().perform();
		}
	}
	
	public void clickPhuKienNavigationLink() {
		if (NAV_PHU_KIEN.isDisplayed()==true) {
			action.moveToElement(NAV_PHU_KIEN).click().perform();
		}
	}
	
	//Phu kien children elements
	public void clickMuNavigationLink() {
		if (NAV_MU.isDisplayed()==true) {
			action.moveToElement(NAV_MU).click().perform();
		}
	}
	
	public void clickKinhNavigationLink() {
		if (NAV_KINH.isDisplayed()==true) {
			action.moveToElement(NAV_KINH).click().perform();
		}
	}
	
	public void clickNhanNavigationLink() {
		if (NAV_NHAN.isDisplayed()==true) {
			action.moveToElement(NAV_NHAN).click().perform();
		}
	}
	
	public void clickWalletChainNavigationLink() {
		if (NAV_WALLET_CHAIN.isDisplayed()==true) {
			action.moveToElement(NAV_WALLET_CHAIN).click().perform();
		}
	}
	
	
}
