package com.brianc.testRepo;

public class BinarySearchArray {


	public static int binarySearch(int arr[],int key) {

		int low = arr[0];
		int high = arr[ arr.length - 1 ];
		int mid = (low + high) / 2;

		while (low <= high) {
			if (arr[mid] < key) {
				low = mid + 1;
			} else if (arr[mid] == key) {
				return mid;
			} else {
				high = mid - 1;
			}
			mid = (low + high) / 2;
		}

		if (low > high) {
			return -1;
		}

		return -1;
	}
	    public static void main(String args[]) {
	    	
	      int val = binarySearch( new int[] {1,2,3,4,5}, 1 );
	      
	      System.out.println( val );
	   	} 
}
