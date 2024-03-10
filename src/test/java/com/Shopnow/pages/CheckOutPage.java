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

public class CheckOutPage extends BaseTest{

	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//a[@class=\"_2Kn22P gBNbID\"]")
	WebElement cartProduct;
	
	@FindBy(xpath="//span[text()=\"Place Order\"]")
	WebElement placeOrder;
	
	public void checkout() {
		String actualProductName;
		this.driver.navigate().to(new ConfigDataProvider().getCarturl());
		this.driver.navigate().refresh();
		try {
			actualProductName=cartProduct.getText();
		}catch(org.openqa.selenium.StaleElementReferenceException e) {
			new WebDriverWait(this.driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cartProduct));
			actualProductName=cartProduct.getText();
		}
		
		Assert.assertTrue(new ConfigDataProvider().getProductName().contains(actualProductName));
		placeOrder.click();
	
		
				 
	}
}
