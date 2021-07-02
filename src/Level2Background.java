// 313309114.

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * the class create the background of level 2.
 */
public class Level2Background implements Sprite {
    private static final int WIDTH_SCREEN = 800;
    private static final int HEIGHT_SCREEN = 600;

    /**
     * draw the sprite(the background) on the screen.
     * @param d -the surface that we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0 , WIDTH_SCREEN, HEIGHT_SCREEN);
        // the lines
        for (int i = 0; i < 70; i++) {
            d.setColor(new Color(255, 254, 147));
            d.drawLine(140, 130, i * 10, 240);
        }
        // big circle
        d.setColor(new Color(253, 255, 181));
        d.fillCircle(140, 130, 60);
        // middle circle
        d.setColor(new Color(255, 245, 120));
        d.fillCircle(140, 130, 50);
        // small circle
        d.setColor(new Color(255, 231, 44));
        d.fillCircle(140, 130, 40);
    }

    /**
     *notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
