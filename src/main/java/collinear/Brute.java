
/*************************************************************************
 *
 * Compilation: javac Brute.java
 * Execution: java Brute input.txt
 * Dependencies: StdDraw.java StdOut.java In.java
 *
 *************************************************************************/

/**
 * Class that uses a brute-force algorithm to find lines inside a given set of
 * points. Lines are interpreted as at least 4 collinear points.
 */
public final class Brute {

    /**
     * Simple integer that creates what would otherwise be a 'magic number'.
     */
    private static final int SCALAR = 32768;

    /**
     * No argument constructor mad private to obviate instantiation.
     */
    private Brute() {
    }

    /**
     * Check if a given set of four points form a line.
     *
     * @param p - one of the four points used to determine whether the four
     *          points form a line.
     * @param q - one of the four points used to determine whether the four
     *          points form a line.
     * @param r - one of the four points used to determine whether the four
     *          points form a line.
     * @param s - one of the four points used to determine whether the four
     *          points form a line.
     * @return boolean - True if the four points form a line; Otherwise, false.
     */
    private static boolean isLine(final Point p, final Point q, final Point r,
                                  final Point s) {
        double slope = p.slopeTo(q);
        return p.slopeTo(r) == slope && p.slopeTo(s) == slope;
    }

    /**
     * Convenience main method that takes first and only argument which is
     * the full path to the file to read.
     *
     * @param args - String array that contains the path to the file to be read.
     */
    public static void main(final String[] args) {
        // re-scale coordinates and turn on animation mode
        StdDraw.setXscale(0, SCALAR);
        StdDraw.setYscale(0, SCALAR);
        StdDraw.show(0);

        // read in the input in the points array
        In in = new In(args[0]);
        int num = in.readInt();
        Point[] points = new Point[num];
        for (int i = 0; i < num; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
            points[i].draw();
        }

        // brute-force [O(num^4)] find the lines, and display them
        Quick.sort(points);
        for (int i = 0; i < num - 3; i++) {
            for (int j = i + 1; j < num - 2; j++) {
                for (int k = j + 1; k < num - 1; k++) {
                    for (int l = k + 1; l < num; l++) {
                        if (isLine(points[i], points[j], points[k],
                            points[l])) {
                            StdOut.print(points[i] + " -> ");
                            StdOut.print(points[j] + " -> ");
                            StdOut.print(points[k] + " -> ");
                            StdOut.print(points[l] + "\n");

                            points[i].drawTo(points[l]);
                        }
                    }
                }
            }
        }

        // display to screen all at once
        StdDraw.show(0);
    }

}
