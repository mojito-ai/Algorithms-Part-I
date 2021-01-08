/**
* <h1>Heap Sort: Create max-heap with all N keys. Repeatedly remove the maximum key</h1>
* 
* <li>Heap construction: Build max heap using bottom up method. Start with an array and work from bottom up to make sure heap ordered.
* <li>Sort-down: Repeatedly delete the largest remaining item.
* 
* @author  Mohit Sharma
* @version 2.0
* @since   08-01-2021
* 
*/
	
@SuppressWarnings("rawtypes")
public class Heap {
	
	/**
	 * Analysis: Heap construction takes <=2N compares and exchanges
	 * <li>Heap-sort uses <=2NlgN compares and exchanges
	 * <li>First sorting algorithm that is in-place sorting with NlgN worst case.
	 * <li>Heap-sort is optimal with respect to time and space.
	 * <li>But, inner loop longer than qsort() and makes poor use of cache memory
	 * 
	 * @param pq
	 */

	public static void sort(Comparable [] pq)
	{
		int N=pq.length;
		for(int k=N/2;k>=1;k--)
			sink(pq,k,N);
		
		while(N>1)
		{
			exch(pq,1,N);
			sink(pq,1,--N);
		}
	}
	
	private static void sink(Comparable [] pq, int k, int N)
	{
		while(N>=2*k)
		{
			int j=2*k;
			if(j<N && less(pq,j,j+1))
				j=j+1;
			if(!less(pq,k,j))
				break;
			exch(pq,k,j);
			k=j;
		}
	}
	
	@SuppressWarnings("unchecked")
	private static boolean less(Comparable [] pq, int i, int j)	//helper functions
	{
		return pq[i].compareTo(pq[j])<0;
	}
	
	private static void exch(Comparable [] pq, int i, int j)	
	{
		Comparable swap=pq[i];
		pq[i]=pq[j];
		pq[j]=swap;
	}
}
