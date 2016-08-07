import java.util.LinkedList;
import java.util.List;

public class Queue<E> {
	
	private LinkedList<E> list;
	
	public Queue()
	{
		this.list=new LinkedList<E>();
	}
	public void push(E element)
	{
		this.list.addFirst(element);
	}
	
	public  E pop()
	{
		E item=this.list.pollLast();
		if(item==null)
			System.out.println("list is empty");
		return item;		
	}
	
	public void display()
	{
		if(!list.isEmpty())
		   System.out.println(this.list);
		else
			System.out.println("list is empty");
	}

	public static void main(String args[])
	{
		
		Queue<Integer> queue=new Queue<Integer>();
		System.out.println("3 has been pushed");
		queue.push(new Integer(3));
		queue.display();
		System.out.println("1 has been pushed");queue.push(new Integer(1));queue.display();
		System.out.println("35 has been pushed");queue.push(new Integer(35));queue.display();
		Integer i=(Integer) queue.pop();System.out.println(i+" has been popped");queue.display();
		System.out.println("56 has been pushed");queue.push(new Integer(56));queue.display();
		System.out.println("2 has been pushed");queue.push(new Integer(2));queue.display();
		
	}

}
