package com.Shopnow.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Shopnow.utlities.ConfigDataProvider;

public class OrderSummaryPage extends BaseTest{

	public OrderSummaryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	@FindBy(xpath="//div[@class=\"_2Kn22P\"]")
	WebElement orderSummaryProductName;
	
	@FindBy(xpath="//button[text()=\"CONTINUE\"]")
	WebElement continueButton;
	
	@FindBy(xpath="//button[text()=\"Accept & Continue\"]")
	WebElement acceptAndContinue;
	
	public void verifyOrderSummary() {
		Assert.assertTrue(new ConfigDataProvider().getProductName().contains(orderSummaryProductName.getText()));
		new WebDriverWait(this.driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(continueButton));
		continueButton.click();
		new WebDriverWait(this.driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(acceptAndContinue));
		acceptAndContinue.click();
	}
}
