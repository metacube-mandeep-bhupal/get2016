package Q2_Queue;

public class Counselling {

	// name of colleges with limited seats
	String[][] collegeList;
	// row display number of colleges register for counseling
	int row;
	// available seats in college
	int availableSeats[];

	/**
	 * Constructor to initialize Counselling 2-D array denotes the list of 5 colleges and their respective 5 seats.
	 */
	public Counselling() {
		collegeList = new String[5][6];
		row = 0;
		availableSeats = new int[] { 0, 0, 0, 0, 0 };
	}

	/**
	 * Following Function adds college to the List.
	 * @param college (String) denotes the name of the college to be added in the list.
	 * @return (String) returns the status whether college is added or not
	 */
	public String addCollege(String college) {
		if (row == collegeList.length) {
			return ("No more College can be added in the list");
		} else {
			collegeList[row++][0] = college;
			return ("college is added sucessfully in the list");
		}
	}

	/**
	 * Following function displays the available colleges having vacant seats.
	 */
	public void displayAvalableCollege() {
		// display the register college if it has seat available for counseling
		for (int college = 0; college < row; college++) {
			if (availableSeats[college] < 5) {
				System.out.println((college + 1) + ". "
						+ collegeList[college][0]);
			}
		}
	}

	/**
	 * Following function assigns a college to the candidate if available
	 * @param candidate(String) denotes the name of candidate.
	 * @param college(int) indicates the college number.
	 */
	public void assignCollege(String candidate, int college) {
		if (college > collegeList.length) {
			System.out.println("Wrong choice Entered");
		} else if (availableSeats[college] >= collegeList[0].length) {
			System.out.println("Seats Full");
		} else {
			availableSeats[college]++;
			collegeList[college - 1][availableSeats[college]] = candidate;
		}
	}

	/**
	 * Following function displays the college assigned to the candidate
	 */
	public void displayCollegeAssigned() {
		for (int college = 0; college < row; college++) {
			for (int candidate = 1; candidate <= availableSeats[college] + 1; candidate++) {
				System.out.println(collegeList[college][0] + " "
						+ collegeList[college][candidate]);
			}
		}
	}
}
