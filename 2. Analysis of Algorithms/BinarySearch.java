/**
* Binary Search: Given a sorted array and a key, find index of key in array
* Analysis of Method: O(lg N).
* 
* @author  Mohit Sharma
* @version 1.0
* @since   03-01-2021
*/

public class BinarySearch {

	//If key appears in the array a[] -> a[lo]<a[mid]<a[hi]
	public static int Binary_Search(int [] a, int key) //sorted array a[]
	{
//		assert isSorted(a);
		int lo=0;
		int hi=a.length-1;
		while(lo<=hi)
		{
			//one 3-way compare
			int mid=lo+(hi-lo)/2;
			if(key<a[mid])	hi=mid-1;
			else if(key>a[mid])	lo=mid+1;
			else return mid;
		}
		
		return -1;
	}
}
