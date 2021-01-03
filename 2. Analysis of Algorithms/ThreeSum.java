/**
* Three Sum: Given N distinct integers, how many triplets of sum=0 are there? 
* (Deeply related to problems in computational geometry)
* 1. Brute Force Method: O(N^3)
* 2. Improved using Binary Search: O(N^2logN) 
* 3. Improved using Double pointers: O(N^2)
* 
* @author  Mohit Sharma
* @version 1.0
* @since   03-01-2021
*/



public class ThreeSum {
	/**
	 *Start two pointers, one at either end of the array. Check their sum. If it's too small, move lesser pointer up one space
	 *Its too big, move the greater pointer down one space. If pointers meet then you dont find solution.
	 * 
	 * @param a
	 * @return
	 */
	public static int count(int [] a)
	{
		//assert isSorted(a);
		int N=a.length;
		int count=0;
		int min=0;	int max=N-1;
		for(int i=0;i<N;i++)
			while(min<max)
			{
				if(-a[i]<(a[min]+a[max]))	max--;
				else if(-a[i]<(a[min]+a[max]))	min++;
				else	
					{
						count++;
						break;
					}
			}
		
		return count;
	}

}

/*
	class ImprovedThreeSum{
		
		//a. Sort the N(distinct) numbers
		//b. For each pair of numbers a[i] & a[j], binary search for -(a[i]+a[j])
		public static int count(int [] a)
		{
			//assert isSorted(a);
			int count=0;
			int N=a.length;
			for(int i=0;i<N;i++)
				for(int j=i+1;j<N;j++) 
				{
					int bin_search=BinarySearch.Binary_Search(a, -(a[i]+a[j]));
					if(bin_search!=-1)
						count++;
				}
			
			return count;
		}
	}

*/