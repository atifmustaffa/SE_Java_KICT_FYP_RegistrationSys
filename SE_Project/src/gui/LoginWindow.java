/**
 * 'Atif Mustaffa
 * 1429619
 * 9 Nov 2016
 * SE_Project
 */
package gui;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import main.*;

public class LoginWindow extends JFrame {
	
	public static UserCollection users;
	public static int loggedUserIndex = -1; // not found or not logged in
	
	// components
	JLabel lblTitle = new JLabel("Welcome to KICT FYP Registration System");
	JLabel lblMatricNo = new JLabel("Matric No:");
	JLabel lblPass = new JLabel("Password:");
	JTextField txtMatricNo = new JTextField();
	JPasswordField txtPass = new JPasswordField();
	JButton btnLogin = new JButton("Login");
	JButton btnRegister = new JButton("Register New User");
	JLabel image = new JLabel(new ImageIcon("files/kictfyp.png"));
	
	JPanel titlePanel = new JPanel();
	JPanel mainPanel = new JPanel();
	JPanel btnPanel = new JPanel();
		
	public LoginWindow() {
		
		setLayout(null);
		mainPanel.setLayout(new GridLayout(4, 1));
		titlePanel.add(lblTitle);
		mainPanel.add(lblMatricNo);
		mainPanel.add(txtMatricNo);
		mainPanel.add(lblPass);
		mainPanel.add(txtPass);
		btnLogin.setEnabled(false);
		btnLogin.setPreferredSize(new Dimension(150, 28));
		btnRegister.setPreferredSize(new Dimension(150, 28));
		btnPanel.add(btnLogin);
		btnPanel.add(btnRegister);
		image.setBounds(30, 30, 370, 150);
		mainPanel.setBounds(145, 170, 150, 110);
		btnPanel.setBounds(145, 295, 150, 70);
		add(image);
		add(titlePanel);
		add(mainPanel);
		add(btnPanel);
		
		txtMatricNo.getDocument().addDocumentListener(new docL());
		txtPass.getDocument().addDocumentListener(new docL());
		
		txtMatricNo.addKeyListener(new keyL());
		txtPass.addKeyListener(new keyL());

		btnLogin.addActionListener(new actionL());
		btnRegister.addActionListener(new actionL());
		
	}
	
	public static void main(String[] str) throws FileNotFoundException {
		
		users = ReadUserFromFile.main(null);
		
		LoginWindow f = new LoginWindow();
		f.setTitle("Login :: KICT FYP Registration System");
		f.setSize(440, 460);
		f.setLocationRelativeTo(null);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    f.setResizable(false);
	    
	}
	
	class docL implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent e) {
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			checkField();				
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			insertUpdate(e);
		}
		
	}
	
	class keyL implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
				login();
			else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				if(e.getSource() == txtMatricNo)
					txtMatricNo.setText("");
				else if(e.getSource() == txtPass)
					txtPass.setText("");
			}
				
		}

		@Override
		public void keyReleased(KeyEvent e) {			
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
		
	}
	
	class actionL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnLogin)
				login();
			else
				register();
				
		}
		
	}

	public void login() {
		if(btnLogin.isEnabled()) {
			String matricNo = txtMatricNo.getText();
			String pass = txtPass.getText();
			int i = 0;
			for(User x : users.getAllUsers()) {
				if(x.getMatricNo().equals(matricNo) && x.getPass().equals(pass)) {
					loggedUserIndex = i;
				}
				i++;
			}
			if(loggedUserIndex == -1) {
				JOptionPane.showMessageDialog(null, "Username or Password is incorrect", "Invalid Login", JOptionPane.YES_OPTION);
				txtPass.setText("");
				txtPass.requestFocus();
			}
			else {
				dispose();
				try {
					MenuWindow.main(null);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void register() {
		dispose();
		RegisterUserWindow.main(null);
	}
	
	private void checkField() {
		String text = txtMatricNo.getText();
		if(text.equals(""))
			btnLogin.setEnabled(false);
		else {
			for(int i = 0; i < text.length(); i++) {
				if(text.charAt(i) < '0' || text.charAt(i) > '9') {
					btnLogin.setEnabled(false);
					break;
				}
				else if(txtPass.getText().equals(""))
					btnLogin.setEnabled(false);
				else
					btnLogin.setEnabled(true);
			}
		}
	}
	
}
