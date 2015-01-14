package com.email.scripts;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SPURPGUI extends JFrame {
	private JTextField adminUser;
	private JTextField adminPwd;
	private JTextField emailID;
	private JTextField loginName;
	private JTextField newPasswprd;
	private JPasswordField passwordfield;

	public SPURPGUI() {
		super("SPURP Tool");
		setLayout(new FlowLayout());

		adminUser = new JTextField(20);
		add(adminUser);

		adminPwd = new JTextField(10);
		add(adminPwd);

		emailID = new JTextField(20);
		add(emailID);

		loginName = new JTextField(20);
		add(loginName);

		passwordfield = new JPasswordField(20);
		add(passwordfield);

		newPasswprd = new JTextField(20);
		add(newPasswprd);
		
		thehandler handler = new thehandler();

		adminUser.addActionListener(handler);
		adminPwd.addActionListener(handler);
		emailID.addActionListener(handler);
		loginName.addActionListener(handler);
		passwordfield.addActionListener(handler);
		newPasswprd.addActionListener(handler);
	}

	private class thehandler implements ActionListener 
	{ 
		public void actionPerformed(ActionEvent event) 
		{
			String string;
			
			if (event.getSource() == adminUser)
				string = String.format("%s", event.getActionCommand());

			else if (event.getSource() == adminPwd)
				string = String.format("%s", event.getActionCommand());

			else if (event.getSource() == emailID)
				string = String.format("%s", event.getActionCommand());

			else if (event.getSource() == loginName)
				string = String.format("%s", event.getActionCommand());

			else if (event.getSource() == passwordfield)
				string = String.format("%s", event.getActionCommand());

			else if (event.getSource() == newPasswprd)
				string = String.format("%s", event.getActionCommand());
			
			JOptionPane.showMessageDialog(null, string);
			System.out.println(string);
			
		}

	}
}