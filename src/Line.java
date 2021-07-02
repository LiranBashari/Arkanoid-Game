// 313309114.

import java.util.List;

/**
 * the class create a line with two Points.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * constructors that create a line by 2 points.
     *
     * @param start is Point,present the start of the line.
     * @param end   is Point,present the end of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    /**
     * constructors that create a line by 4 double values of x and y.
     *
     * @param x1 is double, present the x value of the start point.
     * @param y1 is double, present the y value of the start point.
     * @param x2 is double, present the x value of the end point.
     * @param y2 is double, present the y value of the end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * calculate the length of the line.
     *
     * @return double, the length of the line.
     */
    public double length() {
        return this.start.distance(end);
    }


    /**
     * calculate the middle point of the line.
     *
     * @return Point, the middle point of the line.
     */
    public Point middle() {
        double middleX = ((this.start.getX() + this.end.getX()) / 2);
        double middleY = ((this.start.getY() + this.end.getY()) / 2);
        return new Point(middleX, middleY);
    }

    /**
     * the function return the start point of the line.
     *
     * @return point, the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * the function return the end point of the line.
     *
     * @return point, the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * check if we have intersecting point between the 2 lines.
     *
     * @param other is a line that we check if we have intersecting point with.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        if (other == null) {
            return false;
        }
        return (this.intersectionWith(other) != null);
    }

    /**
     * checking for a point whether it is within range.
     *
     * @param xRange is double, present the x value of the point that we will check if it is in range.
     * @param yRange is double, present the y value of the point that we will check if it is in range.
     * @param x1 is double, point value with which we check whether the value in the range.
     * @param y1 is double, point value with which we check whether the value in the range.
     * @param x2 is double, point value with which we check whether the value in the range.
     * @param y2 is double, point value with which we check whether the value in the range.
     * @return true if the point in range, false otherwise.
     */
    public boolean inRange(double xRange, double yRange, double x1, double y1, double x2, double y2) {
        if (((xRange >= x1) && (xRange <= x2)) || ((xRange >= x2) && (xRange <= x1))) {
            return ((yRange >= y1) && (yRange <= y2)) || ((yRange >= y2) && (yRange <= y1));
        }
        return false;
    }

    /**
     * check if we have intersection point,if we have return the intersection point.
     *
     * @param other is a Line, the line that we check if we have intersection point with.
     * @return returns the intersection point if the lines intersect, null otherwise.
     */
    public Point intersectionWith(Line other) {
        double x1This = this.start.getX();
        double y1This = this.start.getY();
        double x2This = this.end.getX();
        double y2This = this.end.getY();
        double x1Other = other.start.getX();
        double y1Other = other.start.getY();
        double x2Other = other.end.getX();
        double y2Other = other.end.getY();
        //check if we got points with values
        if (other.end == null || other.start == null) {
            return null;
        }
        // if both of the line are point
        if ((this.start.getX() == this.end.getX()) && (other.end.getX() == other.start.getX())
                && (this.start.getY() == this.end.getY() && (other.end.getY() == other.start.getY()))) {
            // if it's the same point
            if (this.start.getX() == other.start.getX()) {
                return new Point(this.start.getX(), this.start.getY());
            }
            return null;
        }

        //if this line dont have slope and the other line have:
        if ((x1This == x2This) && (x2Other != x1Other)) {
            double slopeOther = ((y2Other - y1Other) / (x2Other - x1Other));
            double bEquationOther = y1Other - slopeOther * (x1Other);
            double intersectingY = slopeOther * x1This + bEquationOther;
            //check if the intersection point is in the lines by check if it is between the x's
            if (((x1This <= x2Other) && (x1This >= x1Other)) || ((x1This <= x1Other) && (x1This >= x2Other))) {
                //and if its between the y's
                if ((intersectingY >= y1This && intersectingY <= y2This)
                        || (intersectingY <= y1This && intersectingY >= y2This)) {
                    //if it is-creat the intersecting Point.
                    return new Point(x1This, intersectingY);
                }
            } else {
                //if it isnt between the line return null.
                return null;
            }
        }
        //if other line don't have slope and the this line have:
        if ((x1This != x2This) && (x2Other == x1Other)) {
            double slopeThis = ((y2This - y1This) / (x2This - x1This));
            //calculate the 'b' of y=mx+b Equation
            double bEquationThis = y1This - (slopeThis * (x1This));
            //calculate the y value of the intersection point
            double intersectingY = slopeThis * x1Other + bEquationThis;
            //check if the intersection point is in the lines by check if it is between the x's
            if (((x1Other <= x2This) && (x1Other >= x1This)) || ((x1Other <= x1This) && (x1Other >= x2This))) {
                //and if its between the y's
                if ((intersectingY >= y1Other && intersectingY <= y2Other)
                        || (intersectingY <= y1Other && intersectingY >= y2Other)) {
                    //if it is-create the intersecting Point.
                    return new Point(x1Other, intersectingY);
                }
            } else {
                //if it isn't between the line return null.
                return null;
            }
        }
        // find the slopes by the equation
        double slopeThis = ((y2This - y1This) / (x2This - x1This));
        double slopeOther = ((y2Other - y1Other) / (x2Other - x1Other));
        // if the same slope
        if (slopeOther == slopeThis) {
            // if one line end and the second line start in the exact point
            if ((x2This == x1Other) && (y2This == y1Other)) {
                if (((x2This > x1This) && (x2This < x2Other)) || ((x2This < x1This) && (x2This > x2Other))) {
                    return new Point(x2This, y2This);
                }
            } else if ((x2Other == x1This) && (y2Other == y1This)) {
                if (((x2Other > x1Other) && (x2Other < x2This)) || ((x2Other < x1Other) && (x2Other > x2This))) {
                    return new Point(x2Other, y2Other);
                }
            } else if ((x1Other == x1This) && (y1Other == y1This)) {
                if (((x1Other > x2Other) && (x1Other < x2This)) || ((x1Other < x2Other) && (x1Other > x2This))) {
                    return new Point(x1Other, y1Other);
                }
            } else if ((x2Other == x2This) && (y2Other == y2This)) {
                if (((x2Other > x1Other) && (x2Other < x1This)) || ((x2Other < x1Other) && (x2Other > x1This))) {
                    return new Point(x2Other, y2Other);
                }
            } else {
                return null;
            }
        }
        // if other and this both of them parallel to the y axis
        if (((x1This == x2This) && (y1This != y2This)) && (((x1Other == x2Other) && (y1Other != y2Other)))) {
            // if one line end and the second line start in the exact point:
            if ((x2This == x1Other) && (y2This == y1Other)) {
                return new Point(x2This, y2This);
            } else if ((x2Other == x1This) && (y2Other == y1This)) {
                return new Point(x2Other, y2Other);
            }
            return null;
        }
        // if This is a point and Other is a line:
        if ((x1This == x2This) && (y1This == y2This)) {
            // calculate the 'b' of y=mx+b equation of other
            double bOther = y1Other - (slopeOther * x1Other);
            // if the This point is on the Other line
            if (y1This == slopeOther * x1This + bOther) {
                // if in range
                if (inRange(x1This, y1This, x1Other, y1Other, x2Other, y2Other)) {
                    return new Point(x1This, y1This);
                }
            }
        }
        // if Other is a point and This is a line:
        if ((x1Other == x2Other) && (y1Other == y2Other)) {
            // calculate the 'b' of y=mx+b equation of this
            double bThis = y1This - (slopeThis * x1This);
            // if the Other point is on the This line
            if (y1Other == slopeThis * x1Other + bThis) {
                // if in range
                if (inRange(x1Other, y1Other, x1This, y1This, x2This, y2This)) {
                    return new Point(x1Other, y1Other);
                }
            }
        }
        // calculate the 'b' of y=mx+b equation
        double bOther = y1Other - (slopeOther * x1Other);
        double bThis = y1This - (slopeThis * x1This);
        // find the  intersection x point by comparing the equation
        double  intersectionX = ((bOther - bThis) / (slopeThis - slopeOther));
        // find the  intersection y point by set in the equation.
        double intersectingY = slopeOther * intersectionX + bOther;
        //check if the value of x is in the line of this
        int checkIn = 0;
        if ((intersectionX <= x2This) && (intersectionX >= x1This)) {
            checkIn++;
        } else if ((intersectionX <= x1This) && (intersectionX >= x2This)) {
            checkIn++;
        }
        if ((intersectionX <= x2Other) && (intersectionX >= x1Other)) {
            checkIn++;
        } else if ((intersectionX <= x1Other) && (intersectionX >= x2Other)) {
            checkIn++;
        }
        //if the intersecting point is between the 2 lines:
        if (checkIn == 2) {
            //create and return the intersecting point.
            return new Point(intersectionX, intersectingY);
        } else {
            //if the point is not between the lines
            return null;
        }
    }

    /**
     * check if the two lines are equals.
     *
     * @param other is a line that we check if it the same line.
     * @return true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        int equal = 0;
        // if all the x,y values of the start and end in 'this' line are the same like start and end of 'other' line.
        if ((this.start.getX() == other.start.getX()) && (this.start.getY() == other.start.getY())
                && (this.end.getX() == other.end.getX()) && (this.end.getY() == other.end.getY())) {
            equal++;
        } else if ((this.start.getX() == other.end.getX()) && (this.start.getY() == other.end.getY())
                && (this.end.getX() == other.start.getX()) && (this.end.getY() == other.start.getY())) {
            equal++;
        }
        return equal != 0;
    }

    /**
     * the method check if we have intersection point with the rectangle with a line and call to another function,
     * and return the closest point to the start.
     *
     * @param rect the rectangle that we check intersection point with.
     * @return Point if we have intersection point return the closest intersection point otherwise return null.
     *
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //create a least with the intersection point
        List<Point> pointsList = rect.intersectionPoints(this);
        return findClosestIntersection(pointsList);
    }

    /**
     * method that get a list of points and check who is the closest point to the start of the line and return it.
     *
     * @param pointsList List<Point> the list of the intersection points.
     * @return Point that present the closest point.if the list is empty return null.
     */
    public Point findClosestIntersection(List<Point> pointsList) {
        Point closestPoint = null;
        double currentDistance;
        if (!(pointsList.isEmpty())) {
            // initialize the first point to be the closest one
            closestPoint = pointsList.get(0);
            // same about the distance
            currentDistance = this.start.distance(closestPoint);
            for (int i = 1; i < pointsList.size(); i++) {
                if (this.start.distance(pointsList.get(i)) < currentDistance) {
                    // if find smaller distance the point we choose is the smallest
                    closestPoint = pointsList.get(i);
                    currentDistance = this.start.distance(pointsList.get(i));
                }
            }
        } else { // if list are empty
            return null;
        }
        return closestPoint;
    }
}