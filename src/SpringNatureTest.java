import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpringNatureTest {
	protected WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shubhamdh\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\shubhamdh\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.demoblaze.com");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// For Mobile Phones
		driver.findElement(By.cssSelector("a[onclick=\"byCat('phone')\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tbodyid .col-lg-4.col-md-6.mb-4")));
		List<WebElement> mobiles = driver.findElements(By.cssSelector(".col-lg-4.col-md-6.mb-4"));
		System.out.println("Number of mobiles: " + mobiles.size());

		// Reset the page state by navigating back to the homepage as page was not fully resetting
		driver.get("https://www.demoblaze.com");

		// For Laptops
		driver.findElement(By.cssSelector("a[onclick=\"byCat('notebook')\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4.col-md-6.mb-4")));
		List<WebElement> laptops = driver.findElements(By.cssSelector("#tbodyid .col-lg-4.col-md-6.mb-4"));
		System.out.println("Number of laptops: " + laptops.size());

		// Reset the page state by navigating back to the homepage as page was not fully resetting
		driver.get("https://www.demoblaze.com");

		// For Monitors
		driver.findElement(By.cssSelector("a[onclick=\"byCat('monitor')\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tbodyid .col-lg-4.col-md-6.mb-4")));
		List<WebElement> monitors = driver.findElements(By.cssSelector("#tbodyid .col-lg-4.col-md-6.mb-4"));
		System.out.println("Number of monitors: " + monitors.size());

		driver.quit();
	}
}