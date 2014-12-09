package com.email.scripts;

import org.testng.annotations.Test;

import com.email.pom.EmailLoginPage;
import com.email.pom.GotoUnreadMail;
import com.email.pom.iREPLoginPage;
import com.email.pom.iREPPasswordResetPage;
import com.lib.ExcelLib;

public class PasswordReset extends iREPSuperTestNG
{
	@Test
	public void testPasswordReset() throws InterruptedException 
	{
		iREPLoginPage loginPage = new iREPLoginPage(driver);
		iREPPasswordResetPage passwordReset= new iREPPasswordResetPage (driver); 
		String xlPath = "D:/Selenium/test data/test data_Final.xls";

		//int rowCount = ExcelLib.getRowCount(xlPath, "Password Reset");

		String iREPUname = ExcelLib.getCellValue(xlPath, "Password Reset", 1, 0);
		String iREPpassword = ExcelLib.getCellValue(xlPath,"Password Reset", 1, 1);
		
		String PrfoUname = ExcelLib.getCellValue(xlPath,"Password Reset", 1, 2);
		String iREPeMAil = ExcelLib.getCellValue(xlPath,"Password Reset", 1, 3);
		
		String eMailUname = ExcelLib.getCellValue(xlPath, "Password Reset", 1, 4);
		String eMailpassword = ExcelLib.getCellValue(xlPath,"Password Reset", 1, 5);
		
		String newPWD = ExcelLib.getCellValue(xlPath,"Password Reset", 1, 6);
		
//		loginPage.login(iREPUname, iREPpassword);
//		passwordReset.reset(PrfoUname, iREPeMAil);
		
		EmailLoginPage emailLogin = new EmailLoginPage (driver);
		emailLogin.login(eMailUname, eMailpassword);
		
		GotoUnreadMail unRead = new GotoUnreadMail (driver);
		unRead.gotoUnreadMail(newPWD);
	}
}
