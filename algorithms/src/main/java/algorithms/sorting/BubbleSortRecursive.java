package algorithms.sorting;

public class BubbleSortRecursive {

	public static void main(String[] args) {
		int[] arr = { 14, 33, 27, 35, 10 };
		print(arr);
		sort(arr, 0);
		System.out.println("\nSorting Done");
		print(arr);
	}

	/**
	 * Bubble sort using recursion
	 * 
	 * @param arr
	 * @return
	 */
	public static void sort(int[] arr, int i) {
		if (i >= arr.length - 1) {
			return;
		}
		for (int j = 0; j < arr.length - i - 1; j++) {
			if (arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}

		}
		sort(arr, i + 1);
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
