import edu.princeton.cs.algs4.*;
/*
 * Dequeue. A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a 
 * queue that supports adding and removing items from either the front or the back of the data structure. 
 * Create a generic data type Deque that implements the following API:
*/
import java.util.Iterator;

import algorithms.LinkedQueue.ListIterator;
import algorithms.LinkedQueue.Node;
public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int size;
	
	private class Node
	{
		Item item;
		Node next;
	}
	
    // construct an empty deque
    public Deque()
    {
    	this.first=null;
    	this.last=null;
    	this.size=0;
    }
    // is the deque empty?
    public boolean isEmpty()
    {	return size==0;	}
    
    // return the number of items on the deque
    public int size()
    {	return size;	}
    
    // add the item to the front
    public void addFirst(Item item)
    {
    	
    }
    // add the item to the back
    public void addLast(Item item)
    {
    	size++;
    	Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) 
			first = last;
		else 
			oldlast.next = last;
    }
    // remove and return the item from the front
    public Item removeFirst()
    {
    	size--;
    	Item tmp=first.item;
    	first=first.next;
    	if(isEmpty())
    		last=null;
    	return tmp;
    }
    // remove and return the item from the back
    public Item removeLast()
    {
    	Item tmp=last.item;
    	
    }
    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()	{ return new ListIterator(); }
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		 
		public boolean hasNext()	{ return current != null; }
		public void remove() { }
		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

    // unit testing (required)
    public static void main(String[] args)

}