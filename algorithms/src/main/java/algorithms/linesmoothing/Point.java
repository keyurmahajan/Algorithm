package algorithms.linesmoothing;

/**
 * Represents 2 dimensional point
 *
 * @author keyur.mahajan
 *
 */
public class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.setX(x);
		this.setY(y);

	}

	/**
	 * Get Y Coordinate
	 *
	 * @return X
	 */
	public double getX() {
		return x;
	}

	/**
	 * Set X-Coordinate
	 *
	 * @param x
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Get Y Coordinate
	 *
	 * @return y
	 */
	public double getY() {
		return y;
	}

	/**
	 * Set Y Coordinate
	 *
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}
}