/**
* 2-Sum: Given N distinct integers, how many pairs of them are=0? 
* (Deeply related to problems in computational geometry)
* Analysis of Method: O(N^2).
* 
* @author  Mohit Sharma
* @version 1.0
* @since   03-01-2021
*/

public class TwoSumBrute {
	
	public static int count(int [] a) // Brute Force Two Sum
	{
		int count=0;
		int N=a.length;
		for(int i=0;i<N;i++)
			for(int j=i+1;j<N;j++)
					if(a[i]+a[j]==0)
						count++;
		
		return count;
	}
	
	public static void main(int [] args) //tester
	{
		System.out.println(TwoSumBrute.count(args));
//		System.out.println(TwoSumBrute.count(new int[] {1,2,3})); //Initialise array in function call/method argument
	}

}
