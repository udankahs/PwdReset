package com.email.scripts;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Main {
	public static void main(String[] args) {
		final JFrame frame = new JFrame("SPURP Tool");
		JLabel textLabel = new JLabel("Welcome to SPURP Tool", SwingConstants.CENTER);
		frame.getContentPane().add(textLabel, BorderLayout.CENTER);
		final JButton btnLogin = new JButton("Click to login");

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDialog loginDlg = new LoginDialog(frame);
				loginDlg.setVisible(true);
				// if logon successfully
				if (loginDlg.isSucceeded()) {
					btnLogin.setText("Hi " + loginDlg.getUsername() + "!");

					DetailFieldValues fieldValue = new DetailFieldValues(frame);
					fieldValue.setVisible(true);
					// if logon successfully
					if (fieldValue.isSucceeded()) {
						fieldValue.setTitle("Hi " + loginDlg.getUsername()
								+ "!");

						TestListenerAdapter tla = new TestListenerAdapter();
						TestNG testng = new TestNG();
						testng.setTestClasses(new Class[] { PasswordReset.class });
						testng.addListener(tla);
						testng.run();
					}
				}

			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null); 
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(btnLogin);
		frame.setVisible(true);
	}
}