package com.zombieclothing.testCases;

import com.zombieclothing.pageObjects.LogInDDTWithJSonPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LogInDDTWithJson extends BaseClass{

        @Test(groups= {"001"})
        public void logInTestDDTWithJSon() throws IOException, ParseException {

            LogInDDTWithJSonPage json= new LogInDDTWithJSonPage();
            json.LogInDDTWithJSonPage();
        }

}
