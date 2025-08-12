package App;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to LibraSys");
		boolean active = true;
		
		while (active) {
			System.out.println("1. Create Account 2. Login 3. Exit");
			int userInput = scanner.nextInt();
			
			switch (userInput) {
				case 1:
					break;
					
				case 2:
					break;
					
				case 3:
					active = false;
					break;
			}
		}
	}
}
