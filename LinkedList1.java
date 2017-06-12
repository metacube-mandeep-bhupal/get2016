
public class LinkedList1<E> {

	private int value;
	LinkedList1<E> next=null;
	
	public LinkedList1()
	{
		this.value=0;
		this.next=null;
	}
	
	public LinkedList1(int val)
	{
		this.value=val;
		this.next=null;
	}
	
		
	
	public void addItemLocation(LinkedList1<E> list, int val, int location)  //assuming that location starts from 1,2,.....
	{																		 // this method adds element at particular location 	
		int i=1;
		LinkedList1<E> new_node=new LinkedList1(val);
		LinkedList1<E> temp=new LinkedList1();
		temp.next=list;
		while(i<location-1)
		{
			temp.next=temp.next.next;
		}
		new_node.next=temp.next;
		temp.next=new_node;
		
	}
	
	public LinkedList1<E> removeValue(LinkedList1<E> list, int val)  //this method removed element based on value@@@@@@@
	{
		LinkedList1<E> prev_node=new LinkedList1();
		LinkedList1<E> next_node=new LinkedList1();
		next_node= list;
		while(next_node.value!= val && next_node.next!=null)
		{
			prev_node=next_node;
			next_node = next_node.next;
		}
		if(next_node==null)
			System.out.println("elemnet with the particular value "+val+ " not found in the list");
		else if(next_node==list)   //checking whether element is added at the beginning@@@@@@@@
			list=next_node.next;
		else	
			prev_node.next=next_node.next;
		return list;
	}
	
	public LinkedList1<E> removeIndex(LinkedList1<E> list, int index)    //what if element is added at the beginning or end@@@@@@@
	{
		int i=1;
		LinkedList1<E> prev_node=new LinkedList1();
		LinkedList1<E> next_node=new LinkedList1();
		next_node=list;
		while(i<=index)
		{
			prev_node=next_node;
			next_node=next_node.next;
			i++;
		}
		if(next_node==list)                                      //@@@@@@@@@@@@@@@@
			list=next_node.next;
		else
			prev_node.next=next_node.next;
		return list;
	}
	
	
	
	public LinkedList1<E> retreiveIndex(LinkedList1<E> list, int index)
	{
		int i=1;
		LinkedList1<E> prev_node=new LinkedList1();
		LinkedList1<E> next_node=new LinkedList1();
		next_node=list;
		while(i<index)
		{
			prev_node=next_node;
			next_node=next_node.next;
			i++;
		}
		if(i==1)
			list=next_node.next;
		else
			prev_node.next=next_node.next;
		return list;
	}
	
	public LinkedList1<E> reverseList(LinkedList1<E> list)
	{
		LinkedList1 temp=new LinkedList1<E>();
		LinkedList1 list2=new LinkedList1<E>();
		int a;
		temp=list;
		while(temp!=null)
		{
			a=temp.value;
			list2=insertAtBeginning(list2,a);
			temp=temp.next;
		}
		return list2;
	}
	
	public LinkedList1<E> insertAtBeginning(LinkedList1<E> list, int val)   //this method inserts element at the end
	{
		LinkedList1<E> temp=new LinkedList1();
		temp=list;
		if(list==null)
		{	
			LinkedList1<E> node=new LinkedList1<E>(val);
			list=node;}
		else
		{
			
			while(temp.next!=null)
			{	temp=temp.next;}
			LinkedList1<E> node=new LinkedList1<E>(val);
			temp.next=node;
		}
		return list;
	}
	
	public LinkedList1<E> sortList(LinkedList1<E> list)
	{
		

	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
