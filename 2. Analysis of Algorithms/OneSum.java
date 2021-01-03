/**
* 1-Sum: Given N distinct integers, how many of them are=0? 
* (Deeply related to problems in computational geometry)
* Analysis of Method: O(N).
* Optimal Algorithm as upper bounds = lower bounds in this case
*
* @author  Mohit Sharma
* @version 1.0
* @since   03-01-2021
*/

public class OneSum {

	public static int count(int [] a) // One Sum
	{
		int count=0;
		int N=a.length;
		for(int i=0;i<N;i++)
			if(a[i]==0)
				count++;
		
		return count;
	}
	
	public static void main(int [] args) //tester
	{
		System.out.println(OneSum.count(args));
//		System.out.println(OneSum.count(new int[] {1,2,3})); //Initialise array in function call/method argument
	}

}
