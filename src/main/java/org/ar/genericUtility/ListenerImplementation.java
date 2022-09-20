package org.ar.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	private ExtentReports reports;
	private ExtentTest test;
	public static ExtentTest stest;

	@Override
	public void onStart(ITestContext arg0) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("Document Title-SDET 40");
		spark.config().setReportName("Report Name - SDET 40");
		spark.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author", "Kiran");
		reports.setSystemInfo("OS", "win 11");
		reports.setSystemInfo("Browser", "chrome");

	}

	@Override // @BM
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		stest = test;
	}

	@Override // @AM
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName() + "pass");

	}

	@Override // @AM
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName() + "fail");
		test.fail(result.getThrowable());
		System.out.println(Thread.currentThread().getId());
		String path = new WebDriverUtility().screenShot(BaseClass_SI.sdriver);
		test.addScreenCaptureFromBase64String(path);

	}

	@Override // @AM
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reports.flush();

	}

}
