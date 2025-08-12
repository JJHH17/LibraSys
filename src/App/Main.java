package App;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	// Contains a list of users (pre database existance)
	private static ArrayList<User> users = new ArrayList<User>();
	// Contains a list of books
	private static ArrayList<Book> books = new ArrayList<Book>();
	
	public static void main(String[] args) {
		// Adding some template books for use
		Book harryPotter = new Book("Harry Potter", "JK Rowling", 10000, "Fantasy");
		Book LOTR = new Book("LOTR", "Tolkein", 1000, "Role Playing");
		books.add(harryPotter);
		books.add(LOTR);
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to LibraSys");
		boolean active = true;
		
		while (active) {
			System.out.println("1. Create Account 2. Login 3. Exit");
			int userInput = scanner.nextInt();
			
			switch (userInput) {
				case 1:
					String username = scanner.nextLine();
					String password = scanner.nextLine();
					String firstName = scanner.nextLine();
					String lastName = scanner.nextLine();
					User newUser = new User(username, password, firstName, lastName);
					users.add(newUser); // Adds to arraylist (TEMPORARY, pre PostgreSQL)
					System.out.println("Thank you for registering!");
					break;
					
				case 2:
					String usernameCheck = scanner.nextLine();
					String passwordCheck = scanner.nextLine();
					// Checking if the arraylist contains the username and password
					for (User user : users) {
						if (user.getUserName().equals(usernameCheck) && user.getPassword().equals(passwordCheck)) {
							// Adding a book
							
						}
					}
					System.out.println("Username doesn't exist");
					break;
					
				case 3:
					active = false;
					break;
			}
		}
	}
		
	/** Allowing us to add a book if user logs in */
	public void addBookCLI(Book book, User user) {
		if (books.contains(book)) {
			if (users.contains(user)) {
				user.addBook(book);
			}
		} else {
			System.out.println("This book is currently unavailable");
		}
	}
}
