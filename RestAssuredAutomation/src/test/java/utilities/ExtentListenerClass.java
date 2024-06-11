package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {

	ExtentSparkReporter htmlReporter; // User interface and look & feel of the report
	ExtentReports reports; // Common information
	ExtentTest test; // Entries for test

	public void configureReport() {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "AutomationTestReport-" + timestamp + ".html";
		String reportPath = System.getProperty("user.dir") + "/Reports/" + reportName;

		// Ensure the Reports directory exists
		File reportsDir = new File(System.getProperty("user.dir") + "/Reports");
		if (!reportsDir.exists()) {
			reportsDir.mkdirs();
		}

		htmlReporter = new ExtentSparkReporter(reportPath);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// Add system information/environment info to reports
		reports.setSystemInfo("Machine:", "AS-PC-007");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("Tester name:", "Mitra bhanu");

		// Configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report");
		htmlReporter.config().setReportName("Rest Assured Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	@Override
	public void onStart(ITestContext context) {
		configureReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Name of test method started:" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test method successfully executed:" + result.getName());

		test = reports.createTest(result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the passed test case is: " + result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method failed:" + result.getName());
		test = reports.createTest(result.getName()); // create entry in html report
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the failed test case is: " + result.getName(), ExtentColor.RED));

		// Log the exception message
		Throwable exception = result.getThrowable();
		if (exception != null) {
			test.log(Status.FAIL, exception);
		}

		String screenShotPath = System.getProperty("user.dir") + "/ScreenShots/" + result.getName() + ".png";

		File screenShotFile = new File(screenShotPath);

		if (screenShotFile.exists()) {
			try {
				test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of test method skipped:" + result.getName());

		test = reports.createTest(result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skip test case is: " + result.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finished method invoked....");
		reports.flush(); // It is mandatory to call flush method to ensure information is written to the
							// started reporter.
	}
}
