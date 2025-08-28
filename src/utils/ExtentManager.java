package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	
	public static ExtentReports getReporter() {
		if(extent == null) 
		{
			ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
			reporter.config().setReportName("Austomation Test Report");
			reporter.config().setDocumentTitle("Test result");
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Shubham");
			extent.setSystemInfo("Environment", "QA");
		}
		return extent;
	}

}
