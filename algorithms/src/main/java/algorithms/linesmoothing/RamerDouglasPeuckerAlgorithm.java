package algorithms.linesmoothing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Ramer–Douglas–Peucker algorithm for for reducing the number of points in a
 * curve that is approximated by a series of points
 *
 * @see <a
 *      href="https://en.wikipedia.org/wiki/Ramer%E2%80%93Douglas%E2%80%93Peucker_algorithm#cite_note-5">Wikipedia
 *      Page</a>
 *
 * @author keyur.mahajan
 *
 */

public class RamerDouglasPeuckerAlgorithm {

	/**
	 * Get Smoothing Path. Using Ramer–Douglas–Peucker algorithm. It will
	 * eliminate extra points from the path considering the epsilon value
	 *
	 * @param points
	 *            List of nodes represents the path
	 * @param epsilon
	 *            distance at which points will be discarded from line
	 * @return
	 */

	public List<Point> reducePoints(List<Point> points,
			double epsilon) {

		Objects.requireNonNull(points, "Points parameter is Null");
		if (epsilon == 0) {
			return points;
		}

		// Find the point with the maximum distance
		double farLocDist = 0;
		int farLocindex = 0;
		int size = points.size();

		// creating line which contains two points
		List<Point> line = Arrays.asList(points.get(0), points.get(size - 1));
		for (int j = 0; j < size - 1; j++) {
			double dis = getPoint2LineDistance(line, points.get(j));
			if (dis > farLocDist) {
				farLocindex = j;
				farLocDist = dis;
			}
		}

		// If max distance is greater than epsilon, recursively simplify
		if (farLocDist > epsilon) {
			// Recursive call
			List<Point> list1 = reducePoints(
					points.subList(0, farLocindex + 1), epsilon);
			List<Point> list2 = reducePoints(
					points.subList(farLocindex, points.size()), epsilon);

			// Build the result list
			List<Point> resultList = new ArrayList<Point>(list1);
			resultList.addAll(list2.subList(1, list2.size()));

			return resultList;

		} else {
			return line;
		}
	}

	/**
	 * Get distance between Line and the point
	 *
	 * @param line
	 * @param location
	 * @return
	 */
	public double getPoint2LineDistance(List<Point> line, Point location) {
		Objects.requireNonNull(line, "Line parameter is Null");
		Objects.requireNonNull(location, "Location parameter is Null");

		Point start = line.get(0);
		Point end = line.get(1);

		double dx = start.getX() - end.getX();
		double dy = start.getY() - end.getY();
		double sxey = start.getX() * end.getY();
		double exsy = end.getX() * start.getY();
		double length = Math.sqrt(dx * dx + dy * dy);

		double distance = Math.abs(dy * location.getX() - dx * location.getY()
				+ sxey - exsy)
				/ length;
		return distance;
	}

}
