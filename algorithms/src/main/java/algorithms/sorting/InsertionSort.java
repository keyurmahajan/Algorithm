package algorithms.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 14, 33, 27, 35, 10 };
		print(arr);
		sort(arr, 0);
		System.out.println("\nSorting Done");
		print(arr);
	}

	/**
	 * Insertion sort using
	 * 
	 * @param arr
	 * @return
	 */
	public static void sort(int[] arr, int i) {

	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
