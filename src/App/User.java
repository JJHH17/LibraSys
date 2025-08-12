package App;

import java.util.ArrayList;

public class User {
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private ArrayList<Book> books; // This will later be changed to contain book objects
	
	public User(String userName, String password, String firstName, String lastName) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = new ArrayList<Book>();
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
	
	/** Allowing us to add a book to the user if the book is available */
	public void addBook(Book book) {
		if (book.getAvailability()) {
			this.books.add(book);
			book.rentBook();
			System.out.println("Book added");
		} else {
			System.out.println("This book is currently unavailable");
		}
	}
	
	/** Allows the user to return a given book */
	public void returnBook(Book book) {
		if (this.books.contains(book)) {
			this.books.remove(book);
			book.returnBook();
		} else {
			System.out.println("You have not rented this book");
		}
	}
}
