// 313309114.

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class that create the second level.
 */
public class Level2 implements LevelInformation {
    private static final int WIDTH_SCREEN = 800;
    private static final int PADDLE_WIDTH = 600;
    private static final int EDGE_HEIGHT = 25;
    private static final int BLOCK_HEIGHT = 18;
    private static final int BLOCK_WIDTH = 50;
    private static final int PADDLE_SPEED = 5;
    private static final int BALL_SPEED = 8;
    private static final int START_CREATE_Y = 240;

    /**
     * get the number of the balls for the level.
     *
     * @return number of balls.
     */
    @Override
    public int numberOfBalls() {
        return 10;
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
            velocity.add(Velocity.fromAngleAndSpeed(50 - i * 8, BALL_SPEED));
            velocity.add(Velocity.fromAngleAndSpeed(310 + i * 8, BALL_SPEED));
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
        return "Wide Easy";
    }

    /**
     * Returns a sprite with the background of the level.
     *
     * @return the background.
     */
    @Override
    public Sprite getBackground() {
        return new Level2Background();
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
        for (int i = 0; i < numberOfBlocksToRemove(); i++) {
            b.add(new Block(new Rectangle(new Point(WIDTH_SCREEN - EDGE_HEIGHT - BLOCK_WIDTH - i * BLOCK_WIDTH ,
                    START_CREATE_Y),
                    BLOCK_WIDTH, BLOCK_HEIGHT), whichColor(i)));
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
        return 15;
    }

    /**
     * method that return color by integer i, for exercise requirements.
     *
     * @param i - is the index in the loop that present the column.
     * @return Color - the required color.
     */
    public Color whichColor(int i) {
      if (i == 0 || i == 1) {
          return Color.CYAN;
      } else if (i == 2 || i == 3) {
          return Color.PINK;
      }  else if (i == 4 || i == 5) {
          return Color.BLUE;
      }  else if (i == 6 || i == 7 || i == 8) {
          return Color.GREEN;
      }  else if (i == 9 || i == 10) {
          return Color.YELLOW;
      }  else if (i == 11 || i == 12) {
          return Color.ORANGE;
      }  else {
          return Color.RED;
      }
    }
}
