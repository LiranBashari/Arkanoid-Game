// 313309114.

/**
 * for things that can be collide.
 */
public interface Collidable {
    /**
     * method that return the "collision shape" of the object.
     *
     * @return collision shape
     */
    Rectangle getCollisionRectangle();

    /**
     * with  a given velocity notify the object that we collided with it at collisionPoint and return the new velocity.
     *
     * @param collisionPoint the  collision's point.
     * @param currentVelocity the current velocity before he hit.
     * @param hitter is the ball that hit.
     * @return the new velocity expected after the hit.
     *
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
