package Geometry;
import Games.Game;
import Interfaces.Collidable;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
/**
 * @author Eran Shalev Hamdani
 * this class makes a Geometry.Paddle from a keyboard and a rectangle.
 **/
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rect;
    /**
     * this is the builder, it gets the keyboard and the rect and builds the paddle.
     * @param rect the rect.
     * @param keyboard the keyboard.
     */
    public Paddle(Rectangle rect, biuoop.KeyboardSensor keyboard) {
        this.rect = rect;
        this.keyboard = keyboard;
    }
    /**
     * this method moves the paddle left.
     */
    public void moveLeft() {
        this.rect.setUpperLeft(new Point(this.rect.getUpperLeft().getX() - 10, this.rect.getUpperLeft().getY()));
        if (this.rect.getUpperLeft().getX() < 0) {
            this.rect.setUpperLeft(new Point(this.rect.getUpperLeft().getX() + 700, this.rect.getUpperLeft().getY()));
        }
    }
    /**
     * this method moves the paddle right.
     */
    public void moveRight() {
        this.rect.setUpperLeft(new Point(this.rect.getUpperLeft().getX() + 10, this.rect.getUpperLeft().getY()));
        if (this.rect.getUpperRight().getX() > 800) {
            this.rect.setUpperLeft(new Point(this.rect.getUpperLeft().getX() - 700, this.rect.getUpperLeft().getY()));
        }
    }
    /**
     * this method checks if the right key or the left key is pressed and move the paddle accordingly.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY) || keyboard.isPressed("a")
        || keyboard.isPressed("ש") || keyboard.isPressed("A")) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY) || keyboard.isPressed("d")
        || keyboard.isPressed("ג") || keyboard.isPressed("D")) {
            this.moveRight();
        }
    }
    /**
     * this method gets a surface and draws the paddle on it, in yellow because that is what we were shown in Part 4.
     * @param d the surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.YELLOW);
        d.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }
    /**
     * this method return the Geometry.Rectangle.
     * @return "".
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double v = currentVelocity.getVLength();
        if (collisionPoint.getX() <= this.rect.getUpperLeft().getX()
                + this.rect.getWidth() / 5) {
            return new Velocity(-v * Math.sqrt(3) / 2, -v / 2);
        }
        if (collisionPoint.getX() <= this.rect.getUpperLeft().getX()
                + 2 * this.rect.getWidth() / 5) {
            return new Velocity(-v / 2, -v * Math.sqrt(3) / 2);
        }
        if (collisionPoint.getX() <= this.rect.getUpperLeft().getX()
                + 3 * this.rect.getWidth() / 5) {
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        if (collisionPoint.getX() <= this.rect.getUpperLeft().getX()
                + 4 * this.rect.getWidth() / 5) {
            return new Velocity(v / 2, -v * Math.sqrt(3) / 2);
        }
        return new Velocity(v * Math.sqrt(3) / 2, -v / 2);
    }
    /**
     * Add this paddle to the game.
     * @param g the game.
     */
    public void addToGame(Game g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * this method checks if 2 paddles have the same rect.
     * @param p the other paddle.
     * @return "".
     */
    public boolean equals(Paddle p) {
        return this.rect.equals(p.getCollisionRectangle());
    }

    @Override
    public String toString() {
        return this.rect.toString();
    }
}