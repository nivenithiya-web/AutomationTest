package Frameworklearning.Test;

<<<<<<< HEAD
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
=======

>>>>>>> ea197c6 (Updated pom.xml and fixed dependency issues)

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.core.util.WatchManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< HEAD
import org.openqa.selenium.manager.windows.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
=======
//import org.openqa.selenium.manager.windows.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import junit.framework.Assert;
>>>>>>> ea197c6 (Updated pom.xml and fixed dependency issues)
public class Standalonetest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.Driver", "C:\\Users\\nivethitha\\Desktop\\selenium\\driver.exe");
		WebDriver driver= new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("userEmail")).sendKeys("nivenithiya@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Learn@2528");
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		List <WebElement> products=	driver.findElements(By.cssSelector(".mb-3"));
		System.out.println("printing nive "+products);
		
		WebElement prod=	products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
/*	for(WebElement product: products)
	{
		WebElement prod= product.findElement(By.cssSelector("b"));
		System.out.println("printing nive "+prod.getText());
		if(prod.getText().equalsIgnoreCase("ZARA COAT 3"))
		{
			System.out.println("printing nive inside if  "+prod.getText());
			Thread.sleep(3000);
			prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			break;
		}
		System.out.println(prod);
	}*/
	//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
	//	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space(text())='Checkout']")));
		driver.findElement(By.xpath("//button[normalize-space(text())='Checkout']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results ")));
		driver.findElement(By.xpath("//button[contains(@class,ta-item)][2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confiramtionmsg= driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).getText();
		
	
<<<<<<< HEAD
	Assert.assertTrue(confiramtionmsg.equalsIgnoreCase("Thankyou for the order"));
=======
	//Assert.assertTrue(confiramtionmsg.equalsIgnoreCase("Thankyou for the order"));
>>>>>>> ea197c6 (Updated pom.xml and fixed dependency issues)

		
		
		
		
		
		
		
		
		
		
		
		
	}

}
