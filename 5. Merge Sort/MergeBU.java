/**
* <h1>Merge Sort: Critical component in the world's computational infrastructure. Java uses this to sort for objects.</h1>
* <li>Plan: Divide the array into two halves
* <li>Use an array to mimic the recursion operation. Repeat for sub-arrays of size 1,2,4,8,16....
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
public class MergeBU {

	private static Comparable [] aux;
	
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
	
	public static void sort(Comparable [] a)
	{
		int N=a.length;
		aux=new Comparable[N];
		for(int sz=1;sz<N;sz+=sz)
			for(int lo=0;lo<N-sz;lo+=sz+sz)
				merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1)); //at the end of array need to check which is minimum
	}
	
}