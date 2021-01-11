import java.util.HashMap;
//import java.util.Hashtable;
/**
* <h1>4-SUM: Given an array a[] of n-integers, the 4-sum problems asks if there exists i,j,k,l such that a[i]+a[j]=a[k]+a[l]</h1>
* 
* <li> Brute Force: N^4
* <li> Improved Time: N^2
* 
* @author  Mohit Sharma
* @version 1.0
* @since   09-01-2021
* 
*/

public class Sum4 {

	private static HashMap<Integer, Node> map;
	
	Sum4(Integer [] a)
	{
		map=new HashMap<>();
		int N=a.length;
		for(int i=0;i<N;i++)
			for(int j=i+1;j<N;j++)
				map.put(a[i]+a[j], new Node(i,j));
	}
	
	private class Node{
		private int index1;
		private int index2;
		Node(int i, int j)
		{
			this.index1=i;
			this.index2=j;
		}
	}
	
	private void sum(Integer [] a)
	{
		int N=a.length;
		int count=0;
		for(int i=0;i<N;i++)
			for(int j=i+1;j<N;j++)
			{
				Node x=map.get(-(a[i]+a[j]));
				if(x!=null)
				{
					count++;
					System.out.printf("Indices= %d %d %d %d \n", i, j, x.index1, x.index2 );
				}
			}
		
		System.out.println("Total 4-Sum: "+count);	
	}
	
	public static void main(String [] args) //Driver code
	{
		Integer a[]={-4,-3,-2,-1,0,1,2,3,4};
		Sum4 sum=new Sum4(a);
		sum.sum(a);
	}
	
	
}
