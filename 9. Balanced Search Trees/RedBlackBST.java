import ST.Node;
import edu.princeton.cs.algs4.Queue;

/**
* <h1>Red-Black BST: Left Leaning red-black BST (Guibas-Sedgewick 1979 & Sedgewick-2007).</h1>
* 
* <li>Represent 2-3 Tree as a BST
* <li>Use "Internal" left-leaning links as "glue" for 3-Nodes.
* <li>No node has two red links connected to it.
* <li>Every path from the root to a null link has same number of black lines.
* <li>Red lines lean left.
* 
* <li>Developed at XeroxPARC: There was only red ink in the laser printer hence the name.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   09-01-2021
* 
*/

public class RedBlackBST<Key extends Comparable<Key>,Value> {

		/**
		 * Red-Black BST: Left leaning red-black BST for perfect balance of black lines and symmetric order
		 */
	
		private Node root;		//Root of BST
		private static final boolean RED=true;
		private static final boolean BLACK=false;
		
		private class Node
		{
			private Key key;
			private Value val;
			private Node left;
			private Node right;
			private int count;
			private boolean color;
			
			Node(Key key, Value val, int count)
			{
				this.key=key;
				this.val=val;
				this.count=count;
			}
			
			Node(Key key, Value val, boolean color)
			{
				this.key=key;
				this.val=val;
				this.color=color;
			}
		}
		
		private boolean isRed(Node x)
		{			
			if(x==null)	return false;		//null links are black
			else 		return x.color==RED;
		}
		
		/**
		 * Left Orientation Rotation: Orient a (temporarily) right leaning red link to lean left
		 * @param h
		 * @return
		 */
		
		private Node rotateLeft(Node h)
		{
			assert isRed(h.right);
			Node x=h.right;
			h.right=x.left;
			x.left=h;
			x.color=h.color;
			h.color=RED;
			return x;
		}
		
		/**
		 * Right Orientation Rotation: Orient a left leaning red link to (temporarily) lean right
		 * @param h
		 * @return
		 */
		
		private Node rotateRight(Node h)
		{
			assert isRed(h.left);
			Node x=h.left;
			h.left=x.right;
			x.right=h;
			x.color=h.color;
			h.color=RED;
			return x;
		}
		
		/**
		 * Color Flip: Recolor to split a (temporary) 4-Node
		 */
		
		private void flipColors(Node h)
		{
			assert isRed(h.left);
			assert isRed(h.right);
			assert !isRed(h);
			h.left.color=BLACK;
			h.right.color=BLACK;
			h.color=RED;
		}
		
		public int size()  					//Number of key-value pairs
		{
			return size(root);
		}
		
		private int size(Node x)
		{
			if(x==null)	return 0;
			else return x.count;
		}
		

		/**
		 * <li>Insert: If less, go left.
		 * <li>If greater, go right.
		 * <li>If null, insert the key-value pair</li>
		 * <li>Maintain 1-1 correspondence with 2-3 Trees by applying elementary red-black BST operations
		 * 
		 * Cost: Number of compares is equal to 1+depth of Node
		 * 
		 * @param key
		 * @param val
		 */
		
		public void put(Key key, Value val)	//put key-value pair in the table
		{	
		/*
		 * Tree shape: Many BSTs can correspond to the same set of keys.
		 * <li>Number of compares for search/insert is equal to <=2lgN in worst case
		 * <li>Never two red links in a row.
		 */
			root=put(root,key,val);
		}
		
		private Node put(Node h, Key key, Value val) //recursive code
		{
			if(h==null)	return new Node(key,val,RED);
			int cmp=key.compareTo(h.key);
			if(cmp<0)	h.left=put(h.left,key,val);
			else if(cmp>0)	h.right=put(h.right,key,val);
			else if(cmp==0)	h.val=val;
			
			if(isRed(h.right) && !isRed(h.left))	rotateLeft(h);
			if(isRed(h.left) && isRed(h))			rotateRight(h);
			if(isRed(h.left) && isRed(h.right))		flipColors(h);
			
			return h;
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
			Node t=root;
			Node x=min(t);
			return x.key;
		}
		private Node min(Node x)
		{
			while(x.left!=null)
				x=x.left;
			return x;
		}
		
		public Key max()						//Largest key
		{
			Node t=root;
			Node x=max(t);
			return x.key;
		}
		private Node max(Node x)
		{
			while(x.right!=null)
				x=x.right;
			return x;
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
		 * Can also use the tomb-stone method for deleting but leads to memory overload
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
		 * Can also use the tomb-stone method for deleting but leads to memory overload
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
		
		/**
		 * Hibbard Deletion: To delete a node with key k, search for node t containing key k.
		 * 
		 * <li> Case 0: 0 children -> Delete t by setting the parent link to null.
		 * <li> Case 1: 1 children -> Delete t by replacing the parent link like in deleteMin & deleteMax
		 * <li> Case 2L 2 children -> Find successor x of t. (x has no left child)
		 * 						      Delete the minimum in t's right subtree. (But dont garbage collect x)
		 * 						      Put x in t's spot (Still a BST)
		 * 
		 * 
		 * @param key
		 */
		
		public void delete(Key key)
		{
			root=delete(root,key);
		}
		private Node delete(Node x, Key key)
		{
			if(x==null)	return null;
			int cmp=key.compareTo(x.key);
			if(cmp<0)	x.left=delete(x.left,key);
			else if(cmp>0)	x.right=delete(x.right,key);
			else {
				if(x.right==null)	return x.left;
				if(x.left==null)	return x.right;
				
				Node t=x;
				x=min(t.right);
				x.right=deleteMin(t.right);
				x.left=t.left;
			}
			x.count=size(x.left)+size(x.right)+1;
			return x;
		}
		
		/*
		 *Repeated Insertion and deletion leads to unsymmetric trees. Analysis goes to (N)^0.5 per operation. Also if the input
		 *is in order then worst case is occured.
		 */
	}


