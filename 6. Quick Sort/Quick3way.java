import edu.princeton.cs.algs4.StdRandom;
/**
* <h1>Quick3way :In case of duplicate keys, Quicksort may take ~N²/2 time (when not stopping at equal elements)
* 				 and time ~NlgN (when stopping at equal keys to partitioning item)</h1>
* 
* <li>Plan: Partition array into 3 parts so that
* <li>Entries between lt and gt equal to the partition element v.
* <li>No larger entries to the left of lt.
* <li>No smaller entries to the right of gt.
* 
* <li>Dutch National Flag Problem [Edsger W. Dijkstra]
* 
* <br>Performance Analysis:
* <li>Used in order statistics
* 
* @author  Mohit Sharma
* @version 2.0
* @since   07-01-2021
*/

@SuppressWarnings("rawtypes")
public class Quick3way {
	
	/**
	 * Let the partitioning item be v=a[lo]
	 * <li>Scan i from left to right
	 * <li>a[i]<v = exchange a[lt] with a[i]. Increment both lt and i.
	 * <li>a[i]>v = exchange a[gt] with a[i]. Decrement gt
	 * <li>a[i]==v = increment i
	 * 
	 */

	@SuppressWarnings("unchecked")
	private static void sort(Comparable [] a, int lo, int hi)
	{
		if(hi<=lo)	return;
		int lt=lo;	int gt=hi;
		Comparable v=a[lo];
		int i=lo;
		while(i<=gt)
		{
			int cmp=a[i].compareTo(v);
			if(cmp<0)	exch(a,lt++,i++);
			else if(cmp>0)	exch(a,i,gt--);
			else	i++;
		}
		
		sort(a,lo,lt-1);
		sort(a,gt+1,hi);
	}
	
	private static void exch(Comparable [] a, int i, int j)
	{
		Comparable swap=a[i];
		a[i]=a[j];
		a[j]=swap;
	}
	
	/**
	 * Emperical analysis:
	 * <li>If there are n-distinct keys and the ith one occurs Xi times, any compare based sorting algorithm uses atleast
	 * <li>lg(N!/(X1!*X2!-----Xn!) ~ -∑Xilg(Xi/N)
	 * <li>Quicksort with 3-way partitioning is entropy optimal.
	 * 
	 * @param a
	 */
	public static void sort(Comparable [] a)
	{
		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
	}

}
