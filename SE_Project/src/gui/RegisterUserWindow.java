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

public class RegisterUserWindow extends JFrame {
	
	UserCollection users = LoginWindow.users;
	
	JLabel lblHeader = new JLabel("<html><h2>Register New User</h2></html>");
	JLabel lblInstruct = new JLabel("*Please fill in all fields");
	JLabel lblMatricNo = new JLabel("Matric No: ");
	JLabel lblName = new JLabel("Full Name: ");
	JLabel lblPass = new JLabel("Password: ");
	JLabel lblRePass = new JLabel("Re-Enter Password: ");
	JLabel lblUserType = new JLabel("Register as: ");
	JLabel lblSpec = new JLabel("Specialization: ");
	JTextField txtMatricNo = new JTextField(8);
	JTextField txtName = new JTextField(24);
	JPasswordField txtPass = new JPasswordField(10);
	JPasswordField txtRePass = new JPasswordField(10);
	String[] type = {"", "Student", "Supervisor", "Coordinator", "Administrator"};
	JComboBox cmbUserType = new JComboBox(type);
	String[] spec = { "", "Computer Science", "Information Science", "Information Systems"};
	JComboBox cmbSpec = new JComboBox(spec);
	JButton btnRegister = new JButton("Register");
	JButton btnCancel = new JButton("Cancel");
	
	JPanel mainPanel = new JPanel();
	JPanel fieldPanel = new JPanel();
	JPanel userTypePanel = new JPanel();
	JPanel specPanel = new JPanel();
	JPanel btnPanel = new JPanel();
	
	public RegisterUserWindow() {
		
		setLayout(null);
		lblHeader.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		fieldPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		fieldPanel.setPreferredSize(new Dimension(405, 135));
		userTypePanel.setPreferredSize(new Dimension(305, 35));
		lblUserType.setPreferredSize(new Dimension(120, 25));
		cmbUserType.setPreferredSize(new Dimension(155, 25));
		specPanel.setPreferredSize(new Dimension(305, 35));
		lblSpec.setPreferredSize(new Dimension(120, 25));
		cmbSpec.setPreferredSize(new Dimension(155, 25));
		specPanel.hide();
		userTypePanel.add(lblUserType);
		userTypePanel.add(cmbUserType);
		mainPanel.add(userTypePanel);
		fieldPanel.add(lblMatricNo);
		fieldPanel.add(txtMatricNo); fieldPanel.add(new JLabel(" "));
		fieldPanel.add(lblName);
		fieldPanel.add(txtName);
		fieldPanel.add(lblPass);
		fieldPanel.add(txtPass); fieldPanel.add(new JLabel(" "));
		fieldPanel.add(lblRePass);
		fieldPanel.add(txtRePass);
		specPanel.add(lblSpec);
		specPanel.add(cmbSpec);
		mainPanel.add(specPanel);
		
		for(int i = 0; i < fieldPanel.getComponentCount(); i++) {// 3components
			((JComponent) fieldPanel.getComponent(i)).setPreferredSize(new Dimension(125, 25));
		}
		
		mainPanel.add(fieldPanel);
		btnRegister.setPreferredSize(new Dimension(150, 28));
		btnCancel.setPreferredSize(new Dimension(150, 28));
		btnPanel.add(btnRegister);
		btnPanel.add(btnCancel);
		btnRegister.setEnabled(false);
		lblHeader.setBounds(145, 15, 200, 70);
		lblInstruct.setBounds(50, 95, 200, 20);
		mainPanel.setBounds(45, 115, 410, 230);
		btnPanel.setBounds(170, 340, 150, 70);
		add(lblHeader);
		add(lblInstruct);
		add(mainPanel);
		add(btnPanel);
		
		cmbUserType.addActionListener(new actionL());
		cmbSpec.addActionListener(new actionL());
		btnRegister.addActionListener(new actionL());
		btnCancel.addActionListener(new actionL());
		
		txtMatricNo.getDocument().addDocumentListener(new docL());
		txtName.getDocument().addDocumentListener(new docL());
		txtPass.getDocument().addDocumentListener(new docL());
		txtRePass.getDocument().addDocumentListener(new docL());
		
		txtMatricNo.addKeyListener(new keyL());
		txtName.addKeyListener(new keyL());
		txtPass.addKeyListener(new keyL());
		txtRePass.addKeyListener(new keyL());
		
	}
	
	public static void main(String[] str) {
		RegisterUserWindow f = new RegisterUserWindow();
		f.setTitle("Register New User :: KICT FYP Registration System");
		f.setSize(510, 480);
		f.setLocationRelativeTo(null);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    f.setResizable(false);
	}
	

	class keyL implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
				registerUser();
			else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				JTextField temp = (JTextField) e.getSource();
				temp.setText("");
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
			if(e.getSource() == btnRegister) {
				registerUser();
			}
			else if(e.getSource() == btnCancel) {
				dispose();
				try {
					LoginWindow.main(null);
				} catch (FileNotFoundException e1) {
				}
			}
			else {
				if(cmbUserType.getSelectedIndex() == 2)
					specPanel.show();
				else
					specPanel.hide();
				mainPanel.revalidate();
				mainPanel.repaint();
				
				if(e.getSource() == cmbUserType)
					cmbSpec.setSelectedIndex(0);
				
				checkField();
			}
		}
		
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
	
	private void checkField() {
		String text = txtMatricNo.getText();
		if(text.equals(""))
			btnRegister.setEnabled(false);
		else {
			for(int i = 0; i < text.length(); i++) {
				if(text.charAt(i) < '0' || text.charAt(i) > '9') {
					btnRegister.setEnabled(false);
					break;
				}
				else if(txtPass.getText().equals("") || txtRePass.getText().equals(""))
					btnRegister.setEnabled(false);
				else if(!txtPass.getText().equals(txtRePass.getText()))
					btnRegister.setEnabled(false);
				else if(cmbUserType.getSelectedIndex() == 0)
						btnRegister.setEnabled(false);
				else if(cmbUserType.getSelectedIndex() == 2 && cmbSpec.getSelectedIndex() == 0)
					btnRegister.setEnabled(false);
				else
					btnRegister.setEnabled(true);
			}
		}
	}
	
	public void registerUser() {
		if(btnRegister.isEnabled()) {
						
			String uType = "", spec = "none";
			
			switch(cmbUserType.getSelectedIndex()) {
			case 1: uType = "student"; break;
			case 2: uType = "staff"; spec = cmbSpec.getSelectedItem().toString(); break;
			case 3: uType = "staff"; break;
			case 4: uType = "admin"; break;
			default: ;
			}
			if(users != null) {
				users.addUser(txtMatricNo.getText(), CapitalizeEachWord(txtName.getText()), txtPass.getText(), uType, spec);
				try {
					WriteUserToFile.main(null, users);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println("User Registered.\nID: " + users.getUser(users.getIndex(txtMatricNo.getText())).getMatricNo());
				JOptionPane.showMessageDialog(null, "User Registered.\nID: " + users.getUser(users.getIndex(txtMatricNo.getText())).getMatricNo(),
						"Registration Successful", JOptionPane.NO_OPTION);
			}
			dispose();
			try {
				LoginWindow.main(null);
			} catch (FileNotFoundException e1) {
			}
			
		}
		
	}
	
	public String CapitalizeEachWord(String str) {
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
	
}