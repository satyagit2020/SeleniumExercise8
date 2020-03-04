package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	public WebDriver  driver;
	public Properties pro; 
	public WebDriver initializeDriver() throws IOException
	{
	 pro = new Properties();
	FileInputStream datafile = new FileInputStream(	System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
	pro.load(datafile);
	String browserName=pro.getProperty("browser");
	
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		
		driver = new ChromeDriver();
		//execute in chrome driver
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(pro.getProperty("url"));
	return driver;
	}
	
	public WebDriver tearDown() 
	{
		driver.close();
		return driver;
	}
}

