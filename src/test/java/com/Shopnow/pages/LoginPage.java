package com.Shopnow.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Shopnow.utlities.ConfigDataProvider;
import com.Shopnow.utlities.ReadEmail;

public class LoginPage extends BaseTest{

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	@FindBy(xpath="//input[@class=\"_2IX_2- _17N0em\"]")
	WebElement userEmail;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement continueButton;
	
	@FindBy(xpath="//input[@class=\"_2IX_2- _3mctLh _17N0em\"]")
	WebElement enterOtp;
	
	@FindBy(xpath="//button[@class=\"_2KpZ6l _20xBvF _3AWRsL\"]")
	WebElement loginButton;
	
	public void loginMethod() throws Exception {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(userEmail));
		userEmail.sendKeys(new ConfigDataProvider().getEmail());
		continueButton.click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(enterOtp));
		enterOtp.sendKeys(ReadEmail.getOtp());
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();
		
	}
}
