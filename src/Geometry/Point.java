package Geometry;
/**
 * @author Eran Shalev Hamdani
 * this class makes a point which is made from an x and a y
 and can do a lot with it, like give you its x or y, or calculate the
 distance between 2 points etc...
 **/
public class Point {
    private double x;
    private double y;

    /**
     * this is the builder, it gets an x and a y and creates a point.
     * @param x the x of the point.
     * @param y the y of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * this function get a point, and calculates its distance from our point.
     * @param other the other point.
     * @return returns the distance from our point.
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
    /**
     * this function gets a point and returns true if they are equal and false otherwise.
     * @param other the other point we check.
     * @return returns true / false if they are equals / not.
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return other.getX() == this.getX() && other.getY() == this.getY();
    }
    @Override
    public String toString() {
        return "x - " + this.x + ", y - " + this.y;
    }
    /**
     * this function returns the x of the Point.
     * @return returns the x of the point;
     */
    public double getX() {
        return x;
    }
    /**
     * this function returns the x of the Point.
     * @return returns the y of the point;
     */
    public double getY() {
        return y;
    }

    /**
     * .
     * @param args .
     */
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        System.out.println(p1.equals(p2));
    }
}
