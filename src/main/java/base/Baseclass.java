
package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Baseclass {

    protected WebDriver driver;  // Declare driver at class level

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver
    	System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shubhamdh\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); // Update path with correct chromedriver location

        // Initialize ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\shubhamdh\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe"); // Set the path to the Chrome executable

        // Initialize the ChromeDriver with ChromeOptions
        driver = new ChromeDriver(options);

        // Navigate to the desired URL
        driver.get("https://demo.automationtesting.in/Register.html");
    }

    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver instance after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
