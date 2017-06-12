
public class LinkListStack {
	
	public void push(Node list, int val)
	{
		Node new_node=new Node(val);
		if(list==null)
			list = new_node;
		else
		{
			new_node=list;
			list=new_node;
		}
	}
	
	public int pop(Node list)
	{
		int val=0;
		if(list==null)
			System.out.println("Stack is empty");
		else
		{
			val=list.value;
			list=list.next;
		}
		return val;
	}

	
	 

}


