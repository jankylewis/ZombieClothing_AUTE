package com.zombieclothing.testCases;

import java.util.Random;									import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;						import org.junit.AfterClass;
import org.junit.BeforeClass;								import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;						import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;				import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;		import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;				import com.google.errorprone.annotations.Var;
import com.zombieclothing.utilities.ReadConfig;				import org.testng.annotations.Optional;


public abstract class BaseClass {
	
	transient public ReadConfig readconfig= new ReadConfig();
	@Var
	public String baseURL= readconfig.getApplicationBaseURL();
	public static JavascriptExecutor javascript;
	public static Actions action;
	public static WebDriver wait;
	public static WebDriver driver;
	public static WebElement webelement;
	public final static Logger log= org.apache.logging.log4j.LogManager.getLogger();
	
	public String browserArr[]= {"firefox", "chrome", "opera"};
	public String brRandom= browserArr[new Random().nextInt(browserArr.length)];
	
	@BeforeClass
	public void setUp(@Optional("IE") String baseURL, String br) {
		if (br== "chrome"==true
				|| br.equalsIgnoreCase("chrome")==true
					|| br.contains("chrome")==true) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver= new ChromeDriver();
		}
		if (br== "firefox"
				|| br.equalsIgnoreCase("firefox")
					|| br.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver= new FirefoxDriver();
		}
		if (br== "IE"
				|| br.equalsIgnoreCase("IE")
					|| br.contains("IE")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver= new InternetExplorerDriver();
		}
		if (br== "opera"
				|| br.equalsIgnoreCase("opera")
					|| br.contains( "opera")) {
			System.setProperty("webdriver.opera.driver", readconfig.getOperaPath());
			driver= new OperaDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//		logger= Logger.getLogger("zombieClothingV1");
//		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@AfterClass
	public static void tearDown() {
		try {
			if (driver!= null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		}
		catch (final Exception exception) {
			log.error("//--------###-------NO DRIVER FOUND-------###-----//");
		}
	}
}
