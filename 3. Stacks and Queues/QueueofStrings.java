/**
* Queue: A data structure used to store objects. It works on the principle that it examines the elements least recently
* entered: FIFO (First in, First out)
* 
* @category Linked List approach to the implementation of Queue of Strings.
* @author  Mohit Sharma
* @version 1.0
* @since   04-01-2021
*/

public class QueueofStrings {
	
	private Node first,last;
	private int N;
	
	private class Node{
		String item;
		Node next;
	}
	
	public QueueofStrings()
	{
		first=last=null;
		N=0;
	}
	
	public void enqueue(String item)	//insert onto queue
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
	
	public String dequeue()			//remove according to FIFO
	{
		if(!isEmpty())
		{
			N--;
			String item=first.item;
			first=first.next;
			if(first==null)
				last=first;
			return item;
		}
		else
			return "-1";
		
	}
	
	public boolean isEmpty()
	{
		return first==null;
	}
	
	public int size()
	{
		return N;
	}

}
