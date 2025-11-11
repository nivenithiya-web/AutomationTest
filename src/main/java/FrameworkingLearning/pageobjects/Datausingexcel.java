package FrameworkingLearning.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Datausingexcel {

//	String [][] data= { {"Admin","admin123"},{"admin1","admin23"},{"admin","admin"}   };
	
	DataFormatter formate =new DataFormatter();
	
	@Test(dataProvider="logindata")
	public void login(String user,String pwd) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.Driver", "C:\\Users\\nivethitha\\Desktop\\selenium\\driver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		WebElement unmae= driver.findElement(By.xpath("//input[@placeholder='Username']"));
		unmae.sendKeys(user);
		WebElement Pass= driver.findElement(By.xpath("//input[@placeholder='Password']"));
		Pass.sendKeys(pwd);
		WebElement loginbutton= driver.findElement(By.xpath("//button[@type='submit']"));
		loginbutton.click();
		//driver.close();	
	}
	
		
	/*@DataProvider(name="logindata")
	
	public String [][] getdata()
	{
		return data;
	}*/
	
	@DataProvider(name="logindata")
	public Object[][] getdatafromexcel() throws IOException
	{
		FileInputStream file= new FileInputStream("C:\\Users\\nivethitha\\Desktop\\selenium\\testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("logintestdata");
		
		int noofrows =sheet.getPhysicalNumberOfRows();
		 XSSFRow firstrow=sheet.getRow(0);
		 int noofcols=firstrow.getPhysicalNumberOfCells();
		 
		Object[][] values=new Object[noofrows-1][noofcols];
		 
		for(int i=0;i<noofrows-1;i++)
		{
			XSSFRow row=sheet.getRow(i+1);
	
			for (int j=0;j<noofcols;j++)
			{
				
				XSSFCell cellvalue =row.getCell(j);
				
				values[i][j]=formate.formatCellValue(cellvalue);
				//System.out.println("datas"+testdata );
				
			}
		}
		
		return values;
			
	}

}
