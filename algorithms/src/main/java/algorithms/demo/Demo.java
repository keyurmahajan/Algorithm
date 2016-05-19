package algorithms.demo;

import java.util.ArrayList;
import java.util.List;

import algorithms.linesmoothing.AveragingLineSmoothingAlgorithm;
import algorithms.linesmoothing.Point;
import algorithms.linesmoothing.RamerDouglasPeuckerAlgorithm;

/**
 * Demo Application to test output of the Algorithm on console
 *
 * @author keyur.mahajan
 *
 */
public class Demo {

	public static void main(String[] args) {

		List<Point> line = new ArrayList<Point>();
		line.add(new Point(10, 10));
		line.add(new Point(10, 20));
		line.add(new Point(50, 20));
		line.add(new Point(25, 25));
		line.add(new Point(40, 30));

		System.out.println("ramerDouglasPeuckerAlgorithmTest---->");
		ramerDouglasPeuckerAlgorithmTest(line);

		System.out.println("averagingLineSmoothingAlgorithmTest---->");
		averagingLineSmoothingAlgorithmTest(line);

	}

	// Testing AveragingLineSmoothingAlgorithmTest Algorithm
	private static void averagingLineSmoothingAlgorithmTest(List<Point> line) {
		AveragingLineSmoothingAlgorithm avgAlgorithm = new AveragingLineSmoothingAlgorithm();
		List<Point> convertToSmoothLine = avgAlgorithm
				.convertToSmoothLine(line);
		for (Point point : convertToSmoothLine) {
			System.out.println(point.getX() + "," + point.getY());
		}
	}

	// Testing RamerDouglasPeuckerAlgorithm Algorithm
	private static void ramerDouglasPeuckerAlgorithmTest(List<Point> line) {

		RamerDouglasPeuckerAlgorithm objAlgorithm = new RamerDouglasPeuckerAlgorithm();
		List<Point> reducePoints = objAlgorithm.reducePoints(line, 15);

		for (Point point : reducePoints) {
			System.out.println(point.getX() + "," + point.getY());
		}
	}

}
