
/**
* <h1>Seperate Chaining: Collision resolution stratedgy with linked lists </h1>
* 
* <li> Two keys hashing to the same index.
* <li> Birthday Problem: Can't avoid collisions unless you have a ridiculous amount of memory.
* <li> Coupon Collector + Load Balancing: Collisions will be evenly distributed.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   11-01-2021
* 
*/

public class SeperateChainHashST<Key, Value> {

	/**
	 * Use an array of M<N linked lists [H.P. Luhn] IBM-1953
	 * <li> Hash: Map key to integer i between 0 & M-1
	 * <li> Insert: put at front of ith chain (if not already there)
	 * <li> Search: Need to search only ith chain
	 */
	
	private int M=97;	//number of chains
	@SuppressWarnings("unchecked")
	private Node [] st= (Node []) new Object[M]; 	//array of chains
	
	private class Node{
		private Key key;
		private Value val;
		private Node next;
		
		Node(Key key, Value val, Node next)
		{
			this.key=key;
			this.val=val;
			this.next=next;
		}
	}
	
	private int hash(Key key)
	{
		return (key.hashCode() & 0x7fffffff) % M;		//take 31 bits
	}
	
	public Value get(Key key)
	{
		int i=hash(key);
		for(Node x=st[i]; x!=null; x=x.next)
			if(key.equals(x.key))
				return x.val;
		return null;
	}
	
	/**
	 * Analysis: Under the uniform hashing assumption, probability that the number of keys in a list is within a constant 
	 * factor of N/M is extremely close to 1.
	 * 
	 * Proof: Distribution obeys Binomial Distribution
	 * Consequence: Number of probes for search/insert is N/M
	 * 
	 * Average case: Insert=3.5, Search hit=3.5, Delete=3.5
	 * Worst case: Insert=lg N, Search hit=lg N, Delete=lg N
	 * @param key
	 * @param val
	 */
	
	public void put(Key key, Value val)
	{
		int i=hash(key);
		for(Node x=st[i];x!=null;x=x.next)
			if(key.equals(x.key)) 
			{
				x.val=val;
				return;
			}
		st[i]=new Node(key,val,st[i]);
	}
	
	/**
	 * Delete: Easiest way to delete is to find key-value pair & remove it and reinsert all of the key-value pairs in the same
	 * 		   cluster that appear after deleted key-value pair.
	 * 
	 * Alternative: Tomb-stone method or flagging
	 */
}
