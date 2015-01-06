package com.email.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GotoUnreadMail  {
	
	private WebDriver driver;

	@FindBy(xpath = "//span[@id=('_ariaId_68')]")
	private WebElement unread;
	
	@FindBy(xpath = "//span[contains(text(), 'Subject Sandbox: Salesforce.com password confirmation')]/../../..")
	private WebElement FirstMail;
	
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

	public void gotoUnreadMail(String pwd) throws InterruptedException 
	{
		unread.click();
		String winHandleBefore = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 20); //here, wait time is 20 seconds
		wait.until(ExpectedConditions.visibilityOf(FirstMail));
		Actions action = new Actions(driver);
		action.moveToElement(FirstMail).doubleClick().build().perform();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    
		}
		String url = pswRestLink.getText();
	    System.out.println(url);
	    Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(winHandleBefore);
		driver.get(url);
		try
		{
			enterPWD.sendKeys(pwd);
			reEnterPWD.sendKeys(pwd);
			Save.click();
			
			String title = driver.getTitle();
			System.out.println(title);
			
			if(title.equals("salesforce.com - Developer Edition"))
			{
				System.out.println("Login succsfull. Password has been reset succesfully");
			}
			
			else if(title.equals("salesforce.com - Change Password"))
			{
				System.out.println("Login succsfull. Password has been reset succesfully");
			}
			
		}
		catch (NoSuchElementException e)
		{
			if(driver.getTitle().equals("salesforce.com - Customer Secure Login Page"))
			{
				System.out.println("The Link Expired");
			}
		}
	}
}
