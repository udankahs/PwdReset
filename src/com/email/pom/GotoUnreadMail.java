package com.email.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GotoUnreadMail  {
	
	private WebDriver driver;

	@FindBy(xpath = "//span[@id=('_ariaId_68')]")
	private WebElement unread;

	@FindBy(xpath = "//a[1]")
	private WebElement pswRestLink;
	
	@FindBy(id = "p5")
	private WebElement enterPWD;
	
	@FindBy(id = "p6")
	private WebElement reEnterPWD;
	
	@FindBy(xpath="//input[@type=('submit') and @title=('Save')]")
	private WebElement Save;
	
	public GotoUnreadMail(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void gotoUnreadMail(String pwd) 
	{
		unread.click();
		String url = pswRestLink.getText();
		System.out.println(url);
		driver.get(url);
		enterPWD.sendKeys(pwd);
		reEnterPWD.sendKeys(pwd);
		Save.click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.equals("salesforce.com - Developer Edition"))
		{
			System.out.println("Login succsfull. Password has been reset succesfully");
		}
	}
}
