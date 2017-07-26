package algorithms.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 14, 33, 27, 35, 10 };
		print(arr);
		int[] sort = sort(arr);
		System.out.println("\nSorting Done");
		print(sort);
	}

	/**
	 * Optimized Implementation: The above function always runs O(n^2) time even
	 * if the array is sorted. It can be optimized by stopping the algorithm if
	 * inner loop didn’t cause any swap.
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}
		}
		return arr;
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
