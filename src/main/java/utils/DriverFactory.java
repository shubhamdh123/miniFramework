package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		return driver;
	}
		public static void initDriver() {
			String browser = ConfigReader.get("browser");
			
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			
		}
			driver.manage().window().maximize();
	}
	 public static void quitDriver() {
		 if(driver !=null) 
		 {  driver.quit();
			 }
		 }
	 }
	


