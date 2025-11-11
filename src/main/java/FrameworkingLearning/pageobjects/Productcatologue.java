package FrameworkingLearning.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import FrameworkLearning.Abstarctcomponents.Abstarctcomponents;

public class Productcatologue extends Abstarctcomponents {
	
	WebDriver driver;
	
	public Productcatologue(WebDriver driver)
	{
		super (driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//List <WebElement> products=	driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List <WebElement> products;
	By productBy= By.cssSelector(".mb-3");
	
	By toastcontainer= By.cssSelector("#toast-container");
	
	public List<WebElement> getproductList()
	{
		waitelementtoappear(productBy);
		return products;
	}
	
	public WebElement getproductName(String productName)
	{
		WebElement prod=getproductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
		
	}
	public void addTocart (String productName)
	{
		WebElement prod =getproductName(productName);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		waitelementtoappear(toastcontainer);
		
		
	}

	
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	
	
}