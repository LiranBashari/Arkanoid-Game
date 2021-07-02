// 313309114.

import java.util.ArrayList;
import java.util.List;

/**
 * GameEnvironment is a class of  collection of objects that the Ball can collide with.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * constructor that create the collidableList.
     *
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * return the collidables. (We will not use it in the exercise but we will leave it for future use)
     *
     * @return List<Collidable> the collidable List.
     */
    public List<Collidable> getCollidables() {
        return this.collidables;
    }

    /**
     * add the given Collidable c to the environment.
     *
     * @param c the Collidable that we add.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * the method check if the object have a collide with any of the collidables in this collection.
     *if this object will not collide with any of the collidables in this collection, return null. Else, return the
     * information about the closest collision that is going to occur.
     *
     * @param trajectory line starting at current location, and  ending where the velocity will take the object
     * if no collisions will occur.
     * @return null if object not collide with any of the collidables in this collection.
     * Else, return the information about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Point> pointsList = new ArrayList<Point>();
        List<Collidable> collidableList = new ArrayList<Collidable>();
        for (Collidable c : collidables) {
            if ((trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle())) != null) {
                pointsList.add(trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle()));
                collidableList.add(c);
            }
        }
        // will use the function that return the closest point in the list of hit points
        Point closestPoint = trajectory.findClosestIntersection(pointsList);
        if (closestPoint == null) {
            return null;
        }
        Collidable colObject = collidableList.get(pointsList.indexOf(closestPoint));
        return new CollisionInfo(closestPoint, colObject);
    }

    /**
    * remove the object from the game environment.
    *
    *@param c the object to remove.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }
}
