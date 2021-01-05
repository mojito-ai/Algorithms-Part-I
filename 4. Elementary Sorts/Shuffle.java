/**
* <h1>Shuffle Sort: Generate a random real number for each array entry and sort the array</h1>
*
* <li>Analysis: Depends on the sorting algorithm used to sort the array 
* <li>Drawback: Need to pay the cost of sort
* 
* @author  Mohit Sharma
* @version 1.0
* @since   05-01-2021
* 
*/

import java.util.Random;
@SuppressWarnings("rawtypes") 
public class Shuffle {

	public static void sort(Comparable [] a)
	{	
		int N=a.length;
		Random rd = new Random(); // creating Random object
	    Integer[] arr = new Integer[N];
	    for (int i = 0; i < arr.length; i++) 
	    arr[i] = rd.nextInt(); // storing random integers in an array

		int h=1;
		while(h<N/3)	
			h=3*h+1;
		
		while(h>=1) {
			for(int i=h;i<N;i++){
				for(int j=i;j>=h && less(arr[j],arr[j-h]);j-=h) {
						exch(arr,j,j-h);
						exch(a,j,j-h);
				}
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
