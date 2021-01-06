/**
* <h1>Merge Sort: Critical component in the world's computational infrastructure. Java uses this to sort for objects.</h1>
* 
* <li>Plan: Divide the array into two halves
* <li>Recursively sort each half & merge the two halves
* <li>Divide & Conquer Algorithm
* <li>Analysis: O(NlgN) compares with O(N) auxiliary space
* <li>Analysis: ~NlgN compares & ~6NlgN array exchanges
* <li>Merge Sort is stable
* 
* @author  Mohit Sharma
* @version 1.0
* @since   05-01-2021
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
		for(int k=lo;k<=hi;k++) {
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
		if(hi<=lo)	return;
		int mid=lo+(hi-lo)/2;
		sort(a,aux,lo,mid);
		sort(a,aux,mid+1,hi);
		merge(a,aux,lo,mid,hi);
	}
	
	public static void sort(Comparable [] a)
	{
		Comparable [] aux=new Comparable[a.length];
		sort(a,aux,0,a.length-1);
	}
}
