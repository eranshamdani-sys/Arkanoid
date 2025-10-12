package Interfaces;
import biuoop.DrawSurface;
/**
 * this interface has the ball, the paddle and the blocks, it notifies them when time has passed and draw them.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     * @param d the screen.
     */
    void drawOn(DrawSurface d);
    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}