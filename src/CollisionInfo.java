// 313309114.

/**
 * class that keep the following information: collision Point and collision Object.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable objColl;

    /**
     * constructor that create the CollisionInfo.
     *
     * @param p  is a Point- the collision Point.
     * @param objectC is an object- collidable object involved in the collision.
     */
    public  CollisionInfo(Point p, Collidable objectC) {
        this.collisionPoint = p;
        this.objColl = objectC;
    }

    /**
     * method that return the point at which the collision occurs.
     *
     * @return Point-the collision Point
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * the method return the the collidable object involved in the collision.
     *
     * @return collidable- the collidable object.
     */
    public Collidable collisionObject() {
        return this.objColl;
    }
}