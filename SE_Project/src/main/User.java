/**
 * 'Atif Mustaffa
 * 1429619
 * 7 Nov 2016
 * SE_Project
 */
package main;

public class User {
	
	private String matricNo, name, pass, userType, spec;
	
	public User() {
	}
	
	public User(String matricNo, String name, String pass, String userType, String spec) {
		this.matricNo = matricNo;
		this.name = name;
		this.pass = pass;
		this.userType = userType;
		
		if(spec.equals(""))
			this.spec = "none";
		else
			this.spec = spec;
	}
	
	public String getMatricNo() {
		return matricNo;
	}
	
	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

	public String getUserType() {
		return userType;
	}

	public String getSpec() {
		return spec;
	}
	
	@Override
	public String toString() {
		String out = "User [matricNo=" + matricNo + ", name=" + name + ", pass=" + pass + ", userType=" + userType;
		if(spec.equals("none") || spec.equals(""))
			out += "]";
		else
			out += ", specialization=" + spec + "]";
		return out;
	}	
	
}
