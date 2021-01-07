import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Insertion;
/**
* <h1>Quick Sort: One of the most important algorithms of 20th century. Java uses this to sort for objects. Developed by
* 				  Charles Anthony and Richard Hoare</h1>
* 
* <li>Plan: Shuffle the array
* <li>Partition the array so that, for some j
* <li>Entry a[j] is in place
* <li>No larger entry to the left of j
* <li>No smaller entry to the right of j
* <li>Sort each piece recursively.
* 
* <br>Performance Analysis:
* <li>Partitioning in place.
* <li>Terminating the loop: Trickier than it seems. (i==hi) condition is needed but the (j==lo) condition is redundant.
* <li>Preserving randomness: For performance guarantee.
* <li>Equal keys: When duplicates present, it is better to stop at equal keys.
* 
* @author  Mohit Sharma
* @version 4.0
* @since   07-01-2021
*/

@SuppressWarnings("rawtypes")
public class Quick {
	
	/**
	 * Repeat until i & j pointers cross:
	 * <li>Scan i from left to right so long as (a[i]<a[lo])
	 * <li>Scan j from right to left so long as (a[j]>a[lo])
	 * <li>Exchange a[i] with a[j]
	 * <li>When pointers cross, exchange a[lo] with a[j]
	 */
	
	private static int partition(Comparable [] a, int lo, int hi)
	{
		int i=lo;	int j=hi+1;
		while(true)
		{
			while(less(a[++i],a[lo]))	//find items on left to swap
				if(i==hi)
					break;
			
			while(less(a[lo],a[--j]))	//find items on right to swap
				if(j==lo)
					break;
				
			if(i>=j)	//check if pointers cross
				break;
			
			exch(a,i,j);	//swap
		}
		exch(a,lo,j);	//swap with partitioning item
		
		return j;	//return index of item now known to be in place
	}
	
	/**
	 * <li>Best case: Number of compares ~NlgN
	 * <li>Worst case: Number of compares ~N²/2
	 * <li>Average case: Number of compares ~2NlnN & exchanges is ~0.5NlnN
	 * <br>
	 * C(N) satisfies recurrence C0=C1=0 and for N>=2
	 * <li>Cn=(N+1)+(C0+Cn-1)/N+(C1+Cn-2)/N+-------------
	 * <li>By telescoping we find Cn~1.39NlgN
	 * <li>Random shuffle to escape this
	 * @param a
	 */
	public static void sort(Comparable [] a)
	{
		StdRandom.shuffle(a); //Random shuffling necessary to save from worst case
		int N=a.length;
		sort(a,0,N-1);
	}
	
	private static void sort(Comparable [] a, int lo, int hi)
	{
		if(hi<=lo+7-1)						//cutoff to insertion sort for small subarrays
			{
				Insertion.sort(a,lo,hi);
				return;
			}
		
		//Median of sample: Best choice of pivot
		//Estimate true median by taking median of sample.
		int m=medianof3(a,lo,lo+(hi-lo)/2,hi); 
		exch(a,lo,m);
		
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	@SuppressWarnings("unchecked")
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable [] a, int i, int j)
	{
		Comparable swap=a[i];
		a[i]=a[j];
		a[j]=swap;
	}
	
	private static int medianof3(Comparable [] a, int i, int j, int k)
	{
		if(less(a[j],a[i])!=less(a[k],a[i]))
			return i;
		else if(less(a[i],a[j])!=less(a[k],a[j]))
			return j;
		else 
			return k;	
	}
	
	public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
