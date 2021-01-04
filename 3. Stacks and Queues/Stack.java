import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Stack: A data structure used to store objects. It works on the principle that it examines the elements most recently
* entered: LIFO (Last in, First out)
* 
* @category Generic Implementation with Iterable interface
* @author  Mohit Sharma
* @version 1.0
* @since   04-01-2021
*/


public class Stack<Item> implements Iterable<Item>{

	private Node first;
	private int N;
	
	private class Node
	{
		Item item;
		Node next;
	}
	
	public Stack()	//create an empty stack
	{
		first=null;
		N=0;
	}
	
	public void push(Item item) //insert a new string onto stack
	{
		N++;
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
	}
	
	public Item pop() //remove and return the string
	{
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		N--;
		Item item=first.item;
		first=first.next;
		return item;	
	}

	public boolean isEmpty() //is the stack empty?
	{
		return first==null;
	}
	
	public int size()	//number of strings on the stack
	{
		return N;
	}

	@Override
	public Iterator<Item> iterator() {	return new ListIterator();	}
	
	public class ListIterator implements Iterator<Item>{
		private Node current=first;

		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			Item item=current.item;
			current=current.next;
			return item;
		}
	}
}
