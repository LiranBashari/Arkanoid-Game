// 313309114.

import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * the class hold a collection of sprites.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * constructor.
     *
     * build a new spriteList.
     */
    public  SpriteCollection() {
        this.sprites = new ArrayList<>();

    }

    /**
     * the method add the sprite to the SpriteCollection.
     *
     * @param s is the sprite that we add.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
       List<Sprite> spriteTemp = new ArrayList<>(this.sprites);
        for (Sprite sprite : spriteTemp) {
            sprite.timePassed();
        }
    }

    /**
     * call drawOn on all sprites.
     * @param d the DrawSurface that we draw on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s: sprites) {
            s.drawOn(d);
        }
    }

    /**
     * the method remove the sprite.
     *
     * @param s is the sprite that we remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }
}