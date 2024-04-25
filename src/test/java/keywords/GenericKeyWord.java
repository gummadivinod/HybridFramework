package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import base.BaseTest;

public class GenericKeyWord extends BaseTest {
	
	public void openBrow()
	{
		 String browName = configProp.getProperty("browser");
		 if(browName.equalsIgnoreCase("chrome"))
		 {
			 driver= new ChromeDriver();
		 }
		 else if(browName.equalsIgnoreCase("edge"))
		 {
			 driver= new EdgeDriver();
		 }
		 if(browName.equalsIgnoreCase("fireFox"))
		 {
			 driver= new FirefoxDriver();
		 }
		
	}
	
	public void launchApp()
	{
		driver.get(configProp.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("timeOut"))));
	}
	
	public void type(String locatorKey, String text)
	{ 
		getElement(locatorKey).sendKeys(text);
	}
	public void click(String locatorKey)
	{
		getElement(locatorKey).click();
	}
	
	public WebElement getElement(String locatorKey)
	{
		WebElement element = null;
		element=driver.findElement(getLocator(locatorKey));
		return element;
	}
	
	public By getLocator(String locatorKey)
	{
		By by =null;
		if(locatorKey.endsWith("_id"))
		{
			by=By.id(locProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_name"))
		{
			by=By.name(locProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_linkText"))
		{
			by=By.linkText(locProp.getProperty(locatorKey));
		}
		else
		{
			by=By.xpath(locProp.getProperty(locatorKey));
		}
		
		return by;
		
	}

}
