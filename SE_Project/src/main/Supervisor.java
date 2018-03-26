/**
 * 'Atif Mustaffa
 * 1429619
 * 7 Nov 2016
 * SE_Project
 */
package main;

public class Supervisor extends User {

	public Supervisor() {
	}
	
	public Supervisor(String matricNo, String name, String pass, String specialization) {
		super(matricNo, name, pass, "staff", specialization);
	}
	
	@Override
	public String toString() {
		return "Supervisor [matricNo=" + getMatricNo() + ", name=" + getName() + ", pass=" + getPass() + ", userType=" + getUserType() + ", specialization=" + getSpec() + "]";
	}
	
	
	
}
