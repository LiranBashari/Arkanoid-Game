// 313309114.

import biuoop.DrawSurface;

/**
 *Sprite is a game object that can be drawn to the screen.
 */
public interface Sprite {

    /**
     * draw the sprite to the screen.
     * @param d -the surface that we drow on.
     */
    void drawOn(DrawSurface d);

    /**
     *notify the sprite that time has passed.
     */
    void timePassed();
}