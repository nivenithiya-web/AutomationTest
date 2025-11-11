package FrameworkLearning.Abstarctcomponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends Abstarctcomponents{
	WebDriver driver;
public OrderPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

//tbody/tr[1]/td[2]

//tr td:nth-child(3)

@FindBy(xpath=("//tbody/tr/td[2]"))
List <WebElement> OrderHistoryProducts;

public Boolean verifyOrderHistory(String ProductName)

{
	System.out.println("ordersnive"+ProductName);
	Boolean Match = false;
	for(WebElement OrderProduct:OrderHistoryProducts)
	{
		System.out.println("ordersnive111"+OrderProduct);
		String Orderitems= OrderProduct.getText();
	  Match=Orderitems.equalsIgnoreCase(ProductName);
	
		
	}
	return Match;
}



	


}
