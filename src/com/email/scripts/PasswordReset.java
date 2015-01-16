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

		String iREPUname = DetailFieldValues.adminUname;
		String iREPpassword = DetailFieldValues.adminPaswd;
		String iREPeMAil = DetailFieldValues.UserEmail;
		String eMailUname = DetailFieldValues.EmailUsername;
		String eMailpassword = DetailFieldValues.EmailPWD;
		String newPWD = DetailFieldValues.AllUserPWD;
		String xlPath = "D:/Selenium/test data/test data_Final.xls";
		String sheetName = "Password Reset";
		
//		System.out.println("Enter the path of the Test Data excel in (D:/Selenium/test data/test data_Final.xls) format");
//		Scanner scan= new Scanner(System.in);
//	    String xlPath= scan.nextLine();
//	    System.out.println("=====================");
//	    
//	    System.out.println("Enter the Sheet Name");
//		Scanner scan2= new Scanner(System.in);
//	    String sheetName= scan2.nextLine();
//	    System.out.println("=====================");
//	    
//	    System.out.println("Enter Admin Username");
//	    String iREPUname= new Scanner(System.in).nextLine();
//	    System.out.println("=====================");
//	    
//	    System.out.println("Enter Admin Password");
//	    String iREPpassword= new Scanner(System.in).nextLine();
//	    System.out.println("=====================");
//	    
//	    System.out.println("Enter Tester Email ID to which Mail needs to be sent");
//	    String iREPeMAil= new Scanner(System.in).nextLine();
//	    System.out.println("=====================");
//	    
//	    System.out.println("Enter the Abbvie Username");
//	    String eMailUname= new Scanner(System.in).nextLine();
//	    System.out.println("=====================");
//	    
//	    System.out.println("Enter the Abbvie Password");
//	    String eMailpassword= new Scanner(System.in).nextLine();
//	    System.out.println("=====================");
//	    
//	    System.out.println("Enter the Standard Password which needs set for all the Users");
//	    String newPWD= new Scanner(System.in).nextLine();
//	    System.out.println("=====================");
	    
		//String sheetName = "Password Reset";
		int rowCount = ExcelLib.getRowCount(xlPath, sheetName);

		for (int i = 1; i <= rowCount; i++) 
		{
			//String iREPUname = ExcelLib.getCellValue(xlPath, sheetName ,i, 0);
			//String iREPpassword = ExcelLib.getCellValue(xlPath, sheetName, i, 1);

			String PrfoUname = ExcelLib.getCellValue(xlPath, sheetName, i, 0);
			//String iREPeMAil = ExcelLib.getCellValue(xlPath, sheetName, i, 3);

			//String eMailUname = ExcelLib.getCellValue(xlPath, sheetName, i, 4);
			//String eMailpassword = ExcelLib.getCellValue(xlPath,sheetName, i, 5);

			//String newPWD = ExcelLib.getCellValue(xlPath, sheetName, i,6);

			loginPage.login(iREPUname, iREPpassword);
			String username = passwordReset.reset(PrfoUname, iREPeMAil);

			EmailLoginPage emailLogin = new EmailLoginPage(driver);
			emailLogin.login(eMailUname, eMailpassword);
			
			GotoUnreadMail unRead = new GotoUnreadMail(driver);
			String newUsername = unRead.gotoUnreadMail(newPWD, username);
			
			ExcelLib.writeExcel(xlPath, sheetName, i, 1, newUsername);
			System.out.println();
			System.out.println("=============================================");
		}
		driver.quit();
	}
}
