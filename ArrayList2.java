
public class ArrayList2<E>{
	
	private Object data[];
	private int size;
	private static final int DEFAULT_SIZE=10;
	
	public ArrayList2()
	{
		this.data=new Object[DEFAULT_SIZE];
		this.size=DEFAULT_SIZE;
	}
	
	public void addResize(E a)
	{
		int i=0, new_size;
		Object[] temp;
		if (this.data.length==this.size)
		{
			
			new_size=(3/2)*this.data.length + 1;
			temp=new Object[new_size];
			
			while(i<this.data.length)
			{
				temp[i]=this.data[i];
			}
			
			this.data=temp;
			this.data[this.data.length]=a;
		}	
		else
			this.data[this.data.length]=a;
			
	}
	
	public void add(ArrayList2<E> list1,ArrayList2<E> list2)
	{
		int i=0;
		while(i<list2.data.length)
		{
			list1.addResize((E)list2.data[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList2 list1= new ArrayList2();
		ArrayList2 list2= new ArrayList2();
		
	}

}
