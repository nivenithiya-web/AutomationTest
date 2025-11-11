package FrameworkingLearning.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import FrameworkLearning.Abstarctcomponents.Abstarctcomponents;

public class cartpage extends Abstarctcomponents
{
	
	WebDriver driver;
	
	public cartpage(WebDriver driver)
	{
		super (driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	By CheckoutBy=By.xpath("//button[normalize-space()='Checkout']");
	
	//driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space(text())='Checkout']")));
//	driver.findElement(By.xpath("//button[normalize-space(text())='Checkout']")).click();
	//@FindBy(xpath="//button[normalize-space(text())='Checkout']")
	@FindBy(xpath="//button[normalize-space()='Checkout']")
	WebElement Checkout;	

	@FindBy(css=".cartSection h3")
	List <WebElement> cartproducts;
	
	By cartitemsBy= By.cssSelector(".cartSection");
	
	

public Boolean verifyproductlist(String ProductName)
{
	waitelementtoappear(cartitemsBy);
	Boolean matches = false;
//	Boolean match=cartproducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(ProductName));
	System.out.println("before for"+ cartproducts);
	for(WebElement product:cartproducts)
	{
		System.out.println("after for");
		String prod=product.getText();
		System.out.println("nive"+ prod);
		 matches=prod.equalsIgnoreCase(ProductName);
	}
	System.out.println("productcccccc"+ ProductName);
	return matches;

}

	public Submitpage checkout()
	{
		waitelementtoappear(CheckoutBy);
		Checkout.click();
		return new Submitpage(driver);
		 
	}
	
	
	

//	driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results ")));
//	driver.findElement(By.xpath("//button[contains(@class,ta-item)][2]")).click();
//	driver.findElement(By.cssSelector(".action__submit")).click();

}
