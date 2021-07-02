// 313309114.

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * the class create the background of level 1.
 */
public class Level1Background implements Sprite {
    private static final int WIDTH_SCREEN = 800;
    private static final int HEIGHT_SCREEN = 600;
    private static final int CIRCLE_X = 400;
    private static final int CIRCLE_Y = 165;
    private static final int RADIUS1 = 60;
    private static final int RADIUS2 = 90;
    private static final int RADIUS3 = 120;

    /**
     * draw the sprite(the background) on the screen.
     * @param d -the surface that we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0 , WIDTH_SCREEN, HEIGHT_SCREEN);
        d.setColor(Color.BLUE);
        d.drawCircle(CIRCLE_X, CIRCLE_Y, RADIUS1);
        d.setColor(Color.BLUE);
        d.drawCircle(CIRCLE_X, CIRCLE_Y, RADIUS2);
        d.setColor(Color.BLUE);
        d.drawCircle(CIRCLE_X, CIRCLE_Y, RADIUS3);
        d.setColor(Color.BLUE);
        d.drawLine(380, 165, 250, 165);
        d.setColor(Color.BLUE);
        d.drawLine(420, 165, 550, 165);
        d.setColor(Color.BLUE);
        d.drawLine(400, 145, 400, 15);
        d.setColor(Color.BLUE);
        d.drawLine(400, 185, 400, 315);
    }

    /**
     *notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }
}
