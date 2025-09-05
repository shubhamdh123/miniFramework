package test;

import base.BaseTest;
import pages.LoginPage;
import utils.DriverFactory;
import utils.log;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AddProductCart;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExcelUtil;


public class AddtocartTest extends BaseTest {
	
	@Test
	public void ValidateAddCart() {
		
		LoginPage login = new LoginPage(DriverFactory.getDriver());
		login.login("standard_user", "secret_sauce");
		login.Clickbutn();
		
		
		AddProductCart addCart = new AddProductCart(DriverFactory.getDriver());
		
		addCart.addingCart();
		addCart.clickbtn();
		String item =addCart.getItemname();
		
		Assert.assertEquals(item, "Sauce Labs Backpack", "Product not added to cart");

		
	}
	
	
	
	

}

