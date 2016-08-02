
public class Node<T> {
	public T nodeValue;
	public Node<T> next;
	public Node<T> previous;
	
	public Node(){
		nodeValue = null;
		next = null;
		previous=null;
	}
	
	public Node(T item){
		nodeValue = item;
		next = null;
		previous=null;
	} 
} 