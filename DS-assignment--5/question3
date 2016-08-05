import java.util.LinkedList;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class insertSortedLinkList<E>{
	
	public void insert(LinkedList<E> ll, E item)
	{
		int pos=0;
		
		for(int i=0;i<ll.size();i++){
		if(((Comparable)ll.get(i)).compareTo(item)<0)
			continue;
		else 
		{	pos=i;
			break;}
		}
		ll.add(pos, item);
	}
	
	public static void main(String args[]) throws IOException
	{
		int n=0,item=0;
		LinkedList<Integer> ll=new LinkedList<Integer>();
		insertSortedLinkList<Integer> ill=new insertSortedLinkList<Integer>();
		Scanner sc= new Scanner(System.in);
		//BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Kindly enter elements in a sorted fashion. ");
		System.out.println("enter no. of elements in sorted linked list: ");
		
		
			n=sc.nextInt();
		
		for(int i=0;i<n;i++){
			
			
			System.out.println("Enter element "+(i+1) );
			item=sc.nextInt();
			ll.add(i,new Integer(item));
			
		}
		System.out.println(ll);
		System.out.println("enter the element to be inserted in sorted linked list: ");
		item=sc.nextInt();
		ill.insert(ll, item);
		System.out.println(ll);
		sc.close();
	}
}
