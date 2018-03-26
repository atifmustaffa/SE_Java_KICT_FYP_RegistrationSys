/**
 * 'Atif Mustaffa
 * 1429619
 * 7 Nov 2016
 * SE_Project
 */
package main;

import java.util.Date;

public class FYPCollection {
	
	private FYP[] fyps;
	private int count;
	
	public FYPCollection() {
		fyps = new FYP[0];
		count = 0;
	}
	
	public void addFYP(String matricNo, String icPass, String mahallah, String address, String gender, String contactNo,
	String email, String gpa, String cgpa, Date startDate, Date endDate, String title, String spec, String lectID, String approval) {
		increaseSize();
		fyps[count] = new FYP(matricNo, icPass, mahallah, address, gender, contactNo, email, gpa, cgpa, startDate, endDate, title, spec, lectID, approval);
		count++;
	}
	
	public void addExistingFYP(FYP fypInput) {
		increaseSize();
		fyps[count] = fypInput;
		count++;
	}
	
	public void deleteFYP(int index) {
		for(int i = index; i < fyps.length - 1; i++)
			fyps[i] = fyps[i+1];
		decreaseSize();
		count--;
	}
	
	private void increaseSize() {
		FYP[] temp = new FYP[fyps.length + 1];
		for (int i = 0; i < fyps.length; i++)
			temp[i] = fyps[i];
		fyps = temp;
	}
	
	private void decreaseSize() {
		FYP[] temp = new FYP[fyps.length - 1];
		for (int i = 0; i < fyps.length - 1; i++)
			temp[i] = fyps[i];
		fyps = temp;
	}
	
	public int getLength() {
		return fyps.length;
	}
	
	public FYP getFYP(int index) {
		return fyps[index];
	}
	
	public int getIndexByMNO(String mNo) { // by matric no
		int foundIndex = -1;
		for(int i = 0; i < fyps.length; i++)
			if(fyps[i].getMatricNo().equals(mNo))
				foundIndex = i;
		return foundIndex;
	}
	
	public int getIndexByLID(String lID) { // by lecturer id
		int foundIndex = -1;
		for(int i = 0; i < fyps.length; i++)
			if(fyps[i].getLectID().equals(lID))
				foundIndex = i;
		return foundIndex;
	}
	
	public FYP[] getAllFYP() {
		return fyps;
	}
	
	public String toString() {
		String out = "---------------------------------------------------\n";
		for(int i = 0; i < fyps.length; i++) {
			out += fyps[i].toString() + "\n---------------------------------------------------\n";
		}
		return out;
	}

}
