package Geometry;
/**
 * @author Eran Shalev Hamdani
 * this class makes a line which is made from two points, start and end, and creates a line
 you can do a lot with the line, like get you its start or end, calculate
 its length, ect...
 **/
public class Line {
    private Point start;
    private Point end;
    /**
     * * this is the builder, it gets a start and an end and creates a line.
     * @param start start.
     * @param end end.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    /**
     * this function calculates the line y start - y end, and x start - x end, and
     gives it as a point, which is needed in the case of wanting to get the M from
     the y=mx+b equation.
     * @return it returns the point.
     */
    public Point m() {
        return new Point(this.start.getX() - this.end.getX(),
                this.start.getY() - this.end.getY());
    }
    /**
     * calculates the b from the y=Mx+b formula or the "a" from the x=a formula.
     * @return it returns the b.
     */
    public double b() {
        if (this.m().getX() == 0) {
            return this.start.getX();
        }
        return this.start.getY() - ((this.m().getY()) / this.m().getX())
                * (this.start.getX());
    }

    /**
     * this function checks if the line merges with another line, it returns 1 if
     they are, 0 if they are parallel to one another or 2 else.
     * @param other the other line we check.
     * @return it returns 0,1,2 like explained.
     */
    public int isMerging(Line other) {
        if (this.equals(other)) {
            return 1;
        }
        if (this.m().getX() == 0 || other.m().getX() == 0) {
            if (this.m().getX() == 0 && other.m().getX() == 0) {
                if (this.b() != other.b()) {
                    return 0;
                }
                if (this.start.getY() < other.start.getY() && this.end.getY() < other.start.getY()) {
                    if (this.start.getY() < other.end.getY() && this.end.getY() < other.end.getY()) {
                        return 0;
                    }
                    if (this.start.equals(other.end) || this.end.equals(other.end)) {
                        return 2;
                    }
                    return 1;
                }
                if (this.isPointOn(other.start)) {
                    if (other.start.equals(this.start)
                            || other.start.equals(this.start)) {
                        return 2;
                    }
                    return 1;
                }
                if (other.end.getY() > this.start().getY()
                || other.end.getY() > this.start().getY()) {
                    return 1;
                }
                if (other.end.equals(this.start) || other.end.equals(this.end)) {
                    return 2;
                }
                return 0;
            }
            return 2;
        }
        if (this.m().getY() / this.m().getX() == other.m().getY() / other.m().getX()) {
            if (this.b() == other.b()) {
                if (this.start.getY() < other.start.getY() && this.end.getY() < other.start.getY()) {
                    if (this.start.getY() < other.end.getY() && this.end.getY() < other.end.getY()) {
                        return 0;
                    }
                    if (this.start.equals(other.end) || this.end.equals(other.end)) {
                        return 2;
                    }
                    return 1;
                }
                if (this.isPointOn(other.start)) {
                    if (other.start.equals(this.start)
                            || other.start.equals(this.start)) {
                        return 2;
                    }
                    return 1;
                }
                if (other.end.getY() > this.start().getY()
                        || other.end.getY() > this.start().getY()) {
                    return 1;
                }
                if (other.end.equals(this.start) || other.end.equals(this.end)) {
                    return 2;
                }
            }
            return 0;
        }
        return 2;
    }
    /**
     * it is a builder that gets the x and the y of the start and end and creates
     the line.
     * @param x1 the x of the start.
     * @param y1 the y of the start.
     * @param x2 the x of the end.
     * @param y2 the y of the end.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }
    /**
     * this function calculates the line's length.
     * @return return the length.
     */
    public double length() {
        return start().distance(end());
    }

    /**
     * this function returns the middle point of the line.
     * @return returns the middle point.
     */
    public Point middle() {
        double x = (this.end().getX() + this.start().getX()) / 2;
        double y = (this.end().getY() + this.start().getY()) / 2;
        return new Point(x, y);
    }
    /**
     * this function returns the start point of the line.
     * @return returns the start point.
     */
    public Point start() {
        return this.start;
    }
    /**
     * this function returns the end point of the line.
     * @return returns the end point.
     */
    public Point end() {
        return this.end;
    }

    /**
     * this function checks if the line and the "other" line are intersecting.
     * @param other the other line we check.
     * @return returns true / false, if they intersect / not.
     */
    public boolean isIntersecting(Line other) {
        if (this.isMerging(other) == 1) {
            return true;
        }
        if (this.isMerging(other) == 0) {
            return false;
        }
        double pointX;
        double pointY;
        if (this.m().getX() == 0 && other.m().getX() == 0) {
            return true;
        }
        if (this.m().getX() == 0 || other.m().getX() == 0) {
            if (this.m().getX() == 0) {
                pointX = this.b();
                pointY = (other.m().getY() / other.m().getX()) * pointX + other.b();
                Point p = new Point(pointX, pointY);
                return this.isPointOn(p) && other.isPointOn(p);
            }
            if (other.m().getX() == 0) {
                pointX = other.b();
                pointY = (this.m().getY() / this.m().getX()) * pointX + this.b();
                Point p = new Point(pointX, pointY);
                return this.isPointOn(p) && other.isPointOn(p);
            }
        }
        if (this.m().getY() / this.m().getX() == other.m().getY() / other.m().getX()) {
            return true;
        }
        pointX = (other.b() - this.b()) / (this.m().getY() / this.m().getX()
                - (other.m().getY() / other.m().getX()));
        pointY = this.m().getY() / this.m().getX() * pointX + this.b();
        Point p = new Point(pointX, pointY);
        return this.isPointOn(p) && other.isPointOn(p);
    }
    /**
     * this function checks if the lines "other1" and "other2" are intersecting.
     * @param other1 the first line.
     * @param other2 the second line.
     * @return returns true / false, if they intersect / not.
     */
    public boolean isIntersecting(Line other1, Line other2) {
        return other1.isIntersecting(other2);
    }
    // Returns the intersection point if the lines intersect,
// and null otherwise.

    /**
     * this function returns the point of intersection between the line and "other".
     * @param other the other line we check.
     * @return return the point of intersection.
     */
    public Point intersectionWith(Line other) {
        if (this.isMerging(other) != 2) {
            return null;
        }
        if (!this.isIntersecting(other)) {
            return null;
        }
        double pointX;
        double pointY;
        if (this.m().getX() == 0 || other.m().getX() == 0) {
            if (this.m().getX() == 0) {
                pointX = this.b();
                pointY = (other.m().getY() / other.m().getX()) * pointX + other.b();
                return new Point(pointX, pointY);
            }
            if (other.m().getX() == 0) {
                pointX = other.b();
                pointY = (this.m().getY() / this.m().getX()) * pointX + this.b();
                return new Point(pointX, pointY);
            }
        }
        if (this.m().getY() / this.m().getX() == other.m().getY() / other.m().getX()) {
            if (this.start.equals(other.end)) {
                return this.start;
            }
            return this.end;
        }
        pointX = (other.b() - this.b()) / (this.m().getY() / this.m().getX()
                - other.m().getY() / other.m().getX());
        pointY = (other.m().getY() / other.m().getX()) * pointX + other.b();
        return new Point(pointX, pointY);
    }
    /**
     * this function return true is the lines are equal, false otherwise.
     * @param other the other line we check.
     * @return returns true if equal and false otherwise.
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start) && this.end.equals(other.end))
                || (this.start.equals(other.end) && this.end.equals(other.start));
    }

    /**
     * this is an override.
     * @return "".
     */
    public String toString() {
        return "start - " + this.start.toString() + ", end - " + this.end.toString();
    }
    /**
     *  If this line does not intersect with the rectangle, return null, otherwise, return the
     closest intersection point to the start of the line.
     * @param rect the rectangle.
     * @return "".
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        java.util.List<Point> points = rect.intersectionPoints(this);
        if (points.isEmpty()) {
            return null;
        }
        int i = 0;
        int counter = 0;
        double smallestDis = this.start.distance(points.get(i));
        while (i < points.size()) {
            if (this.start.distance(points.get(i)) < smallestDis) {
                counter = i;
                smallestDis = this.start.distance(points.get(i));
            }
            i++;
        }
        return points.get(counter);
    }

    /**
     * this method gets a point and return true/false if it is on this line.
     * @param p the point.
     * @return "".
     */
    public boolean isPointOn(Point p) {
        if (this.m().getX() == 0) {
            if (p.getX() == this.b()) {
                if (p.getY() > this.start.getY() && p.getY() > this.end.getY()) {
                    return false;
                }
                return !(p.getY() < this.start.getY()) || !(p.getY() < this.end.getY());
            }
            return false;
        }
        double threshold = 0.00001;
        if (p.getY() < (this.m().getY() / this.m().getX()) * p.getX() + this.b() + threshold
                && (this.m().getY() / this.m().getX()) * p.getX() + this.b() - threshold < p.getY()) {
            if (p.getX() > this.start.getX() && p.getX() > this.end.getX()) {
                return false;
            }
            if (p.getX() < this.start.getX() && p.getX() < this.end.getX()) {
                return false;
            }
            return true;
        }
        return false;
    }
}
