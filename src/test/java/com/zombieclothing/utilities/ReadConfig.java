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
	
	public String getViewAoByProductType() {
		String viewaobyproducttype= prop.getProperty("viewaobyproducttype");
		return viewaobyproducttype;
	}
	
	public String getViewAoThunSoMiByProductType() {
		String viewaothunsomibyproducttype= prop.getProperty("viewaothunsomibyproducttype");
		return viewaothunsomibyproducttype;
	}
	
	public String getViewSweaterHoodieByProductType() {
		String viewsweaterhoodiebyproducttype= prop.getProperty("viewsweaterhoodiebyproducttype");
		return viewsweaterhoodiebyproducttype;
	}
	
	public String getViewSanPhamKhacByProductType() {
		String viewsanphamkhacbyproducttype= prop.getProperty("viewsanphamkhacbyproducttype");
		return viewsanphamkhacbyproducttype;
	}
	
	public String getViewQuanByProductType() {
		String viewquanbyproducttype= prop.getProperty("viewquanbyproducttype");
		return viewquanbyproducttype;
	}
	
	public String getViewQuanDaiByProductType() {
		String viewquandaibyproducttype= prop.getProperty("viewquandaibyproducttype");
		return viewquandaibyproducttype;
	}
	
	public String getViewQuanShortByProductType() {
		String viewquanshortbyproducttype= prop.getProperty("viewquanshortbyproducttype");
		return viewquanshortbyproducttype;
	}
	
	public String getViewSetByProductType() {
		String viewsetbyproducttype= prop.getProperty("viewsetbyproducttype");
		return viewsetbyproducttype;
	}
	
	public String getViewPhuKienByProductType() {
		String viewphukienbyproducttype= prop.getProperty("viewphukienbyproducttype");
		return viewphukienbyproducttype;
	}
	
	public String getViewMuByProductType() {
		String viewmubyproducttype= prop.getProperty("viewmubyproducttype");
		return viewmubyproducttype;
	}
	
	public String getViewKinhByProductType() {
		String viewkinhbyproducttype= prop.getProperty("viewkinhbyproducttype");
		return viewkinhbyproducttype;
	}
	
	public String getViewNhanByProductType() {
		String viewnhanbyproducttype= prop.getProperty("viewnhanbyproducttype");
		return viewnhanbyproducttype;
	}
	
	public String getViewWalletChainByProductType() {
		String viewwalletchainbyproducttype= prop.getProperty("viewwalletchainbyproducttype");
		return viewwalletchainbyproducttype;
	}
}
