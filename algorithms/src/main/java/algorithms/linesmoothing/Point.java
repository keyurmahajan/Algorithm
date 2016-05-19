package algorithms.linesmoothing;

/**
 * Represents 2 dimensional point
 *
 * @author keyur.mahajan
 *
 */
public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);

	}

	/**
	 * Get Y Coordinate
	 *
	 * @return X
	 */
	public int getX() {
		return x;
	}

	/**
	 * Set X-Coordinate
	 *
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Get Y Coordinate
	 *
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set Y Coordinate
	 *
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
}