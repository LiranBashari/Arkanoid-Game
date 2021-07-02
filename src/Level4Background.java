// 313309114.

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * the class create the background of level 1.
 */
public class Level4Background implements Sprite {
    private static final int WIDTH_SCREEN = 800;
    private static final int HEIGHT_SCREEN = 600;

    /**
     * draw the sprite(the background) on the screen.
     * @param d -the surface that we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0x1E76B4));
        d.fillRectangle(0, 0, WIDTH_SCREEN, HEIGHT_SCREEN);
        // create the left cloud with white rain.
        for (int i = 0; i < 9; i++) {
            d.setColor(Color.white);
            d.drawLine(120 + i * 10, 350, 100 + i * 10, 600);
        }
        d.setColor(new Color(0xBAC2CF));
        d.fillCircle(120, 350, 20);
        d.setColor(new Color(0xBAC2CF));
        d.fillCircle(145, 370, 25);
        d.setColor(new Color(0xB1B7C4));
        d.fillCircle(155, 340, 25);
        d.setColor(new Color(0x9EA4B1));
        d.fillCircle(170, 370, 20);
        d.setColor(new Color(0x9EA4B1));
        d.fillCircle(190, 350, 30);
        // create the right cloud with white rain.
        for (int i = 0; i < 10; i++) {
            d.setColor(Color.white);
            d.drawLine(600 + i * 10, 500, 580 + i * 10, 600);
        }
        d.setColor(new Color(0xBAC2CF));
        d.fillCircle(600, 500, 20);
        d.setColor(new Color(0xBAC2CF));
        d.fillCircle(625, 520, 25);
        d.setColor(new Color(0xB1B7C4));
        d.fillCircle(635, 490, 25);
        d.setColor(new Color(0x9EA4B1));
        d.fillCircle(650, 520, 20);
        d.setColor(new Color(0x9EA4B1));
        d.fillCircle(670, 500, 30);
    }

    /**
     *notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }
}