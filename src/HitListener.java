// 313309114.

/**
 *this interface is for Objects that want to be notified of hit events.
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit is the block that the ball hit.
     * @param hitter   is the sprites.Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
