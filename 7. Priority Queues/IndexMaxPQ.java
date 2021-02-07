import java.util.NoSuchElementException;

/**
* <h1>Indexed Max Priority Queue: It is a traditional priority queue variant which on top of the regular PQ operations
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
* @version 1.0
* @since   07-02-2021
* 
*/

public class IndexMaxPQ<Key extends Comparable<Key>> {
	
	private Key [] pq;
	private int N=0;
	@SuppressWarnings("unchecked")
	IndexMaxPQ(int N)
	{
		pq=(Key []) new Object[N+1];
	}
	
	/**
	 * Associate key with index i
	 * @param i
	 * @param key
	 */
	void insert(int i, Key key)
	{
		
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
	private void swim(int k)
	{
		while(k>1 && less(k/2,k))
		{
			exch(k,k/2);
			k=k/2;
		}
	}
	
	public Key deleteMax()
	{
		Key key=pq[1];
		exch(1,N);
		sink(1);
		pq[N--]=null;
		return key;
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
			exch(k,j);
			k=j;
		}
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

}
