package com.Shopnow.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Shopnow.pages.AddToCartPage;
import com.Shopnow.pages.BaseTest;
import com.Shopnow.pages.CheckOutPage;
import com.Shopnow.pages.HomePage;
import com.Shopnow.pages.LoginPage;
import com.Shopnow.pages.OrderSummaryPage;
import com.Shopnow.pages.PaymentPage;
import com.Shopnow.pages.ShippingPage;
import com.Shopnow.utlities.ConfigDataProvider;

public class CheckOutTest extends BaseTest {
	ConfigDataProvider config = new ConfigDataProvider();
	@Test
	public void demo() throws Exception {
		//Open Flipkart Website & validates homepage loaded successfully
		BaseTest bt=new BaseTest();
		Assert.assertEquals(driver.getTitle(), config.getHomePageTitle());
		
		//Searching Laptop and adding to cart
		new HomePage(driver).search();
		new AddToCartPage(driver).addToCart();
		
		//Navigate to cart url, verified product & procceded with placing order
		new CheckOutPage(driver).checkout();
		
		//user Authentication & Validated login succesfully
		new LoginPage(driver).loginMethod();
		//Note: While logging in as this is Automated browser Otp is not being able to send 
		//And getting error as Something went wrong.
		
		//entered shipping info.
		new ShippingPage(driver).enterShippingDetails();
		
		// verify order summary
		new OrderSummaryPage(driver).verifyOrderSummary();
		
		//Payment throuch credit card
		new PaymentPage(driver).pay();
		
	//Note 1: Order summary is done previously and then payment flow.
	//Note 2: Have written the code to fetch otp from email, But while trying to login
	//		  to flipkart through automated browser the mail for otp is not sent.
	//		  Getting error as Something went wrong
	//Note 3: login to flipkart doesn't ask for username & password, but mail/mobile with OTP.
		
		
	}
}
