package com.email.scripts;

public class FieldVerification {

	public static boolean verify(String adminUname, String adminPaswd,
			String userEmail, String emailUsername, String emailPWD,
			String allUserPWD) {
		if (adminUname.equals(null) || adminPaswd.equals(null) || userEmail.equals(null)|| emailUsername.equals(null)|| emailPWD.equals(null)|| allUserPWD.equals(null) ) 
		{
			return false;
		}
		return true;
	}
}