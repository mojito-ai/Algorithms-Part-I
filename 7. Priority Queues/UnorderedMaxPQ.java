
/**
* <h1>Unordered Priority Queue: Variant of sorting that generalises the idea of flexible data structure</h1>
* 
* <li>Priority Queue: Remove the largest (or smallest) item
* <li>Generic items need to be comparable
* <li>Analysis: insert=1, delete max=N, max=N
* 
* @author  Mohit Sharma
* @version 1.0
* @since   08-01-2021
* 
*/

public class UnorderedMaxPQ<Key extends Comparable<Key>> 
{
	private Key [] pq;
	private int N=0;
	
	@SuppressWarnings("unchecked")
	UnorderedMaxPQ(int capacity)		//create an empty priority queue
	{
		pq=(Key[])new Comparable[capacity];
	}
	
	public boolean isEmpty()			//is the priority queue empty?
	{
		return N==0;
	}
	
	public void insert(Key v)			//insert a key into the priority queue
	{
		pq[N++]=v;
	}
	
	public Key delmax()					//remove and return the largest key
	{
		int max=0;
		for(int i=0;i<N;i++)
			if(less(max,i))
				max=i;
		
		exch(max,N-1);
		Key item=pq[N-1];
		pq[--N]=null;
		return item;
	}
	
	private boolean less(int i, int j)	//helper functions
	{
		return pq[i].compareTo(pq[j])<0;
	}
	
	private void exch(int i, int j)	
	{
		Key swap=pq[i];
		pq[i]=pq[j];
		pq[j]=swap;
	}
	
	public void show()					//display the priority queue
	{
		for(int i=0;i<N;i++)
			System.out.print(pq[i]+" ");
	}
}

