package session4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 
 * *Allocation of room according to there age
 *Given - number of room > number of guest 
 *use linear probing hashing
 */
public class Room {

	/**
	 * This method give integer value if input is give wrong then again it run
	 * till a correct input is not given
	 * 
	 * @return //user input value
	 */
	public static int inputNumber() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputNumber = 0;
		try {
			inputNumber = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("Please Enter the Valid Number");
			inputNumber = inputNumber();
		}
		return inputNumber;
	}

	public static void main(String[] args) {
		// each user age
		int userAge[];
		// allocated room
		int roomAllocate[];
		// check room availability  
		int roomAvailable[];
		int numberOfUser;
		int numberOfRoom;
		
		System.out.println("Enter Number of customer");
		numberOfUser = inputNumber();
		System.out.println("Enter Number of rooms in hotel ");
		numberOfRoom = inputNumber();
		roomAllocate = new int[numberOfUser+2];
		roomAvailable = new int[numberOfRoom+2];
		userAge = new int[numberOfUser+2];
		for(int i=0;i<numberOfUser;i++){
			System.out.print("Enter user number " + (i+1)+" Age:  ");
			userAge[i] = inputNumber();
			//use linear probing  method of hashing
			int index = (userAge[i]%numberOfRoom);
			while(roomAllocate[i] == 0){
				if(roomAvailable[index] == 1){
					index++;
				}else{
					roomAllocate[i] = index;
					roomAvailable[index] = 1;
				}
				if(index >= numberOfRoom){
					index =1;
				}
			}
		}
		for(int i=0;i<numberOfUser;i++){
			System.out.println("User number "+(i+1)+" Age "+userAge[i]+" room allocate " +roomAllocate[i]);
		}
	}
}
