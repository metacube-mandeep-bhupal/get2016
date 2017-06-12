import java.util.AbstractList;


public class DoublyLinkedList<E> extends AbstractList<E> {

		protected Node<E> head;
		int sizeOfLinkedList = 0;
		
		/**
		 * @param index(int) denotes the position.
		 * @return the node at that position
		 */
		private Node<E> node(int index) {
			Node<E> node = head;
			for(int i=0; i < index; i++) {
				node = node.next;
			}
			return node;
		}
		/**
		 * @param item(E) denotes the item to be added in the linked list.
		 * @param position(int) denotes the position at which the item is to be added.
		 * @return true/false whether item added or not
		 */
		public boolean add(E item, int position) {
			if (head == null) {
				Node<E> newNode = new Node<E>(item);
				head = newNode;
				newNode.next = null;
				newNode.previous = null;
				sizeOfLinkedList++;
				return true;
			}
			Node<E> temp = head;
			Node<E> newNode = new Node<E>(item);
			newNode.next = null;
			newNode.previous = null;
			int index = 1;
			while (index < position - 1) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.previous = temp;
			sizeOfLinkedList++;
			return true;
		}
		/**
		 * @param item(E) denotes the item to be remove from the linked list.
		 * @return true/false whether item has been removed or not.
		 */
		public boolean removeItem(E item) {
			if (head == null) {
				System.out.println("Empty List");
				return false;
			}
			Node<E> current = head;
			boolean flag = false;
			while (current != null) {
				if (current.nodeValue == item) {
					flag = true;
					break;
				}
				current = current.next;
			}
			if (flag == true) {
				current.previous.next = current.next;
				return true;
			}
			System.out.println("Item not in the List");
			return false;
		}
		/**
		 * @param position(int) denotes the position of node that is to be deleted from the list
		 * @return true/false whether item removed or not.
		 */
		public boolean removeAt(int position) {
			if (head == null) {
				System.out.println("Empty List");
				return false;
			} else if (position <= 0)
				return false;
			else if (position == 1) {
				head = head.next;
				head.previous = null;
			} else if (position == 2) {
				head.next = head.next.next;
				head.next.previous = head;
			} else {
				Node<E> current = head;
				int index = 2;
				while (index < position) {
					current = current.next;
				}
				current.next = current.next.next;
				current.next.previous = current;
			}
			return true;
		}
		/**
		 * @param position(int) denotes the position of node which is to be retrieved
		 * @return the item at the specified position.
		 */
		public E retreiveItem(int position) {
			if (head == null) {
				System.out.println("Empty List");
				return null;
			} else if (position > sizeOfLinkedList) {
				System.out.println("Array Index Out Of Bound Exception");
				return null;
			} else {
				Node<E> current = head;
				int index = 0;
				while (current != null) {
					index++;
					if (index == position)
						break;
					current = current.next;
				}
				return current.nodeValue;
			}
		}
		//following function reverses the linked list.
		void reverse() {
			Node<E> temp = null;
			Node<E> current = head;

			/*
			 * swap next and prev for all nodes of doubly linked list
			 */
			while (current != null) {
				temp = current.previous;
				current.previous = current.next;
				current.next = temp;
				current = current.previous;
			}

			/*
			 * Before changing head, check for the cases like empty list and list
			 * with only one node
			 */
			if (temp != null) {
				head = temp.previous;
			}
		}
		//Following Function Sorts the Linked List
		public void sorting() {
			DoublyLinkedList<E> temp = new DoublyLinkedList<E>();
			Node<E> node = head;
			for (int i = 0; i < sizeOfLinkedList; i++) {
				temp.add(node.nodeValue);
				node = node.next;
			}

			temp.sorting();
			node = head;
			for (int i = 0; i < temp.size(); i++) {
				node.nodeValue = temp.get(i);
				node = node.next;
			}
		}
			//Followinf Function returns the node value at the specified index.
			public E get(int index) {
				return node(index).nodeValue;
			}
			//Following Function returns the size of linked list.
		public int size() {
			return sizeOfLinkedList;
		}

	}


