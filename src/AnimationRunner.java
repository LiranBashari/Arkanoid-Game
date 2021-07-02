// 313309114.

import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * The animation.AnimationRunner takes an animation.Animation object and runs it.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;

    /**
     * constructor.
     *
     * @param g is the gui
     */
    public AnimationRunner(GUI g) {
        this.framesPerSecond = 60;
        this.gui = g;
    }

    /**
     * the method run the object.
     *
     * @param animation is a object that we want to to the animation on him
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            biuoop.Sleeper sleeper = new biuoop.Sleeper();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * the method get the gui.
     *
     * @return the gui.
     */
    public GUI getGui() {
        return gui;
    }
}