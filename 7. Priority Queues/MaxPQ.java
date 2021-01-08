/**
* <h1>Binary Heaps: Ingenious data structure to handle priority key operations. Based on the idea of complete binary tree</h1>
* 
* <li>Complete Binary Tree: A binary tree is empty or has a node with links to left and right tree. A complete Binary tree is perfectly balanced, except at bottom level.
* <li>Height of a complete tree is floor(lgN).
* <li>Priority Queue: Remove the largest (or smallest) item
* <li>Max oriented PQ
* <li>Generic items need to be comparable
* 
* @author  Mohit Sharma
* @version 1.0
* @since   08-01-2021
* 
*/

public class MaxPQ<Key extends Comparable<Key>> 
{
	private Key [] pq;
	private int N=0;
	
	/**
	 * Heap ordered Binary tree
	 * 
	 * <li>Key in nodes
	 * <li>Parent's key never smaller than children's keys.
	 * <li>We start from index 1
	 * <li>Take nodes in level order
	 * <li>No explicit links needed.
	 * 
	 * @param capacity
	 */
	
	@SuppressWarnings("unchecked")
	public MaxPQ(int capacity)		//create an empty priority queue
	{
		pq=(Key[])new Comparable[capacity+1];
	}
	
	public boolean isEmpty()			//is the priority queue empty?
	{
		return N==0;
	}
	
	/**
	 * <li>Add node at end. 
	 * <li>Swim it up. 
	 * <li> Cost is at most lgN + 1 compares
	 * @param v
	 */
	public void insert(Key v)			//insert a key into the priority queue
	{
		pq[++N]=v;
		swim(N);
	}
	
	/**
	 * <li>Exchange root with node at end.
	 * <li> Sink it down.
	 * <li>At most 2lgN compares
	 * 
	 * @return
	 */
	
	public Key delMax()					//remove and return the largest key
	{
		Key item=pq[1];
		exch(1,N--);
		sink(1);
		pq[N+1]=null;
		return item;
	}
	
	/**
	 * Promotion in Heap:
	 * 
	 * <li> Child's key becomes larger than it's parents key.
	 * <li> Exchange key in child with parent.
	 * <li> Repeat until heap order restored.</li>
	 * 
	 * Peter Principle: Node promoted to the level of incompetence. E.g. Getting promoted till it can't be better than boss. 
	 * @param k
	 * 
	 */
	
	private void swim(int k)
	{
		while(k>1 && less(k/2,k))
		{
			exch(k/2,k);
			k=k/2;
		}
	}
	
	/**
	 * Demotion in a heap: Parent's key becomes smaller than one (or both) of it's children
	 * 
	 * <li>Exchange key in parent with key in larger child.
	 * <li>Repeat until heap order restored.</li>
	 * 
	 * Power Struggle: Better subordinate promoted. E.g. Subordinate fighting if boss not able to perform well.
	 * @param k
	 */
	
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
	
	public void show()					//display the priority queue
	{
		for(int i=0;i<N;i++)
			System.out.print(pq[i]+" ");
	}
}

