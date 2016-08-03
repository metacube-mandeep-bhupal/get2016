package Q2_Queue;
import java.util.*;

public class MyQueue<E> {
	protected Object Queue[];
	protected int front, rear, size, len;

	/* Constructor */
	public MyQueue(int n) {
		size = n;
		len = 0;
		Queue = new Object[size];
		front = -1;
		rear = -1;
	}

	/**
	 * Function to check if queue is empty 
	 * @return true/false whether empty or not.
	 */
	public boolean isEmpty() {
		return front == -1 || len==0;
	}

	/**
	 * Following function checks, if queue is full 
	 * @return true/false according to the condition.
	 */
	public boolean isFull() {
		return front==0 && rear==size-1;
	}

	/**
	 * Following function returns the size of the queue.
	 * @return (int) returns the size.
	 */
	public int getSize() {
		return this.Queue.length;
	}

	/**
	 * Following function checks the front element of the queue 
	 * @return the front item of the queue
	 */
	public Object peek() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		else
			return Queue[front];
	}

	/**
	 * Following function inserts an element to the queue 
	 * @param item(Object) denotes the item to be added in the queue.
	 */
	public void enqueue(Object item) {
		if (rear == -1) {
			front = 0;
			rear = 0;
			Queue[rear] = item;
		} else if (rear + 1 >= size)
			throw new IndexOutOfBoundsException("Overflow Exception");
		else if (rear + 1 < size)
			Queue[++rear] = item;
		len++;
	}

	/**
	 * Function to remove front element from the queue
	 * @return returns(Object) the item that has been removed from the queue.
	 */
	public Object dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		else {
			len--;
			Object item = Queue[front];
			if (front == rear) {
				front = -1;
				rear = -1;
			} else
				front++;
			return item;
		}
	}

	/**
	 * Function to display the status of the queue
	 */
	public void display() {
		System.out.print("\nQueue = ");
		if (len == 0) {
			System.out.print("Empty\n");
			return;
		}
		for (int i = front; i <= rear; i++)
			System.out.print(Queue[i] + " ");
		System.out.println();
	}
}

