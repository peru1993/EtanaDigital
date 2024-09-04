package TestNG;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // common info of the report
	public ExtentTest test; //creating testcase entries in the report and update status of the test methods
	
	
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports");
		sparkReporter.config().setDocumentTitle("Automation Report"); //Title of the report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Peru");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser name", "Chrome");	
	}
	
	
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName()); //create a new entry in a report
		test.log(Status.PASS, "Test Case PASSED is : " + result.getName());  //update the status
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName()); //create a new entry in a report
		test.log(Status.FAIL, "Test Case Failed is : " + result.getName());  //update the status
		test.log(Status.FAIL, "Test Case Failed cause is : " + result.getThrowable());  //update the status	
	}
	
	public void onTestSkipped(ITestResult result) {
		
		test = extent.createTest(result.getName()); //create a new entry in a report
		test.log(Status.SKIP, "Test Case Skipped is : " + result.getName());  //update the status	
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
	
}
