// 313309114.

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * class that create a sprite of the level name and print it on the screen.
 */
public class LevelName implements Sprite {
    private static final int SCORE_LOCATION_Y = 15;
    private static final int SIZE_OF_WORDS = 13;
    private static final int WIDTH_SCREEN = 800;
    private  String name;

    /**
     * constructor.
     *
     * @param name the level name.
     */
    public LevelName(String name) {
        this.name = name;
    }

    /**
     * draw the name to the screen.
     *
     * @param d -the surface that we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText((WIDTH_SCREEN - (WIDTH_SCREEN / 3)), SCORE_LOCATION_Y,
                "Level Name: " + name, SIZE_OF_WORDS);
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }

    /**
     * add the sprite to the game.
     *
     * @param g - is the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
