package com.zombieclothing.testCases;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import com.google.errorprone.annotations.Var;
import com.zombieclothing.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig();
	@Var
	public String baseURL= readconfig.getApplicationBaseURL();
	
	public static JavascriptExecutor javascript;
	
	public static WebDriver driver;
	public static Logger log= org.apache.logging.log4j.LogManager.getLogger();
	
	@BeforeClass
	public void setUp(String baseURL, String br) {
		if (br== "chrome") {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver= new ChromeDriver();
		}
		if (br== "firefox") {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver= new FirefoxDriver();
		}
		if (br== "IE") {	
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver= new InternetExplorerDriver();
		}
		if (br== "opera") {	
			System.setProperty("webdriver.opera.driver", readconfig.getOperaPath());
			driver= new OperaDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
//		logger= Logger.getLogger("zombieClothingV1");
//		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
