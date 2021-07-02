// 313309114.

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * class that indicate how much score you have to the screen.
 */
public class ScoreIndicator implements Sprite {
    private static final int SCORE_LOCATION_Y = 15;
    private static final int SIZE_OF_WORDS = 13;
    private static final int WIDTH_SCREEN = 800;
    private Counter score;
    private Color color;
    private Rectangle rectangle;

    /**
     * constructor.
     * @param rec is the rectangles that the lives will print on.
     * @param s is the counter that count how much score you have.
     * @param c is the color.
     */
    public ScoreIndicator(Rectangle rec, Color c, Counter s) {
        this.rectangle = rec;
        this.color = c;
        this.score = s;
    }

    /**
     * draw the sprite(score) on the screen.
     * @param d -the surface that we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        Point start = this.rectangle.getUpperLeft();
        double width = this.rectangle.getWidth();
        double height = this.rectangle.getHeight();
        // size of string's words
        int scoreLocationX = WIDTH_SCREEN / 3;
        // the score in string
        String myScore = Integer.toString(this.score.getValue());
        d.setColor(this.color);
        d.fillRectangle((int) start.getX(), (int) start.getY(), (int) width, (int) height);
        d.setColor(Color.BLACK);
        d.drawText(scoreLocationX, SCORE_LOCATION_Y, "Score: " + myScore, SIZE_OF_WORDS);
    }

    /**
     *notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }

    /**
     * add this sprite to the game.
     * @param g - is the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
