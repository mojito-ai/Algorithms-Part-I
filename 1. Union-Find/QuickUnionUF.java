
/**
* Lazy implementation to the Union Find problem
* Quick Union used with union operation being O(N) whereas find operation is O(N)
*
* @author  Mohit Sharma
* @version 1.0
* @since   02-01-2021
*/

import java.util.HashSet;
import java.util.Set;

import edu.princeton.cs.algs4.StdIn;

public class QuickUnionUF {
	
	private int [] id;
	public QuickUnionUF(int N) //initialize the union find data structure with N-objects (O to N-1)
	{
		id=new int[N];
		for(int i=0;i<id.length;i++)
			id[i]=i;
	}
	
	private int root(int i) 
	{
		while(i!=id[i])
			i=id[i];
		return i;
	}
	
	public boolean connected(int p, int q) // are p & q in the same component?
	{
		return root(p)==root(q);
	}
	
	public void union(int p, int q) //add connection between p & q
	{
		if(!connected(p,q))
		{
			int i=root(p);
			int j=root(q);
			id[i]=j;
		}
	}
	
	public int find(int p) //component identifier
	{
		return root(p);
	}
	
	public int count() // number of components
	{
		Set<Integer> hash_Set = new HashSet<>(); 
		for(int i=0;i<id.length;i++)
			hash_Set.add(root(i));
		
		return hash_Set.size();
	}
	
	public static void main(String [] args)
	{
		int N=StdIn.readInt();
		QuickUnionUF UF=new QuickUnionUF(N);
		while(!StdIn.isEmpty())
		{
			int p=StdIn.readInt();
			int q=StdIn.readInt();
			if(!UF.connected(p, q))
			{
				UF.union(p, q);
				System.out.println(p+" "+q);
			}
		}
	}
}
