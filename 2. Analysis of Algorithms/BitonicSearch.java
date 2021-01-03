/**
 *Bitonic Search: An array is bitonic if it comprises of increasing sequence of integers followed by decreasing sequence
 *of integers. Given N-distinct integers in a bitonic array, determine whether a given number is in the array.
 *
 *1. Standard Version ~3lg N compares in worst case
 *	--> first find the maximum integer using ~lg N compares. Then divide the array into the increasing and decreasing parts
 *
 *2. Signing Bonus: ~2lg N compares in worst case
 *	--> Do it without finding the maximum integer 	
 *
 *	 We can modify the standard Binary Search algorithm for the given type of arrays.
 *	i) If the mid element is greater than both of its adjacent elements, then mid is the maximum.
 *	ii) If mid element is greater than its next element and smaller than the previous element then maximum lies on left side of mid. Example array: {3, 50, 10, 9, 7, 6}
 *	iii) If mid element is smaller than its next element and greater than the previous element then maximum lies on right side of mid. Example array: {2, 4, 6, 8, 10, 3, 1}
 * 
 * @author  Mohit Sharma
 * @version 1.0
 * @since   03-01-2021
 */

public class BitonicSearch {
	
	/*
	 * The right way to solve the problem in time ~ 2log(N) is to proceed as follows (assuming the array is first in ascending order and then in descending order):
	 * 
	 * 1. Take the middle of the array
	 * 2. Compare the middle element with one of its neighbour to see if the max is on the right or on the left
	 * 3. Compare the middle element with the desired value
	 * 4. If the middle element is smaller than the desired value AND the max is on the left side, then do bitonic search on the left subarray (we are sure that the value is not in the right subarray)
	 * 5. If the middle element is smaller than the desired value AND the max is on the right side, then do bitonic search on the right subarray
	 * 6. If the middle element is bigger than the desired value, then do descending binary search on the right subarray and ascending binary search on the left subarray.
	 *
	 *
	 *In the last case, it might be surprising to do a binary search on a subarray that may be bitonic but it actually 
	 *works because we know that the elements that are not in the good order are all bigger than the desired value. 
	 *For instance, doing an ascending binary search for the value 5 in the array [2, 4, 5, 6, 9, 8, 7] will work 
	 *because 7 and 8 are bigger than the desired value 5.
	 */
	
	//signing bonus version
	public static int search(int [] a, int key)
	{
		int N=a.length;
		int pos=-1;
		boolean right=false;
		int mid=(N-1)/2;
		
		if(a[mid]>a[mid-1])	right=true;
		else 	right=false;
		
		if(a[mid]<key && right==false) //case 1
			pos=BinarySearch(a,0,mid-1,key,true);
		
		else if(a[mid]<key && right==true) //case 2
			pos=BinarySearch(a,mid+1,N-1,key,true);
		
		else if(a[mid]>key) //case 3
		{
			pos=BinarySearch(a,0,mid-1,key,true);
			if(pos==-1)
				pos=BinarySearch(a,mid+1,N-1,key,false);
		}
		
		return pos;
		
	}
	
	private static int BinarySearch(int [] a, int lo, int hi, int key, boolean value)
	{
		int flag=0;
		if (value==true)	flag=1;		//ascending binary search
		if (value==false)	flag=-1;	//descending binary search
		
		while(lo<=hi)
		{
			//one 3-way compare
			int mid=lo+(hi-lo)/2;
			if(key<a[mid])	hi=mid-flag;
			else if(key>a[mid])	lo=mid+flag;
			else return mid;
		}
		
		return -1;
		
	}
}

/*
		public class BitonicSearch {
			
			//standard version
			public static int search(int [] a, int key)
			{
				int large=largest(a);
				int N=a.length;
				int lo=0;	int hi=N-1;
				if(key==a[large])	return large;
				else if(key<a[large])	hi=large-1;
				else if(key>a[large])	lo=large+1;
				
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
			
			private static int largest(int [] a)
			{
				//assert isBitonic(a);
				int N=a.length;
				int lo=1; int hi=N-2; //making sure that no array index out of bounds error
				int mid=lo+(hi-lo)/2;
				while(!(a[mid]>=a[mid-1] && a[mid]>=a[mid+1]))
				{
					mid=lo+(hi-lo)/2;
					
					if(a[mid]>=a[mid+1] && a[mid]<=a[mid-1])
						hi=mid-1;
					
					else if(a[mid]<=a[mid+1] && a[mid]>=a[mid-1])
						lo=mid+1;
				}
					
				return mid;
			}
		
		}
*/
