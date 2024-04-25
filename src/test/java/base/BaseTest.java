package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import util.ExtentManager;

public class BaseTest {
	public static WebDriver driver;
	public static FileInputStream fis1;
	public static Properties configProp;
	public static FileInputStream fis2;
	public static Properties locProp;
	
	public static ExtentReports reports;
	public static ExtentTest test;
	
	 
	@AfterTest
	public void closeRep()
	{
		if(reports!=null)
		{
			reports.flush();
		}
	}
	
	  @BeforeTest 
	  public void fileSetUp() throws IOException { 
		  fis1=new
	  FileInputStream("src\\test\\resources\\properties\\config.properties");
	  
	  configProp=new Properties();
	  
	  configProp.load(fis1);
	  
     fis2 = new  FileInputStream("src\\test\\resources\\properties\\locator.properties");
	  
	  locProp=new Properties();
	  
	  locProp.load(fis2);
	  
	 reports = ExtentManager.getReports();
	  
	  }
	 
		
		@BeforeMethod
		public void setup(ITestContext context)
		{
			
			//creating Test Reports
			//test = reports.createTest("Login_Test");
			test = reports.createTest(context.getCurrentXmlTest().getClasses().get(0).getName());
			
			//driver=new ChromeDriver();
			String browName = configProp.getProperty("browser");
			if(browName.equalsIgnoreCase("chrome"))
			{
				driver= new ChromeDriver();
				test.info("Chrome browser launched");
			}
			if(browName.equalsIgnoreCase("fireFox"))
			{
				driver= new FirefoxDriver();
				test.info("Firefox browser launched");
			}
			if(browName.equalsIgnoreCase("Edge"))
			{
				driver= new EdgeDriver();
				test.info("Edge browser launched");
			}
			
			driver.get(configProp.getProperty("url"));
			test.info("App is launched using url"+configProp.getProperty("url") );
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		}
		
		@AfterMethod
		public void teardown() 
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.quit();
		}

		
}
