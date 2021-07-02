// 313309114.

import biuoop.KeyboardSensor;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * class that create paddle- the "player" - a block controlled by the keyboard.
 */
public class Paddle implements Sprite, Collidable {
    private static final int LEFT_BORDER = 25;
    private static final int RIGHT_BORDER = 775;
    private static final int REGION_1 = 300;
    private static final int REGION_2 = 330;
    private static final int REGION_4 = 30;
    private static final int REGION_5 = 60;
    private static final int FIVE_REGIONS = 5;
    private biuoop.KeyboardSensor keyboard;
    private Rectangle puddle;
    private java.awt.Color color;
    private int speed;
    /**
     * constructot that build the paddle.
     *
     * @param color -Color, the new paddle color.
     * @param puddle -Rectangle, the new paddle.
     * @param keyboard  is the keyboard from the game.
     * @param speed speed of paddle.
     */
    public Paddle(Rectangle puddle, biuoop.KeyboardSensor keyboard, Color color, int speed) {
        this.puddle = puddle;
        this.keyboard = keyboard;
        this.color = color;
        this.speed = speed;
    }

    /**
     * the method move left the paddle(until the border).
     */
    public void moveLeft() {
        if ((this.puddle.getUpperLeft().getX() - speed >= LEFT_BORDER - this.puddle.getWidth())
                && (this.puddle.getUpperLeft().getX() - speed < LEFT_BORDER)) {
            this.puddle.setUpperLeft(new Point(LEFT_BORDER, this.puddle.getUpperLeft().getY()));
        } else if (this.puddle.getUpperLeft().getX() - speed >= LEFT_BORDER) {
            this.puddle.setUpperLeft(new Point(this.puddle.getUpperLeft().getX() - speed
                    , this.puddle.getUpperLeft().getY()));
        }
    }

    /**
     * the method move right the paddle(until the border).
     */
    public void moveRight() {
        if ((this.puddle.getUpperLeft().getX() + this.puddle.getWidth() + speed >= RIGHT_BORDER)
                && (this.puddle.getUpperLeft().getX() + this.puddle.getWidth() + speed < RIGHT_BORDER
                + this.puddle.getWidth())) {
            this.puddle.setUpperLeft(new Point(RIGHT_BORDER - this.puddle.getWidth()
                    , this.puddle.getUpperLeft().getY()));
        } else if (this.puddle.getUpperLeft().getX() + this.puddle.getWidth() + speed <= RIGHT_BORDER) {
            this.puddle.setUpperLeft(new Point(this.puddle.getUpperLeft().getX() + speed
                    , this.puddle.getUpperLeft().getY()));
        }
    }

    /**
     * the method check if the "left" or "right" keys are pressed, and if one of the keys are pressed call the
     * "moveLeft" or "moveRight" accordingly.
     */
    public void timePassed() {
        //check if the "left" or "right" keys are pressed.
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        } else if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * draw the paddle on the given DrawSurface, according to the assignments.
     *
     * @param d -the surface that we draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) puddle.getUpperLeft().getX(), (int) puddle.getUpperLeft().getY()
                , (int) puddle.getWidth(), (int) puddle.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) puddle.getUpperLeft().getX(), (int) puddle.getUpperLeft().getY()
                , (int) puddle.getWidth(), (int) puddle.getHeight());
    }

    /**
     * return the "collision shape" of the object-the paddle.
     *
     * @return the "collision shape" -the paddle.
     */
    public Rectangle getCollisionRectangle() {
        return this.puddle;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g - is the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Notify the paddle that we collided with it at collisionPoint with a given velocity.
     * and we return the new velocity.
     *
     * @param collisionPoint  - the point of the collision.
     * @param currentVelocity - the current velocity until the hit.
     * @param b is the ball that hit.
     * @return the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    public Velocity hit(Ball b, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = null;
        //set the regions.
        double regionSize = (puddle.getWidth()) / FIVE_REGIONS;
        double startXPuddle = this.puddle.getUpperLeft().getX();
        double region2 = startXPuddle + regionSize;
        double region3 = startXPuddle + 2 * regionSize;
        double region4 = startXPuddle + 3 * regionSize;
        double region5 = startXPuddle + 4 * regionSize;
        //if the collision Point is on the left/right sides of the paddle.
        if (collisionPoint.getY() != puddle.getUpperLeft().getY()) {
            return (new Velocity((-1) * currentVelocity.getDx(), currentVelocity.getDy()));
        } else if ((collisionPoint.getX() >= startXPuddle) && (collisionPoint.getX() <= region2)) {
            //if it in region 1:
            newVelocity = Velocity.fromAngleAndSpeed(REGION_1, currentVelocity.getSpeed());
            newVelocity.setDx(-Math.abs(newVelocity.getDx()));
        } else if ((collisionPoint.getX() >= region2) && (collisionPoint.getX() <= region3)) {
            //if it in region 2:
            newVelocity = Velocity.fromAngleAndSpeed(REGION_2, currentVelocity.getSpeed());
            newVelocity.setDx(-Math.abs(newVelocity.getDx()));
        } else if ((collisionPoint.getX() >= region3) && (collisionPoint.getX() <= region4)) {
            //if it in region 3:
            newVelocity = new Velocity(currentVelocity.getDx(), -(currentVelocity.getDy()));
        } else if ((collisionPoint.getX() >= region4) && (collisionPoint.getX() <= region5)) {
            //if it in region 4:
            newVelocity = Velocity.fromAngleAndSpeed(REGION_4, currentVelocity.getSpeed());
            newVelocity.setDx(Math.abs(newVelocity.getDx()));
        } else if ((collisionPoint.getX() >= region5) && (collisionPoint.getX() <= (startXPuddle
                + this.puddle.getWidth()))) {
            //if it in region 5:
            newVelocity = Velocity.fromAngleAndSpeed(REGION_5, currentVelocity.getSpeed());
            newVelocity.setDx(Math.abs(newVelocity.getDx()));
        }
        //if the dy is positive and the ball go down,change the dy.
        assert newVelocity != null;
        if (newVelocity.getDy() > 0) {
            newVelocity = new Velocity(newVelocity.getDx(), -1 * newVelocity.getDy());
        }
        return newVelocity;
    }
}