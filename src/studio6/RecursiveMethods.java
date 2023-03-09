package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		if (n == 0)
			return 0;
		else
			return (1 / Math.pow(2, n)) + geometricSum(n - 1);
	}

	/**
	 * This method uses recursion to compute the greatest common divisor for the two
	 * input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (p % q == 0)
			return q;
		else
			return gcd(q, p % q);

	}

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		int x = (array.length - 1) / 2;
		int[] narray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			narray[i] = array[i];
		}
		if (narray.length == 0) {
			return narray;
		}
		return helperMethod(narray, x);
	}

	private static int[] helperMethod(int[] array, int x) {
		if (x == -1) {
			return array;
		} else {
			int temp = array[x];
			array[x] = array[array.length - 1 - x];
			array[array.length - 1 - x] = temp;
			return helperMethod(array, --x);
		}
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		if (radius < radiusMinimumDrawingThreshold)
			;
		else {
			StdDraw.circle(xCenter, yCenter, radius);
			radius = radius / 3;
			circlesUponCircles(xCenter + radius * 3, yCenter, radius, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter - radius * 3, yCenter, radius, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter + radius * 3, radius, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter - radius * 3, radius, radiusMinimumDrawingThreshold);
		}
	}

}
