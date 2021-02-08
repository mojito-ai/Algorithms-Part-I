import java.util.NoSuchElementException;

/**
* <h1>Indexed Min Priority Queue: It is a traditional priority queue variant which on top of the regular PQ operations
* 								  supports quick updates and deletions of key-value pairs. </h1>
* 
* <li> Associate an index between 0 & N-1 with each key in a priority queue.
* <li> Client can insert and delete-the-minimum.
* <li> Client can change the key by specifying the index.
* <li> Suppose we have N people with different priorities that we need to serve. Assume priorities can change dynamically
* 	   and we always want to serve the person with the highest priority. To figure out who to serve next, we use a max IPQ
* 	   to sort by lowest value first.
* <li> Use Hash-table to convert key values to integer based.
* 
* 
* @author  Mohit Sharma
* @version 3.0
* @since   08-02-2021
* 
*/

public class IndexMinPQ<Priority extends Comparable<Priority>> {
	/**
	 * Start with the same code as MaxPQ
	 * Maintain parallel arrays keys[], pq[], qp[] so that:
	 * <li> keys[i] is the priority of i
	 * <li> pq[i] is the index of the key in heap position i
	 * <li> qp[i] is the heap position of the key with index i
	 * 
	 */
	
	/*
	 * 1. The array pm is a Position Map we maintain to tell us the index of the node in the heap for a given key index (ki).
	 * 	  It is synonymous with qp
	 * 
	 * 2. To know the position of a node to its key, we maintain a inverse lookup table (inverse map). It is synonymous with pq.
	 */
	private Priority [] values;
	private int [] pm;		//position map
	private int [] im;		//inverse map
	private int N=0;
	@SuppressWarnings("unchecked")
	IndexMinPQ(int N)
	{
		values=(Priority []) new Object[N];
		pm=new int[N];
		im=new int[N];
	}
	
	/**
	 * Associate key with index i
	 * @param i
	 * @param key
	 */
	void insert(int i, Priority value)
	{
		values[i]=value;
		pm[i]=N;
		im[N]=i;
		//N is the current size of the array.
		swim(N);
		N++;
	}
	
	/**
     * Increase the key associated with index {@code i} to the specified value.
     *
     * @param  i the index of the key to increase
     * @param  key increase the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws IllegalArgumentException if {@code key <= keyOf(i)}
     * @throws NoSuchElementException no key is associated with index {@code i}
     */
    public void increaseKey(int i, Key key)
	{
		
	}
	
	 /**
     * Decrease the key associated with index {@code i} to the specified value.
     *
     * @param  i the index of the key to decrease
     * @param  key decrease the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws IllegalArgumentException if {@code key >= keyOf(i)}
     * @throws NoSuchElementException no key is associated with index {@code i}
     */
    public void decreaseKey(int i, Key key)
    {
    	
    }
	
    /**
     * Is i an index on the PQ
     * @param i
     * @return
     */
	boolean contains(int i)
	{
		
	}
	
	/**
	 * Remove a maximal key and return its associated value.
	 * @return
	 */
	int delMax()
	{
		
	}
	
	/**
	 * Is the PQ empty?
	 * @return
	 */
	boolean isEmpty()
	{
		
	}
	
	/**
	 * Number of entries in the PQ.
	 * @return
	 */
	int size()
	{
		
	}
	
	public void insert(Key key)
	{
		pq[++N]=key;
		swim(N);
	}

	public Key deleteMax()
	{
		Key key=pq[1];
		exch(1,N);
		sink(1);
		pq[N--]=null;
		return key;
	}
	
	/***********************************************************
	 * Helper Functions
	 * 
	 ***********************************************************
	 */
	
	private void swim(int k)
	{
		while(k>0 && less(k,(k-1)/2))
		{
			swap(k,(k-1)/2);
			k=(k-1)/2;
		}
	}
	
	
	private void sink(int k)
	{
		while(N>=2*k)
		{
			int j=2*k;
			if(j<N && less(j,j+1))
				j=j+1;
			if(!less(k,j))
				break;
			swap(k,j);
			k=j;
		}
	}
	
	private boolean less(int i, int j)	//helper functions
	{
		return values[im[i]].compareTo(values[im[j]])<0;
	}
	
	private void swap(int i, int j)	
	{
		pm[im[j]]=i;
		pm[im[i]]=j;
		int tmp=im[i];
		im[i]=im[j];
		im[j]=tmp;
	}

}