package algorithms.basics;
/**
 * Filename : DecimalToBinary.java
 * Class : DecimalToBinary
 * Author : keyur.mahajan
 * Date : Sep 19, 2017
 * Description:  convert given decimal number to binary representation
 */

public class DecimalToBinary {

	public static void main(String[] args) {
		int decimal = 12;
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println("No of processor" + availableProcessors);
		String binaryString = decimalToBinary(decimal);

		System.out.println(decimal + " = " + binaryString);
	}

	public static String decimalToBinary(int num) {
		StringBuilder binaryString = new StringBuilder();
		char[] charArray = new char[20];
		int i =0;
		while (num > 0) {
			binaryString.append(num % 2);
			num = num / 2;
		}

		return binaryString.reverse().toString();

	}

}
