package com.Shopnow.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Shopnow.utlities.ConfigDataProvider;

public class ShippingPage extends BaseTest {

	public ShippingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//input[@name=\"name\"]")
	WebElement name;
	
	@FindBy(xpath="//input[@name=\"phone\"]")
	WebElement phone;
	
	@FindBy(xpath="//input[@name=\"pincode\"]")
	WebElement pincode;
	
	@FindBy(xpath="//input[@name=\"addressLine2\"]")
	WebElement addressLine2;
	
	@FindBy(xpath="//textarea[@name=\"addressLine1\"]")
	WebElement addressLine1;
	
	@FindBy(xpath="//input[@name=\"city\"]")
	WebElement city;
	
	@FindBy(xpath="//select[@name=\"state\"]")
	WebElement select;
	
	@FindBy(xpath="//span[text()=\"Home (All day delivery)\"]")
	WebElement addressType;
	
	@FindBy(xpath="//button[text()=\"Save and Deliver Here\"]")
	WebElement saveAndDeliverButton;
	
	public void enterShippingDetails() {
		ConfigDataProvider cp=new ConfigDataProvider();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(name));
		Assert.assertTrue(name.isDisplayed(),"Login Failed");
		name.sendKeys(cp.getName());
		phone.sendKeys(cp.getPhone());
		pincode.sendKeys(cp.getPhone());
		addressLine2.sendKeys(cp.getAddressLine2());
		addressLine1.sendKeys(cp.getAddressLine1());
		city.sendKeys(cp.getCity());
		Select s=new Select(select);
		s.selectByVisibleText("Maharashtra");
		addressType.click();
		saveAndDeliverButton.click();
	}
}
