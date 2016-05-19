package algorithms.linesmoothing;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculates average points on the line and make the line smooth.
 *
 * @author keyur.mahajan
 *
 */
public class AveragingLineSmoothingAlgorithm {

	/**
	 * Generates Smooth line
	 *
	 * @param line
	 * @return Smoothen Line
	 */

	public List<Point> convertToSmoothLine(List<Point> line) {

		List<Point> smoothPath = new ArrayList<Point>();

		Point current = line.get(0);
		smoothPath.add(current);
		int sizeOfPath = line.size();
		int i = 1;
		while (i < sizeOfPath - 1) {
			double[] yCoordinates = new double[3];
			double[] xCoordinates = new double[3];

			yCoordinates[0] = current.getY();
			xCoordinates[0] = current.getX();

			Point next = line.get(i);
			yCoordinates[1] = next.getY();
			xCoordinates[1] = next.getX();

			Point next2Next = line.get(i + 1);
			if (next2Next == null) {
				smoothPath.add(next);
				break;
			}

			yCoordinates[2] = next2Next.getY();
			xCoordinates[2] = next2Next.getX();

			double avgY = findAverage(yCoordinates);
			double avgX = findAverage(xCoordinates);

			Point avgNew = new Point(avgY, avgX);

			smoothPath.add(avgNew);
			current = next;
			i++;
		}
		smoothPath.add(line.get(sizeOfPath - 1));

		return smoothPath;

	}

	private double findAverage(double[] values) {
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		return sum / values.length;
	}

}
