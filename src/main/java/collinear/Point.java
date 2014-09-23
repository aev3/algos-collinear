
/*************************************************************************
 *
 * Compilation: javac Point.java
 * Dependencies: StdDraw.java
 *
 *************************************************************************/

import java.util.Comparator;

/**
 * Class that instantiates an immutable data type for points in the plane.
 */
public class Point implements Comparable<Point> {

    /**
     * Private class that implements the slope order comparator.
     */
    private class SlopeOrder implements Comparator<Point> {
        /**
         * Compare method required by Comparator. This method instantiates the
         * SlopeOrder Comparator to determine whether the two points passed
         * in as parameters to this method are in the same plain.
         *
         * @param q1 - One of the two Point instances
         * @param q2 - The other Point
         * @return int - That reflects common integer based comparator return
         * values of [-1, 0, and 1].
         */
        public int compare(final Point q1, final Point q2) {
            if (q1 == null) {
                throw new RuntimeException();
            }
            if (q2 == null) {
                throw new RuntimeException();
            }

            final double slope1 = slopeTo(q1);
            final double slope2 = slopeTo(q2);

            if (slope1 < slope2) {
                return -1;
            }
            if (slope1 > slope2) {
                return +1;
            }
            return 0;
        }
    }

    /**
     * Compare points by slope.
     */
    private final Comparator<Point> slopeOrder = new SlopeOrder();

    /**
     * Simple getter for slopeOrder;
     *
     * @return  Point - object reflecting values based upon interpolation of
     * x,y coordinates.
     */
    public final Comparator<Point> getSlopeOrder() {
        return slopeOrder;
    }

    /**
     * Integer representing the value of the x coordinate.
     */
    private int x;

    /**
     * Integer representing the value of the y coordinate.
     */
    private int y;

    /**
     * Create the point (x, y) coordinates.
     *
     * @param p1 - int with x coordinates
     *
     * @param p2 - int with y coordinates
     */
    public Point(final int p1, final int p2) {
        this.x = p1;
        this.y = p2;
    }

    /**
     * Is this Point lexicographically smaller than that Point?
     *
     * @param that - Point instance for comparison
     *
     * @return int - That reflects common integer based comparator return
     * values of [-1, 0, and 1].
     */
    public final int compareTo(final Point that) {
        if (that == null) {
            throw new RuntimeException();
        }

        if (y < that.y || y == that.y && x < that.x) {
            return -1;
        }
        if (y > that.y || x > that.x) {
            return +1;
        }

        return 0;
    }

    /**
     * Plot this point to standard drawing.
     */
    public final void draw() {
        StdDraw.point(x, y);
    }

    /**
     * Draw line between this point and that point to standard drawing.
     *
     * @param that - Point instance for comparison
     */
    public final void drawTo(final Point that) {
        StdDraw.line(x, y, that.x, that.y);
    }

    /**
     * Slope between this Point and that Point.
     *
     * @param that  - Point instance for comparison
     *
     * @return  double - equal to value of slope.
     */
    public final double slopeTo(final Point that) {
        if (that == null) {
            throw new RuntimeException();
        }

        final double deltaY = that.y - y;
        final double deltaX = that.x - x;

        if (deltaX == 0 && deltaY == 0) {
            return Double.NEGATIVE_INFINITY;
        }
        if (deltaX == 0) {
            return Double.POSITIVE_INFINITY;
        }
        if (deltaY == 0) {
            return +0.0;
        }

        return deltaY / deltaX;
    }

    /**
     * Simple toString method that returns a string repesentation of the
     * points x,y coordinates.
     *
     * @return String - representation of this Point
     */
    public final String toString() {
        return "(" + x + ", " + y + ")";
    }

}
