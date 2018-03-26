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

public class ViewFYPWindow extends JFrame {
	
	FYPCollection fyps = MenuWindow.fyps;
	UserCollection users = LoginWindow.users;
	int loggedUserIndex = LoginWindow.loggedUserIndex;
	
	JLabel lblHeader = new JLabel("<html><h2>View FYP Status</h2></html>");
	JLabel lblFilter = new JLabel("Filter by:");
	JButton btnBack = new JButton("Back to menu");
	JButton btnClrSearch = new JButton("Clear Search");
	JButton btnSearch = new JButton("Search");
	JTextField txtSearch = new JTextField(13);
	String[] sType = {"Search by", "Name", "Title", "Supervisor", "Approval"};
	JComboBox cmbSearch = new JComboBox(sType);
	
	JPanel mainPanel = new JPanel();
	JPanel searchPanel = new JPanel();
	JPanel btnPanel = new JPanel();
	
	JScrollPane scrollPane = new JScrollPane(mainPanel);
	
	public ViewFYPWindow() {
		
		setLayout(null);
		lblHeader.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		btnBack.setPreferredSize(new Dimension(120, 28));
		txtSearch.setPreferredSize(new Dimension(10, 24));
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), " List of Projects ", 2, 0));
		searchPanel.add(cmbSearch);
		searchPanel.add(txtSearch);
		searchPanel.add(btnSearch);
		searchPanel.add(btnClrSearch);
		btnPanel.add(btnBack);
		searchPanel.hide();
		lblHeader.setBounds(295, 16, 200, 70);
		searchPanel.setBounds(170, 86, 450, 40);
		scrollPane.setBounds(85, 135, 620, 340);
		btnPanel.setBounds(332, 495, 125, 40);
		add(lblHeader);
		add(searchPanel);
		add(scrollPane);
		add(btnPanel);
		
		btnBack.addActionListener(new actionL());
		btnSearch.addActionListener(new actionL());
		btnClrSearch.addActionListener(new actionL());
		txtSearch.addKeyListener(new keyL());

		findFYP();
	}
	
	public static void main(String[] str) {
		ViewFYPWindow f = new ViewFYPWindow();
		f.setTitle("View FYP :: KICT FYP Registration System");
		f.setSize(800, 600);
		f.setLocationRelativeTo(null);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    f.setResizable(false);
	}
	
	class keyL implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
				if(cmbSearch.getSelectedIndex() != 0)
					searchFYP(cmbSearch.getSelectedIndex(), txtSearch.getText());
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
			if(e.getSource() == btnBack) {
				dispose();
				try {
					MenuWindow.main(null);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
			else if(e.getSource() == btnSearch) {
				if(cmbSearch.getSelectedIndex() != 0)
					searchFYP(cmbSearch.getSelectedIndex(), txtSearch.getText());
			}
			else if(e.getSource() == btnClrSearch) {
				cmbSearch.setSelectedIndex(0);
				txtSearch.setText("");
				mainPanel.removeAll();
				findFYP();
			}
			else {
				JButton btn = (JButton) e.getSource();
				int index = 0;
				if(btn.getName().contains("details")) {
					index = Integer.parseInt(btn.getName().replace("details", ""));
					try {
						ViewDetailsWindow.main(null, index, false);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
				else {
					if(btn.getName().contains("approve")) {
						index = Integer.parseInt(btn.getName().replace("approve", ""));
						if(JOptionPane.showConfirmDialog(null, "Approve FYP?", "Confirmation",
								JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION)
							fyps.getFYP(index).setApproval("Approved");
					}
					else if(btn.getName().contains("decline")) {
						index = Integer.parseInt(btn.getName().replace("decline", ""));
						if(JOptionPane.showConfirmDialog(null, "Decline FYP?", "Confirmation",
								JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION)
							fyps.getFYP(index).setApproval("Declined");
					}
					else if(btn.getName().contains("delete")) {
						index = Integer.parseInt(btn.getName().replace("delete", ""));
						if(JOptionPane.showConfirmDialog(null, "Delete FYP?\nThis cannot be undone!", "Confirmation",
								JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION)
							fyps.deleteFYP(index);
					}
					
					try {
						WriteFYPToFile.main(null, fyps);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					findFYP();
				}
			}
				
		}
		
	}
	
	private void findFYP() {
		
		mainPanel.removeAll();
		int size = 0;
		for(int i = 1; i < fyps.getLength(); i++) {
			boolean found = false;
			if(users.getUser(loggedUserIndex).getUserType().equals("student") &&
					users.getUser(loggedUserIndex).getMatricNo().equals(fyps.getFYP(i).getMatricNo()))
				found = true;
			else if((users.getUser(loggedUserIndex).getUserType().equals("staff") && users.getUser(loggedUserIndex).getSpec().equals("none"))
					&& fyps.getFYP(i).getApproval().equals("Approved"))
				found = true;
			else if((users.getUser(loggedUserIndex).getUserType().equals("staff") && !users.getUser(loggedUserIndex).getSpec().equals("none"))
					&& (users.getUser(loggedUserIndex).getMatricNo().equals(fyps.getFYP(i).getLectID())))
				found = true;
			else if(users.getUser(loggedUserIndex).getUserType().equals("admin"))
				found = true;
			
			if(found)
				size += printFYP(i);
						
		}
		
		mainPanel.setPreferredSize(new Dimension(1, 140));
		if(size == 0)
			mainPanel.add(new JLabel("<html><center>No Project.</center></html>"));
		else if(size > 190 ) {
			searchPanel.show();
			mainPanel.setPreferredSize(new Dimension(1, size));
		}
		mainPanel.revalidate();
		mainPanel.repaint();
		scrollPane.revalidate();
		scrollPane.repaint();
		
	}
	
private void searchFYP(int filter, String keyword) {
		
		mainPanel.removeAll();
		int size = 0;
		for(int i = 1; i < fyps.getLength(); i++) {
			boolean found = false;
			if(users.getUser(loggedUserIndex).getUserType().equals("student") &&
					users.getUser(loggedUserIndex).getMatricNo().equals(fyps.getFYP(i).getMatricNo()))
				found = checkSearch(filter, keyword, i);
			else if((users.getUser(loggedUserIndex).getUserType().equals("staff") && !users.getUser(loggedUserIndex).getSpec().equals("none"))
					&& (users.getUser(loggedUserIndex).getMatricNo().equals(fyps.getFYP(i).getLectID())))
				found = checkSearch(filter, keyword, i);
			else if((users.getUser(loggedUserIndex).getUserType().equals("staff") && users.getUser(loggedUserIndex).getSpec().equals("none"))
					&& fyps.getFYP(i).getApproval().equals("Approved"))
				found = checkSearch(filter, keyword, i);
			else if(users.getUser(loggedUserIndex).getUserType().equals("admin"))
				found = checkSearch(filter, keyword, i);
			
			if(found)
				size += printFYP(i);
						
		}
		
		mainPanel.setPreferredSize(new Dimension(1, 140));
		if(size == 0)
			mainPanel.add(new JLabel("<html><center>Project not found.</center></html>"));
		else if(size > 140) {
			searchPanel.show();
			mainPanel.setPreferredSize(new Dimension(1, size));
		}
		mainPanel.revalidate();
		mainPanel.repaint();
		scrollPane.revalidate();
		scrollPane.repaint();
	}
	
	private int printFYP(int i) {

		String text = "";
		
		JLabel label = new JLabel();
		JPanel panel = new JPanel();
		JPanel panelButton = new JPanel();
		text = "<html><table style='font-size: 13'>" +
				"<tr><td>Name:</td><td>" + users.getUser(users.getIndex(fyps.getFYP(i).getMatricNo())).getName() + "</td></tr>" +
				"<tr><td>Matric No:</td><td>" + fyps.getFYP(i).getMatricNo() + "</td></tr>" +
				"<tr><td>Project Title:</td><td>"+ fyps.getFYP(i).getTitle() + "</td></tr>" +
				"<tr><td>Supervisor:</td><td>"+ users.getUser(users.getIndex(fyps.getFYP(i).getLectID())).getName() + "</td></tr>" +
				"<tr><td>Approval:</td><td>"+ fyps.getFYP(i).getApproval() + "</td></tr></table></html>";
		label.setText(text);

		int length = 0;
		if(fyps.getFYP(i).getTitle().length() > 50)
			length = (int) label.getPreferredSize().getHeight() + 25;
		else
			length = (int) label.getPreferredSize().getHeight();
		
		if(users.getUser(loggedUserIndex).getUserType().equals("staff") && !users.getUser(loggedUserIndex).getSpec().equals("none") &&
				fyps.getFYP(i).getApproval().equals("Under Approval")) {
			JButton buttonApprove = new JButton("Approve");
			JButton buttonDecline = new JButton("Decline");
			buttonApprove.setName("approve" + i);
			buttonDecline.setName("decline" + i);
			buttonApprove.addActionListener(new actionL());
			buttonDecline.addActionListener(new actionL());
			panelButton.add(buttonApprove);
			panelButton.add(buttonDecline);
		}
		else if(users.getUser(loggedUserIndex).getUserType().equals("admin") && fyps.getFYP(i).getApproval().equals("Declined")) {
			JButton buttonDelete = new JButton("Delete");
			buttonDelete.setName("delete" + i);
			buttonDelete.addActionListener(new actionL());
			panelButton.add(buttonDelete);
		}

		JButton buttonView = new JButton("View Details");
		buttonView.setName("details" + i);
		buttonView.addActionListener(new actionL());
		panelButton.add(buttonView);
		label.setPreferredSize(new Dimension(420, length));
		panelButton.setPreferredSize(new Dimension(418, 35));
		panel.setPreferredSize(new Dimension(420, length + 50));
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.add(label);
		panel.add(panelButton);
		mainPanel.add(panel);
		
		return (int) panel.getPreferredSize().getHeight() + 5;
	}
	
	private boolean checkSearch(int filter, String keyword, int i) {
		if(filter == 1 && users.getUser(users.getIndex(fyps.getFYP(i).getMatricNo())).getName().toLowerCase().contains(keyword))
			return true;
		else if(filter == 2 && fyps.getFYP(i).getTitle().toLowerCase().contains(keyword))
			return true;
		else if(filter == 3 && users.getUser(users.getIndex(fyps.getFYP(i).getLectID())).getName().toLowerCase().contains(keyword))
			return true;
		else if(filter == 4 && fyps.getFYP(i).getApproval().toLowerCase().contains(keyword))
			return true;
		else
			return false;
	}
	
}
