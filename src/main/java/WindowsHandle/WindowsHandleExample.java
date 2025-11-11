package WindowsHandle;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandleExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.Driver", "C:\\Users\\nivethitha\\Desktop\\selenium\\driver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml;jsessionid=node0166dcpoiaremmr9ceae27dhyq7425846.node0");
		driver.findElement(By.name("j_idt88:new")).click();
		
		String oldwindow=driver.getWindowHandle();
		Thread.sleep(3000);
		Set<String> allwindow =driver.getWindowHandles();
		for(String newwindow:allwindow )
		{
			driver.switchTo().window(newwindow);
			driver.close();
		}
		
		driver.findElement(By.name("j_idt88:j_idt91")).click();
		int noofwindows=driver.getWindowHandles().size();
		System.out.println("No of windows: "+noofwindows);
		
		Set<String> allwindows =driver.getWindowHandles();
		
		for(String newwindows:allwindows)
		{
			if(!oldwindow.equals(newwindows))
			{
				driver.switchTo().window(newwindows);
				driver.close();
			}
		}
		
		
	}

}
