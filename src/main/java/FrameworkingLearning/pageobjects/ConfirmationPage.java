package FrameworkingLearning.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import FrameworkLearning.Abstarctcomponents.Abstarctcomponents;

public class ConfirmationPage extends Abstarctcomponents{
	
WebDriver driver;
	
	public ConfirmationPage (WebDriver driver)
	{
		super (driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
//String confiramtionmsg= driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).getText();
		
	
	//Assert.assertTrue(confiramtionmsg.equalsIgnoreCase("Thankyou for the order"));
@FindBy(css="button[routerlink='/dashboard/cart']")
WebElement confirmationmsg;

public String getconfimrationmsg() {
	String msg= confirmationmsg.getText();
	return msg;
}

}
