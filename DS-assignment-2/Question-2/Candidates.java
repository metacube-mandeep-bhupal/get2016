package Q2_Queue;

import java.util.Scanner;

public class CollegeCounselling {

	public static void main(String[] args) {
		Candidates candidate = new Candidates();
		Counselling counselling = new Counselling();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out
					.println("Do you want to add colleges\nPress \n1.yes\n2.no");
			int check = sc.nextInt();
			if (check != 1) {
				break;
			}
			System.out.println("Enter the name of college");
			String college = sc.next();
			counselling.addCollege(college);
		}

		while (true) {
			System.out
					.println("Do you want to add students to list\nPress \n1.yes\n2.no");
			int check = sc.nextInt();
			if (check != 1) {
				break;
			}
			System.out.println("Enter the name of student");
			String candi = sc.next();
			candidate.addCandidate(candi);
		}

		System.out.println("Assigning of college to students:");
		while (true) {
			String candi = candidate.getCandidate();
			if (candi == null) {
				break;
			}
			System.out.println("Press college ID for " + candi);
			counselling.displayAvalableCollege();
			int college = sc.nextInt();
			counselling.assignCollege(candi, college);
		}
		counselling.displayCollegeAssigned();
		sc.close();
	}
}
