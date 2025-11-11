package FrameworkingLearning.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkLearning.Abstarctcomponents.Abstarctcomponents;

public class Landingpage extends Abstarctcomponents
{
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		super (driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
		
@FindBy(id="userEmail")
WebElement username;

@FindBy(id="userPassword")
WebElement password;

@FindBy(id="login")
WebElement Submit;

@FindBy(css="[class*=flyInOut]")
WebElement Errorvalidation;

public String getErrormessage()
{
	waitelementtoappearByWeb(Errorvalidation);
	String Errormsg=Errorvalidation.getText();
	return Errormsg;
}

public Productcatologue getloginpage(String email,String pass)
{
	username.sendKeys(email);
	password.sendKeys(pass);
	Submit.click();
	Productcatologue prodctlg =new Productcatologue(driver);
	return prodctlg;
	
}

public void gourl()
{
	driver.get("https://rahulshettyacademy.com/client/#/auth/login");
}



	/*driver.findElement(By.id("userEmail")).sendKeys("nivenithiya@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Learn@2528");
	driver.findElement(By.id("login")).click();*/
		
		
	

}
