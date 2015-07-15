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

		
//		String iREPUname = DetailFieldValues.adminUname;
//		String iREPpassword = DetailFieldValues.adminPaswd;
//		String iREPeMAil = DetailFieldValues.UserEmail;
//		String eMailUname = DetailFieldValues.EmailUsername;
//		String eMailpassword = DetailFieldValues.EmailPWD;
//		String newPWD = DetailFieldValues.AllUserPWD;

		String xlPath = "D:/SPURP/Test Data/Test Data_Demo.xls";
		String sheetName = "Password Reset";
		
		String iREPUname = ExcelLib.getCellValue(xlPath,"Basic",1,0);
		String iREPpassword = ExcelLib.getCellValue(xlPath,"Basic",1,1);
		String iREPeMAil = ExcelLib.getCellValue(xlPath,"Basic",1,2);
		String eMailUname = ExcelLib.getCellValue(xlPath,"Basic",1,3);
		String eMailpassword = ExcelLib.getCellValue(xlPath,"Basic",1,4);
		String newPWD = ExcelLib.getCellValue(xlPath,"Basic",1,5);
	
		System.out.println(iREPUname);
		System.out.println(iREPpassword);
		System.out.println(iREPeMAil);
		System.out.println(eMailUname);
		System.out.println(eMailpassword);
		System.out.println(newPWD);

		int rowCount = ExcelLib.getRowCount(xlPath, sheetName);

		for (int i = 1; i <= rowCount; i++) 
		{
			String PrfoUname = ExcelLib.getCellValue(xlPath, sheetName, i, 0);

			loginPage.login(iREPUname, iREPpassword);
			String username = passwordReset.reset(PrfoUname, iREPeMAil);

			EmailLoginPage emailLogin = new EmailLoginPage(driver);
			emailLogin.login(eMailUname, eMailpassword);

			GotoUnreadMail unRead = new GotoUnreadMail(driver);
			String newUsername = unRead.gotoUnreadMail(newPWD, username);

			ExcelLib.writeExcel(xlPath, sheetName, i, 1, newUsername);
			ExcelLib.writeExcel(xlPath, sheetName, i, 2, newPWD);
			System.out.println();
			System.out.println("=============================================");
		}
		
		//driver.quit();
	}
}
