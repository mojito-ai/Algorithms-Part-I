import java.util.Comparator;

/**
* Insertion Sort: In iteration "i", swap a[i] with each larger entry to its left.
* 
* <li>Analysis: To sort a randomly ordered array with distinct keys: ~N�/4 compares and ~N�/4 exchanges on average
* <li>Proof: Expect each entry to move halfway back
* <li>Best case analysis: N-1 compares & 0 exchanges to an already sorted array 
* <li>Insertion sort is stable
* <li>Comparator feature added for callbacks and function passing
* 
* @author  Mohit Sharma
* @version 2.0
* @since   06-01-2021
*/
@SuppressWarnings("rawtypes") 

public class Insertion {

	public static void sort(Comparable [] a)
	{
		int N=a.length;
		for(int i=0;i<N;i++){
			for(int j=i;j>0;j--)
				if(less(a[j],a[j-1]))
					exch(a,j,j-1);
				else
					break;
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
	
	public static void sort(Object [] a, Comparator comparator)
	{
		int N=a.length;
		for(int i=0;i<N;i++){
			for(int j=i;j>0;j--)
				if(less(comparator,a[j],a[j-1]))
					exch(a,j,j-1);
				else
					break;
		}
	}
	
	@SuppressWarnings("unchecked")
	private static boolean less(Comparator c, Object v, Object w)
	{
		return c.compare(v,w) < 0;
	}
	
	private static void exch(Object [] a, int i, int j)
	{
		Object swap=a[i];
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
