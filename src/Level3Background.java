// 313309114.

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * the class create the background of level 3.
 */
public class Level3Background implements Sprite {
    private static final int WIDTH_SCREEN = 800;
    private static final int HEIGHT_SCREEN = 600;

    /**
     * draw the sprite(the background) on the screen.
     * @param d -the surface that we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0x349B02));
        d.fillRectangle(0, 0, WIDTH_SCREEN, HEIGHT_SCREEN);
        d.setColor(new Color(255, 218, 129));
        d.fillCircle(120, 180, 10);
        d.setColor(new Color(255, 110, 120));
        d.fillCircle(120, 180, 6);
        d.setColor(Color.WHITE);
        d.fillCircle(120, 180, 2);
        // The roof of the building
        d.setColor(new Color(77, 81, 82));
        d.fillRectangle(116, 190, 8, 150);
       // The roof of the building
        d.setColor(new Color(44, 48, 49));
        d.fillRectangle(109, 340, 22, 50);
        // the building
        d.setColor(new Color(0, 0, 0));
        d.fillRectangle(70, 390, 100, 210);
        // the white windows
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                d.setColor(Color.white);
                d.fillRectangle(75 + i * 20, 398 + j * 30, 10, 20);
            }
        }
    }

    /**
     *notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }
}