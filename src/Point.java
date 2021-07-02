// 313309114.

/**
 * the class create a point with x,y values.
 */
public class Point {
    private double x;
    private double y;

    /**
     * constructor.
     *
     * @param x is double,the x of the point.
     * @param y is double,the y of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * calculate the distance of this point to the other point by the equation of distance.
     *
     * @param other is Point.
     * @return the distance between the two points.
     */
    public double distance(Point other) {
        double dx = this.x - other.getX();
        double dy = this.y - other.getY();
      return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * check if the two points are equals.
     *
     * @param other is the point that we check if its equal with.
     * @return true is the points are equals, false otherwise.
     */
    public boolean equals(Point other) {
        //check if we have point or not.
        if (other == null) {
            return false;
        }
        return (this.x == other.getX()) && (this.y == other.getY());
    }

    /**
     * return the x values of this point.
     *
     * @return  the x double value of this point.
     */
    public double getX() {
        // return the x value of this point.
        return this.x;
    }
    /**
     * return the y values of this point.
     *
     * @return  the y double value of this point.
     */
    public double getY() {
        // return the y value of this point.
        return this.y;
    }
}