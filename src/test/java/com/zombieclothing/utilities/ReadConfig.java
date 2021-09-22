package com.zombieclothing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	public ReadConfig() {
		File src= new File("./Configuration/config.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			prop= new Properties();
			prop.load(fis);
		} catch (Exception e) {
			//throw exceptional malfunction
			System.out.println("\nException is "+ e.getMessage());
		}
	}
	
	public String getApplicationBaseURL() {
		String url= prop.getProperty("baseURL");
		return url;
	}
	
	public String getEmail() {
		String email= prop.getProperty("email");
		return email;
	}
	
	public String getPassword() {
		String password= prop.getProperty("password");
		return password;
	}
	
	public String getChromePath() {
		String chromepath= prop.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath() {
		String firefoxpath= prop.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getIEPath() {
		String iepath= prop.getProperty("iepath");
		return iepath;
	}
	
	public String getOperaPath() {
		String operapath= prop.getProperty("operapath");
		return operapath;
	}
	
	public String getLastName() {
		String lastname= prop.getProperty("lastname");
		return lastname;
	}
	
	public String getFirstName() {
		String firstname= prop.getProperty("firstname");
		return firstname;
	}
	
	public String getBirthday() {
		String birthday= prop.getProperty("birthday");
		return birthday;
	}
	
	public String getLocalPart() {
		String localpart= prop.getProperty("localpart");
		return localpart;
	}
	
	public String getDomainPart() {
		String domainpart= prop.getProperty("domainpart");
		return domainpart;
	}
	
	public String getSearchProductKey() {
		String searchproductkey= prop.getProperty("searchproductkey");
		return searchproductkey;
	}
	
	public String getViewProductType() {
		String viewproducttype= prop.getProperty("viewproducttype");
		return viewproducttype;
	}
}
