package App;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	// Contains a list of users (pre database existance)
	private static ArrayList<User> users = new ArrayList<User>();
	// Contains a list of books
	private static ArrayList<Book> books = new ArrayList<Book>();
	private static Scanner scanner = new Scanner(System.in);
	
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
					createUser();
					break;
					
				case 2:
					credentialCheck();
					break;
					
				case 3:
					active = false;
					System.out.println("Exiting");
					break;
			}
		}
	}
	
	/** Allowing user to create a profile */
	public static void createUser() {
		System.out.println("Enter a username");
		String username = scanner.nextLine();
		System.out.println("Enter a password");
		String password = scanner.nextLine();
		System.out.println("Enter your first name");
		String firstName = scanner.nextLine();
		System.out.println("Enter your last name");
		String lastName = scanner.nextLine();
		
		User newUser = new User(username, password, firstName, lastName);
		users.add(newUser); // Adds to arraylist (TEMPORARY UNTIL WE ADD POSTGRESQL)
		System.out.println("Thank you for registering!");
	}
	
	/** Used for authentication check */
	public static void credentialCheck() {
		System.out.println("Enter your username");
		String username = scanner.nextLine();
		System.out.println("Enter your password");
		String password = scanner.nextLine();
		
		// Checking if our arraylist contains the above credentials
		for (User user : users) {
			if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
				String bookNameInput = addBookCLI();
				bookAvailabilityChecker(bookNameInput, user);
				return;
			} 
		}
		System.out.println("Credentials not found");
	}
	
	/** Allows us to input a given book */
	public static String addBookCLI() {
		System.out.println("Enter a book name");
		String bookName = scanner.nextLine();
		return bookName;
	}
	
		
	/** Allows us to check whether book is available/exists */
	public static void bookAvailabilityChecker(String bookName, User user) {
		// Checking if a given book name exists
		for (Book book : books) {
			if (book.getName().equalsIgnoreCase(bookName)) {
				user.addBook(book);
				return;
			}
		}
		System.out.println("Book is unavailable");
	}
}
