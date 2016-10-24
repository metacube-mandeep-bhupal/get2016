package session8.assignment2;

import java.util.LinkedList;
import java.util.Queue;

public class LinearSorting {

	private int array[];

	/**
	 * Constructor
	 * @param array(int[]) denotes the array of numbers entered by the user.
	 */
	LinearSorting(int array[]) {
		this.array = array;
	}

	/**
	 * Following function linearSort() decides which sorting has to be performed
	 * according to the conditions imposed.
	 */
	public int[] linearSort() {
		int max = max();
		int numberOfDigits = countDigits(max);
		if (numberOfDigits > 2) {
			System.out.println("Radix Sort has been performed : \n\n");
			radixSort();
		} else {
			System.out.println("Counting Sort has been performed : \n\n");
			countingSort();
		}
		return array;
	}

	/**
	 * Following function performs counting sort on the given array
	 */
	public void countingSort() {
		int max = max() + 1;
		int count[] = new int[max];
		int i = 0;
		while (i < array.length) {
			count[array[i]]++;
			i++;
		}
		i = 0;
		int j = 0;
		while (i < max) {
			if (count[i] != 0) {
				int frequency = 0;
				while (frequency < count[i]) {
					array[j] = i;
					j++;
					frequency++;
				}
			}
			i++;
		}
	}

	/**
	 * Following function performs radix sort on the given array
	 */
	public void radixSort() {
		@SuppressWarnings("unchecked")
		Queue<Integer>[] buckets = new Queue[10];
		for (int index = 0; index < 10; index++)
			buckets[index] = new LinkedList<Integer>();

		boolean sorted = false;
		int expo = 1;

		while (!sorted) {
			sorted = true;

			for (int item : array) {
				int bucket = (item / expo) % 10;
				if (bucket > 0)
					sorted = false;
				buckets[bucket].add(item);
			}
			expo *= 10;
			int index = 0;
			for (Queue<Integer> bucket : buckets)
				while (!bucket.isEmpty())
					array[index++] = bucket.remove();
		}
	}

	/**
	 * Following function counts the number of digits in the given number
	 * @param number(int) denotes the maximum number in the array.
	 * @return returns(int) the number of digits in the given number.
	 */
	public int countDigits(int number) {
		int count = 0;
		while (number > 0) {
			count++;
			number = number / 10;
		}
		return count;
	}

	/**
	 * Following function finds the maximum number in the array given by the
	 * user.
	 * @return returns(int) the maximum number in the given array by the user.
	 */
	public int max() {
		int max = array[0];
		int i = 1;
		while (i < array.length) {
			if (max < array[i]) {
				max = array[i];
			}
			i++;
		}
		return max;
	}

	/**
	 * Following function displays the sorted array to the user.
	 */
	public void display() {
		System.out.println();
		for (int index = 0; index < array.length; index++) {
			System.out.print("\t" + array[index]);
		}
		System.out.println();
	}
}
