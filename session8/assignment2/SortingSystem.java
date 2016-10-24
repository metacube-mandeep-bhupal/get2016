package session8.assignment2;

import java.util.Scanner;

public class SortingSystem {

	/**
	 * Following main() function is a driver class for other classes.
	 * @param args(String[]) denotes the command line arguments.
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of elements : ");
		int numberOfElements = sc.nextInt();
		int array[] = new int[numberOfElements];
		for (int index = 0; index < numberOfElements; index++) {
			System.out.println("Enter Element " + (index + 1) + " : ");
			array[index] = sc.nextInt();
		}

		int choice;
		do {
			System.out.println("Enter 1 for Comparison Sorting : ");
			System.out.println("Enter 2 for Linear Sorting : ");
			System.out.println("Enter 3 for Exit : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				ComparisonSorting objectOfComparison = new ComparisonSorting(
						array);
				objectOfComparison.comparison();
				objectOfComparison.display();
				break;
			}

			case 2: {
				LinearSorting objectOfLinear = new LinearSorting(array);
				objectOfLinear.linearSort();
				System.out.println("Display sorted array :");
				objectOfLinear.display();
				break;
			}
			}
		} while (choice != 3);
		sc.close();
	}
}
