/**
* Insertion Sort: In iteration "i", swap a[i] with each larger entry to its left.
* 
* <li>Analysis: To sort a randomly ordered array with distinct keys: ~N²/4 compares and ~N²/4 exchanges on average
* <li>Proof: Expect each entry to move halfway back
* <li>Best case analysis: N-1 compares & 0 exchanges to an already sorted array 
* <li>Insertion sort is stable
* 
* @author  Mohit Sharma
* @version 1.0
* @since   05-01-2021
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
	
	// print array to standard output
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
