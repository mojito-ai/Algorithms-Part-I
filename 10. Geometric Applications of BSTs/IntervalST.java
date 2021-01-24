/**
* <h1>Interval Search Trees: 1D interval search</h1>
*
* <li> Data structure to hold set of (overlapping) intervals : Interval1D
* <li> Insert an interval (lo,hi)
* <li> Search for an interval (lo,hi)
* <li> Delete an interval (lo,hi)
* <li> Interval Intersection query: Given an interval (lo,hi), find all intervals (or one interval) in data structure that
* 									intersects (lo,hi)
* <li>Non degenerate assumption: No two intervals have same left endpoint
* 
* @author  Mohit Sharma
* @version 1.0
* @since   11-01-2021
* 
*/

public class IntervalST<Key extends Comparable<Key>, Value> 
{
	private Node root;
	/**
	 * Create BST, where each node stores an interval (lo, hi)
	 * <li> Use left end-point as BST key
	 * <li> Store max end-point in subtree at node.
	 * 
	 */
	IntervalST()					//create interval search tree
	{
		// TreeMap<Key, Value> st=new TreeMap<>();
	}
	
	private class Node{
		
		Key lo;
		Key hi;
		Value val;
		Key max;
		Node left;
		Node right;
		
		@SuppressWarnings("unused")
		Node(Key lo, Key hi)
		{
			this.lo=lo;
			this.hi=hi;
		}
		
		public boolean intersects(Key lo, Key hi)
		{
			if(this.lo.compareTo(hi)>0)	return false;
			if(this.hi.compareTo(lo)<0)	return false;
			else 						return true;
		}
	}
	/**
	 * To insert a value (lo,hi)
	 * <li> Insert into BST, using 'lo' as key.
	 * <li> Update max in each node on search path.
	 * 
	 * @param lo
	 * @param hi
	 * @param val
	 */
	void put(Key lo, Key hi, Value val)			//put interval value pair into ST
	{
		
	}
	
	/**
	 * To search for ANY one interval that intersects query interval (lo, hi):
	 * <li> If interval in node intersects query interval, return it.
	 * <li> Else if left subtree empty, go right.
	 * <li> Else if max end-point in left subtree is less than lo, go right.
	 * <li> Else go left
	 * 
	 * @param lo
	 * @param hi
	 * @return
	 */
	Value get(Key lo, Key hi)		//value paired with given interval
	{
		/**
		 * Case 1: If search goes right, then no intersection in left
		 * <li> Max end-point in left subtree (max) is less than lo -> For any interval (a,b) in left subtree of x, we have b<=max<lo </li>
		 * 
		 * Case 2: If search goes left, then there is either an intersection in left subtree or no intersections at all.
		 * <li> Since went left, we have lo<=max.
		 * <li> Then for any interval (a.b) in right subtree of x, hi<c<=a. Therefore, no intersection in right.
		 * 
		 */
		Node x=root;
		while(x!=null)
		{
			if(x.intersects(lo,hi))	return x.val;
			else if(x.left==null)	x=x.right;
			else if(x.left.max.compareTo(lo)<0)	x=x.right;
			else 					x=x.left;
		}
		return null;
	}
	
	void delete(Key lo, Key hi)		//delete the given interval
	{	
	}
	Iterable<Value>	intersects(Key lo, Key hi)	//all intervals that intersect the given interval
	{
		return null;
	}
}
