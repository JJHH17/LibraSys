package App;

public class Book {
	private String name;
	private String author;
	private long pages;
	private String genre;
	private boolean isAvailable;
	private int numberOfRents;
	
	public Book(String name, String author, long pages, String genre) {
		this.name = name;
		this.author = author;
		this.pages = pages;
		this.genre = genre;
		this.isAvailable = true;
		this.numberOfRents = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public long getPages() {
		return this.pages;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	/** Allows us to tweak availability of book based on given status */
	public void setAvailable() {
		if (this.isAvailable == true) {
			this.isAvailable = false;
		} else {
			this.isAvailable = true;
		}
	}
	
	public boolean getAvailability() {
		return this.isAvailable;
	}
	
	/** Allows us to rent a book */
	public void rentBook() {
		if (this.isAvailable == true) {
			this.isAvailable = false;
			this.numberOfRents++;
		} else {
			System.out.println("This book is currently unavailable");
		}
	}
	
	/** Allows us to return a rented book */
	public void returnBook() {
		if (this.isAvailable == false) {
			this.isAvailable = true;
		} else {
			System.out.println("This book is not currently hired");
		}
	}
	
	public int getNumOfRents() {
		return this.numberOfRents;
	}
	
	public String toString() {
		return "Book Name: " + this.getName() + " Author: " + this.getAuthor() + " Number of Pages: " + this.getPages() + " Genre: " + this.getGenre() +
				" Is Available? ";
	}
}
