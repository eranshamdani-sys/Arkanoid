package Geometry;
/**
 * @author Eran Shalev Hamdani
 * this class makes a velocity based on the x and y movements given, it can set the
 dx, dy, give them, use r and the angle to get x y etc...
 **/
public class Velocity {
    private double dx;
    private double dy;
    /**
     * this is the constructor, it gets the dx and dy and creates the velocity.
     * @param dx the dx.
     * @param dy the dy.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * this function moves a point by the velocity.
     * @param p the point.
     * @return returns the moved point.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * makes a velocity from an angle and a radius.
     * @param angle the angle.
     * @param speed the radius.
     * @return returns the new velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
            angle = angle % 360;
        double dx = speed * Math.cos(Math.toRadians(angle));
        double dy = speed * Math.sin(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }
    /**
     * this function returns dx.
     * @return returns dx.
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * this function returns dy.
     * @return returns dy.
     */
    public double getDy() {
        return this.dy;
    }
    /**
     * this function gets a dx and makes it the new dx of the velocity.
     * @param dx the dx.
     */
    public void setDx(double dx) {
        this.dx = dx;
    }
    /**
     * this function gets a dx and makes it the new dx of the velocity.
     * @param dy the dy.
     */
    public void setDy(double dy) {
        this.dy = dy;
    }
    /**
     * this method return the velocity's length.
     * @return "".
     */
    public double getVLength() {
        Point p = new Point(1, 1);
        return p.distance(this.applyToPoint(p));
    }
    @Override
    public String toString() {
        return "dx - " + this.getDx() + ", dy - " + this.getDy();
    }

    /**
     *  gets a velocity and checks if it's equal to this velocity.
     * @param v the velocity.
     * @return "".
     */
    public boolean equals(Velocity v) {
        return this.getDx() == v.getDx() && v.getDy() == this.getDy();
    }
}