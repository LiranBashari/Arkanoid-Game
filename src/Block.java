// 313309114.

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class that create a block with rectangle and color.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * constructor-that create the block.
     *
     * @param rec       the rectangle for the block.
     * @param col - initialize the block's color.
     */
    public Block(Rectangle rec, Color col) {
        this.rectangle = rec;
        this.color = col;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * method that return the "collision shape" -the block.
     *
     * @return rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * with a given velocity, notify the block that we collided with it at collisionPoint, and return the new velocity.
     *
     * @param collisionPoint  - the point of the collision.
     * @param currentVelocity - the current velocity until the hit.
     * @param hitter is the ball that hit.
     * @return the new velocity expected after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double height = this.rectangle.getHeight();
        double width = this.rectangle.getWidth();
        Point upperLeftPoint = this.rectangle.getUpperLeft();
        // notify about the hit
        // if hit the block in the upper side or the bottom side we will change direction
        if ((collisionPoint.getX() >= upperLeftPoint.getX() && collisionPoint.getX() <= upperLeftPoint.getX() + width)
                && ((collisionPoint.getY() == upperLeftPoint.getY())
                || (collisionPoint.getY() == upperLeftPoint.getY() + height))) {
            currentVelocity = new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
            this.notifyHit(hitter);
        } else if ((collisionPoint.getY() >= upperLeftPoint.getY()
                && collisionPoint.getY() <= upperLeftPoint.getY() + height)
                && ((collisionPoint.getX() == upperLeftPoint.getX())
                || (collisionPoint.getX() == upperLeftPoint.getX() + width))) {
            // if hits in the sides (left/right) we will change direction
            currentVelocity = new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
            this.notifyHit(hitter);
        } else if (((collisionPoint.getY() == upperLeftPoint.getY())
                || (collisionPoint.getY() == upperLeftPoint.getY() + height))
                && ((collisionPoint.getX() == upperLeftPoint.getX())
                || (collisionPoint.getX() == upperLeftPoint.getX() + width))) {
            currentVelocity = new Velocity((-1) * currentVelocity.getDx(), (-1) * currentVelocity.getDy());
            this.notifyHit(hitter);
        }
        return currentVelocity;
    }

    /**
     * the method draw the block on the surface.
     * @param d -the draw surface.
     */
    public void drawOn(DrawSurface d)  {
        Point upperLeft = this.rectangle.getUpperLeft();
        double width = this.rectangle.getWidth();
        double height = this.rectangle.getHeight();
        //set the color of the block
        d.setColor(this.color);
        //print the block on the screen
        d.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
        // for the frame's block
        d.setColor(Color.black);
        d.drawRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
    }

    /**
     * the method notify the block that time passed-for now, according to the assignment she do nothing.
     */
    public void timePassed() {
    }
    /**
     * the method add the block to the game.
     *
     * @param g - is the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * the method remove the block to the game.
     *
     * @param gameLevel - is the game.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * called whenever a hit occurs, and notifiers all of the registered listener.HitListener objects.
     * @param hitter is ball that hit the block.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * add the hit listener to the block.
     * @param hl the hl
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * remove the hit listener from the block.
     * @param hl the hl
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
