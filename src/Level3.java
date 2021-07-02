// 313309114.

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class that create level number 3.
 */
public class Level3 implements LevelInformation {
    private static final int WIDTH_SCREEN = 800;
    private static final int HEIGHT_SCREEN = 600;
    private static final int PADDLE_WIDTH = 85;
    private static final int EDGE_HEIGHT = 25;
    private static final int BLOCK_HEIGHT = 18;
    private static final int BLOCK_WIDTH = 40;
    private static final int PADDLE_SPEED = 10;
    private static final int BALL_SPEED = 7;

    /**
     * get the number of the balls for the level.
     *
     * @return number of balls.
     */
    @Override
    public int numberOfBalls() {
        return 2;
    }

    /**
     * create a list of velocity for the balls.
     *
     * @return the list of the velocity.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocity = new ArrayList<>();
        for (int i = 0; i < numberOfBalls() / 2; i++) {
            velocity.add(Velocity.fromAngleAndSpeed(35 - i * 8, BALL_SPEED));
            velocity.add(Velocity.fromAngleAndSpeed(325 + i * 8, BALL_SPEED));
        }
        return velocity;
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
        return "Green 3";
    }

    /**
     * Returns a sprite with the background of the level.
     *
     * @return the background.
     */
    @Override
    public Sprite getBackground() {
        return new Level3Background();
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
        int height = 18, width = 45, row = 5, numOfBlocks = 10;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < numOfBlocks - i; j++) {
                b.add(new Block(new Rectangle(new Point(WIDTH_SCREEN - EDGE_HEIGHT - BLOCK_WIDTH - j * BLOCK_WIDTH,
                        (double) HEIGHT_SCREEN / 4 + height * (i)),
                        BLOCK_WIDTH, BLOCK_HEIGHT), whichColor(i)));
            }
        }
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
        return 40;
    }

    /**
     * method that return color by integer i, for exercise requirements.
     *
     * @param i - is the index in the loop that present the column.
     * @return Color - the required color.
     */
    public Color whichColor(int i) {
        // we have 6 rows and each row different color
        switch (i) {
            case 0:
                return Color.GRAY;
            case 1:
                return Color.RED;
            case 2:
                return Color.YELLOW;
            case 3:
                return Color.BLUE;
            case 4:
                return Color.WHITE;
            default:
                return Color.GREEN;
        }
    }
}
