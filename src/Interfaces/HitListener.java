package Interfaces;

import Geometry.Ball;
import Geometry.Block;

/**
 * @author Eran Shalev Hamdani
 * this interface is a hitlistener, it checks what hapeens when a hit accours.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     The hitter parameter is the Geometry.Ball that's doing the hitting.
     * @param beingHit the block.
     * @param hitter the ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
