package session4;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	private int heapSize =0;
	int totalHeapSize = 0;
	List<Integer> numbers;

	/**
	 * @return	// return size of heap
	 */
	public int getHeapSize(){
		return heapSize;
	}
	// decrease heap size
	public void decressHeapSizeByOne(){
		heapSize--;
	}
	public void decressTotalSizeByOne(){
		totalHeapSize--;
	}
	public void setHeapSizeByTotalHeapSize(){
		heapSize = totalHeapSize;
	}
	// constructor
	public Queue(){
		numbers = new ArrayList<Integer>();
		numbers.add(null);
	}
	@Override
	public String toString() {
		String string = "";
		for(int i=totalHeapSize;i >= 1 ; i--){
			string += numbers.get(i) + " ";
		}
		// if nothing in the queue
		if(string.equals("")){
			string += "sorry, no job found";
		}
		return string;
	}
	/**
	 * @param data	// insert data to the list
	 */
	public void insert(int data){
		totalHeapSize++;
		heapSize++;
		numbers.add(data);	
	}
}
