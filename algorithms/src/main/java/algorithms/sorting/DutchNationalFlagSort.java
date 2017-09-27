package algorithms.sorting;

/**
 * Filename : DutchNationalFlagSort.java
 * Class : DutchNationalFlagSort
 * Author :keyur.mahajan
 * Date : Sep 27, 2017
 * 
 * Description: Sort array with 0 at start 2 at end and 1 in middle.
 * -> here we will maintain three pointer, low, mid and high
 * -> we will try to maintain 1 at mid indexes
 * -> if mid index read 0 then swap with low index and increase low index
 * -> if mid index reads 2 then swap with high index and decrement high index
 * 
 */

public class DutchNationalFlagSort {

	public static void main(String[] args) {
		int[] intArray = { 2, 1, 1, 0, 2, 2, 0, 1, 1, 0, 2, 1, 1, 1, 1, 1 };
		printArray(intArray);
		sort(intArray);
		printArray(intArray);
	}


	private static void sort(int[] intArray) {
		int low = 0, mid = 0, high = intArray.length - 1;
		while (mid <= high) {
			int value = intArray[mid];
			if (value == 0) {
				swapValues(intArray, low, mid);
				low++;
				mid++;
			} else if (value == 1) {
				mid++;
			} else if (value == 2) {
				swapValues(intArray, high, mid);
				high--;
			}
		}
	}
	private static void swapValues(int[] intArray, int v1, int v2) {
		int temp = intArray[v1];
		intArray[v1] = intArray[v2];
		intArray[v2] = temp;
	}
	private static void printArray(int[] intArray) {
		for (int i : intArray) {
			System.out.print(" " + i);
		}
		System.out.println();

	}

}
