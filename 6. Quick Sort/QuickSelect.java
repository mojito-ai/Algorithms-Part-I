import edu.princeton.cs.algs4.StdRandom;
/**
* <h1>Quick Select:Given an array of N items, find the kth largest element</h1>
* 
* <li>Plan: Partition array same as Quick Sort
* <li>Repeat in one sub-array, depending on j, finished when j equals k
* 
* <br>Performance Analysis:
* <li>Used in order statistics
* 
* @author  Mohit Sharma
* @version 2.0
* @since   07-01-2021
*/

@SuppressWarnings("rawtypes")
public class QuickSelect {

	/**
	 * Emperical Analysis: Takes linear time on average.
	 * 
	 * <li>Method 1: N+N/2+N/4+-------+1 ~2N compares as each partition step splits array proportionally.
	 * 
	 * <li> Method 2: Formal analysis similar to quick-sort analysis yields
	 * <li>Cn=2N+2kln(N/k)+2(N-k)ln(N/(N-k)) --> (2+2ln2)N to find the median
	 * 
	 * @param a
	 * @param k
	 * @return
	 */

	public static Comparable select(Comparable [] a, int k)
	{
		StdRandom.shuffle(a);
		int lo=0;	int hi=a.length-1;
		while(hi>lo)
		{
			int j=partition(a,lo,hi);
			if(j<k)
				lo=j+1;
			else if(j>k)
				hi=j-1;
			else 
				return a[k];
		}
		return a[k];
	}

	private static int partition(Comparable [] a, int lo, int hi)
	{
		int i=lo;	int j=hi+1;
		while(true)
		{
			while(less(a[++i],a[lo]))
				if(i==hi)
					break;
			
			while(less(a[lo],a[--j]))
				if(j==lo)
					break;
			
			if(j<=i)
				break;
			
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	
	@SuppressWarnings("unchecked")
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w)<0;
	}
	
	private static void exch(Comparable [] a, int i, int j)
	{
		Comparable swap=a[i];
		a[i]=a[j];
		a[j]=swap;
	}
}
