import edu.princeton.cs.algs4.StdRandom;
/**
* <h1>Knuth Sort: In iteration i, pick integer r between 0 & i uniformly at random. Swap a[i] & a[r]</h1>
*
* <li>Analysis: Linear time taken to produce random permutation
* <li>Note: In iteration i, pick either between (0 & i) or (i & N-1). Don't pick between (0 & N-1). 
* 
* <blockquote> The generation of Random numbers is too important to be left to chance - Robert R. Coveyou" </blockquote>
* 
* @author  Mohit Sharma
* @version 1.0
* @since   05-01-2021
* 
*/


@SuppressWarnings("rawtypes") 

public class Knuth {

	public static void shuffle(Object [] a)
	{	
		int N=a.length;
		for(int i=0;i<N;i++)
		{
			int r=StdRandom.uniform(i+1);
			exch(a,i,r);
		}
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

