package com.Shopnow.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Shopnow.utlities.ConfigDataProvider;

public class AddToCartPage extends BaseTest {

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//div[@class=\"_1YokD2 _3Mn1Gg\"]//child::div[@class=\"_1AtVbE col-12-12\"][1]")
	WebElement laptop1;

	@FindBy(xpath = "//span[@class=\"B_NuCI\"]")
	WebElement productName;

	@FindBy(xpath = "//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")
	WebElement addToCartButton;

	public void addToCart()  {
		
		laptop1.click();
		Set<String> windows = this.driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		this.driver.switchTo().window(child);
		try {
			new ConfigDataProvider().setProductName(productName.getText());
	    } catch (org.openqa.selenium.StaleElementReferenceException e) {
	        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(productName));
	        new ConfigDataProvider().setProductName(productName.getText());
	    }
		Actions act = new Actions(this.driver);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(addToCartButton));
		act.moveToElement(addToCartButton).click().perform();

	}
}
