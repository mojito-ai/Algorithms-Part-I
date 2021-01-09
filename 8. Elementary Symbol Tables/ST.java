import edu.princeton.cs.algs4.Queue;

/**
* <h1>Symbol Table: Insert a value with specified key. Given a key, search for the corresponding value.</h1>
* 
* <li>Associative array: Associate one value with each key
* <li>Applications: Purpose of Search=Dictionary | Key=word | Value=definition
* <li>Purpose of Search=Financial Account | Key=Account number | Value=Transaction details
* <li>Assume Keys are comparable, use compareTo()
* <li>Assume Keys are generic types, use equals() to test equality. Use hashCode() to scramble key.
* <li>Use immutable keys for symbol table keys.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   09-01-2021
* 
*/

public class ST<Key extends Comparable<Key>,Value> 
{
	/**
	 * Binary Search Trees: A binary tree in symmetric order. In binary heaps we talked about implicit representation of 
	 * trees within array. For BST we talk about actual explicit representation of tree data structure.
	 * 
	 * <li>Symmetric order: Each node has a key and a value. And every node is larger than all the keys on its left subtree.
	 * And its is smaller than all the keys on the right subtree.
	 * <li>A BST is a reference to the Root Node. A Node comprises of: Key, Value, Left link & Right link
	 * 
	 */
	private Node root;		//Root of BST
	
	/**
	 * Correspondence between BSTs and quicksort partitioning: Exactly same if array has no duplicate keys.
	 * <li>Analysis: If N-distinct keys are inserted in a BST in random order, the expected number of compares for a 
	 * 				 search/insert is ~2lnN or ~1.38lgN
	 * <li>Reed 2003: Expected height of tree is ~4.311lnN when N distinct keys are inserted in random order
	 * <li>Worst case height still N
	 *
	 */
	
	private class Node
	{
		private Key key;
		private Value val;
		private Node left;
		private Node right;
		private int count;
		
		Node(Key key, Value val, int count)
		{
			this.key=key;
			this.val=val;
			this.count=count;
		}
	}
	
	/**
	 * <li>Insert: If less, go left.
	 * <li>If greater, go right.
	 * <li>If null, insert the key-value pair</li>
	 * 
	 * Cost: Number of compares is equal to 1+depth of Node
	 * 
	 * @param key
	 * @param val
	 */
	
	public int size()  					//Number of key-value pairs
	{
		return size(root);
	}
	
	private int size(Node x)
	{
		if(x==null)	return 0;
		else return x.count;
	}
	
	public void put(Key key, Value val)	//put key-value pair in the table
	{	
	/*
	 * Tree shape: Many BSTs can correspond to the same set of keys.
	 * <li>Number of compares for search/insert is equal to 1+depth of node.
	 * <li>Worst case when keys entered in order
	 */
		root=put(root,key,val);
	}
	
	private Node put(Node x, Key key, Value val) //recursive code
	{
		if(x==null)		return new Node(key,val,1);
		int cmp=key.compareTo(x.key);
		if(cmp<0)
			x.left=put(x.left,key,val);
		else if(cmp>0)
			x.right=put(x.right,key,val);
		else if(cmp==0)
			x.val=val;
		x.count=1+size(x.left)+size(x.right);
		return x;
	}
	
	/**
	 * <li>Search: If less, go left. 
	 * <li>If greater, go right.
	 * <li>If equal,search hit</li>
	 * 
	 * Cost: Number of compares if 1+depth of Node
	 * 
	 * @param key
	 * @return
	 */
	
	public Value get(Key key)				//Value passed with Key(Null if key is absent)
	{
		Node x=root;
		while(x!=null)
		{
			int cmp=key.compareTo(x.key);
			if(cmp<0)	x=x.left;
			else if(cmp>0)	x=x.right;
			else if(cmp==0)	return x.val;
		}
		return null;
	}
	
	public Key min()						//Smallest key
	{
		Node x=root;
		while(x.left!=null)
			x=x.left;
		return x.key;
	}
	
	public Key max()						//Largest key
	{
		Node x=root;
		while(x.right!=null)
			x=x.right;
		return x.key;
	}
	
	/**
	 * Floor: largest key<=given key
	 * <li>Case 1: k is equal to the key at root -> The floor of k is k
	 * <li>Case 2: k is less than the key at root -> The floor of k is in the left subtree.
	 * <li>Case 3: k is greater than the key at root -> The floor of k lies in the right subtree if there is any key<=k 
	 * 													in right subtree. Otherwise it is the key at root.
	 * 
	 * @param key
	 * @return
	 */
	
	public Key floor(Key key)				//largest key less than or equal to the given key
	{
		Node x=floor(root,key);
		if(x!=null)
			return x.key;
		else return null;
	}
	
	private Node floor(Node x, Key key)
	{
		if(x==null)	return null;
		int cmp=key.compareTo(x.key);
		if(cmp==0)
			return x;
		else if(cmp<0)
			return floor(x.left,key);
		else
		{
			Node t=floor(x.right,key);
			if(t!=null)	return t;
			else return x;
		}
	}
	
	/**
	 * Ceiling: smallest key>=given key
	 * <li>Case 1: k is equal to the key at root -> The floor of k is k
	 * <li>Case 2: k is less than the key at root -> The floor of k is in the right subtree.
	 * <li>Case 3: k is greater than the key at root -> The floor of k lies in the left subtree if there is any key<=k 
	 * 													in right subtree. Otherwise it is the key at root.
	 * 
	 * @param key
	 * @return
	 */
	
	public Key ceiling(Key key)				//smallest key greater than or equal to the given key
	{
		Node x=ceiling(root,key);
		if(x!=null)
			return x.key;
		else return null;
	}
	
	private Node ceiling(Node x, Key key)
	{
		if(x==null)	return null;
		int cmp=key.compareTo(x.key);
		if(cmp==0)
			return x;
		else if(cmp<0)
			return ceiling(x.right,key);
		else
		{
			Node t=ceiling(x.left,key);
			if(t!=null)	return t;
			else return x;
		}
	}
	
	/**
	 * Rank: How many keys <= k
	 * 
	 * @param key
	 * @return
	 */
	public int rank(Key key)
	{
		return rank(root,key);
	}
	
	private int rank(Node x, Key key)
	{
		if(x==null)	return 0;
		int cmp=key.compareTo(x.key);
		if(cmp<0)	return rank(x.left,key);
		else if(cmp>0)	return 1+size(x.left)+rank(x.right,key);
		else return size(x.left);
	}
	
	/**
	 * Inorder Traversal: Traverse left subtree -> Enqueue key -> Traverse right subtree
	 * 
	 * <li> Yields keys in ascending order
	 */

	public Iterable<Key> Keys()
	{
		Queue<Key> q=new Queue<>();
		Inorder(root,q);
		return q;
	}
	
	private void Inorder(Node x, Queue<Key> q)
	{
		if(x==null)	return;
		Inorder(x.left,q);
		q.enqueue(x.key);
		Inorder(x.right,q);
	}
	
	/**
	 * Delete the Minimum: 
	 * <li> Go left until finding a node with null left link
	 * <li> Replace that node by its right link
	 * <li> Update subtree counts.
	 * 
	 */
	
	public void deleteMin()				//delete smallest key
	{
		root=deleteMin(root);
	}
	private Node deleteMin(Node x)
	{
		if(x.left==null)	return x.right;
		x.left=deleteMin(x.left);
		x.count=1+size(x.left)+size(x.right);
		return x;
	}
	
	/**
	 * Delete the Maximum: 
	 * <li> Go right until finding a node with null right link
	 * <li> Replace that node by its left link
	 * <li> Update subtree counts.
	 * 
	 */
	public void deleteMax()				//delete largest key
	{
		root=deleteMax(root);
	}
	private Node deleteMax(Node x)
	{
		if(x.right==null)	return x.left;
		x.right=deleteMax(x.right);
		x.count=1+size(x.left)+size(x.right);
		return x;
	}
}
