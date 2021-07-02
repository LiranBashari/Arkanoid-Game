// 313309114.

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 *  class that will create classes that can be stoppable.
 */
public class KeyPressStoppableAnimation implements Animation {
    private Animation animation;
    private KeyboardSensor keyboardSensor;
    private String key;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * constructor.
     *
     * @param ks us the keyboard.
     * @param a animation that will be stoppable.
     */
    public KeyPressStoppableAnimation(Animation a, KeyboardSensor ks) {
        this.animation = a;
        this.keyboardSensor = ks;
        this.key = KeyboardSensor.SPACE_KEY;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * draw the current frame and update the animation.
     *
     * @param d  is the surface that we draw on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.keyboardSensor.isPressed(key) && (!(this.isAlreadyPressed))) {
            this.stop = true;
        }
        if (!(this.keyboardSensor.isPressed(key))) {
            this.isAlreadyPressed = false;
        }
    }

    /**
     * if the animation need to stop.
     *
     * @return false/true
     */
    @Override
    public boolean shouldStop() {
            return this.stop;
        }
}
