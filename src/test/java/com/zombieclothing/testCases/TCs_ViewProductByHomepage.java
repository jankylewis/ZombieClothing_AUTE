package com.zombieclothing.testCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.ViewProductByHomepagePage;
import com.zombieclothing.utilities.ReadConfig;
import lombok.Builder.Default;

public class TCs_ViewProductByHomepage extends BaseClass{

	ReadConfig readconfig= new ReadConfig();
	@Var
//	private String aoProductType= readconfig.getViewAoByProductType();
//	private String aoThunSoMiProductType= readconfig.getViewAoThunSoMiByProductType();
//	private String sweaterHoodieProductType= readconfig.getViewSweaterHoodieByProductType();
//	private String sanPhamKhacProductType= readconfig.getViewSanPhamKhacByProductType();
//	private String quanProductType= readconfig.getViewQuanByProductType();
//	private String quanDaiProductType= readconfig.getViewQuanDaiByProductType();
//	private String quanShortProductType= readconfig.getViewQuanShortByProductType();
//	private String setProductType= readconfig.getViewSetByProductType();
//	private String phuKienProductType= readconfig.getViewPhuKienByProductType();
//	private String muProductType= readconfig.getViewMuByProductType();
//	private String kinhProductType= readconfig.getViewKinhByProductType();
//	private String nhanProductType= readconfig.getViewNhanByProductType();
//	private String walletChainProductType= readconfig.getViewWalletChainByProductType();
	
	//for asserting	
	private String aoProductType= "Áo";
	private String aoThunSoMiProductType= "Áo thun - Sơ mi";
	private String sweaterHoodieProductType= "Sweater - Hoodie";
	private String sanPhamKhacProductType= "Các Sản Phẩm Khác";
	
		private String quanProductType= "Quần";
		private String quanDaiProductType= "Quần Dài";
		private String quanShortProductType= "Quần short";
			
			private String setProductType= "Set";
				
				private String phuKienProductType= "Phụ kiện";
				private String muProductType= "Mũ";
				private String kinhProductType= "Kính";
				private String nhanProductType= "Nhẫn";
				private String walletChainProductType= "Wallet chain";
	
	@Test(groups= {"Ao"})
	public void viewAoByProductType() {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("Navigated to homepage\n");
		
		ViewProductByHomepagePage vpg= new ViewProductByHomepagePage(driver);
		vpg.performTatcaspMouseHover();
		log.info("Hovered San pham navigation link\n");
		
		vpg.clickAoNavigationLink();
		log.info("Clicked Ao product type\n");
		
		//assertion
		String expProductType= aoProductType;
		String actProductType= driver.findElement(By.xpath("//ancestor::div//h1[@class=\"title\"]")).getText();
		System.out.println(expProductType+ "\n\n"+ actProductType+ "\n");
		
		if (actProductType.equals(expProductType) && actProductType.isBlank()==false) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---View product by Ao test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---View product by Ao test case is failed due to an error---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"Ao", "Ao Thun - So Mi"})
	public void viewAoThunSoMiByProductType() {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("Navigated to homepage\n");
		
		ViewProductByHomepagePage vpg= new ViewProductByHomepagePage(driver);
		vpg.performTatcaspMouseHover();
		log.info("Hovered San pham navigation link\n");
		
		vpg.performAoMouseHover();
		log.info("Hovered Ao product type\n");
		
		vpg.clickAoThunSoMiNavigationLink();
		log.info("Clicked Ao Thun - So Mi product type\n");
		
		//assertion
		String expProductType= aoThunSoMiProductType;
		String actProductType= driver.findElement(By.xpath("//ancestor::div//h1[@class=\"title\"]")).getText();
		System.out.println(expProductType+ "\n\n"+ actProductType+ "\n");
		
		if (actProductType.equals(expProductType) && actProductType.isBlank()==false) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---View product by Ao Thun - So Mi test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---View product by Ao Thun - So Mi test case is failed due to an error---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"Ao", "Sweater - Hoodie"})
	public void viewSweaterHoodieByProductType() {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("Navigated to homepage\n");
		
		ViewProductByHomepagePage vpg= new ViewProductByHomepagePage(driver);
		vpg.performTatcaspMouseHover();
		log.info("Hovered San pham navigation link\n");
		
		vpg.performAoMouseHover();
		log.info("Hovered Ao product type\n");
		
		vpg.clickSweaterHoodieNavigationLink();
		log.info("Clicked Sweater - Hoodie product type\n");
		
		//assertion
		String expProductType= sweaterHoodieProductType;
		String actProductType= driver.findElement(By.xpath("//ancestor::div//h1[@class=\"title\"]")).getText();
		System.out.println(expProductType+ "\n\n"+ actProductType+ "\n");
		
		if (actProductType.equals(expProductType) && actProductType.isBlank()==false) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---View product by Sweater - Hoodie test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---View product by Sweater - Hoodie test case is failed due to an error---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"Ao", "San Pham Khac"})
	public void viewSanPhamKhacByProductType() {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("Navigated to homepage\n");
		
		ViewProductByHomepagePage vpg= new ViewProductByHomepagePage(driver);
		vpg.performTatcaspMouseHover();
		log.info("Hovered San pham navigation link\n");
		
		vpg.performAoMouseHover();
		log.info("Hovered Ao product type\n");
		
		vpg.clickSanPhamKhacNavigationLink();
		log.info("Clicked San Pham Khac product type\n");	
		
		//assertion
		String expProductType= sanPhamKhacProductType;
		String actProductType= driver.findElement(By.xpath("//ancestor::div//h1[@class=\"title\"]")).getText();
		System.out.println(expProductType+ "\n\n"+ actProductType+ "\n");
		
		if (actProductType.equals(expProductType) && actProductType.isBlank()==false) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---View product by San Pham Khac test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---View product by San Pham Khac test case is failed due to an error---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"Quan"})
	public void viewQuanByProductType() {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("Navigated to homepage\n");
		
		ViewProductByHomepagePage vpg= new ViewProductByHomepagePage(driver);
		vpg.performTatcaspMouseHover();
		log.info("Hovered San pham navigation link\n");
		
		vpg.clickQuanNavigationLink();
		log.info("Clicked Quan product type\n");
		
		//assertion
		String expProductType= quanProductType;
		String actProductType= driver.findElement(By.xpath("//ancestor::div//h1[@class=\"title\"]")).getText();
		System.out.println(expProductType+ "\n\n"+ actProductType+ "\n");
		
		if (actProductType.equals(expProductType) && actProductType.isBlank()==false) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---View product by Quan test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---View product by Quan test case is failed due to an error---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"Quan", "Quan Dai"})
	public void viewQuanDaiByProductType() {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("Navigated to homepage\n");
		
		ViewProductByHomepagePage vpg= new ViewProductByHomepagePage(driver);
		vpg.performTatcaspMouseHover();
		log.info("Hovered San pham navigation link\n");
		
		vpg.performQuanMouseHover();
		log.info("Hovered Quan navigation link\n");
		
		vpg.clickQuanDaiNavigationLink();
		log.info("Clicked Quan Dai product type\n");
		
		//assertion
		String expProductType= quanDaiProductType;
		String actProductType= driver.findElement(By.xpath("//ancestor::div//h1[@class=\"title\"]")).getText();
		System.out.println(expProductType+ "\n\n"+ actProductType+ "\n");
		
		if (actProductType.equals(expProductType) && actProductType.isBlank()==false) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---View product by Quan Dai test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---View product by Quan Dai test case is failed due to an error---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"Quan", "Quan Short"})
	public void viewQuanShortByProductType() {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("Navigated to homepage\n");
		
		ViewProductByHomepagePage vpg= new ViewProductByHomepagePage(driver);
		vpg.performTatcaspMouseHover();
		vpg.pauseWithTryCatch(500);
		log.info("Hovered San pham navigation link\n");
		
		vpg.performQuanMouseHover();
		vpg.pauseWithTryCatch(500);
		log.info("Hovered Quan navigation link\n");
		
		vpg.clickQuanShortNavigationLink();
		vpg.pauseWithTryCatch(500);
		log.info("Clicked Quan Short product type\n");
		
		//assertion
		String expProductType= quanShortProductType;
		String actProductType= driver.findElement(By.xpath("//ancestor::div//h1[@class=\"title\"]")).getText();
		System.out.println(expProductType+ "\n\n"+ actProductType+ "\n");
		
		if (actProductType.equals(expProductType) && actProductType.isBlank()==false) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---View product by Quan Short test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---View product by Quan Short test case is failed due to an error---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"Set"})
	public void viewSetByProductType() {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("Navigated to homepage\n");
		
		ViewProductByHomepagePage vpg= new ViewProductByHomepagePage(driver);
		vpg.performTatcaspMouseHover();
		vpg.pauseWithTryCatch(500);
		log.info("Hovered San pham navigation link\n");
		
		vpg.clickSetNavigationLink();
		vpg.pauseWithTryCatch(500);
		log.info("Clicked Set navigation link\n");
		
		//assertion
		String expProductType= setProductType;
		String actProductType= driver.findElement(By.xpath("//ancestor::div//h1[@class=\"title\"]")).getText();
		System.out.println(expProductType+ "\n\n"+ actProductType+ "\n");
		
		if (actProductType.equals(expProductType) && actProductType.isBlank()==false) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---View product by Set test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---View product by Set test case is failed due to an error---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"Phu Kien"})
	public void viewPhuKienByProductType() {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("Navigated to homepage\n");
		
		ViewProductByHomepagePage vpg= new ViewProductByHomepagePage(driver);
		vpg.performTatcaspMouseHover();
		vpg.pauseWithTryCatch(500);
		log.info("Hovered San pham navigation link\n");
		
		vpg.clickPhuKienNavigationLink();
		vpg.pauseWithTryCatch(500);
		log.info("Clicked Phu Kien navigation link\n");
		
		//assertion
		String expProductType= phuKienProductType;
		String actProductType= driver.findElement(By.xpath("//ancestor::div//h1[@class=\"title\"]")).getText();
		System.out.println(expProductType+ "\n\n"+ actProductType+ "\n");
		
		if (actProductType.equals(expProductType) && actProductType.isBlank()==false) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---View product by Phu Kien test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---View product by Phu Kien test case is failed due to an error---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"Phu Kien", "Mu"})
	public void viewMuByProductType() {
		setUp(readconfig.getApplicationBaseURL(), "opera");
		log.info("Navigated to homepage\n");
		
		ViewProductByHomepagePage vpg= new ViewProductByHomepagePage(driver);
		vpg.performTatcaspMouseHover();
		vpg.pauseWithTryCatch(1500);
		
		log.info("Hovered San pham navigation link\n");
		
		vpg.performPhuKienMouseHover();
		vpg.pauseWithTryCatch(1500);
		
		log.info("Hovered Phu Kien nưavigation link\n");
		
		vpg.clickMuNavigationLink();
		log.info("Clicked Mu navigation link\n");
		
		//assertion
		String expProductType= muProductType;
		String actProductType= driver.findElement(By.xpath("//ancestor::div//h1[@class=\"title\"]")).getText();
		System.out.println(expProductType+ "\n\n"+ actProductType+ "\n");
		
		if (actProductType.equals(expProductType) && actProductType.isBlank()==false) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---View product by Mu test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---View product by Mu test case is failed due to an error---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"Phu Kien", "Kinh"})
	public void viewKinhByProductType() {
		setUp(readconfig.getApplicationBaseURL(), "opera");
		log.info("Navigated to homepage\n");
		
		ViewProductByHomepagePage vpg= new ViewProductByHomepagePage(driver);
		vpg.performTatcaspMouseHover();
		vpg.pauseWithTryCatch(500);
		log.info("Hovered San pham navigation link\n");
		
		vpg.performPhuKienMouseHover();
		vpg.pauseWithTryCatch(500);
		log.info("Hovered Phu Kien navigation link\n");
		
		vpg.clickKinhNavigationLink();
		vpg.pauseWithTryCatch(500);
		log.info("Clicked Kinh navigation link\n");
		
		//assertion
		String expProductType= kinhProductType;
		String actProductType= driver.findElement(By.xpath("//ancestor::div//h1[@class=\"title\"]")).getText();
		System.out.println(expProductType+ "\n\n"+ actProductType+ "\n");
		
		if (actProductType.equals(expProductType) && actProductType.isBlank()==false) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---View product by Kinh test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---View product by Kinh test case is failed due to an error---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"Phu Kien", "Nhan"})
	public void viewNhanByProductType() {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("Navigated to homepage\n");
		
		ViewProductByHomepagePage vpg= new ViewProductByHomepagePage(driver);
		vpg.performTatcaspMouseHover();
		vpg.pauseWithTryCatch(500);
		log.info("Hovered San pham navigation link\n");
		
		vpg.performPhuKienMouseHover();
		vpg.pauseWithTryCatch(500);
		log.info("Hovered Phu Kien navigation link\n");
		
		vpg.clickNhanNavigationLink();
		vpg.pauseWithTryCatch(500);
		log.info("Clicked Nhan navigation link\n");
		
		//assertion
		String expProductType= nhanProductType;
		String actProductType= driver.findElement(By.xpath("//ancestor::div//h1[@class=\"title\"]")).getText();
		System.out.println(expProductType+ "\n\n"+ actProductType+ "\n");
		
		if (actProductType.equals(expProductType) && actProductType.isBlank()==false) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---View product by Nhan test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---View product by Nhan test case is failed due to an error---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
	@Test(groups= {"Phu Kien", "Wallet Chain"})
	public void viewWalletChainByProductType() {
		setUp(readconfig.getApplicationBaseURL(), "chrome");
		log.info("Navigated to homepage\n");
		
		ViewProductByHomepagePage vpg= new ViewProductByHomepagePage(driver);
		vpg.performTatcaspMouseHover();
		vpg.pauseWithTryCatch(500);
		log.info("Hovered San pham navigation link\n");
		
		vpg.performPhuKienMouseHover();
		vpg.pauseWithTryCatch(500);
		log.info("Hovered Phu Kien navigation link\n");
		
		vpg.clickWalletChainNavigationLink();
		vpg.pauseWithTryCatch(500);
		log.info("Clicked Wallet Chain navigation link\n");
		
		//assertion
		String expProductType= walletChainProductType;
		String actProductType= driver.findElement(By.xpath("//ancestor::div//h1[@class=\"title\"]")).getText();
		System.out.println(expProductType+ "\n\n"+ actProductType+ "\n");
		
		if (actProductType.equals(expProductType) && actProductType.isBlank()==false) {
			Assert.assertTrue(true);
			log.info("\n\n==>>-----------/*---View product by Wallet Chain test case is passed---*/-----------\n");
		}
		else {
			Assert.assertFalse(true);
			log.error("\n\n==>>-----------/*---View product by Wallet Chain test case is failed due to an error---*/-----------\n");
		}
		
		tearDown();
		log.warn("\n\n==>>-----------/*---Terminated test case---*/-----------\n");
		log.exit();
	}
	
}
