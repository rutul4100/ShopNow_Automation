package com.Shopnow.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Shopnow.utlities.BrowserFactory;
import com.Shopnow.utlities.ConfigDataProvider;

public class BaseTest {
//This class is used to create reference of utility packages
	public WebDriver driver;
	ConfigDataProvider config = new ConfigDataProvider();
	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getUrl());
	}
	
	@AfterClass
	public void tearDown() {
		driver=BrowserFactory.quitApplication(driver);
	}
}
