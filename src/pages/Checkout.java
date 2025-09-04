package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import utils.DriverFactory;

public class Checkout extends BaseTest {

	public WebDriver driver;

	private By Checkoutbtn = By.id("checkout");
	private By FirstName = By.id("first-name");
	private By LastName = By.id("last-name");
	private By PostalCode = By.id("postal-code");
	private By ContinueBtn= By.id("continue");
	private By FinishBtn= By.id("finish");
	//private By FinishMsg = By.xpath("//h2[@data-test='complete-header']");

	public Checkout(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickCheckout() {
		WebDriverWait wait= new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Checkoutbtn));
		
		driver.findElement(Checkoutbtn).click();
	}
	public void EnterDetails() 
	{
		driver.findElement(FirstName).sendKeys("Shuhb");
		driver.findElement(LastName).sendKeys("Dhtest");
		driver.findElement(PostalCode).sendKeys("12345");
	}
	public void Continuebutton() 
	{
		driver.findElement(ContinueBtn).click();
	}
	public void finishBtn() 
	{
		driver.findElement(FinishBtn).click();
	}
	
//	public String getFinishMsg()
//	{
//		return driver.findElement(FinishMsg).getText();
//		
//	}

}
