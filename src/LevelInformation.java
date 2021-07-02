// 313309114.

import java.util.List;

/**
 * interface that give level information.
 */
public interface LevelInformation {

    /**
     * get the number of the balls for the level.
     *
     * @return number of balls.
     */
    int numberOfBalls();

    /**
     * create a list of velocity for the balls.
     *
     * @return the list of the velocity.
     */
    List<Velocity> initialBallVelocities();

    /**
     * get the speed of the paddle.
     *
     * @return the speed.
     */
    int paddleSpeed();

    /**
     * get the width of the paddle.
     *
     * @return the width.
     */
    int paddleWidth();

    /**
     * get the level name will be displayed at the top of the screen.
     *
     * @return the level name.
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @return the background.
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return the list of the blocks.
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return num of blocks.
     */
    int numberOfBlocksToRemove();
}
