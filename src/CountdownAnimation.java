import biuoop.DrawSurface;
// 313309114.

import java.awt.Color;

// The CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.

/**
 * class that create a countdown that display on the screen from 3 to 1 that display in the start of each turn.
 *
 */
public class CountdownAnimation implements Animation {
    private static final int WIDTH_SCREEN = 800;
    private static final int HEIGHT_SCREEN = 600;
    private static final int SIZE_COUNT = 80;
    private double numOfSeconds;
    private  int countFrom;
    private SpriteCollection gameScreen;
    private double wait;

    /**
     * constructor.
     *
     * @param numOfSec the num of second to wait at all from the start of the count untill the end.
     * @param countF    from what number to count.
     * @param gameScreen   the screen that we display on the count.
     */
    public CountdownAnimation(double numOfSec,  int countF, SpriteCollection gameScreen) {
        this.countFrom = countF;
        this.gameScreen = gameScreen;
        this.numOfSeconds = numOfSec;
        this.wait = this.numOfSeconds / this.countFrom;
    }

    /**
     * draw one frame.
     *
     * @param d  is the surface that we draw on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.YELLOW);
        d.drawText(WIDTH_SCREEN / 2, HEIGHT_SCREEN / 2, Integer.toString(this.countFrom), SIZE_COUNT);
        //if is not  the first number,wait before you display it.
        if (wait != this.numOfSeconds / this.countFrom) {
            sleeper.sleepFor((long) wait * 1000 + 760);
        }
        this.countFrom -= 1;
    }

    /**
     * stop the animation if it end count.
     *
     * @return true if should stop otherwise false.
     */
    @Override
    public boolean shouldStop() {
        return this.countFrom < 0;
    }
}
