package com.email.scripts;

import org.testng.annotations.Test;

import com.email.pom.EmailLoginPage;
import com.email.pom.GotoUnreadMail;
import com.email.pom.iREPLoginPage;
import com.email.pom.iREPPasswordResetProfile;
import com.lib.ExcelLib;

public class PasswordReset extends iREPSuperTestNG 
{
	@Test
	public void testPasswordReset() throws Exception 
	{
		iREPLoginPage loginPage = new iREPLoginPage(driver);
		iREPPasswordResetProfile passwordReset = new iREPPasswordResetProfile(driver);

		String xlPath = "D:/Selenium/test data/test data_Final.xls";
		int rowCount = ExcelLib.getRowCount(xlPath, "Password Reset");

		for (int i = 1; i <= rowCount; i++) 
		{
			String iREPUname = ExcelLib.getCellValue(xlPath, "Password Reset",i, 0);
			String iREPpassword = ExcelLib.getCellValue(xlPath,	"Password Reset", i, 1);

			String PrfoUname = ExcelLib.getCellValue(xlPath, "Password Reset",i, 2);
			String iREPeMAil = ExcelLib.getCellValue(xlPath, "Password Reset",i, 3);

			String eMailUname = ExcelLib.getCellValue(xlPath, "Password Reset",i, 4);
			String eMailpassword = ExcelLib.getCellValue(xlPath,"Password Reset", i, 5);

			String newPWD = ExcelLib.getCellValue(xlPath, "Password Reset", i,6);

			loginPage.login(iREPUname, iREPpassword);
			String username = passwordReset.reset(PrfoUname, iREPeMAil);

			EmailLoginPage emailLogin = new EmailLoginPage(driver);
			emailLogin.login(eMailUname, eMailpassword);

			GotoUnreadMail unRead = new GotoUnreadMail(driver);
			unRead.gotoUnreadMail(newPWD);
			
			ExcelLib.writeExcel(xlPath, "Password Reset", i, 7, username);
		}
		driver.quit();
	}

}
