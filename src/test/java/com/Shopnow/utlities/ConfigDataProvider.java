package com.Shopnow.utlities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;

	public ConfigDataProvider() {
		File file=new File("./src/test/resources/config/config.properties");
		System.out.println();
		try {
			
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			
				prop.load(fis);
			
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getBrowser() {
		return prop.getProperty("browser");
	}

	public String getUrl() {
		return prop.getProperty("url");
	}
	
	public String getHomePageTitle() {
		return prop.getProperty("homePage-Title");
	}
	
	public String getCarturl() {
		return prop.getProperty("cart-Url");
	}
	
	public String getProductName() {
		return prop.getProperty("productName");
	}
	
	public String getEmail() {
		return prop.getProperty("email");
	}
	public String getName() {
		return prop.getProperty("name");
	}
	public String getPhone() {
		return prop.getProperty("phone");
	}
	public String getPincode() {
		return prop.getProperty("pincode");
	}
	public String getAddressLine2() {
		return prop.getProperty("addressLine2");
	}
	public String getAddressLine1() {
		return prop.getProperty("addressLine1");
	}
	public String getCity() {
		return prop.getProperty("city");
	}
	public String getcardNumber() {
		return prop.getProperty("cardNumber");
	}
	public String getexpiryMonth() {
		return prop.getProperty("expiryMonth");
	}
	public String getexpiryYear() {
		return prop.getProperty("expiryYear");
	}
	public String getCvv() {
		return prop.getProperty("cvv");
	}
	
	public void setProductName(String name) {
		FileOutputStream fos = null;
		try {
			fos= new FileOutputStream("./src/test/resources/config/config.properties");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		prop.setProperty("productName",name);
		try {
			prop.store(fos, null);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
