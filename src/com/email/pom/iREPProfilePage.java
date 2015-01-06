package com.email.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iREPProfilePage
{
	private WebDriver driver;
	
	@FindBy(id="setupLink")
	private WebElement Setup;
	
	@FindBy(id="Users_font")
	private WebElement ManageUsers;
	
	@FindBy(id="ManageUsers_font")
	private WebElement Users;
	
	@FindBy(id="EnhancedProfiles_font")
	private WebElement Profiles;
	
	@FindBy(xpath= "//td[@id='topButtonRow']/input[@value='View Users']")
	private WebElement ViewUsers;
	
	@FindBy(xpath="//*[@id='topButtonRow']/input[@type=('button') and @name='edit']")
	private WebElement Edit;
	
	@FindBy(id="Email")
	private WebElement Email;
	
	@FindBy(id="new_password")
	private WebElement PasswordResetCheckbox;
	
	@FindBy(id="userNavLabel")
	private WebElement Menu;
	
	@FindBy(xpath="//a[contains(text(), 'Logout')]")
	private WebElement Logout;
	
	@FindBy(xpath="//*[@id='topButtonRow']/input[@type=('submit') and @title=('Save')]")
	private WebElement Save;
	
	public iREPProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void reset(String un, String email, String ProfName) throws InterruptedException
	{
		
		Setup.click();
		ManageUsers.click();
		Profiles.click();
		driver.findElement(By.xpath("//a[contains(text(), '"+un+"')]")).click();
		
	
		
		Users.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(), '"+ProfName+"')]")).click();
		Edit.click();
		Email.clear();
		Email.sendKeys(email);
		PasswordResetCheckbox.click();
		Save.click();
		Menu.click();
		Logout.click();
		Thread.sleep(5000);
	}
}
