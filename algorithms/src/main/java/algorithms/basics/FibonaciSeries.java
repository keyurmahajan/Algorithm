package algorithms.basics;

public class FibonaciSeries {

	private static String getFibSeries(int n) {
		StringBuffer series = new StringBuffer();
		double temp1 = 0;
		double temp2 = 1;
		double sum = 0;
		for (int i = 0; i < n; i++) {
			series = series.append(sum + " ");
			sum = temp1 + temp2;
			temp2 = temp1;
			temp1 = sum;
		}

		return series.toString();
	}

	public static void main(String[] args) {
		String fibSeries = getFibSeries(2);
		System.out.println(fibSeries);

	}

}
