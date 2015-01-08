package com.email.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iREPPasswordResetProfile
{
	private WebDriver driver;
	
	@FindBy(id="userNavLabel")
	private WebElement userNavLabel;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[1]")
	private WebElement Setup;
	
	@FindBy(id="Users_font")
	private WebElement ManageUsers;
	
	@FindBy(id="EnhancedProfiles_font")
	private WebElement Profiles;
	
	@FindBy(xpath="//td[@id='topButtonRow']/input[@title='View Users']")
	private WebElement ViewUsers;
	
	@FindBy(xpath="//*[@id='ResetForm']/div[2]/table/tbody/tr[2]/td[6]/img")
	private WebElement ActiveCheckBox;
	
	@FindBy(xpath="//*[@id='ResetForm']/div[2]/table/tbody/tr[2]/td[1]/a[contains(text(),'Edit')]")
	private WebElement ActiveUserEdit;
	
	@FindBy(xpath=".//*[@id='ResetForm']/div[2]/table/tbody/tr[1]/th[7]/a")
	private WebElement ActiveHeader;
	
	@FindBy(id="Email")
	private WebElement Email;
	
	@FindBy(id="Username")
	private WebElement Username;
	
	@FindBy(id="new_password")
	private WebElement PasswordResetCheckbox;
	
	@FindBy(xpath="//a[contains(text(), 'Logout')]")
	private WebElement Logout;
	
	@FindBy(xpath="//*[@id='topButtonRow']/input[@type=('submit') and @title=('Save')]")
	private WebElement Save;
	
	public iREPPasswordResetProfile(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public String reset(String profName, String email) throws InterruptedException
	{
		userNavLabel.click();
		Setup.click();
		ManageUsers.click();
		Profiles.click();
		driver.findElement(By.xpath("//span[contains(text(), '"+profName+"')]")).click();
		ViewUsers.click();
		Thread.sleep(5000);
		
		if(ActiveCheckBox.getAttribute("title").equals("Checked"))
		{
			ActiveUserEdit.click();
		}
		
		else
		{
			ActiveHeader.click();
			ActiveUserEdit.click();
		}
		
		Email.clear();
		Email.sendKeys(email);
		String username = Username.getAttribute("value");
		System.out.println(username);
		PasswordResetCheckbox.click();
		Save.click();
		userNavLabel.click();
		Logout.click();
		Thread.sleep(5000);
		return username;
	}
}
