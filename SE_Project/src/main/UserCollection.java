/**
 * 'Atif Mustaffa
 * 1429619
 * 14 Nov 2016
 * SE_Project
 *
 */
package main;

public class UserCollection {
	
	private User[] users;
	private int count;
	
	public UserCollection() {
		users = new User[0];
		count = 0;
	}
	
	public void addUser(String matricNo, String name, String pass, String userType, String spec) {
		increaseSize();
		users[count] = new User(matricNo, name, pass, userType, spec);
		count++;
	}
	
	private void increaseSize() {
		User[] temp = new User[users.length + 1];
		for (int i = 0; i < users.length; i++)
			temp[i] = users[i];
		users = temp;
	}
	
	public int getLength() {
		return users.length;
	}
	
	public User getUser(int index) {
		return users[index];
	}
	
	public User[] getAllUsers() {
		return users;
	}
	
	public int getIndex(String mNo) {
		int foundIndex = -1;
		for(int i = 0; i < users.length; i++)
			if(users[i].getMatricNo().equals(mNo))
				foundIndex = i;
		return foundIndex;
	}
	
	public void sortUser() {
		// by matric No
		int matricNo;
		int matricNoNxt;
		for(int i = 1; i < users.length - 1; i++) {
			for(int y = 1; y < users.length - 1; y++) {
				matricNo = Integer.parseInt(users[y].getMatricNo());
				matricNoNxt = Integer.parseInt(users[y+1].getMatricNo());
				if(matricNoNxt < matricNo) {
					User temp = users[y];
					users[y] = users[y+1];
					users[y+1] = temp;
				}
			}
		}
		
	}
	
	public String toString() {
		String out = "---------------------------------------------------\n";
		for(int i = 0; i < users.length; i++) {
			out += users[i].toString() + "\n---------------------------------------------------\n";
		}
		return out;
	}

}
