package com.zombieclothing.testCases;
import com.google.errorprone.annotations.Var;
import com.zombieclothing.pageObjects.SignUpPage;
import com.zombieclothing.utilities.JSONReader;
import com.zombieclothing.utilities.ReadConfig;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeoutException;


@Listeners({BaseTestListeners.class})
public class TC_SignUpDDTWithJSONFile extends BaseClass{

    ReadConfig read= new ReadConfig(/*get data from the config file*/);
    @Var()
    private boolean checkPointTestCase;
    private int     ranNum= new Random().nextInt(5000);
    private final   String textRequiredMessage= "Please fill out this field.";

    private final   By TXT_LAST_NAME_LOCATOR=
                    By.xpath("//div[@id=\"form-last_name\"]//child::input[@id=\"last_name\"][1]");
    private final   By TXT_FIRST_NAME_LOCATOR=
                    By.xpath("//div[@id=\"form-first_name\"]//child::input[@id and @required or @validationMessage][1]");
    private final   By TXT_BIRTHDAY_LOCATOR=
                    By.xpath("//div[@id=\"form-birthday\"]//child::input[@id or @validationMessage][1]");
    private final   By TXT_EMAIL_LOCATOR=
                    By.xpath("//div[@id=\"form-email\"]//child::input[@id= \"email\" and @required]");
    private final   By TXT_PASSWORD_LOCATOR=
                    By.xpath("//label[@for=\"password\"]//following::input[1]");

    @DataProvider(name= "registrationData")
    public Object[][] passData() throws IOException, ParseException
    {
        return JSONReader.getData("src/" +
                                        "test/" +
                                    "java/" +
                                "com/" +
                            "zombieclothing/" +
                        "testData/SignUpData.json",
                "Registration Data",
                8,
                6);
    }

    @BeforeMethod(alwaysRun = true,
            enabled = true,
            description = "Trigger web browser")
    public void be4SignUpMethod() {
        setUp(read.getApplicationBaseURL()+ "/account"
                                            + "/register", brRandom);
        log.info("TRIGGERED WEB BROWSER \n");
    }

    @Test(groups = {"JSON DDT"}, dataProvider = "registrationData")
    public final void signUpTestWithJSONDDT (
                                                String lastName,
                                                String firstName,
                                                String gender,
                                                String birthday,
                                                String email,
                                                String password
                                            ) throws    InterruptedException
                                                        , TimeoutException
                                                        , RuntimeException {
/*      System.out.println(lastName);
        System.out.println(firstName);
        System.out.println(gender);
        System.out.println(birthday);
        System.out.println(email);
        System.out.println(password);                                                                                                                                                                                                                                                                                       */
        SignUpPage sign= new SignUpPage(driver);

        //data set 1

        if (lastName== "" && Objects.equals(firstName, "")
                && Objects.equals(gender, "") && birthday!= ""
                    && email!= "" && !Objects.equals(password, "")) {
            log.info("TRIGGERED DATA SET NUMBER 01");
            sign.setLastName(lastName);
            log.info("overpassed last name field");
            sign.setFirstName(firstName);
            log.info("overpassed first name field");
            sign.selectGender(gender, driver);
            log.info("overpassed gender field");
            sign.setBirthday(birthday);
            log.info("overpassed birthday field");
            sign.setEmail(email);
            log.info("overpassed email field");
            sign.setPassword(password);
            log.info("overpassed password field");

            if (sign.checkRequiredMessageWithJSON(driver, textRequiredMessage,
                                                    TXT_LAST_NAME_LOCATOR, "Last Name")) {
                checkPointTestCase=true;
                if (checkPointTestCase) {
                    Assert.assertFalse(false);
                    log.info("last name required alert is present \n\n");
                    log.info("asserted alert successfully \n\n");
                }
                else if (!checkPointTestCase) {
                    Assert.assertFalse(true);
                    log.warn("asserted alert unsuccessfully due to the absence of the alert \n\n");
                }
            }
        }

        //data set 2

        if (!Objects.equals(lastName, "") && !Objects.equals(firstName, "")
                && !Objects.equals(gender, "") && Objects.equals(birthday, "")
                && Objects.equals(email, "") && !password.equals("")) {
            log.info("TRIGGERED DATA SET NUMBER 2");
            sign.setLastName(lastName);
            log.info("overpassed last name field");
            sign.setFirstName(firstName);
            log.info("overpassed first name field");
            sign.selectGender(gender, driver);
            log.info("overpassed gender field");
            sign.setBirthday(birthday);
            log.info("overpassed birthday field");
            sign.setEmail(email);
            log.info("overpassed email field");
            sign.setPassword(password);
            log.info("overpassed password field");

            if (sign.checkRequiredMessageWithJSON(driver, textRequiredMessage,
                                            TXT_EMAIL_LOCATOR, "Email")) {
                checkPointTestCase=true;
                if (checkPointTestCase) {
                    Assert.assertFalse(false);
                    log.info("email required alert is present \n\n");
                    log.info("asserted alert successfully \n\n");
                }
                else if (!checkPointTestCase) {
                    Assert.assertFalse(true);
                    log.warn("asserted alert unsuccessfully due to the absence of the alert \n\n");
                }
            }
        }

        //data set 3

        if (!Objects.equals(lastName, "") && !Objects.equals(firstName, "")
                && Objects.equals(gender, "") && Objects.equals(birthday, "")
                && Objects.equals(email, "") && Objects.equals(password, "")) {
            log.info("TRIGGERED DATA SET NUMBER 3");
            sign.setLastName(lastName);
            log.info("overpassed last name field");
            sign.setFirstName(firstName);
            log.info("overpassed first name field");
            sign.selectGender(gender, driver);
            log.info("overpassed gender field");
            sign.setBirthday(birthday);
            log.info("overpassed birthday field");
            sign.setEmail(email.concat(String.valueOf(ranNum)).concat("@gmail.com"));
            log.info("overpassed email field");
            sign.setPassword(password);
            log.info("overpassed password field");

            if (sign.checkRequiredMessageWithJSON(driver, textRequiredMessage,
                    TXT_PASSWORD_LOCATOR, "Email")) {
                checkPointTestCase=true;
                if (checkPointTestCase) {
                    Assert.assertFalse(false);
                    log.info("password required alert is present \n\n");
                    log.info("asserted alert successfully \n\n");
                }
                else if (!checkPointTestCase) {
                    Assert.assertFalse(true);
                    log.warn("asserted alert unsuccessfully due to the absence of the alert \n\n");
                }
            }
        }

        //data set 4

        if (Objects.equals(lastName, "") && !Objects.equals(firstName, "")
                && !Objects.equals(gender, "") && !Objects.equals(birthday, "")
                && !Objects.equals(email, "") && !Objects.equals(password, "")) {
            log.info("TRIGGERED DATA SET NUMBER 4");
            sign.setLastName(lastName);
            log.info("overpassed last name field");
            sign.setFirstName(firstName);
            log.info("overpassed first name field");
            sign.selectGender(gender, driver);
            log.info("overpassed gender field");
            sign.setBirthday(birthday);
            log.info("overpassed birthday field");
            sign.setEmail(email);
            log.info("overpassed email field");
            sign.setPassword(password);
            log.info("overpassed password field");

            if (sign.checkRequiredMessageWithJSON(driver, textRequiredMessage,
                    TXT_LAST_NAME_LOCATOR, "Last Name")) {
                checkPointTestCase=true;
                if (checkPointTestCase) {
                    Assert.assertFalse(false);
                    log.info("last name required alert is present \n\n");
                    log.info("asserted alert successfully \n\n");
                }
                else if (!checkPointTestCase) {
                    Assert.assertFalse(true);
                    log.warn("asserted alert unsuccessfully due to the absence of the alert \n\n");
                }
            }
        }

        //data set 5

        if (!Objects.equals(lastName, "") && Objects.equals(firstName, "")
                && !Objects.equals(gender, "") && !Objects.equals(birthday, "")
                && !Objects.equals(email, "") && !Objects.equals(password, "")) {
            log.info("TRIGGERED DATA SET NUMBER 5");
            sign.setLastName(lastName);
            log.info("overpassed last name field");
            sign.setFirstName(firstName);
            log.info("overpassed first name field");
            sign.selectGender(gender, driver);
            log.info("overpassed gender field");
            sign.setBirthday(birthday);
            log.info("overpassed birthday field");
            sign.setEmail(email);
            log.info("overpassed email field");
            sign.setPassword(password);
            log.info("overpassed password field");

            if (sign.checkRequiredMessageWithJSON(driver, textRequiredMessage,
                    TXT_FIRST_NAME_LOCATOR, "Last Name")) {
                checkPointTestCase=true;
                if (checkPointTestCase) {
                    Assert.assertFalse(false);
                    log.info("first name required alert is present \n\n");
                    log.info("asserted alert successfully \n\n");
                }
                else if (!checkPointTestCase) {
                    Assert.assertFalse(true);
                    log.warn("asserted alert unsuccessfully due to the absence of the alert \n\n");
                }
            }
        }

        //data set 6

        if (!Objects.equals(lastName, "") && !Objects.equals(firstName, "")
                && !Objects.equals(gender, "") && !Objects.equals(birthday, "")
                && Objects.equals(email, "") && !Objects.equals(password, "")) {
            log.info("TRIGGERED DATA SET NUMBER 6");
            sign.setLastName(lastName);
            log.info("overpassed last name field");
            sign.setFirstName(firstName);
            log.info("overpassed first name field");
            sign.selectGender(gender, driver);
            log.info("overpassed gender field");
            sign.setBirthday(birthday);
            log.info("overpassed birthday field");
            sign.setEmail(email);
            log.info("overpassed email field");
            sign.setPassword(password);
            log.info("overpassed password field");

            if (sign.checkRequiredMessageWithJSON(driver, textRequiredMessage,
                    TXT_EMAIL_LOCATOR, "Email")) {
                checkPointTestCase=true;
                if (checkPointTestCase) {
                    Assert.assertFalse(false);
                    log.info("email required alert is present \n\n");
                    log.info("asserted alert successfully \n\n");
                }
                else if (!checkPointTestCase) {
                    Assert.assertFalse(true);
                    log.warn("asserted alert unsuccessfully due to the absence of the alert \n\n");
                }
            }
        }

        //data set 7

        if (!Objects.equals(lastName, "") && !Objects.equals(firstName, "")
                && !Objects.equals(gender, "") && !Objects.equals(birthday, "")
                && !Objects.equals(email, "") && Objects.equals(password, "")) {
            log.info("TRIGGERED DATA SET NUMBER 7");
            sign.setLastName(lastName);
            log.info("overpassed last name field");
            sign.setFirstName(firstName);
            log.info("overpassed first name field");
            sign.selectGender(gender, driver);
            log.info("overpassed gender field");
            sign.setBirthday(birthday);
            log.info("overpassed birthday field");
            sign.setEmail(email);
            log.info("overpassed email field");
            sign.setPassword(password);
            log.info("overpassed password field");

            if (sign.checkRequiredMessageWithJSON(driver, textRequiredMessage,
                    TXT_PASSWORD_LOCATOR, "Email")) {
                checkPointTestCase=true;
                if (checkPointTestCase) {
                    Assert.assertFalse(false);
                    log.info("password required alert is present \n\n");
                    log.info("asserted alert successfully \n\n");
                }
                else if (!checkPointTestCase) {
                    Assert.assertFalse(true);
                    log.warn("asserted alert unsuccessfully due to the absence of the alert \n\n");
                }
            }
        }

        //data set 8

        if (Objects.equals(lastName, "") && Objects.equals(firstName, "")
                && Objects.equals(gender, "") && Objects.equals(birthday, "")
                && Objects.equals(email, "") && Objects.equals(password, "")) {

            log.info("TRIGGERED DATA SET NUMBER 8");

            sign.setLastName(lastName);
            log.info("overpassed last name field");
            sign.setFirstName(firstName);
            log.info("overpassed first name field");
            sign.selectGender(gender, driver);
            log.info("overpassed gender field");
            sign.setBirthday(birthday);
            log.info("overpassed birthday field");
            sign.setEmail(email);
            log.info("overpassed email field");
            sign.setPassword(password);
            log.info("overpassed password field");

            if (sign.checkRequiredMessageWithJSON(driver, textRequiredMessage,
                    TXT_LAST_NAME_LOCATOR, "Last Name")) {
                checkPointTestCase=true;
                if (checkPointTestCase) {
                    Assert.assertFalse(false);
                    log.info("last name required alert is present \n\n");
                    log.info("asserted alert successfully \n\n");
                }
                else if (!checkPointTestCase) {
                    Assert.assertFalse(true);
                    log.warn("asserted alert unsuccessfully due to the absence of the alert \n\n");
                }
            }
        }
    }


    @AfterMethod(alwaysRun = true,
            enabled = true,
            description = "Repel the driver")
    public void afSignUpMethod() {
        tearDown();
        log.warn("REPELLED THE DRIVER \n");
        log.warn("TERMINATED TEST CASE \n");
    }

}
