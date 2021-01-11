
/**
* <h1>Linear Probing: Collision resolution stratedgy with open addressing [Amdahl-Boehme-Rocherster-Samuel, IBM 1953] </h1>
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

public class LinearProbingHashST<Key,Value> {
	
	/**
	 * When a new key collides, find next empty slot and put it there.
	 * <li> Hash = Map key to integer i between 0 & M-1
	 * <li> Insert = Put at table index i if free; if not try i+1, i+2 etc.
	 * <li> Search = Search table index i, if occupied but no match try i+1, i+2 etc.
	 * <li> Array size must be greater than the number of key value pairs.
	 */
	
	private int M=30001;
	@SuppressWarnings("unchecked")
	private Value[] vals= (Value []) new Object[M];
	@SuppressWarnings("unchecked")
	private Key[] keys= (Key []) new Object[M];
	
	private int hash(Key key)
	{
		return (key.hashCode() & 0x7fffffff) % M;		//take 31 bits
	}
	
	/**
	 * Clustering: A contiguous block of items
	 * Observation: New keys likely to hash into middle of big clusters.
	 * 
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val)
	{
		int i;
		for(i=hash(key); keys[i]!=null; i=(i+1)%M)	//wrapping up of array
			if(keys[i].equals(key))
				vals[i]=val;
		keys[i]=key;
		vals[i]=val;
	}
	
	public Value get(Key key)
	{
		int i;
		for(i=hash(key); keys[i]!=null; i=(i+1)%M)
			if(keys[i].equals(key))
				return vals[i];
		return null;
	}
	
	/**
	 * Delete: Easiest way to delete is to find key-value pair & remove it and reinsert all of the key-value pairs in the same
	 * 		   cluster that appear after deleted key-value pair.
	 * 
	 * Alternative: Tomb-stone method or flagging
	 */
}
