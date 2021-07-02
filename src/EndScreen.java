// 313309114.

import biuoop.DrawSurface;
import java.awt.Color;

/**
 *  This class is responsible for the end screen and prints the end screen when the player loses or wins.
 */
public class EndScreen implements Animation {
    private static final int TEXT_X = 150;
    private static final int SIZE_WORDS = 32;
    private static final int WIDTH_SCREEN = 800;
    private static final int HEIGHT_SCREEN = 600;
    private boolean stop;
    private boolean ifWin;
    private Counter score;

    /**
     *  Constructor.
     *
     * @param ifWin flag that say if the player win or lose.
     * @param score the score of the player.
     */
    public EndScreen(boolean ifWin, Counter score) {
        this.ifWin = ifWin;
        this.stop = false;
        this.score = score;
    }

    /**
     *  the function draw on the screen.
     *
     * @param d is the draw surface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.ifWin) {
            d.setColor(new Color(0x3D3F3F));
            d.fillRectangle(0, 0, WIDTH_SCREEN, HEIGHT_SCREEN);
            d.setColor(Color.WHITE);
            d.drawText(TEXT_X, d.getHeight() / 2,
                    "You Win! Your score is " + Integer.toString(this.score.getValue()), SIZE_WORDS);
        } else {
            d.setColor(new Color(0x3D3F3F));
            d.fillRectangle(0, 0, WIDTH_SCREEN, HEIGHT_SCREEN);
            d.setColor(Color.WHITE);
            d.drawText(TEXT_X, d.getHeight() / 2,
                    "Game Over. Your score is " + Integer.toString(this.score.getValue()), SIZE_WORDS);
        }
    }

    /**
     *  The function says whether to stop or not.
     *
     * @return boolean- yes- stop, else don't stop.
     */
    @Override
        public boolean shouldStop() {
            return this.stop;
        }
}
