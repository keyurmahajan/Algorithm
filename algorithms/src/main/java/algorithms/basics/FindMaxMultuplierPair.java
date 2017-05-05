package algorithms.basics;

/**
 * Find max pair multiplier from given int array.
 * 
 * @author keyur.mahajan
 *
 */
public class FindMaxMultuplierPair {
	private static int[] numbers = { 0, 11, 55, 99, 66, 50, 99, -50, 56 };

	public static void main(String[] args) {
		int maxNumber = findMaxNumber(numbers);
		System.out.println("Max Multiplier from the array = " + maxNumber);
	}

	private static int findMaxNumber(int[] array) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max1 || array[i] > max2) {
				max1 = Integer.max(max1, max2);
				max2 = array[i];
			}
		}
		return max1 * max2;
	}
}
