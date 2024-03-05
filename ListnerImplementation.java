package CommonUtils;

import java.awt.event.ItemListener;

import javax.naming.spi.DirStateFactory.Result;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener {
	
	ExtentReports report;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String Methods=result.getMethod().getMethodName();
		Reporter.log(Methods+"Testscript Execution is Started",true);
	//	System.out.println("Testscript Execution is Started");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("Testscript Execution is Pass");
		String Methods=result.getMethod().getMethodName();
		Reporter.log(Methods+"Testscript Execution is Pass",true);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String message=result.getThrowable().toString();
		String Methods=result.getMethod().getMethodName();
		Reporter.log(Methods+"Testscript Execution is Fail",true);
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		System.out.println("To start Execution ");
		JavaUtils jutil=new JavaUtils();
//		Reporter.log("To start Execution ",true);
		//use ExtentSparkReporter class just for congigure extent report.
		ExtentSparkReporter reporter=new ExtentSparkReporter("./extentreport/report"+jutil.getRandomNumber()+"JavaUtils");
		reporter.config().setDocumentTitle("VtigerCrm");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Organization");
		
		//use ExtentReports class to genrate Extent report.
		report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Os", "Window 15");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Chromeversion", "120");
		report.setSystemInfo("Author", "Rushikesh");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		System.out.println("To finish the Execution ");
		
//		Reporter.log("To finish the Execution ",true);
		report.flush();
		
		
	}
	
	
}
