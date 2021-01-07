
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
* @author  Mohit Sharma
* @version 1.0
* @since   07-01-2021
*/

@SuppressWarnings("rawtypes")
public class Quick {
	
	private static int partition(Comparable [] a, int lo, int hi)
	{
		/**
		 * Repeat until i & j pointers cross:
		 * <li>Scan i from left to right so long as (a[i]<a[lo])
		 * <li>Scan j from right to left so long as (a[j]>a[lo])
		 * <li>Exchange a[i] with a[j]
		 * <li>When pointers cross, exchange a[lo] with a[j]
		 * 
		 */
		
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
	
	public static void sort(Comparable [] a)
	{
		int N=a.length;
		sort(a,0,N-1);
	}
	
	private static void sort(Comparable [] a, int lo, int hi)
	{
		if(hi<=lo)	return;
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
	
	public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
