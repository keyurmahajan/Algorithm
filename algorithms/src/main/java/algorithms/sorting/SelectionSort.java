package algorithms.sorting;

/**
 * 
 * @author keyur.mahajan
 *
 */

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 14, 33, 27, 35, 10 };
		print(arr);
		sort(arr);
		System.out.println("\nSorting Done");
		print(arr);

	}

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i; j < arr.length - 1; j++) {
				if (arr[index] > arr[j]) {
					index = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
