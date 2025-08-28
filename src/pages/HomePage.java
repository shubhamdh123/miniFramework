package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private static WebDriver driver;
	private static By productTitle =By.className("title");
	
	public HomePage(WebDriver driver) {
		this.driver =driver;
		
	}
	public static String getTitle() 
	{
		return driver.findElement(productTitle).getText();
	}

}
