package com.email.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class temp
{
	public static void main(String[] args) 
	{
			WebDriver driver;

			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.get("https://login.salesforce.com");
			driver.findElement(By.id("username")).sendKeys("udankahs@yahoo.corp");
			driver.findElement(By.id("password")).sendKeys("Udanka123");
			driver.findElement(By.id("Login")).click();
		}
}
