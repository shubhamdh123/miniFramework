package test;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddProductCart;
import pages.Checkout;
import pages.LoginPage;
import utils.DriverFactory;

public class CheckoutTest extends BaseTest {
	
	@Test
	public void ValidateCheckOutTest() 
	{
		LoginPage login = new LoginPage(DriverFactory.getDriver());
		login.login("standard_user", "secret_sauce");
		login.Clickbutn();
		
		AddProductCart addCart = new AddProductCart(DriverFactory.getDriver());
		
		addCart.addingCart();
		addCart.clickbtn();
		
		
		Checkout check = new Checkout(DriverFactory.getDriver());
		
		check.ClickCheckout();
		check.EnterDetails();
		check.Continuebutton();
		//String message = check.getFinishMsg();
		
		//Assert.assertEquals(message, "Thank you for your order!");
	}
	

}
