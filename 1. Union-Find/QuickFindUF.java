/**
* An eager implementation to the Union Find problem
* Quick Find used with union operation being O(N) whereas find operation is O(1)
*
* @author  Mohit Sharma
* @version 1.0
* @since   01-01-2021
*/

import java.util.*;

import edu.princeton.cs.algs4.StdIn;
public class QuickFindUF {
	
	private int [] id;
	
	public QuickFindUF(int N)
	{
		id=new int[N];
		for(int i=0;i<N;i++)
			id[i]=i;
	}
	
	void union(int p, int q)
	{
		int p_id=id[p];
		int q_id=id[q];
		for(int i=0;i<id.length;i++)
			if(id[i]==p_id)
				id[i]=q_id;
	}
	
	boolean connected(int p, int q)
	{
		return (id[p]==id[q]);
	}
		
	int count()
	{
		Set<Integer> hash_Set = new HashSet<>(); 
		for(int i=0;i<id.length;i++)
			hash_Set.add(id[i]);
		
		return hash_Set.size();
	}

	public static void main(String [] args)
	{
		int N=StdIn.readInt();
		QuickFindUF UF=new QuickFindUF(N);
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
	
	

