/**
 * 'Atif Mustaffa
 * 1429619
 * 7 Nov 2016
 * SE_Project
 */
package main;

public class Coordinator extends User {

	public Coordinator() {
	}
	
	public Coordinator(String matricNo, String name, String pass) {
		super(matricNo, name, pass, "staff", "");
	}
	
	@Override
	public String toString() {
		return "Coordinator [matricNo=" + getMatricNo() + ", name=" + getName() + ", pass=" + getPass() + ", userType=" + getUserType() + "]";
	}
	
}
