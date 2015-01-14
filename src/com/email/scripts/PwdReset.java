package com.email.scripts;

import javax.swing.JFrame;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class PwdReset 
{
	public static void main(String[] args) 
	{
		SPURPGUI temp = new SPURPGUI();
		temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		temp.setSize(390, 490);
		temp.setVisible(true);
		
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { PasswordReset.class });
		testng.addListener(tla);
		testng.run();
	}
}