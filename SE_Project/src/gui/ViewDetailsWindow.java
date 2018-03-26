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
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import main.*;

public class ViewDetailsWindow extends JFrame {
		
	FYPCollection fyps = MenuWindow.fyps;
	UserCollection users = LoginWindow.users;
	static int fypindex = -1;
	static boolean isNew = false;
		
	JLabel lblHeader = new JLabel("<html><h2>View FYP Details</h2></html>");
	JLabel lblShow = new JLabel();
	
	JButton btnClose = new JButton("Close");
	JButton btnPrint = new JButton("Print");
	
	JPanel mainPanel = new JPanel();
	JPanel btnPanel = new JPanel();
	
	JScrollPane scrollPane = new JScrollPane(mainPanel);
	
	public ViewDetailsWindow() {
		
		setLayout(null);
		lblHeader.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		btnClose.setPreferredSize(new Dimension(80, 28));
		btnPrint.setPreferredSize(new Dimension(80, 28));
		lblShow.setPreferredSize(new Dimension(490, 470));
		lblShow.setLayout(new FlowLayout(FlowLayout.LEFT));
		mainPanel.add(lblShow);
		btnPanel.add(btnClose);
		btnPanel.add(btnPrint);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		lblHeader.setBounds(245, 10, 200, 70);
		scrollPane.setBounds(90, 86, 520, 400);
		btnPanel.setBounds(260, 500, 170, 40);
		add(lblHeader);
		add(scrollPane);
		add(btnPanel);
		
		btnClose.addActionListener(new actionL());
		btnPrint.addActionListener(new actionL());
		
		printFYP();
	}
	
	public static void main(String[] str, int index, boolean newReg) throws FileNotFoundException {
		
		fypindex = index;
		isNew = newReg;
		
		ViewDetailsWindow f = new ViewDetailsWindow();
		f.setTitle("View FYP Details :: KICT FYP Registration System");
		f.setSize(700, 600);
		f.setLocationRelativeTo(null);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    f.setResizable(false);
	}
	
	class keyL implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
							
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
			if(e.getSource() == btnClose) {
				dispose();
				if(isNew)
					ViewFYPWindow.main(null);
			}
			else if(e.getSource() == btnPrint) {
				String x = "" + new SimpleDateFormat("d_MMM_yyyy_HHmmss", Locale.ENGLISH).format(new Date());
				// print codes
				PrinterJob pj = PrinterJob.getPrinterJob();
				pj.setJobName("FYP_Details_" + x);

				pj.setPrintable(new Printable() {
					public int print(Graphics pg, PageFormat pf, int pageNum) {
						if (pageNum > 0)
							return Printable.NO_SUCH_PAGE;

						Graphics2D g2 = (Graphics2D) pg;
						g2.translate(pf.getImageableX() + 70, pf.getImageableY() + 70);
						g2.scale(0.90, 0.90);
						lblShow.paint(g2);
						return Printable.PAGE_EXISTS;
					}
				});
				if (pj.printDialog() == false)
					return;

				try {
					pj.print();
				} catch (PrinterException ex) {
					// handle exception
				}
				// end print
			}
		}
		
	}
	
	private void printFYP() {
		String text = "";
		
		if(fypindex > -1) {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
			text = "<html><table style='font-size: 13'>" +
					"<tr><td>Name:</td><td>" + users.getUser(users.getIndex(fyps.getFYP(fypindex).getMatricNo())).getName() + "</td></tr>" +
					"<tr><td>Matric No:</td><td>" + fyps.getFYP(fypindex).getMatricNo() + "</td></tr>" +
					"<tr><td>IC/Passport:</td><td>" + fyps.getFYP(fypindex).getIcPass() + "</td></tr>" +
					"<tr><td>Mahallah:</td><td>"+ fyps.getFYP(fypindex).getMahallah() + "</td></tr>" +
					"<tr><td>Address:</td><td>"+ fyps.getFYP(fypindex).getAddress() + "</td></tr>" +
					"<tr><td>Gender:</td><td>"+ fyps.getFYP(fypindex).getGender() + "</td></tr>" +
					"<tr><td>Contact No.:</td><td>"+ fyps.getFYP(fypindex).getContactNo() + "</td></tr>" +
					"<tr><td>Email:</td><td>"+ fyps.getFYP(fypindex).getEmail() + "</td></tr>" +
					"<tr><td>GPA:</td><td>"+ fyps.getFYP(fypindex).getGpa() + "</td></tr>" +
					"<tr><td>CGPA:</td><td>"+ fyps.getFYP(fypindex).getCgpa() + "</td></tr>" +
					"<tr><td>Project Title:</td><td>"+ fyps.getFYP(fypindex).getTitle() + "</td></tr>" +
					"<tr><td>Specialization:</td><td>"+ fyps.getFYP(fypindex).getSpec() + "</td></tr>" +
					"<tr><td>Start Date:</td><td>"+ df.format(fyps.getFYP(fypindex).getStartDate()) + "</td></tr>" +
					"<tr><td>End Date:</td><td>"+ df.format(fyps.getFYP(fypindex).getEndDate()) + "</td></tr>" +
					"<tr><td>Supervisor:</td><td>"+ users.getUser(users.getIndex(fyps.getFYP(fypindex).getLectID())).getName() + "</td></tr>" +
					"<tr><td>Approval:</td><td>"+ fyps.getFYP(fypindex).getApproval() + "</td></tr>" +
					"</table></html>";
		}
		else 
			text = "<html><center>No Projects.</center></html>";
		

		lblShow.setText(text);
	}
	
}
