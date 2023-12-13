package com.brianc.testRepo;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class MergeSortLongHand {

	private static void mergeSort(int[] inputArray) {
		
		int inputLength = inputArray.length;
  	    
  	    if (inputLength < 2) { return; }
  	    
  	    int midIndex = inputLength / 2;
  	    int[] leftHalf = new int[midIndex];
  	    int[] rightHalf = new int[inputLength - midIndex];
  	    
  	    for (int i = 0; i < midIndex; i++) {
  	      leftHalf[i] = inputArray[i];
  	    }
  	    for (int i = midIndex; i < inputLength; i++) {
  	      rightHalf[i - midIndex] = inputArray[i];
  	    }
  	    
  	    mergeSort(leftHalf);
  	    mergeSort(rightHalf);
  	    
  	    merge(inputArray, leftHalf, rightHalf);
	}

	private static void merge (int[] inputArray, int[] leftHalf, int[] rightHalf) {
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;
  	    
  	    int leftIndex = 0, rightIndex = 0, mergeIndex = 0;
  	    
  	    while (leftIndex < leftSize && rightIndex < rightSize) {
  	    	
  	      if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
  	    	  
  	        inputArray[mergeIndex] = leftHalf[leftIndex];
  	        leftIndex++;
  	      }
  	      else {
  	        inputArray[mergeIndex] = rightHalf[rightIndex];
  	        rightIndex++;
  	      }
  	      mergeIndex++;
  	    }
  	    
  	    while (leftIndex < leftSize) {
  	      inputArray[mergeIndex] = leftHalf[leftIndex];
  	      leftIndex++;
  	      mergeIndex++;
  	    }
  	    
  	    while (rightIndex < rightSize) {
  	      inputArray[mergeIndex] = rightHalf[rightIndex];
  	      rightIndex++;
  	      mergeIndex++;
  	    }
	}
	
	private static void printArray(int[] numbers) {
  	    for (int i = 0; i < numbers.length; i++) {
  	      System.out.print(numbers[i] + ", ");
  	    }
  	    System.out.println( "" );
	}

	public static void main(String args[]) {
		
		Random rand = new Random();
		int[] numbers = new int[10000];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(1000000);
		}

//		System.out.println("Before:");
		//printArray(numbers);

		mergeSort(numbers); 

		System.out.println("\nAfter:");
		printArray(numbers);
	}
 }