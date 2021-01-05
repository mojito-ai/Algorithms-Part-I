/**
* Selection Sort: In iteration "i", find index min of smallest remaining entry. Swap a[i] with a[min]
* 
* Analysis: ~N²/2 compares and N exchanges
* Selection sort is insensitive to input. Would still take quadratic time if array is sorted.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   05-01-2021
*/
@SuppressWarnings("rawtypes") 
public class Selection {
	

	public static void sort(Comparable [] a)
	{
		int N=a.length;
		int min=0;
		for(int i=0;i<N;i++){
			min=i;
			for(int j=i+1;j<N;j++)
				if(less(a[j],a[min]))
					min=j;
			exch(a,i,min);
		}
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
	
	// print array to standard output
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
