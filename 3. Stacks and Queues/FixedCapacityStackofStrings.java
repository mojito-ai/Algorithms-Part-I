import edu.princeton.cs.algs4.StdIn;

/**
* Stack: A data structure used to store objects. It works on the principle that it examines the elements most recently
* entered: LIFO (Last in, First out)
* 
* @category Array (fixed capacity) approach to the implementation of Stack of Strings.
* @author  Mohit Sharma
* @version 1.0
* @since   04-01-2021
*/

public class FixedCapacityStackofStrings {
	
	private String [] s;
	private int N=0;
	
	public FixedCapacityStackofStrings(int N)	//create an empty stack with fixed capacity
	{
		s=new String[N];
	}
	
	public void push(String item) //insert a new string onto stack
	{
		s[N++]=item;
	}
	
	public String pop() //remove and return the string
	{
		if(!isEmpty())
		{	
			String item=s[--N];
			s[N]=null;
			return item;
		}		
		else
			return "-1";
	}

	public boolean isEmpty() //is the stack empty?
	{
		return this.N==0;
	}
	
	public int size()	//number of strings on the stack
	{
		return N;
	}
	
	public static void main(String [] args) //tester
	{
		FixedCapacityStackofStrings stack=new FixedCapacityStackofStrings(10);
		while(!StdIn.isEmpty())
		{
			String s=StdIn.readString();
			if(s.equals("-"))	System.out.println(stack.pop());
			else				stack.push(s);
		}
	}

}
