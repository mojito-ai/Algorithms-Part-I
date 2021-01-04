import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Queue: A data structure used to store objects. It works on the principle that it examines the elements least recently
* entered: FIFO (First in, First out)
* 
* @category Generic + Iterable implementation of Queue
* @author  Mohit Sharma
* @version 1.0
* @since   04-01-2021
*/

public class Queue<Item> implements Iterable<Item> {
	
	private Node first,last;
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public Queue()
	{
		first=last=null;
		N=0;
	}
	
	public void enqueue(Item item)	//insert onto queue
	{
		N++;
		Node oldlast=last;
		last=new Node();
		last.item=item;
		last.next=null;
		if(isEmpty())
			first=last;
		else
			oldlast.next=last;
	}
	
	public Item dequeue()			//remove according to FIFO
	{
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
			N--;
			Item item=first.item;
			first=first.next;
			if(first==null)
				last=first;
			return item;
	}
	
	public boolean isEmpty()
	{
		return first==null;
	}
	
	public int size()
	{
		return N;
	}

	@Override
	public Iterator<Item> iterator() {	return new queueIterator();	}
	
	private class queueIterator implements Iterator<Item>{

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

