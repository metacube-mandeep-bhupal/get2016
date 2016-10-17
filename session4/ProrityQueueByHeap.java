package session4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Implement Heap data structure on Jobs.
 * 
 * */
public class ProrityQueueByHeap {

	public static void maxHeapify(Queue queue, int position) {
		// getting heap node's left and right index
		int left = 2 * position;
		int right = (2 * position) + 1;
		// largest number's index
		int largest;
		if (left <= queue.getHeapSize()
				&& queue.numbers.get(left) > queue.numbers.get(position)) {
			largest = left;
		} else {
			largest = position;
		}
		if (right <= queue.getHeapSize()
				&& queue.numbers.get(right) > queue.numbers.get(largest)) {
			largest = right;
		}
		if (largest != position) {
			// swaping of numbers
			int swapTemp = queue.numbers.get(largest);
			queue.numbers.set(largest, queue.numbers.get(position));
			queue.numbers.set(position, swapTemp);
			// again recursive call
			maxHeapify(queue, largest);
		}
	}

	/**
	 * Build max heap
	 * 
	 * @param queue
	 *            //Queue object
	 */
	public static void buildMaxHeap(Queue queue) {
		for (int i = (queue.getHeapSize() / 2); i >= 1; i--) {
			maxHeapify(queue, i);
		}
	}

	/**
	 * heap sorting
	 * 
	 * @param queue
	 *            //Queue object
	 */
	public static void heapSort(Queue queue) {
		buildMaxHeap(queue);
		for (int i = queue.getHeapSize(); i >= 2; i--) {
			// swaping of numbers
			int tempVar = queue.numbers.get(1);
			queue.numbers.set(1, queue.numbers.get(i));
			queue.numbers.set(i, tempVar);
			// decrease the size
			queue.decressHeapSizeByOne();
			maxHeapify(queue, 1);
		}
		queue.setHeapSizeByTotalHeapSize();
	}

	/**
	 * use to serve the jobs
	 * 
	 * @param queue
	 *            // Queue
	 */
	public static void serveJob(Queue queue) {
		if (queue.totalHeapSize > 0) {
			queue.numbers.remove(queue.totalHeapSize);
			queue.decressHeapSizeByOne();
			queue.decressTotalSizeByOne();
			maxHeapify(queue, 1);
			System.out.println("Job served");
		} else {
			System.out.println("sorry,no job in queue");
		}
	}

	/**
	 * This method give integer value between 1 to 4
	 * 
	 * 
	 * @return //user input value between 1 to 4
	 */
	public static int inputPriority() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputNumber = 0;
		try {
			inputNumber = Integer.parseInt(br.readLine());
			if (inputNumber < 1 || inputNumber > 4) {
				System.out.println("Number should be in between 1 to 4 ");
				inputNumber = inputPriority();
			}
		} catch (Exception e) {
			System.out.println("Please Enter the Valid Number");
			inputNumber = inputPriority();
		}
		return inputNumber;
	}

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

	public static void main(String args[]) {

		Queue queue = new Queue();
		boolean exitVariable = true;
		while (exitVariable) {
			System.out.println("Enter 1 for insert jobs");
			System.out.println("Enter 2 for a serve job");
			System.out.println("Enter 3 for show prority queue");
			System.out.println("Enter any other number for exit ");
			int choice;

			choice = inputNumber();
			switch (choice) {
			case 1:
				int loopVariable = 1;
				while (loopVariable == 1) {
					System.out
							.println("Insert a new JOB prority between 1 to 4");
					int jobPrority;
					// insert new job priority
					jobPrority = inputPriority();
					queue.insert(jobPrority);
					System.out
							.println("Enter 1 if there is more job to insert else Enter any other number");
					loopVariable = inputNumber();
				}
				break;
			case 2:
				// served jobs
				serveJob(queue);
				break;
			case 3:
				// heap sorting
				heapSort(queue);
				System.out.println(queue);
				break;
			default:
				exitVariable = false;
			}
		}
	}

}
