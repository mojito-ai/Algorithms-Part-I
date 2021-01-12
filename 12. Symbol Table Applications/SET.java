/**
* <h1>Sets: A collection of distinct keys</h1>
* 
* <li> Implementation: Remove "Value" operation from any ST implementation
* <li> Application: 
* <li> Exception Filter:Read in a list of words from one file and print out all the words from input that are {in, not in} the list
* <li> Spam filter: Eliminate spam by using IP address as key.
* <li> Credit cards: Check for stolen credit cards by using number as key.
* <li> Java implementation: java.util.TreeSet
* 
* @author  Mohit Sharma
* @version 1.0
* @since   09-01-2021
* 
*/

public class SET<Key extends Comparable<Key>>
{
	private Node root;
	private int count;
	
	private class Node{
		Key key;
		Node left;
		Node right;
		Node(Key key)
		{
			this.key=key;
		}
	}
	
	SET()					//create an empty set
	{
		root=null;
		count=0;
	}
	
	public void add(Key key)		//add the key to the set
	{
		if(!contains(key)) {
			count++;
			root=add(root,key);
		}
	}
	private Node add(Node x, Key key)
	{
		if(x==null)	return new Node(key);
		int cmp=key.compareTo(x.key);
		if(cmp<0)	x.left=add(x.left,key);
		else if(cmp>0)	x.right=add(x.right,key);
		else x.key=key;
		return x;
	}
	
	public boolean contains(Key key)		//is the key in the set?
	{
		Node x=root;
		while(x!=null)
		{
			int cmp=key.compareTo(x.key);
			if(cmp<0)	x=x.left;
			else if(cmp>0)	x=x.right;
			else 	return true;
		}
		return false;
	}
	
	public void remove(Key key)
	{
		if(!contains(key)) {
			count--;
			root=remove(root,key);
		}
	}
	private Node remove(Node x, Key key)		//remove the key from the list
	{
		//Hibbard deletion
		if(x==null)	return null;
		int cmp=key.compareTo(x.key);
		if(cmp<0) x.left=remove(x.left,key);
		else if(cmp>0)	x.right=remove(x.right,key);
		else
		{
			if(x.left==null)	return x.right;
			if(x.right==null)	return x.left;
				
			Node t=x;
			x=min(t.right);
			x.right=deleteMin(t.right);
			x.left=t.left;
		}
		return x;
	}
	
	private Node min(Node x) //helper function
	{
		while(x.left!=null)
			x=x.left;
		return x;
	}
	
	private Node deleteMin(Node x) //helper function
	{
		if(x.left==null)	return x.right;
		x.left=deleteMin(x.left);
		return x;
	}
	
	public int size() 	//return the number of keys in the set
	{
		return count;
	}
	
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
	
	
}
