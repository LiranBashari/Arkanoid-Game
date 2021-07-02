// 313309114.

import biuoop.KeyboardSensor;
import java.util.List;

/**
 * This class will be in charge of creating the different levels, and moving from one level to the next.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;

    /**
     * constructor.
     *
     * @param ar is a the animation runner
     * @param ks is the keyboard
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = new Counter(0);
    }

    /**
     * the method run the levels and change from one level to the next.
     * @param levels is list of the levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean ifWin = true;
        // a loop that run the levels.
        for (LevelInformation levelInfo : levels) {
            //create the level
            GameLevel level = new GameLevel(this.animationRunner, levelInfo, this.keyboardSensor, this.score);
            level.initialize();
            while ((level.getNumOfBlocks() > 0) && (level.getNumOfBalls() > 0)) {
                //run the level
                level.run();
            }
            if (!(level.getNumOfBalls() > 0)) {
                //if the user loose
                ifWin = false;
                this.animationRunner.run(new KeyPressStoppableAnimation(
                        new EndScreen(ifWin, this.score), this.keyboardSensor));
                this.animationRunner.getGui().close();
            }
        }
        this.animationRunner.run(new KeyPressStoppableAnimation(
                new EndScreen(ifWin, this.score), this.keyboardSensor));
        this.animationRunner.getGui().close();
    }
}
