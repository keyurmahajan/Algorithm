package algorithms.basics;

/**
 * For Given array of int values find the max value
 * 
 * @author keyur.mahajan
 *
 */
public class FindMaxNumber {

	private static int[] numbers = { 0, 11, 55, 99, 666, 50, 999, -50, 56 };

	public static void main(String[] args) {
		int maxNumber = findMaxNumber(numbers);
		System.out.println("Max Number from the array = " + maxNumber);

	}

	private static int findMaxNumber(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;

	}

}
