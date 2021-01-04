import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Stack: A data structure used to store objects. It works on the principle that it examines the elements most recently
* entered: LIFO (Last in, First out)
* 
* <li> Amortized Analysis: Cost of inserting first N elements: N+(2+4+8+16--------+N)~3N
* 
* <li> Performance: Constant time ~1 under amortized analysis.
* 
* @category Generic Resizing Stack with Iterable interface implementation of Strings.
* @author  Mohit Sharma
* @version 1.0
* @since   04-01-2021
*/


public class ArrayStack<Item> implements Iterable<Item> {
	
	private Item [] s;
	private int N=0;
	
	@SuppressWarnings("unchecked")
	public ArrayStack()	//create an empty stack with fixed capacity
	{
		s=(Item[]) new Object[1]; //java doesnt allow generic array creation
	}
	
	public void push(Item item) //insert a new string onto stack
	{
		if(N==s.length)		
			resize(2*s.length); //if array is full, create a new one of twice the size
		s[N++]=item;
	}
	
	public Item pop() //remove and return the string
	{
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
			Item item=s[--N];
			s[N]=null;
			if(N>0 && N==s.length/4)
				resize(s.length/2);
			return item;
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
		@SuppressWarnings("unchecked")
		Item [] copy=(Item[]) new Object[capacity];
		for(int i=0;i<N;i++)
			copy[i]=s[i];
		s=copy;
	}

	@Override
	public Iterator<Item> iterator() {	return new ArrayIterator();	}
	
	private class ArrayIterator implements Iterator<Item>{

		private int i=N;
		@Override
		public boolean hasNext() {
			return i>0;
		}

		@Override
		public Item next() {
			return s[--i];
		}
		
	}

}

