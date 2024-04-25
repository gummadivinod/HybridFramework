package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseTest;
import freemarker.template.SimpleDate;

public class BasePage extends BaseTest {
	
	public void verifyTitle(String expTitle)
	{
		Assert.assertEquals(driver.getTitle(),expTitle);
		test.info("Assertion is true");
	}
	public void verifyText(WebElement element,String WelText)
	{
		Assert.assertEquals(element.getText(),WelText);
		test.info("webText is true");
	}
	
	
	
	public void type(WebElement element, String text)
	{
		element.sendKeys(text);
		test.info("Entered the text"+text+"in textbox"+element );
	}
	public void click(WebElement element)
	{
		element.click();
		test.info("clicked the element"+element);
	}
	public void clear(WebElement element)
	{
		element.clear();
		test.info("cleared the element"+element);
	}
	public void selectFromDropDown(WebElement element,String option)
	{
		new Select(element).selectByVisibleText(option);
		test.info("selected the option"+option+" from dropdown"+element);
	}
	
	public static String getSS()
	{
		String screenSSFoldPath = System.getProperty("user.dir")+"//screenShots";
		File screenSSFold = new File(screenSSFoldPath);
		screenSSFold.mkdir();
		
		Date d =new Date();
		String pattern ="YYYY:MM:DD HH:MM:SS";
		SimpleDateFormat simpDateForm = new SimpleDateFormat(pattern);
		String date = simpDateForm.format(d);
		date=date.replace(":","-");
		System.out.println(date);
		
		String filePath = screenSSFoldPath+"//"+date+".png";
		File ssFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyDirectory(ssFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
		
	}
	

}
