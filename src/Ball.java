// 313309114.

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * this class create ball with center point, radius, velocity and color for the ball.
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * constructor.
     *
     * @param center is a point,present the center of the circle.
     * @param r      is int, the radius size.
     * @param color  is "java.awt.Color",the color of the circle
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
    }

    /**
     * constructor.
     *
     * @param center is a point,present the center of the circle.
     * @param r      is int, the radius size.
     * @param color  is "java.awt.Color",the color of the circle
     * @param gameEnvironment  is GameEnvironment ,the environment of the game.
     */
    public Ball(Point center, int r, Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
        this.velocity = new Velocity(0, 0);
    }
    /**
     * constructor.
     *
     * @param centerX is a int value point,present the x value of the center of the circle.
     * @param centerY is a int value point,present the y value of the center of the circle.
     * @param radius  is int, the radius size.
     * @param red  is java.awt.Color, means the circle color.
     */
    public Ball(double centerX, double centerY, int radius, Color red) {
        this.center = new Point(centerX, centerY);
        this.radius = radius;
        this.color = red;
    }

    /**
     * accessor.
     * return the value of the x  center point.
     *
     * @return the value of the x center point.
     */
    public int getX() {
        return (int) this.center.getX();

    }

    /**
     * accessor.
     * return the value of the y  center point.
     *
     * @return the value of the y center point.
     */
    public int getY() {

        return (int) this.center.getY();
    }

    /**
     * accessor.
     * return the size of the ball.
     *
     * @return the size of the ball.
     */
    public int getSize() {

        return this.radius;
    }

    /**
     * accessor.
     * return the color of the ball.
     *
     * @return the color of the ball.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface is the DrawSurface.
     */
    public void drawOn(DrawSurface surface) {
        // draw the ball on the given DrawSurface
        surface.setColor(this.color);
        surface.fillCircle((int) center.getX(), (int) center.getY(), this.getSize());
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) center.getX(), (int) center.getY(), this.getSize());
    }

    /**
     * set the velocity of the ball.
     *
     * @param v is Velocity.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * set the velocity of the ball.
     *
     * @param dx is Velocity.
     * @param dy is Velocity.
     */
    public void setVelocity(double dx, double dy) {
       this.velocity = new Velocity(dx, dy);
    }

    /**
     * get the velocity of the ball.
     *
     * @return Velocity.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     *
     * the function change the center of the ball by the velocity of the ball and create animation,
     * if the center hit the coliidable the ball chance his velocity, and so he changes the direction of his movement.
     *
     */
    public void moveOneStep() {
        Point intersectionsPoint = null;
        Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        //if the center of the ball don't touch anything callable
        if (gameEnvironment.getClosestCollision(trajectory) == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else {
            //if the center of the ball touch any colladable object:
            intersectionsPoint = new Point(gameEnvironment.getClosestCollision(trajectory).collisionPoint().getX(),
                    gameEnvironment.getClosestCollision(trajectory).collisionPoint().getY());
            Collidable objectColl = gameEnvironment.getClosestCollision(trajectory).collisionObject();
            //change the center:
            this.center = (new Velocity(intersectionsPoint.getX()
                    - this.center.getX() - this.velocity.getDx(),
                    intersectionsPoint.getY() - this.center.getY()
                            - this.velocity.getDy()).applyToPoint(this.center));
            //get and set the new velocity of the object.
            Velocity newVelocity = gameEnvironment.getClosestCollision(trajectory).
                    collisionObject().hit(this, intersectionsPoint, this.velocity);
            setVelocity(newVelocity);
        }
    }

    /**
     * method that add the ball to the game.
     *
     * @param gameLevel is the "game".
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    /**
     * the method notify that the time passed, make the ball move one step forward.
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     * method that remove the ball to the game.
     *
     * @param g is the "game".
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}