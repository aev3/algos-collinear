
/*************************************************************************
 * Compilation: javac PointPlotter.java
 * Execution: java PointPlotter input.txt
 *
 * Dependencies: Point.java, In.java, StdDraw.java
 *
 *************************************************************************/

/**
 * Class that takes the name of a file as a command-line argument,
 * reads in an integer N followed by N pairs of points (x, y)
 * with coordinates between 0 and 32,767, and plots them using
 * standard drawing.
 */
public final class PointPlotter {

    /**
     * Default no argument constructor made private to obviate instantiation.
     */
    private PointPlotter() {
    }

    /**
     * Simple integer that creates what would otherwise be a 'magic number'.
     */
    private static final int SCALAR = 32768;

    /**
     * Conveeniance main method for CLI/IDE testing.
     *
     * @param args  - String array [Not implemented.]
     */
    public static void main(final String[] args) {

        /*
         * Scale coordinates and turn on animation mode.
         */
        StdDraw.setXscale(0, SCALAR);
        StdDraw.setYscale(0, SCALAR);
        StdDraw.show(0);

        /*
         * Read in the input.
         */
        String filename = args[0];
        In in = new In(filename);
        int num = in.readInt();
        for (int i = 0; i < num; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            p.draw();
        }

        /*
         * Display to screen all at once.
         */
        StdDraw.show(0);
    }

}
