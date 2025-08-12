package App;

import java.util.ArrayList;

public class User {
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private ArrayList<String> books; // This will later be changed to contain book objects
	
	public User(String userName, String password, String firstName, String lastName) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = new ArrayList<String>();
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String returnName() {
		return this.firstName + " " + this.lastName;
	}
	
	// TODO: Add a method that fetches a list of books
}
