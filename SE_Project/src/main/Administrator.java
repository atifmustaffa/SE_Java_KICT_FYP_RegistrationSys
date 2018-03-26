/**
 * 'Atif Mustaffa
 * 1429619
 * 7 Nov 2016
 * SE_Project
 */
package main;

public class Administrator extends User {

	public Administrator() {
	}
	
	public Administrator(String matricNo, String name, String pass) {
		super(matricNo, name, pass, "admin", "");
	}
	
	@Override
	public String toString() {
		return "Administrator [matricNo=" + getMatricNo() + ", name=" + getName() + ", pass=" + getPass() + ", userType=" + getUserType() + "]";
	}
	
}
