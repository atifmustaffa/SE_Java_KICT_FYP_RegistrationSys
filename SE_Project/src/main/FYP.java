/**
 * 'Atif Mustaffa
 * 1429619
 * 7 Nov 2016
 * SE_Project
 */
package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FYP {
	
	private String matricNo, icPass, mahallah, address, gender, contactNo, email, gpa, cgpa, title, spec, lectID;
	private Date startDate, endDate;
	private String approval;
	
	public FYP() {
	}
	
	public FYP(String matricNo, String icPass, String mahallah, String address, String gender, String contactNo,
			String email, String gpa, String cgpa, Date startDate, Date endDate, String title, String spec, String lectID, String approval) {
		this.matricNo = matricNo;
		this.icPass = icPass;
		this.mahallah = mahallah;
		this.address = address;
		this.gender = gender;
		this.contactNo = contactNo;
		this.email = email;
		this.gpa = gpa;
		this.cgpa = cgpa;
		this.title = title;
		this.spec = spec;
		this.lectID = lectID; 
		this.startDate = startDate;
		this.endDate = endDate;
		if(approval.equals(""))
			this.approval = "Under Approval";
		else
			this.approval = approval;
	}

	@Override
	public String toString() {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		return "FYP [matricNo=" + matricNo + ", icPass=" + icPass + ", mahallah=" + mahallah + ", address=" + address
				+ ", gender=" + gender + ", contactNo=" + contactNo + ", email=" + email + ", gpa=" + gpa + ", cgpa="
				+ cgpa + ", title=" + title + ", spec=" + spec + ", lectID=" + lectID + ", startDate="
				+ df.format(startDate) + ", endDate=" + df.format(endDate) + ", approval=" + approval + "]";
	}
	
	public String getMatricNo() {
		return matricNo;
	}
	
	public String getApproval() {
		return approval;
	}
	
	public void setApproval(String app) {
		this.approval = app;
	}
	
	public String getIcPass() {
		return icPass;
	}
	
	public String getMahallah() {
		return mahallah;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getGpa() {
		return gpa;
	}
	
	public String getCgpa() {
		return cgpa;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getSpec() {
		return spec;
	}
	
	public String getLectID() {
		return lectID;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
}
