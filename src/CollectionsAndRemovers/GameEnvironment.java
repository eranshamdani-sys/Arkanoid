package CollectionsAndRemovers;
import Geometry.Line;
import Geometry.Point;
import Interfaces.Collidable;
import java.util.Collections;
/**
 * @author Eran Shalev Hamdani
 * this class have a bunch of collidables, it can add a collidable and check who has the closestcolision with a line.
 */
public class GameEnvironment {
    private java.util.List<Collidable> collidables;
    /**
     * builder, gets a list of collidables and builds an environment.
     * @param collide the list.
     */
    public GameEnvironment(java.util.List<Collidable> collide) {
        this.collidables = collide;
    }

    /**
     *  adds a given collidable to the environment.
     * @param c the collidable.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * Assume an object moving from line.start() to line.end(), if this object will not collide with any of the
     collidables in this collection, return null. Else, return the information about the closest collision that
     is going to occur.
     * @param trajectory the line.
     * @return "".
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        java.util.ArrayList<Point> closestPoints
                = new java.util.ArrayList<>(Collections.emptyList());
        Point newClosestPoint;
        for (Collidable collidable : this.collidables) {
            newClosestPoint = trajectory.closestIntersectionToStartOfLine(
                    collidable.getCollisionRectangle());
            if (newClosestPoint != null) {
                closestPoints.add(newClosestPoint);
            }
        }
        if (closestPoints.isEmpty()) {
            return null;
        }
        int counter = 0;
        double smallestDis = trajectory.start().distance(closestPoints.get(0));
        for (int j = 0; j < closestPoints.size(); j++) {
            if (smallestDis > trajectory.start().distance(closestPoints.get(j))) {
                smallestDis = trajectory.start().distance(closestPoints.get(j));
                counter = j;
            }
        }
        Point pointOfColl = closestPoints.get(counter);
        int d = 0;
        for (int c = 0; c < this.collidables.size(); c++) {
            if (pointOfColl.equals(trajectory.closestIntersectionToStartOfLine(this.collidables.get(c)
                    .getCollisionRectangle()))) {
                d = c;
                break;
            }
        }
        return new CollisionInfo(collidables.get(d), pointOfColl);
    }

    /**
     * removes a given collidable.
     * @param c the given collidable.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }
}
