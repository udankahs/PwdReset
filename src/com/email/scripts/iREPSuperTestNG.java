package com.email.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class iREPSuperTestNG 
{
	public WebDriver driver;
	
	
	@BeforeMethod
	public void preCondition()
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.MINUTES);
		driver.manage().window().maximize();
	}
//	@AfterMethod
//	public void postCondition()
//	{
//	   driver.quit();	
//	}
}
