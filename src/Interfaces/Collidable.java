package Interfaces;
import Geometry.Ball;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;

/**
 * @author Eran Shalev Hamdani
 * this interface is for all collidables, blocks and paddles, they can all give their rectangle, and change the
 velocity of a ball hitting them.
 */
public interface Collidable {
    /**
     * this method returns the rectangle of the collidable.
     * @return "".
     */
    Rectangle getCollisionRectangle();
    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).

    /**
     * this method change the velocity of a ball hitting this collidable.
     * @param collisionPoint the collisionPoint.
     * @param currentVelocity the old velocity of the ball.
     * @param hitter the ball.
     * @return the new velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}