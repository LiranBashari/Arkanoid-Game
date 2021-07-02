// 313309114.

import biuoop.DrawSurface;

/**
 * for things that will be animation.
 */
public interface Animation {
    /**
     * draw the current frame update the animation.
     *
     * @param d  is the surface that we draw on.
     */
    void doOneFrame(DrawSurface d);

    /**
     * if the animation need to stop.
     *
     * @return false/true
     */
    boolean shouldStop();
}