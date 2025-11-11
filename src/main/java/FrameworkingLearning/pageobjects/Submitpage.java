package FrameworkingLearning.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkLearning.Abstarctcomponents.Abstarctcomponents;

public class Submitpage extends Abstarctcomponents{
	
WebDriver driver;
	
	public Submitpage (WebDriver driver)
	{
		super (driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	By CountryBy =By.cssSelector(".ta-results ");
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath="//button[contains(@class,ta-item)][2]")
	WebElement countrySelected;
	@FindBy(css=".action__submit")    
	WebElement Submit;
	
	
	public void selectcountry(String CountryName)
	{
		country.sendKeys(CountryName);
		waitelementtoappear(CountryBy);
		countrySelected.click();
	}
	
	public ConfirmationPage submit()
	{
		Submit.click();
		return new ConfirmationPage(driver);
	}
	
}
