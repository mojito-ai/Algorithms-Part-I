import edu.princeton.cs.algs4.Insertion;

/**
* <h1>Merge Sort: Critical component in the world's computational infrastructure. Java uses this to sort for objects.</h1>
* 
* <li>Plan: Divide the array into two halves
* <li>Recursively sort each half & merge the two halves
* <li>Divide & Conquer Algorithm
* <li>Analysis: O(NlgN) compares with O(N) auxiliary space
* <li>Analysis: ~NlgN compares & ~6NlgN array exchanges
* <li>Merge Sort is stable
* <li>Only N-1 compares used if optimization used: a[mid]<=a[mid+1] --> return
* 
* @author  Mohit Sharma
* @version 2.0
* @since   06-01-2021
*/

@SuppressWarnings("rawtypes")
public class Merge {

	private static void merge(Comparable [] a, Comparable [] aux, int lo, int mid, int hi) 
	{
		//assert isSorted(a,lo,mid);
		//assert isSorted(a,mid+1,hi);
		
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];
		
		int i=lo;	int j=mid+1;
		for(int k=lo;k<=hi;k++) 
		{
			if(i>mid)						a[k]=aux[j++];
			else if(j>hi)					a[k]=aux[i++];
			else if(less(aux[j],aux[i]))	a[k]=aux[j++];
			else if(less(aux[i],aux[j]))	a[k]=aux[i++];
		}
		//aasert isSorted(a,lo,hi)
	}
	
	@SuppressWarnings("unchecked")
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	private static void sort(Comparable [] a, Comparable [] aux, int lo, int hi)
	{
		if(hi<=lo+7-1) //cutoff to Insertion sort for array size less than 7	
		{
			Insertion.sort(a,lo,hi);
			return;
		}
		int mid=lo+(hi-lo)/2;
		sort(a,aux,lo,mid);
		sort(a,aux,mid+1,hi);
		if(!less(a[mid+1],a[mid])) //Helps for partially sorted arrays.
			return;
		merge(a,aux,lo,mid,hi);
	}
	
	public static void sort(Comparable [] a)
	{
		Comparable [] aux=new Comparable[a.length];
		sort(a,aux,0,a.length-1);
	}
	
	/*Eliminate the copy of Auxiliary array, by switching the role of the input and the output in each recursive call.
	 * 
	 * private static void merge(a,aux,lo,mid,hi)
	 * {
	 * 		----------
	 * 		----------
	 * 		{	
	 * 			if(i>mid)					aux[k]=a[j++];
	 * 			else if(j>hi)				aux[k]=a[i++];
	 * 			else if(less(a[j],a[i])		aux[k]=a[j++];
	 * 			else if(less(a[i],a[j])		aux[k]=a[i++];
	 * 		}
	 * }
	 * 
	 * private static void sort(a,aux,lo,mid,hi)
	 * {
	 * 		----------
	 * 		----------
	 * 		sort(aux,a,lo,mid);
	 * 		sort(aux,a,mid+1,hi);
	 * 		merge(a,aux,lo,mid,hi);
	 * }
	 * 
	 */
}
