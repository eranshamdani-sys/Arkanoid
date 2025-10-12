package CollectionsAndRemovers;
import Geometry.Point;
import Interfaces.Collidable;

/**
 * @author Eran Shalev Hamdani
 * this is a class which holds the collisionPoint and collisionObject, and it can return those:).
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;
    /**
     * the builder which gets the object and point and build a CollectionsAndRemovers.CollisionInfo.
     * @param collisionObject the object.
     * @param collisionPoint the point.
     */
    public CollisionInfo(Collidable collisionObject, Point collisionPoint) {
        this.collisionObject = collisionObject;
        this.collisionPoint = collisionPoint;
    }
    /**
     * return the point.
     * @return "".
     */
    public Point collisionPoint() {
        return collisionPoint;
    }
    /**
     * return the object.
     * @return "".
     */
    // the collidable object involved in the collision.
    public Collidable collisionObject() {
        return collisionObject;
    }

    /**
     * gets another CollectionsAndRemovers.CollisionInfo and checks if they're the same.
     * @param ci the other CollectionsAndRemovers.CollisionInfo.
     * @return "".
     */
    public boolean equals(CollisionInfo ci) {
        return this.collisionObject.equals(ci.collisionObject) && this.collisionPoint.equals(ci.collisionPoint);
    }
    /**
     * this is an override.
     * @return "".
     */
    public String toString() {
        return "collision Object - " + this.collisionObject.toString() + "collision Point - "
                + this.collisionPoint.toString();
    }
}