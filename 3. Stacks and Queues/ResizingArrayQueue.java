import java.util.NoSuchElementException;

/**
* Queue: A data structure used to store objects. It works on the principle that it examines the elements least recently
* entered: FIFO (First in, First out)
* 
* @category Resizing Array approach to the implementation of Queue of Strings.
* @author  Mohit Sharma
* @version 1.0
* @since   04-01-2021
*/

public class ResizingArrayQueue {
	
	private String [] s;
	private int first;
	private int last;
	private int N;
	
	public ResizingArrayQueue()
	{
		s=new String[1];
		first=last=0;
		N=0;
	}
	
	public void enqueue(String item)
	{
		if(N>0 && N==s.length)	resize(2*s.length);
		N++;
		s[last++]=item;
		if(last==s.length)	last=0;		//wrap around
		
	}
	
	public String dequeue()
	{
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		N--;
		String item=s[first];
		s[first]=null;
		first++;
		if(first==s.length)	first=0;		//wrap around
		if(N>0 && N==s.length/4)	resize(s.length/2);
		return item;
	}
	
	private void resize(int capacity)
	{
		assert capacity >= N;
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[(first + i) % s.length];
        }
        s = copy;
        first = 0;
        last  = N;
	}
	
	public boolean isEmpty()
	{
		return first==0;
	}
	
	public int size()
	{
		return N;
	}

}
