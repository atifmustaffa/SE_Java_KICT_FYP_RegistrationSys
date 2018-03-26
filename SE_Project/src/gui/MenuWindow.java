/**
 * 'Atif Mustaffa
 * 1429619
 * 9 Nov 2016
 * SE_Project
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import main.*;

public class MenuWindow extends JFrame {
	
	public static FYPCollection fyps;
	UserCollection users = LoginWindow.users;
	int loggedUserIndex = LoginWindow.loggedUserIndex;
	
	JLabel lblHeader = new JLabel("<html><h2>Main Menu</h2></html>");
	JLabel lblID = new JLabel("<html>Logged in as : <br>" + CapitalizeEachWord(users.getUser(loggedUserIndex).getUserType()) + "<br>"
	+ users.getUser(loggedUserIndex).getName() + ", "
	+ users.getUser(loggedUserIndex).getMatricNo() + "</html>");
	JButton btnRegister = new JButton("Register FYP");
	JButton btnView = new JButton("View FYP");
	JButton btnLogout = new JButton("Logout");
	
	JPanel mainPanel = new JPanel();
	JPanel btnPanel = new JPanel();
	
	public MenuWindow() {
		
		setLayout(null);
		mainPanel.setLayout(new GridLayout(2, 1));
		lblHeader.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		mainPanel.add(lblHeader);
		mainPanel.add(lblID);
		btnRegister.setPreferredSize(new Dimension(160, 45));
		btnView.setPreferredSize(new Dimension(160, 45));
		btnLogout.setPreferredSize(new Dimension(160, 45));
		btnRegister.hide();
		if(users.getUser(loggedUserIndex).getUserType().equals("student")) {
			btnRegister.show();
			btnRegister.setEnabled(false);
			 if(checkIfRegistered()) {
				 btnRegister.setEnabled(true);
				 if(checkIfRejected())
					 btnView.setEnabled(true);
				 else
					 btnView.setEnabled(false);
			 }
		}
		
		btnPanel.add(btnRegister);
		btnPanel.add(btnView);
		btnPanel.add(btnLogout);
		mainPanel.setBounds(35, 25, 360, 140);
		btnPanel.setBounds(135, 180, 160, 160);
		add(mainPanel);
		add(btnPanel);
		
		btnRegister.addActionListener(new actionL());
		btnView.addActionListener(new actionL());
		btnLogout.addActionListener(new actionL());
		
	}
	
	public static void main(String[] str) throws FileNotFoundException {
		
		fyps = ReadFYPFromFile.main(null);
		
		MenuWindow f = new MenuWindow();
		f.setTitle("Main Menu :: KICT FYP Registration System");
		f.setSize(440, 420);
		f.setLocationRelativeTo(null);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    f.setResizable(false);
	    
	}
	
	class actionL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			dispose();
			if(e.getSource() == btnRegister)
				RegisterFYPWindow.main(null);
			else if(e.getSource() == btnView)
				ViewFYPWindow.main(null);
			else if(e.getSource() == btnLogout) {
				JOptionPane.showMessageDialog(null, "Logout Successful", "Logout", JOptionPane.NO_OPTION);
				try {
					LoginWindow.main(null);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
			
		}
		
	}
	
	private String CapitalizeEachWord(String str) {
	    String[] arr = str.toLowerCase().split(" ");
	    StringBuffer sb = new StringBuffer();

	    for (int i = 0; i < arr.length; i++) {
	    	if(Character.isLetter(arr[i].charAt(0)))
	    		sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
	    	else
	    		sb.append(arr[i].charAt(0)).append(Character.toUpperCase(arr[i].charAt(1))).append(arr[i].substring(2)).append(" ");
	    }          
	    return sb.toString().trim();
	} 
	
	private boolean checkIfRegistered() {
		for(FYP f:fyps.getAllFYP()) {
			if (f.getMatricNo().equals(users.getUser(loggedUserIndex).getMatricNo()) &&
					(f.getApproval().equals("Under Approval") || f.getApproval().equals("Approved")))
				return false;
		}
		return true;
	}
	
	private boolean checkIfRejected() {
		for(FYP f:fyps.getAllFYP()) {
			if (f.getMatricNo().equals(users.getUser(loggedUserIndex).getMatricNo()) &&
					f.getApproval().equals("Declined"))
				return true;
		}
		return false;
	}
}
