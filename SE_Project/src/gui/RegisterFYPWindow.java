/**
 * 'Atif Mustaffa
 * 1429619
 * 9 Nov 2016
 * SE_Project
 */
package gui;

import javax.swing.*;
import org.jdatepicker.impl.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

import main.*;
public class RegisterFYPWindow extends JFrame {
	
	FYPCollection fyps = MenuWindow.fyps;
	UserCollection users = LoginWindow.users;;
	int loggedUserIndex = LoginWindow.loggedUserIndex;
	String lectSelectedName = "";
	
	JLabel lblHeader = new JLabel("<html><h2>Register New FYP</h2></html>");
	JLabel lblInstruct = new JLabel("*Please fill in all required details");
	JLabel lblTitle1 = new JLabel("<html><h3>Student Particulars</h3>"
			+ "_____________________________________________________________________________________<br><br></html>");
	JLabel lblTitle2 = new JLabel("<html><br><br><h3>Supervisor and Project Information</h3>"
			+ "_____________________________________________________________________________________<br><br></html>");
	
	JButton btnRegister = new JButton("Register");
	JButton btnClear = new JButton("Clear");
	JButton btnCancel = new JButton("Cancel");
	
	JPanel mainPanel = new JPanel();
	JPanel fieldPanellbl = new JPanel();
	JPanel fieldPaneltxt = new JPanel();
	JPanel radPanel = new JPanel();
	JPanel btnPanel = new JPanel();
	
	JLabel lblName = new JLabel("Name: *");
	JLabel lblICPass = new JLabel("IC/Passport Number: *");
	JLabel lblMahallah = new JLabel("Mahallah: *");
	JLabel lblAddress = new JLabel("Home Address: *");
	JLabel lblGender = new JLabel("Gender: *");
	JLabel lblContNo = new JLabel("Contact Number: *");
	JLabel lblEmail = new JLabel("Email: *");
	JLabel lblGPA = new JLabel("GPA: *");
	JLabel lblCGPA = new JLabel("CGPA: *");
	JLabel lblSDate = new JLabel("Start Date: *");
	JLabel lblEDate = new JLabel("End Date: *");
	JLabel lblProject = new JLabel("Project Title: *");
	JLabel lblArea = new JLabel("Area of Specialization: *");
	JLabel lblLecturer = new JLabel("Select Lecturer: *");
	
	JTextField txtName = new JTextField(32);
	JTextField txtICPass = new JTextField(15);
	JTextField txtMahallah = new JTextField(15);
	JTextArea txtAddress = new JTextArea(4, 32);
	JRadioButton radMale = new JRadioButton("Male");
	JRadioButton radFemale = new JRadioButton("Female");
	JTextField txtContNo = new JTextField(10);
	JTextField txtEmail = new JTextField(20);
	JTextField txtGPA = new JTextField(5);
	JTextField txtCGPA = new JTextField(5);
	
	UtilDateModel model1 = new UtilDateModel();
	UtilDateModel model2 = new UtilDateModel();
	Properties p = new Properties();
	JDatePickerImpl sDatePicker = new JDatePickerImpl(new JDatePanelImpl(model1, p), new DateLabelFormatter());
	JDatePickerImpl eDatePicker = new JDatePickerImpl(new JDatePanelImpl(model2, p), new DateLabelFormatter());
	
	
	JTextField txtProject = new JTextField(32);
	String[] spec = { "", "Computer Science", "Information Science", "Information Systems"};
	JComboBox cmbSpec = new JComboBox(spec);
	
	JCheckBox cbAgree = new JCheckBox(" I hereby agree that information entered above are correct");

	JScrollPane scrollPane = new JScrollPane(mainPanel);
	
	public RegisterFYPWindow() {
	    	
		setLayout(null);
		
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		
		txtName.setText(users.getUser(loggedUserIndex).getName());
		txtName.setEditable(false);
		sDatePicker.setPreferredSize(new Dimension(120, 28));
		eDatePicker.setPreferredSize(new Dimension(120, 28));
		txtName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		txtAddress.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		lblHeader.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		lblTitle1.setPreferredSize(new Dimension(600, 70));
		btnRegister.setPreferredSize(new Dimension(90, 28));
		btnCancel.setPreferredSize(new Dimension(90, 28));
		btnClear.setPreferredSize(new Dimension(90, 28));
		btnPanel.add(btnRegister);
		btnPanel.add(btnClear);
		btnPanel.add(btnCancel);
		
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		radPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		radPanel.add(radMale); radPanel.add(radFemale);
		
		mainPanel.add(lblTitle1);
		mainPanel.add(lblName);
		mainPanel.add(txtName);
		mainPanel.add(lblICPass);
		mainPanel.add(txtICPass); mainPanel.add(new JLabel(" "));
		mainPanel.add(lblMahallah);
		mainPanel.add(txtMahallah); mainPanel.add(new JLabel(" "));
		mainPanel.add(lblAddress);
		mainPanel.add(txtAddress);
		mainPanel.add(lblGender);
		mainPanel.add(radPanel); mainPanel.add(new JLabel(" "));
		mainPanel.add(lblContNo);
		mainPanel.add(txtContNo); mainPanel.add(new JLabel(" "));
		mainPanel.add(lblEmail);
		mainPanel.add(txtEmail); mainPanel.add(new JLabel(" "));
		mainPanel.add(lblGPA);
		mainPanel.add(txtGPA); mainPanel.add(new JLabel(" ")); mainPanel.add(new JLabel(" "));
		mainPanel.add(lblCGPA);
		mainPanel.add(txtCGPA); mainPanel.add(new JLabel(" ")); mainPanel.add(new JLabel(" "));
		mainPanel.add(lblSDate);
		
		mainPanel.add(sDatePicker); mainPanel.add(new JLabel(" "));
		mainPanel.add(lblEDate);
		
		mainPanel.add(eDatePicker); mainPanel.add(new JLabel(" "));
		
		mainPanel.add(lblTitle2);
		mainPanel.add(lblProject);
		mainPanel.add(txtProject);
		mainPanel.add(lblArea);
		mainPanel.add(cmbSpec); mainPanel.add(new JLabel(" "));
		mainPanel.add(lblLecturer);
		
		for(int i = 1; i < mainPanel.getComponentCount(); i++) // 41components
			if(!(i == 0 || i == 34 || i == 32 || i == 29)) // exclude the titles and dates
				((JComponent) mainPanel.getComponent(i)).setPreferredSize(new Dimension(180, 25));
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(18);
		lblHeader.setBounds(295, 16, 200, 70);
		lblInstruct.setBounds(75, 95, 200, 20);
		scrollPane.setBounds(75, 120, 640, 330);
		cbAgree.setBounds(220, 460, 360, 20);
		btnPanel.setBounds(235, 500, 330, 50);
		displayListLecturer(0);
		add(lblHeader);
		add(lblInstruct);
		add(scrollPane);
		add(cbAgree);
		add(btnPanel);

		btnRegister.addActionListener(new actionL());
		btnCancel.addActionListener(new actionL());
		btnClear.addActionListener(new actionL());
		radMale.addActionListener(new actionL());
		radMale.addActionListener(new actionL());
		radFemale.addActionListener(new actionL());
		cmbSpec.addActionListener(new actionL());
		
	}

	public static void main(String[] str) {
		
		RegisterFYPWindow f = new RegisterFYPWindow();
		f.setTitle("Register New FYP :: KICT FYP Registration System");
		f.setSize(800, 600);
		f.setLocationRelativeTo(null);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    f.setResizable(false);
	}
	
	class actionL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cmbSpec) {
				if(cmbSpec.getSelectedIndex() == 0)
					displayListLecturer(0);
				else
					displayListLecturer(users.getLength());
			}
			
			else if(e.getSource() == btnRegister) {
				if(checkField())
					registerFYP();
			}
			
			else if(e.getSource() == btnCancel) {
				dispose();
				try {
					MenuWindow.main(null);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
			
			else if(e.getSource() == btnClear) {
				txtAddress.setText("");
				radMale.setSelected(false);
				radFemale.setSelected(false);
				cbAgree.setSelected(false);
				cmbSpec.setSelectedIndex(0);
				for (Component comp : mainPanel.getComponents()) {
					if(comp.getClass().toString().contains("JTextField") && comp != txtName) {
						JTextField temp = (JTextField) comp;
						temp.setText("");
					}
				}
			}
			
			else if(e.getSource() == radMale || e.getSource() == radFemale) {
				JRadioButton temp = (JRadioButton) e.getSource();
				radMale.setSelected(false);
				radFemale.setSelected(false);
				temp.setSelected(true);
			}
			
			else {
				JRadioButton temp = (JRadioButton) e.getSource();
				Component[] comp = mainPanel.getComponents();
				int total = comp.length;
				for(int i = 41; i < total; i++) {
					if(comp[i].toString().contains("JRadioButton")) {
						JRadioButton test = (JRadioButton) comp[i];
						test.setSelected(false);			
					}
				}
				temp.setSelected(true);
				lectSelectedName = temp.getText();				
			}
		}
		
	}
	
	private void delPrev() {
		if(mainPanel.getComponentCount() > 41) {
			Component[] comp = mainPanel.getComponents();
			int total = comp.length;
			for(int i = 41; i < total; i++)
				if(comp[i] != null)
					mainPanel.remove(comp[i]);
		}
		
	}
	
	private void displayListLecturer(int num) {
		delPrev();
		if(num == 0) {
			JLabel noLect = new JLabel("Please select lecturer specialization");
			noLect.setPreferredSize(new Dimension(420, 25));
			mainPanel.add(noLect);
		}
		String spec = cmbSpec.getSelectedItem().toString();
		int height = 0;
		for(int i = 0; i < num; i++) {
			if(users.getUser(i).getSpec().equals(spec)) {
				JLabel indent = new JLabel(" ");
				indent.setPreferredSize(new Dimension(180, 25));
				JRadioButton radio = new JRadioButton(users.getUser(i).getName());
				radio.setPreferredSize(new Dimension(420, 25));
				radio.addActionListener(new actionL());
				mainPanel.add(radio);
				mainPanel.add(indent);
				height++;
			}
		}
		mainPanel.setPreferredSize(new Dimension(160, 690+20*height));
		mainPanel.revalidate();
		mainPanel.repaint();

	}
	
	public void registerFYP() {
		String gender = "";
		
		if(radMale.isSelected())
			gender = "Male";
		else
			gender = "Female";

		String address = "";
		if(txtAddress.getText().contains("\n"))
			address = txtAddress.getText().replace("\n", " ");
		else
			address = txtAddress.getText();
		address = address.replaceAll("\\s+"," "); //removes consecutive white spaces
		
		int lectSelectedIndex = -1;
		for(User x: users.getAllUsers()) {
			lectSelectedIndex++;
			if(x.getName().equals(lectSelectedName))
				break;
		}

		if(fyps != null) {
			try {
				fyps.addFYP(users.getUser(loggedUserIndex).getMatricNo(), txtICPass.getText(),
						txtMahallah.getText(), address,
						gender, txtContNo.getText(),
						txtEmail.getText(),
						new DecimalFormat("#0.00").format(Double.parseDouble(txtGPA.getText())),
						new DecimalFormat("#0.00").format(Double.parseDouble(txtCGPA.getText())),
						(Date) sDatePicker.getModel().getValue(), (Date) eDatePicker.getModel().getValue(),
						txtProject.getText(), cmbSpec.getSelectedItem().toString(),
						users.getUser(lectSelectedIndex).getMatricNo(), "");
				
				WriteFYPToFile.main(null, fyps);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("FYP Submitted. \n: " + fyps.getFYP(fyps.getLength()-1));
			JOptionPane.showMessageDialog(null, "FYP Submitted", "Registration Successful", JOptionPane.NO_OPTION);
		}
		dispose();
		try {
			ViewDetailsWindow.main(null, fyps.getLength()-1, true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private boolean checkField() {
		String text = "";
		String gender = "";
		boolean valid = true;
		
		if(radMale.isSelected())
			gender = "Male";
		else if(radFemale.isSelected())
			gender = "Female";
		else
			gender = "none";
		
		if(txtICPass.getText().trim().equals("") || txtMahallah.getText().trim().equals("") || txtAddress.getText().trim().equals("") ||
		gender.equals("none") || txtContNo.getText().trim().equals("") || txtEmail.getText().trim().equals("") || txtGPA.getText().trim().equals("")
		|| txtCGPA.getText().trim().equals("") || (Date) sDatePicker.getModel().getValue() == null || 
		(Date) eDatePicker.getModel().getValue() == null || txtProject.getText().trim().equals("") ||
		cmbSpec.getSelectedItem().toString().trim().equals("")) {
			text += "Please fill in all fields.";
			valid = false;
		}
		else {
			if(!(txtICPass.getText().trim().length() == 9 || txtICPass.getText().trim().length() == 12)) {
				text += "IC/Passport number is invalid (must be 9 or 12).\n";
				valid = false;
			}
			
			if(gender.equals("none")) {
				text += "Gender is not selected.\n";
				valid = false;
			}
			
			String cNum = txtContNo.getText().trim();
			for(int i = 0; i < cNum.length(); i++) {
				if(cNum.charAt(i) < '0' || cNum.charAt(i) > '9') {
					if(!text.contains("Contact Number is invalid. Only numbers allowed\n"))
						text += "Contact Number is invalid. Only numbers allowed\n";
					valid = false;
					break;
				}
				else
					if(txtContNo.getText().trim().length() < 9 ||  txtContNo.getText().trim().length() > 12) {
						if(!text.contains("Contact Number is invalid. Must be 10 - 12\n"))
							text += "Contact Number is invalid. Must be 10 - 12\n";
						valid = false;
					}
				
			}
			
			String e = txtEmail.getText().trim();
			int atpos = e.indexOf("@");
			int dotpos = e.lastIndexOf(".");
			if (atpos < 1 || dotpos < atpos+2 || dotpos+2 >= e.length()) {
				text += "E-mail address is invalid.\n";
				valid = false;
			}
			
			String str = txtCGPA.getText().trim() + txtGPA.getText().trim();
			for(int i = 0; i < str.length(); i++) {
				if((str.charAt(i) < '0' || str.charAt(i) > '9') && str.charAt(i) != '.') {
					if(!text.contains("GPA or CGPA is invalid.\n"))
						text += "GPA or CGPA is invalid.\n";
					valid = false;
					break;
				}
				else {
					double gpa = Double.parseDouble(txtGPA.getText ().trim());
					double cgpa = Double.parseDouble(txtCGPA.getText().trim());
					if((gpa > 4 || gpa < 0) || (cgpa > 4 || cgpa < 0)) {
						if(!text.contains("GPA or CGPA is invalid (must be 0 to 4).\n"))
							text += "GPA or CGPA is invalid (must be 0 to 4).\n";
						valid = false;
					}
				}
			}
			
			Date start = (Date) sDatePicker.getModel().getValue();
			Date end = (Date) eDatePicker.getModel().getValue();
			if(end.equals(start) || end.before(start)) {
				text += "The Date is not valid.\n";
				valid = false;
			}
			
			if(lectSelectedName  == "" || lectSelectedName == null) {
				text += "Lecturer is not selected.\n";
				valid = false;
			}
			
			if(!cbAgree.isSelected()) {
				text += "Please agree on correct information entered.\n";
				valid = false;
			}
							
		}
		
		if(!valid) {
			text += "Please re-enter\n";
			JOptionPane.showMessageDialog(null, text, "Invalid Input", JOptionPane.YES_OPTION);
			return false;
		}
		
		return true;
	}
	
}