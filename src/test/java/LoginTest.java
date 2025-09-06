package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.log;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExcelUtil;

public class LoginTest extends BaseTest {
	
	
	@DataProvider(name="LoginData")
	public Object[][] getLoginData()
	{
		return ExcelUtil.getTestData("src/test/resources/LoginData.xlsx", "Sheet1");
	}
	
	@Test(dataProvider = "LoginData" , groups={"login"})
	public void validLoginTest(String username,String password) 
	{
		log.info("Starting login test with username: "+ username);
		
		LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
		loginpage.login(username,password);
		loginpage.Clickbutn();
		log.info("Entered username and password");
		
		HomePage homepage = new HomePage(DriverFactory.getDriver());
		String title = HomePage.getTitle();
		log.info("Captured page title: " + title);
		
		if(username.equals("fail_user")) 
		{
			Assert.assertNotEquals(HomePage.getTitle(), "products","fail user should not login");
			log.warn("Invalid user tried to login-Expected failure");
		}
		else 
		{
		
		Assert.assertEquals(HomePage.getTitle(), "Products");
		log.info("Login successful for user: " + username);
		
		System.out.println(HomePage.getTitle());
	}
	

}}
