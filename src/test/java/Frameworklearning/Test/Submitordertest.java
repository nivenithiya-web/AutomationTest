package Frameworklearning.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrameworkLearning.Abstarctcomponents.OrderPage;
import FrameworkingLearning.pageobjects.ConfirmationPage;
import FrameworkingLearning.pageobjects.Landingpage;
import FrameworkingLearning.pageobjects.Productcatologue;
import FrameworkingLearning.pageobjects.Submitpage;
import FrameworkingLearning.pageobjects.cartpage;
import Frameworklearning.Testcomponents.BaseTest;

public class Submitordertest extends BaseTest{

	String productName ="ZARA COAT 3";
		
		@Test(dataProvider="getdata",groups= {"Purchase"})
		public void submitorder(HashMap<String,String> input) throws IOException, InterruptedException
		{
			
		
		Productcatologue prodctlg=landingpage.getloginpage(input.get("email"),input.get("password"));
		
		prodctlg.getproductList();
		prodctlg.addTocart(input.get("productName"));
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cartpage cart=prodctlg.gotocart();
		
	//Thread.sleep(3000);
		Boolean match =cart.verifyproductlist(input.get("productName"));
		Assert.assertTrue(match);
		Submitpage submitorder=	cart.checkout();
			
		submitorder.selectcountry("india");
		ConfirmationPage ConfirmationPage=submitorder.submit();
		
//	String message=ConfirmationPage.getconfimrationmsg() ;  
//	Assert.assertEquals(message.equalsIgnoreCase("Thankyou for the order"), "This is pass");	
	}
		
		@Test(dependsOnMethods= {"submitorder"})
		public void verifyorders () throws InterruptedException
		{
			Productcatologue prodctlg=landingpage.getloginpage("nivenithiya@gmail.com", "Learn@2528");	
			OrderPage OrderPage=prodctlg.gotoOrderHistory();
		    Assert.assertTrue(OrderPage.verifyOrderHistory(productName));	
			
		}
		
		
	/*	@DataProvider
		public String[][] getdata()
		{
			
			 return new String[][] {
				{"nivenithiya@gmail.com", "Learn@2528","ZARA COAT 3"}
							
			};
			
		}*/
		
		@DataProvider
		public Object[][] getdata()
		{
			
			HashMap<String,String> map =new HashMap<String,String>();
			
			map.put("email","nivenithiya@gmail.com");
			map.put("password","Learn@2528");
			map.put("productName", "ZARA COAT 3");
		
			 return new Object[][] {{map}};
	

}
}
