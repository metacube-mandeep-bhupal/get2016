import java.util.Scanner;

public class ArrayList1<E> {
private static final int DEFAULT_SIZE=10;

private int size;
private Object data[];

public ArrayList1(int s)
{
	this.size=s;
	this.data= new Object[s];
}

public ArrayList1()
{
	this.size=DEFAULT_SIZE;
	this.data=new Object[DEFAULT_SIZE];
}

public void addResize(E element)
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
		this.data[this.data.length]=element;
	}	
	else
		this.data[this.data.length]=element;
		
}



public void addParticularLocation(E a, int location)   //assuming that location is like an array index starting from 0,1....
{
	int i=0,b, new_size;
	Object[] temp;
	if (this.data.length==this.size)
	{
		
		new_size=(3/2)*this.data.length + 1;
		temp=new Object[size];
		
		while(i<this.data.length)
		{
			temp[i]=this.data[i];
		}
		
		this.data=temp;
		b=this.data.length;
		while(b!=location)
		{data[b]=data[b-1];
		b--;}
		data[b]=a;
	}
	else
	{
		
		b=this.data.length;
		while(b!=location)
		{data[b]=data[b-1];
		b--;}
		data[b]=a;
		
	}
		
}

public int retreieveGivenLocation(E element, int location)
{
	int i;
	for(i=location;i<data.length;i++)       //considering user gives the location like this--element E is at 6th position
	{
		if(data[i]==element)
			break;
			
	}
	return i;
}

public int firstIndex(E element)
{
	int i=0;
	while(i<data.length)
	{
		if(data[i]==element)
		{	
		    break;}
		else
			i++;
	}
	return i;
}

public void removeParticularLocation(int location)
{
	int i=location;
	while(i<data.length-1)
	{
		data[i]=data[i+1];
		data[i+1]=null;
		i++;
	}
}

public void removeParticularElement(E element)
{
	int i=0;
	while(data[i]!=element)
	{
		i++;
		break;
	}
	while(i<data.length-1)
	{	data[i]=data[i+1];
		data[i+1]=null;
		i++;
	}
		
}

public void removeElements()
{
	this.data=new Object[1];
}

public void reverse()
{
	int i=0, j=data.length-1;
	E element;
	while(i<j)
	{
		element= (E)data[i];
		data[i]=data[j];
		data[j]=element;
		i++;
		j--;
	}
}

public void sort() {
	mergeSort(0, size - 1);
}

private void mergeSort(int low, int high) {
	if (low < high) {
		int middle = low + (high - low) / 2;
		mergeSort(low, middle);
		mergeSort(middle + 1, high);
		merge(low, middle, high);
	}
}

@SuppressWarnings({ "rawtypes", "unchecked" })
private void merge(int low, int middle, int high) {

	Object[] helper = new Object[size];
	for (int i = low; i <= high; i++) {
		helper[i] = data[i];
	}

	int i = low;
	int j = middle + 1;
	int k = low;
	while (i <= middle && j <= high) {
		if (((Comparable) helper[i]).compareTo(helper[j]) < 0) {
			data[k] = helper[i];
			i++;
		} else {
			data[k] = helper[j];
			j++;
		}
		k++;
	}
	while (i <= middle) {
		data[k] = helper[i];
		k++;
		i++;
	}
}

private Object[] copy(int newSize) {
	Object[] temp = new Object[newSize];
	for (int i = 0; i < size; i++) {
		temp[i] = data[i];
	}
	return temp;
}
public static void main(String args[])
{
	System.out.print("Enter initial size of Array List:");
	Scanner scan= new Scanner(System.in);
	int size=scan.nextInt();
	ArrayList1 ar= new ArrayList1(size);
	
}



}