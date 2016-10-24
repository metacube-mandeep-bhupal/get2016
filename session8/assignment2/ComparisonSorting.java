package session8.assignment2;

public class ComparisonSorting {
	
	private int array[];
	/**
	 * Constructor
	 * @param array(int[]) denotes the array of numbers entered by the user.
	 */
	ComparisonSorting(int array[]){
		this.array = array;
	}
	
	/**
	 * Following function comparison() decides which sorting has to be performed according to the conditions imposed.
	 */
	public int[] comparison(){
		if(array.length<10){
			System.out.println("\n\nBubble Sort has been Performed: \n\n");
			bubbleSort();
		} else {
			System.out.println("\n\nQuick Sort has been performed : \n\n");
			quickSort(0,array.length-1);
		}
		return array;
	}
	
	/**
	 * Following function bubbleSort() is a logic that sorts the given array using bubble sorting algorithm.
	 */
	public void bubbleSort(){
		boolean swap = false;
		for(int index = 0 ; index < array.length -1 ; index++){
			swap = false;
			for(int position = 0; position < array.length-index-1 ; position++){
				if(array[position] > array[position+1]){
					swap = true;
					int t= array[position];
					array[position] = array[position+1];
					array[position+1] = t;
				}
			}
			if(swap == false){
				break;
			}
		}
	}
	
	/**
	 * Following function quickSort() is is a logic that sorts the given array using Quick sort recursive algorithm.
	 * @param first(int) denotes the first index of array.
	 * @param last(int) denotes the last index of array.
	 */
	public void quickSort(int first,int last){
		int dividingIndex;
		if( first<last ){
			dividingIndex=partition(first,last);
			quickSort(first,dividingIndex-1);
			quickSort(dividingIndex+1,last);
		}
	}
	
	/**
	 * Following function partition() is is a logic that places the pivot element at its correct position and divide the array in two parts about the correcrt position of pivot element.
	 * @param first(int) denotes the first index of array.
	 * @param last(int) denotes the last index of array.
	 * @return returns(int) the index of element which is either before and after the correct positon of pivot element.
	 */
	public int partition(int first,int last){
		int index = first-1;
		int position  = first;
		int item = array[last];
		while(position < last){
			if( array[position] <= item ){
				index++;
				array[index] = array[index] + array[position] - ( array[position] = array[index]);
			}
			position++;
		}
		array[index+1] = array[index+1] + array[last] - ( array[last] = array[index+1]);
		return index+1;
	}
	
	/**
	 * Following function displays the sorted array to the user.
	 */
	public void display(){
		System.out.println();
		for(int index = 0; index < array.length; index++){
			System.out.print("\t"+array[index]);
		}
	}
}
