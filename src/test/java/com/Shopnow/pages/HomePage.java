package com.Shopnow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest{

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(css="input.Pke_EE")
	WebElement searchBar;
	
	public void search() {
		searchBar.sendKeys("Laptop");
		searchBar.sendKeys(Keys.ENTER);
	}
}
