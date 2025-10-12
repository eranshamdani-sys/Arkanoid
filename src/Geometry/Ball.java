package Geometry;
import CollectionsAndRemovers.CollisionInfo;
import CollectionsAndRemovers.GameEnvironment;
import Games.Game;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author Eran Shalev Hamdani
 * this class makes a ball from a center point, a color, a radius and velocity,
 it can give you the velocity, size, the x of the center etc...
 **/
public class Ball implements Sprite {
    private Point center;
    private int r;
    private Color color;
    private Velocity v;
    private GameEnvironment collidables;
    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * this method returns the environment of the ball.
     * @return "".
     */
    public GameEnvironment getCollidables() {
        return collidables;
    }
    /**
     * this method set the environment of the ball.
     * @param collidables the environment.
     */
    public void setCollidables(GameEnvironment collidables) {
        this.collidables = collidables;
    }
    /**
     * this is the constructor, it gets the color, center and radius and make a ball.
     * @param center the point of the center of the ball.
     * @param r the ball's radius.
     * @param color the ball's color.
     */
    public Ball(Point center, int r, Color color) {
        this.center = new Point(center.getX(), center.getY());
        this.r = r;
        this.color = color;
        this.v = null;
    }

    /**
     * this function returns the x of the center of the ball.
     * @return returns the x of the center.
     */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * this function returns the y of the center of the ball.
     * @return returns the y of the center.
     */
    public int getY() {
        return (int) this.center.getY();
    }
    /**
     * this function returns the radius of the ball.
     * @return returns the radius.
     */
    public int getSize() {
        return this.r;
    }
    /**
     * this function returns the color of the ball.
     * @return returns the color.
     */
    public Color getColor() {
        return this.color;
    }
    // draw the ball on the given DrawSurface

    /**
     * this method returns the center of the ball.
     * @return "".
     */
    public Point getCenter() {
        return this.center;
    }
    /**
     * this function draws the ball on a surface.
     * @param surface the surface.
     */
    public void drawOn(DrawSurface surface) {
        Color c = this.color;
        surface.setColor(c);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }
    /**
     * this function set the velocity of the ball to the velocity given.
     * @param v the velocity given.
     */
    public void setVelocity(Velocity v) {
        this.v = v;
    }
    /**
     * this function gets the dx and dy creates a velocity and sets the
     velocity of the ball.
     * @param dx the dx.
     * @param dy the dy.
     */
    public void setVelocity(double dx, double dy) {
        setVelocity(new Velocity(dx, dy));
    }
    /**
     * this function returns the velocity of the ball.
     * @return returns the velocity.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * this function moves the ball by its velocity.
     */
    public void moveOneStep() {
        Line trajectory = new Line(this.getCenter(), this.getVelocity().applyToPoint(
                this.getCenter()));
        CollisionInfo ci = this.getCollidables().getClosestCollision(trajectory);
        if (ci != null) {
            this.setVelocity(ci.collisionObject().hit(this, ci.collisionPoint(),
                    this.getVelocity()));
        }
        this.center = this.v.applyToPoint(this.center);
    }

    /**
     * this function gets a game and add this ball to it.
     * @param g the game.
     */
    public void addToGame(Game g) {
        g.addSprite(this);
    }
    /**
     * this function get another ball and check if it's equals to our ball.
     * @param ball the other ball.
     * @return "".
     */
    public boolean equals(Ball ball) {
        return this.getX() == ball.getX() && this.getY() == ball.getY() && this.getSize() == ball.getSize();
    }

    /**
     * this function returns the string of this ball.
     * @return "".
     */
    public String toString() {
        return "x - " + this.getX() + ", y - " + this.getY() + ", size - " + this.getSize();
    }

    /**
     * this method gets a color and changes the ball's color to the given color.
     * @param color the given color.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * this class gets a game and removes this call from it.
     * @param game the game.
     */
    public void removeFromGame(Game game) {
        game.removeSprite(this);
    }
}