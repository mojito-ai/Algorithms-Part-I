import ST.Node;

/**
* <h1>1-D Range Search: (1-Key) Geometric Interpretation: Keys are points on a line. Find/Count points in a given 1-d interval</h1>
*
* <li> Extension of ordered symbol tables
* <li> Insert a key-value pair.
* <li> Search for a key k
* <li> Delete a key k
* <li> Range Search: Find all keys between k1 & k2.
* <li> Range Count: Number of keys between k1 & k2.
* 
* <li>Application: Database Queries
* 
* @author  Mohit Sharma
* @version 1.0
* @since   11-01-2021
* 
*/

public class OneDimRangeSearch<Key extends Comparable<Key>, Value> extends ST<Key, Value> {
	
	private ST<Key, Value> st;
	public OneDimRangeSearch(ST<Key, Value> st)
	{
		this.st=st;
	}
	
	/**
	 * 1D range count: How many keys between lo & hi.
	 * <li> Running Time: lgN
	 * <li> Nodes examined = search path to lo + search path to hi
	 * @param lo
	 * @param hi
	 * @return
	 */
	public int size(Key lo, Key hi)
	{
		if(st.get(hi)!=null)	return st.rank(hi)-st.rank(lo)+1;
		else 					return st.rank(hi)-st.rank(lo);
	}
	
	/**
	 * Range Search: Find all keys between lo & hi
	 * <li> Recursively find all keys in left subtree(if any could fall in the range)
	 * <li> Check key in current node.
	 * <li> Recursively find all keys in the right subtree (if any could fall in the range)
	 * <li> Running time: R+lgN where R is the number of keys that match.
	 * 
	 */
	
	public Iterable<Key> search(Key lo, Key hi)
	{
		Queue<Key> q=new Queue<>();
		Node x=st.root;
		search(q, x, lo, hi);
		return q;
	}
	

	private void search(Queue<Key> q, Node x, Key lo, Key hi)				
	{
		
		
	}
	
	
	

}
