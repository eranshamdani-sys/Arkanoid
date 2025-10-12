package Geometry;
import java.util.Collections;
/**
 * @author Eran Shalev Hamdani
 * this class makes a rectangle from its upperleft point, its width and height, it can do
 a lot with it, like calculate the closest colission with a line and more.
 **/
public class Rectangle {
    private Point upperleft;
    private double width;
    private double height;
    /**
     * builds a rectangle like explained before.
     * @param upperLeft the upperleft point.
     * @param width the width.
     * @param height the height.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.height = height;
        this.width = width;
        this.upperleft = upperLeft;
    }
    /**
     * return the upperright Point.
     * @return "".
     */
    public Point getUpperRight() {
        return new Point(upperleft.getX() + width, upperleft.getY());
    }
    /**
     * return the lowerleft Point.
     * @return "".
     */
    public Point getLowerLeft() {
        return new Point(upperleft.getX(), upperleft.getY() + height);
    }
    /**
     * return the lowerright Point.
     * @return "".
     */
    public Point getLowerRight() {
        return new Point(upperleft.getX() + width, upperleft.getY() + height);
    }
    /**
     * return the upperleft Point.
     * @return "".
     */
    public Point getUpperLeft() {
        return upperleft;
    }
    /**
     * return the up Geometry.Line.
     * @return "".
     */
    public Line getUp() {
        return new Line(this.getUpperLeft(), this.getUpperRight());
    }
    /**
     * return the low Geometry.Line.
     * @return "".
     */
    public Line getLow() {
        return new Line(this.getLowerLeft(), this.getLowerRight());
    }
    /**
     * return the left Geometry.Line.
     * @return "".
     */
    public Line getLeft() {
        return new Line(this.getLowerLeft(), this.getUpperLeft());
    }
    /**
     * return the right Geometry.Line.
     * @return "".
     */
    public Line getRight() {
        return new Line(this.getLowerRight(), this.getUpperRight());
    }
    /**
     * returns all the intersectionPoints between this rect and a line.
     * @param line the line.
     * @return "".
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> points = new java.util.ArrayList<>(Collections.emptyList());
        Point p1 = this.getUp().intersectionWith(line);
        if (p1 != null) {
            points.add(p1);
        }
        Point p2 = this.getLeft().intersectionWith(line);
        if (p2 != null) {
            points.add(p2);
        }
        Point p3 = this.getRight().intersectionWith(line);
        if (p3 != null) {
            points.add(p3);
        }
        Point p4 = this.getLow().intersectionWith(line);
        if (p4 != null) {
            points.add(p4);
        }
        return points;
    }
    /**
     * return the width.
     * @return "".
     */
    public double getWidth() {
        return width;
    }
    /**
     * return the height.
     * @return "".
     */
    public double getHeight() {
        return height;
    }
    /**
     * set the upperleft point.
     * @param upperleft the new point.
     */
    public void setUpperLeft(Point upperleft) {
        this.upperleft = upperleft;
    }
    @Override
    public String toString() {
        return "upperleft - " + this.getUpperLeft().toString() + ", width - " + this.getWidth()
                + ", height - " + this.getHeight();
    }
    /**
     * gets a rectangle and returns true if they're equal.
     * @param rect the rectangle.
     * @return "".
     */
    public boolean equals(Rectangle rect) {
        return this.getUpperLeft().equals(rect.getUpperLeft()) && this.getHeight() == rect.getHeight()
                && this.getWidth() == rect.getWidth();
    }
}