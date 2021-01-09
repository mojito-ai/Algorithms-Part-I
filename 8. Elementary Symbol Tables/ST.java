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
	
	private class Node
	{
		Key key;
		Value val;
		Node left;
		Node right;
		
		Node(Key key, Value val)
		{
			this.key=key;
			this.val=val;
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
	
	public void put(Key key, Value val)	//put key-value pair in the table
	{
		root=put(root,key,val);
	}
	
	private Node put(Node x, Key key, Value val) //recursive code
	{
		if(x==null)		return new Node(key,val);
		int cmp=key.compareTo(x.key);
		if(cmp<0)
			x.left=put(x.left,key,val);
		else if(cmp>0)
			x.right=put(x.right,key,val);
		else if(cmp==0)
			x.val=val;
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
}
