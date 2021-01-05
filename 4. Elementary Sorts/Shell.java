/**
* <h1>Shell Sort: Move entries more than one position at a time by h-sorting an array. h-sort array for decreasing 
* sequence of values of h</h1>
* 
* <li>Shell sort is basically insertion sort but with stride length h
* <li>A g-sorted array remains g-sorted after h-sorting it.
* <li>Analysis: Number of compares is O(N^(3/2)) with 3x+1 increments
* <li>Shell sort is unstable
* 
* @author  Mohit Sharma
* @version 1.0
* @since   05-01-2021
* 
*/
@SuppressWarnings("rawtypes") 


public class Shell {

	public static void sort(Comparable [] a)
	{
		/**
		 * Insertion sequences:
		 * 
		 * <li>Powers of 2: 1,2,4,8..... [Not good as odd indexes not checked]
		 * <li>Powers of 2n-1: 1,3,7,15...[maybe]
		 * <li>3x+1: 1,4,13,40,121....[Knuth]
		 * <li>merging of (9*4^i)-(9*2^i)+1 & 4^i-(3*2^i)+!: 1,5,19,41,109,209.....[Sedgewick]
		 * 
		 */
		
		int N=a.length;
		int h=1;
		while(h<N/3)	
			h=3*h+1;
		while(h>=1) {
			for(int i=h;i<N;i++){
				for(int j=i;j>=h && less(a[j],a[j-h]);j-=h)
						exch(a,j,j-h);
			}
			h=h/3;
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

