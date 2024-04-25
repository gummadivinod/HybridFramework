package testscript.regression;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import util.UtilKit;

public class XcelDataProvValLogDetails extends BaseTest{
	
	@Test(dataProvider= "getData")
	public void validLoginDetails( HashMap<String, String> data)
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(data.get("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get("password"));
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Assert.assertEquals(driver.getTitle(), data.get("expTitle"));	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][1];
		data[0][0]=UtilKit.getTestDataFromExcel("TC-100");
		
		return data;
		
	}

}
