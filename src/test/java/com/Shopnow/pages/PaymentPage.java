package com.Shopnow.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Shopnow.utlities.ConfigDataProvider;

public class PaymentPage extends BaseTest {
	
	public PaymentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	@FindBy(xpath="//input[@id=\"CREDIT\"]")
	WebElement creditButton;
	
	@FindBy(xpath="//input[@name=\"cardNumber\"]")
	WebElement cardNumber;
	
	@FindBy(xpath="//select[@name=\"month\"]")
	WebElement expiryMonth;
	
	@FindBy(xpath="//select[@name=\"year\"]")
	WebElement expiryYear;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	WebElement cvv;
	
	
	public void pay() {
		ConfigDataProvider cp=new ConfigDataProvider();
		new WebDriverWait(this.driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(creditButton));
		creditButton.click();
		cardNumber.sendKeys(cp.getcardNumber());
		Select s=new Select(expiryMonth);
		s.selectByVisibleText(cp.getexpiryMonth());
		Select s1=new Select(expiryYear);
		s.selectByVisibleText(cp.getexpiryYear());
		cvv.sendKeys(cp.getCvv());
	}
}
