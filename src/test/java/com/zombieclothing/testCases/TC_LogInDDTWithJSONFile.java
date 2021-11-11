package com.zombieclothing.testCases;

import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.LogInPage;
import com.zombieclothing.utilities.JSONReader;
import com.zombieclothing.utilities.ReadConfig;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.io.IOException;


@Listeners(BaseTestListeners.class)
public class TC_LogInDDTWithJSONFile extends BaseClass{

        ReadConfig rdf= new ReadConfig();
        @Var
        private By alertLocator= By.xpath("//div[@class=\"errors\"]//li");
        private final String alertText= "Thông tin đăng nhập không hợp lệ.";

        @DataProvider(name= "loginData")
        public Object[][] passData() throws IOException, ParseException
        {
            return JSONReader.getData("src/test/java/com/zombieclothing/testData/LogInData.json",
                                            "Login Data",
                                        3,
                                    2);
        }

        @BeforeMethod(alwaysRun = true,
                                enabled = true,
                                        description = "Trigger web browser")
        public void logInMethod() {
                setUp(rdf.getApplicationBaseURL()+ "/account", "chrome");
                log.info("TRIGGERED WEB BROWSER \n");
        }

        @Test(groups= {"001"},
                    dataProvider = "loginData")
        public void logInTestDDTWithJSon(String email, String password) throws InterruptedException {

                LogInPage lp = new LogInPage(driver);

                lp.setUserEmail(email);
                log.info("Inputted user email\n");

                lp.setPassword(password);
                log.info("Inputted user password\n");

                lp.clickSubmit();
                log.info("Clicked login button\n");

                lp.checkIfInvalidLoginInforIsPresent(driver, alertLocator, alertText);
                if (lp.checkPoint == true) {
                        Assert.assertFalse(false);
                        log.info("READING JSON FILE TEST CASE IS PASSED!");
                } else {
                        Assert.assertFalse(true);
                        log.error("READING JSON FILE TEST CASE IS FAILED!");
                }
        }

        @AfterMethod(alwaysRun = true,
                        enabled = true,
                                description = "Repel the driver")
        public void afLogInMethod() {
                tearDown();
                log.warn("REPELLED THE DRIVER \n");
                log.warn("TERMINATED TEST CASE \n");
        }
}

