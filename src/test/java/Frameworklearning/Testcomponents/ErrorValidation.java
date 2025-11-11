package Frameworklearning.Testcomponents;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import FrameworkingLearning.pageobjects.Productcatologue;
import FrameworkingLearning.pageobjects.cartpage;

public class ErrorValidation extends BaseTest{
	
	@Test
	public void LoginErrorTest()
	{	
		landingpage.getloginpage("nivenithiya@gmail.com","earn@2528");
		String message=landingpage.getErrormessage();
		Assert.assertEquals("Incorrect email  password", message);
	}
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
		{
			
		String productName ="ADIDAS ORIGINAL";
		Productcatologue prodctlg=landingpage.getloginpage("nivenithiya@gmail.com", "Learn@2528");
		
		prodctlg.getproductList();
		prodctlg.addTocart(productName);
	
		cartpage cart=prodctlg.gotocart();
		

		Boolean match =cart.verifyproductlist(productName);
		Assert.assertTrue(match);
	}
	

}
