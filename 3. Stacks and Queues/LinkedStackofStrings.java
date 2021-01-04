import edu.princeton.cs.algs4.StdIn;

/**
* Stack: A data structure used to store objects. It works on the principle that it examines the elements most recently
* entered: LIFO (Last in, First out)
* 
* @category Linked List approach to the implementation of Stack of Strings.
* @author  Mohit Sharma
* @version 1.0
* @since   04-01-2021
*/

public class LinkedStackofStrings {
	
	private Node first;
	private int N;
	
	private class Node
	{
		String item;
		Node next;
	}
	
	public LinkedStackofStrings()	//create an empty stack
	{
		first=null;
		N=0;
	}
	
	public void push(String item) //insert a new string onto stack
	{
		N++;
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
	}
	
	public String pop() //remove and return the string
	{
		if(!isEmpty())
		{	
			N--;
			String item=first.item;
			first=first.next;
			return item;
		}
		else
			return "-1";
			
	}

	public boolean isEmpty() //is the stack empty?
	{
		return first==null;
	}
	
	public int size()	//number of strings on the stack
	{
		return N;
	}
	
	public static void main(String [] args) //tester
	{
		LinkedStackofStrings stack=new LinkedStackofStrings();
		while(!StdIn.isEmpty())
		{
			String s=StdIn.readString();
			if(s.equals("-"))	System.out.println(stack.pop());
			else				stack.push(s);
		}
	}
}
