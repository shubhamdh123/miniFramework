package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	public static String takeScreenshot(WebDriver driver,String testName) 
	{
		String timestamp =new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotPath ="test-output/screenshots/" + testName + "_"+timestamp + ".png";
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File(screenshotPath));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return screenshotPath;
	}

}
