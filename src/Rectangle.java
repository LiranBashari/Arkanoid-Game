// 313309114.

import java.util.ArrayList;
import java.util.List;

/**
 * class the create rectangle with point, width and height.
 */
public class Rectangle {
    private double width;
    private double height;
    private Point upperLeft;

    /**
     * constructor- create a new rectangle with location and width/height.
     *
     * @param upperLeft is the upperLeft point of the rectangles (the location).
     * @param width -the width of the rectangle.
     * @param height - te height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.height = height;
        this.width = width;
    }

    /**
     * check if we have intersection points with the specified line that we got with the rectangle (that have 4 lines).
     * and if we have, put it ia array list.
     * @param line -the line that we check intersection with the rectangle.
     * @return a (possibly empty) List of intersection points
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        // 3 other Point of the rectangle
        Point lowerLeftPoint = new Point(upperLeft.getX(), upperLeft.getY() + this.height);
        Point lowerRightPoint = new Point(upperLeft.getX() + this.width, upperLeft.getY() + height);
        Point upperRightPoint = new Point(upperLeft.getX() + this.width, upperLeft.getY());
        // 4 line's of the rectangle
        Line recRightLine = new Line(lowerRightPoint, upperRightPoint);
        Line recLeftLine = new Line(this.upperLeft, lowerLeftPoint);
        Line recUpperLine = new Line(this.upperLeft, upperRightPoint);
        Line recLowerLine = new Line(lowerLeftPoint, lowerRightPoint);
        // new List of point
        List<Point> pointList = new ArrayList<Point>();
        //check intersection with the left line of the rectangle
        if (line.isIntersecting(recLeftLine)) {
            pointList.add(line.intersectionWith(recLeftLine));
        }
        //check intersection with the right line of the rectangle
        if (line.isIntersecting(recRightLine)) {
            pointList.add(line.intersectionWith(recRightLine));
        }
        //check intersection with the upper line of the rectangle
        if (line.isIntersecting(recUpperLine)) {
            pointList.add(line.intersectionWith(recUpperLine));
        }
         //check intersection with the lower line of the rectangle
        if (line.isIntersecting(recLowerLine)) {
            pointList.add(line.intersectionWith(recLowerLine));
        }
        return pointList;
    }

    /**
     * the method return the width of the rectangle.
     *
     * @return double- the width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * the method return the height of the rectangle.
     *
     * @return double- the height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * the method returns the upper-left point of the rectangle.
     *
     * @return point,the Upper Left point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * the method change the upper left point of the rectangle.
     *
     * @param upperLeft1 is the upper left point.
     */
    public void setUpperLeft(Point upperLeft1) {
        this.upperLeft = upperLeft1;
    }
}
