package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class selectObjects {
	
	WebDriver driver;
	//created a constructor 
	public selectObjects (WebDriver driver) 
	{
		this.driver=driver;
		//Initializing FindBy annotations
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="div.Showcase__style__item:nth-child(1)")
	WebElement item0;
	
	@FindBy(css="div.Showcase__style__item:nth-child(2)")
	WebElement item1;
	
	
		
	public WebElement itemZero()
	{
		return item0;
	}
	public WebElement itemOne()
	{
		return item1;
	}
	
	
}
