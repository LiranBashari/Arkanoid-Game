// 313309114.

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * class that create a screen of a "pause".
 */
public class PauseScreen implements Animation {
    private static final int WIDTH_SCREEN = 800;
    private static final int HEIGHT_SCREEN = 600;
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor.
     * @param k is the keyboard.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * draw the current frame update the animation.
     *
     * @param d is the surface that we draw on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(0x3D3F3F));
        d.fillRectangle(0, 0, WIDTH_SCREEN, HEIGHT_SCREEN);
        d.setColor(Color.WHITE);
        d.drawText(10, d.getHeight() / 2,  "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
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
