package testscript.regression;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class ToVerifInvalidLoginDetails extends BaseTest{

	@Test
	public void inValidUnValidPw()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz0860");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz123");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Hotel Reservation System");
	}

	@Test
	public void ValidUnInValidPw()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz0860");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz112");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Hotel Reservation System");
	}
	@Test
	public void inValidUnInValidPw()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz0860");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz112");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Hotel Reservation System");
	}
}
