package algorithms.sorting;

/**
 * 
 * @author keyur.mahajan
 *
 */

public class QuikSort {

	public static void main(String[] args) {
		int[] arr = { 14, 33, 27, 35, 10 };
		print(arr);
		int[] sort = sort(arr);
		System.out.println("\nSorting Done");
		print(sort);

	}

	public static int[] sort(int[] arr) {

		return arr;
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
