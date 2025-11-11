package FrameworkLearning.Abstarctcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FrameworkingLearning.pageobjects.cartpage;

public class Abstarctcomponents {
	
	WebDriver driver;
	
	public Abstarctcomponents(WebDriver driver) 
	{
		this.driver=driver;
	}


	public void waitelementtoappear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
			
	}
	
	public void waitelementtoappearByWeb(WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Element));
			
	}
	
	public void waitelementtodisappear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
			
	}
	

	//driver.findElemnt(By.id("toast-container");
	By Waitforspinnerinvisible = By.id("toast-container");
	
	//driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cart;
			
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement OrderHistory;
	
	public cartpage gotocart() throws InterruptedException
	{
		waitelementtodisappear(Waitforspinnerinvisible);
		cart.click();
		cartpage cartpage =new cartpage(driver);
		return cartpage;
	}
	public OrderPage gotoOrderHistory() throws InterruptedException
	{
		Thread.sleep(3000);
		OrderHistory.click();
		OrderPage orderpage =new OrderPage(driver);
		return orderpage;
	}
	
	
	
	

}
