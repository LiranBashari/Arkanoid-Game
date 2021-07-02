// 313309114.

/**
 * listener.BallRemover charge of removing balls, and updating an available-balls counter.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBall;

    /**
     * constructor.
     * @param gameLevel is the game
     * @param removedBalls is the counter of the balls.
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.remainingBall = removedBalls;
    }

    /**
     * remove the ball from the game.
     * @param beingHit is the block the the ball hit.
     * @param hitter is the ball that hit the block.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.remainingBall.decrease(1);
    }
}
