/**
 * 'Atif Mustaffa
 * 1429619
 * 7 Nov 2016
 * SE_Project
 */
package main;

public class Student extends User {

	public Student() {
	}
	
	public Student(String matricNo, String name, String pass) {
		super(matricNo, name, pass, "student", "");
	}
	
	@Override
	public String toString() {
		return "Student [matricNo=" + getMatricNo() + ", name=" + getName() + ", pass=" + getPass() + ", userType=" + getUserType() + "]";
	}
	
}
