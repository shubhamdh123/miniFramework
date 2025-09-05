package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProductCart {
	
	private WebDriver driver;
	
	private By BackpackButton= By.id("add-to-cart-sauce-labs-backpack");
	private By OpenCart = By.className("shopping_cart_link");
	private By GetItemName = By.xpath("//*[@id=\"item_4_title_link\"]/div");
	
	
	public AddProductCart(WebDriver driver) 
	{
		this.driver =driver;
	}
	
	public void addingCart() 
	{
		driver.findElement(BackpackButton).click();
		
	}
	public void clickbtn() 
	{
		driver.findElement(OpenCart).click();
	
	}
		
	public String getItemname() 
	{
		return driver.findElement(GetItemName).getText();
	}
	

	}


