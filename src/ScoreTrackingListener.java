// 313309114.

 /**
 * update the counter when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    /**
     * constructor.
     * @param scoreCounter is the counter that count the score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * the method is called whenever the beingHit object is hit.
     * and update the score counter.
     *
     * @param beingHit is the block that the ball hit.
     * @param hitter   is the sprites.Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}
