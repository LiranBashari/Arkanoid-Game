// 313309114.

/**
 * this class set the velocity of the ball on the screen.
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor.
     *
     * @param dx is double.
     * @param dy is double.
     */
   public Velocity(double dx, double dy) {
       this.dx = dx;
       this.dy = dy;
   }

    /**
     * constructor.
     *
     * @param angle a double number,the angle move.
     * @param speed is double number, present the speed of the ball.
     * @return the new velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx =  Math.sin(Math.toRadians(angle)) * speed;
        double dy = -Math.cos(Math.toRadians(angle)) * speed;
        return (new Velocity(dx, dy));
    }

    /**
     * get the dx.
     *
     * @return the dx (double).
     */
   public double getDx() {
       return this.dx;
   }

    /**
     * get the dy.
     *
     * @return the dy (double).
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * set the dx.
     * @param dx1  is double that present the dx.
     */
    public void setDx(double dx1) {
        this.dx = dx1;
    }

    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p is the point that we change his position.
     * @return the new point with the new position.
     */
    public Point applyToPoint(Point p) {
       // Take a point with position (x,y) and return a new point with position (x+dx, y+dy)
       double newDx = this.dx + p.getX();
       double newDy = this.dy + p.getY();
        return new Point(newDx, newDy);
    }

    /**
     * get the speed.
     *
     * @return the current speed.
     */
    public double getSpeed() {
        double speed = this.getDx() * this.getDx() + this.getDy() * this.getDy();
        return Math.sqrt(speed);
    }
}