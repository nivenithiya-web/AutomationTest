package Frameworklearning.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import FrameworkingLearning.pageobjects.Landingpage;

public class BaseTest {
	
public	WebDriver driver;
	public Landingpage landingpage;
	
	
	public WebDriver initializeDriver() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\nivethitha\\eclipse-workspace\\ExcelIntergation\\src\\test\\java\\Frameworklearning\\Testcomponents\\Globalfile.properties ");
		Properties prop = new Properties();
		prop.load(file);
		String browserName= prop.getProperty("browser");
		System.out.println("NIve"+ browserName);
	//	if(browserName.equalsIgnoreCase("Chrome"))
				//{
			System.out.println("NIve1");
					System.setProperty("webdriver.chrome.Driver", "C:\\Users\\nivethitha\\Desktop\\selenium\\driver.exe");
					 driver= new ChromeDriver();
					
			//	}
	/*	else if(browserName.equalsIgnoreCase("firefox"))
		{
			
		}*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;

	}
		public WebDriver dvr;
	public String getScreenshot(String testcasename,WebDriver dvr) throws IOException
	{
		TakesScreenshot screen=  (TakesScreenshot)dvr;
		File source=screen.getScreenshotAs(OutputType.FILE);
		File Destination=new File("C:\\Users\\nivethitha\\eclipse-workspace\\FrameWorks\\reports\\"+testcasename+"\\.png");
		FileUtils.copyFile(source, Destination);
		String Filepath="C:\\Users\\nivethitha\\eclipse-workspace\\FrameWorks\\reports\\"+testcasename+"\\.png";
		return Filepath;
		
		
	}
	@BeforeMethod(alwaysRun=true)
	public Landingpage landingurl() throws IOException
	{
		driver=initializeDriver();
		landingpage= new Landingpage(driver);
		landingpage.gourl();
		return landingpage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		driver.close();
	}
	

}
