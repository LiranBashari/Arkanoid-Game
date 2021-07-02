// 313309114.

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class that create the first level.
 */
public class Level1 implements LevelInformation {
    private static final int WIDTH_SCREEN = 800;
    private static final int HEIGHT_SCREEN = 600;
    private static final int PADDLE_WIDTH = 85;
    private static final int SIZE_BLOCK = 30;
    private static final int PADDLE_SPEED = 5;

    /**
     * get the number of the balls for the level.
     *
     * @return number of balls.
     */
    @Override
    public int numberOfBalls() {
        return 1;
    }

    /**
     * create a list of velocity for the balls.
     *
     * @return the list of the velocity.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> initBallVelocity = new ArrayList<>();
        initBallVelocity.add(new Velocity(0, -6));
        return initBallVelocity;
    }

    /**
     * get the speed of the paddle.
     *
     * @return the speed.
     */
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    /**
     * get the width of the paddle.
     *
     * @return the width.
     */
    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    /**
     * get the level name will be displayed at the top of the screen.
     *
     * @return the level name.
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * Returns a sprite with the background of the level.
     *
     * @return the background.
     */
    @Override
    public Sprite getBackground() {
        return new Level1Background();
    }

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return the list of the blocks.
     */
    @Override
    public List<Block> blocks() {
        List<Block> b = new ArrayList<>();
        Rectangle rec = new Rectangle(new Point((double)
                ((WIDTH_SCREEN / 2) - SIZE_BLOCK / 2) , (double) HEIGHT_SCREEN / 4)
                , SIZE_BLOCK, SIZE_BLOCK);
       Block block = new Block(rec, Color.RED);
       b.add(block);
       return b;
    }

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return num of blocks.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
