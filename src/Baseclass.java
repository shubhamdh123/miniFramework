import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Baseclass {
	
	protected WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// Set up the WebDriver and ChromeOptions
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shubhamdh\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\shubhamdh\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://brave-bear-q3t5eb-dev-ed.trailblaze.my.salesforce.com/");

		// Login to Salesforce
		driver.findElement(By.id("username")).sendKeys("shubhamdhawale1976@brave-bear-q3t5eb.com");
		driver.findElement(By.id("password")).sendKeys("Sh123456");
		driver.findElement(By.id("Login")).click();
		driver.manage().window().maximize();

		// Navigate to the page with the New Contact modal
		driver.navigate().to(
				"https://brave-bear-q3t5eb-dev-ed.trailblaze.lightning.force.com/lightning/o/Contact/pipelineInspection?filterName=00BWU00000FNS9R2AX");

		// Wait for the "New Contact" button to be visible and clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time to 20 seconds
		WebElement newContactButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='NewContact']")));

		// Wait again for the element to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(newContactButton));

		// Click the NewContact button
		newContactButton.click();

		// Wait for the modal to appear
		WebElement detailPanel = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div[class=\"modal-container slds-modal__container\"]")));

		if (detailPanel.isDisplayed()) {
			// Example: Fill a form inside the panel or interact with elements inside it
			System.out.println("Yes, the modal is there");

			Thread.sleep(5000);

			// You do not need to switch to a frame, simply interact with the elements
			// directly inside the modal
			// WebElement salute =
			// detailPanel.findElement(By.xpath("//button[@name='salutation']"));
			// wait.until(ExpectedConditions.elementToBeClickable(salute));

			// Select a value from the dropdown
//            Select s = new Select(salute);
//            s.selectByIndex(0);

			WebElement fname = driver.findElement(By.xpath("//input[@placeholder='First Name']"));

			if (fname.isDisplayed()) {
				// Example: Fill a form inside the panel or interact with elements inside it
				System.out.println("Yes, the name is there");

				fname.sendKeys("shubham");

			}
			WebElement Lname = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));

			Lname.sendKeys("Dhawale");

			WebElement Salutation = driver.findElement(By.xpath("//button[@name='salutation']"));

			if (Salutation.isDisplayed()) {
				// Example: Fill a form inside the panel or interact with elements inside it
				System.out.println("Salutation is there");

				Salutation.click();

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//lightning-base-combobox-item[@data-value='Mr.']")));

				// direct Mr select kela adhi dropdwon la click kela ani mg dropdown open zala
				// ani mg Mr ch option select kela locator .

				WebElement option = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Mr.']"));
				option.click();

				WebElement address = driver.findElement(By.xpath("((//textarea[@name='street'])[1])"));
				address.sendKeys("Jisingpure layout");
				
				
				WebElement savebut= driver.findElement(By.xpath("//button[@name='SaveEdit']"));

				
				if (savebut.isDisplayed()) {
					// he mi check karayla lihla ki save button disat ahe ka
					System.out.println("Save buutton is there");

					savebut.click();
				// Close the browser after test completion
				// driver.quit();
			}
		}
	}}
}