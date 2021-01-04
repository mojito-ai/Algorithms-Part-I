import edu.princeton.cs.algs4.StdIn;

/**
* Stack: A data structure used to store objects. It works on the principle that it examines the elements least recently
* entered: LIFO (Last in, First out)
* 
* <li> Amortized Analysis: Cost of inserting first N elements: N+(2+4+8+16--------+N)~3N
* 
* <li> Performance: Constant time ~1 under amortized analysis-
* 
* @category Array (Resizing) approach to the implementation of Stack of Strings.
* @author  Mohit Sharma
* @version 1.0
* @since   04-01-2021
*/

public class ResizingArrayStackofStrings {
	
	private String [] s;
	private int N=0;
	
	public ResizingArrayStackofStrings()	//create an empty stack with fixed capacity
	{
		s=new String[1];
	}
	
	public void push(String item) //insert a new string onto stack
	{
		if(N==s.length)		
			resize(2*s.length); //if array is full, create a new one of twice the size
		s[N++]=item;
	}
	
	public String pop() //remove and return the string
	{
		if(!isEmpty())
		{	
			String item=s[--N];
			s[N]=null;
			if(N>0 && N==s.length/4)
				resize(s.length/2);
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
	
	private void resize(int capacity)
	{
		String [] copy=new String[capacity];
		for(int i=0;i<N;i++)
			copy[i]=s[i];
		s=copy;
	}
	
	public static void main(String [] args) //tester
	{
		ResizingArrayStackofStrings stack=new ResizingArrayStackofStrings();
		while(!StdIn.isEmpty())
		{
			String s=StdIn.readString();
			if(s.equals("-"))	System.out.println(stack.pop());
			else				stack.push(s);
		}
	}

}

