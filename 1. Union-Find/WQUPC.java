/**
* "Weighted Quick Union with Path Compression approach to the Union Find problem
* WQUPC used with analysis going to c(N+M(lg*N)) or Ackermann function
*
* @author  Mohit Sharma
* @version 1.0
* @since   02-01-2021
*/

import java.util.HashSet;
import java.util.Set;

public class WQUPC {
	
	private int [] id;
	private int [] sz; //to store the size of each tree
	
	public WQUPC(int N) //constructor
	{
		id=new int[N];
		sz=new int[N];
		for(int i=0;i<N;i++)
			{
				id[i]=i;
				sz[i]=1;
			}
	}
	
	/*
	 * 1-pass implementation: Make every node point to the grandparent
	 * 
	 * 2-pass implementation: Make every node point to its root (The tree becomes flat with length 1)
	 */
	
	private int root(int i) 
	{
		while(i!=id[i])
			{
			 	id[i]=id[id[i]]; //1-pass variant
				i=id[i];
			}
		return i;
		
		/*
		 *2-pass variant 
		 * 
		 * {
		 * 		int temp=i;
		 * 		while(i!=id[i]) //finding the root
		 * 			i=id[i];
		 * 
		 * 		while(temp!=i)
		 * 			{
		 * 				int change=temp; 
		 * 				temp=id[temp];
		 * 				id[change]=i; //changing the previous node to point to root
		 * 			}
		 * }
		 * 
		 */
	}
	
	public boolean connected(int p, int q) // are p & q in the same component?
	{
		return root(p)==root(q);
	}
	
	public void union(int p, int q) //add connection between p & q making sure that larger tree is made the parental root
	{
		if(!connected(p,q))
		{
			int i=root(p);
			int j=root(q);
			if(sz[i]<sz[j]) {	id[i]=j;	sz[j]+=sz[i];	}
			else if(sz[j]<sz[i]) {	id[j]=i;	sz[i]+=sz[j];	}
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

	//can add driver code if required
}
