package session6.assignment2;

import java.util.Scanner;

public class UniqueString {

	public static void main(String args[]) {
		Uniquecharacters unique = new Uniquecharacters();
		Scanner sc = new Scanner(System.in);
		int option = 0;
		{
			do {
				do {
						System.out.println("\nWhat do u want to perform:");
						System.out.println("1. Add String");
						System.out.println("2. Display No of unique character in string");
						System.out.println("3. Exit");
						option = sc.nextInt();
				} while (option < 1 && option > 3);

				if (option == 1) {
					System.out.println("Enter the String to in list");
					sc.nextLine();
					String value = sc.nextLine();
					unique.addString(value);
				} else if (option == 2) {
					unique.display();
				} else if (option == 3) {
					System.exit(0);
				}
			} while (option != 3);
		}
		sc.close();
	}
}
