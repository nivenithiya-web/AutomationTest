package FrameworkLearning.Abstarctcomponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	
	public static ExtentReports getExtendReports()
	{
		
	//	"C:\\Users\\nivethitha\\eclipse-workspace\\FrameWorks\\reports\\"+testcasename+"\\.png"
	String path= "C:\\Users\\nivethitha\\eclipse-workspace\\FrameWorks\\reports\\index.html";
	System.out.println("sdsf"+path);
	
	ExtentSparkReporter report =new ExtentSparkReporter(path);
	report.config().setReportName("Webdriver test");
	report.config().setDocumentTitle("Test Results");
	
	ExtentReports extent=new ExtentReports();
	extent.attachReporter(report);
	extent.setSystemInfo("Tester", "Nive");
	
	return extent;
	}
}

