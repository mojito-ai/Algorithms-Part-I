/**
* 3-Sum: Given N distinct integers, how many triplets of sum=0 are there? 
* (Deeply related to problems in computational geometry)
* Brute Force Method: O(N^3)
*
* @author  Mohit Sharma
* @version 1.0
* @since   03-01-2021
*/

public class ThreeSumBrute {
	
	public static int count(int [] a) // Brute Force Three Sum
	{
		int count=0;
		int N=a.length;
		for(int i=0;i<N;i++)
			for(int j=i+1;j<N;j++)
				for(int k=j+1;k<N;k++)
					if(a[i]+a[j]+a[k]==0)
						count++;
		
		return count;
	}
	
	public static void main(int [] args) //tester
	{
		System.out.println(ThreeSumBrute.count(args));
//		System.out.println(ThreeSumBrute.count(new int[] {1,2,3})); //Initialise array in function call/method argument
	}

}
