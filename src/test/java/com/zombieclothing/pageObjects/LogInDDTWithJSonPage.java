package com.zombieclothing.pageObjects;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LogInDDTWithJSonPage {

//    @DataProvider(name="dp")
//    public String[] readJson() throws IOException, ParseException {
//        JSONParser jsonParser= new JSONParser();
//        FileReader reader= new FileReader(".\\testData\\LogInData_1.json");
//
//        Object obj= jsonParser.parse(reader);
//        JSONObject userloginsJsonobj= (JSONObject) obj;
//        JSONArray userloginsArray=(JSONArray) userloginsJsonobj.get("userlogins");
//
//        String arr[]= new String[userloginsArray.size()];
//
//        for (int index=0; index<userloginsArray.size(); index++) {
//            JSONObject users= (JSONObject) userloginsArray.get(index);
//            String email= (String) users.get("email");
//            String pwd= (String) users.get("password");
//
//            arr[index]= email+ ","+ pwd;
//        }
//
//        return arr;
//
//    }



    public void LogInDDTWithJSonPage() throws IOException, ParseException {
        JSONParser jsonParser= new JSONParser();
        JSONObject jsonObject= (JSONObject) jsonParser.parse
                (new FileReader("src/test/java/com/zombieclothing/testData/LogInData_2.json"));

        String email= (String) jsonObject.get("email");
        String pwd= (String) jsonObject.get("password");
        System.out.println(email);
        System.out.println(pwd);
    }
}
