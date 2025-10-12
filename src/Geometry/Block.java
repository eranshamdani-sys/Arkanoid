package Geometry;
import Games.Game;
import Interfaces.Collidable;
import Interfaces.HitListener;
import Interfaces.HitNotifier;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Eran Shalev Hamdani
 * this class makes a block from a rectangle and a color
it can draw the block, give you its rectangle, give you the new velocity of a ball that has hit the block etc...
 **/
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private Color c;
    private ArrayList<HitListener> hitListeners = new ArrayList<>();
    /**
     * this is the builder which builds the block from a rectangle and color.
     * @param r1 the rectangle.
     * @param c the color.
     */
    public Block(Rectangle r1, Color c) {
        this.c = c;
        this.rect = r1;
    }
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (!ballColorMatch(hitter)) {
            if (!this.hitListeners.isEmpty()) {
                hitter.setColor(this.c);
            }
            this.notifyHit(hitter);
        }
        if (collisionPoint.equals(this.rect.getLowerLeft())
                || collisionPoint.equals(this.rect.getUpperLeft())
        || collisionPoint.equals(this.rect.getLowerRight())
        || collisionPoint.equals(this.rect.getUpperRight())) {
            return new Velocity(-currentVelocity.getDx(), -currentVelocity.getDy());
        }
        if (this.rect.getUp().isPointOn(collisionPoint)
        || this.rect.getLow().isPointOn(collisionPoint)) {
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
    }

    /**
     * this method gets a surface and draws the block over it.
     * @param surface the surface.
     */
    public void drawOn(DrawSurface surface) {
        Color c = this.c;
        surface.setColor(c);
        surface.fillRectangle((int) this.rect.getUpperLeft().getX(),
                (int) this.rect.getUpperLeft().getY(), (int) this.rect.getWidth(), (int) this.rect.getHeight());
        c = Color.BLACK;
        surface.setColor(c);
        surface.drawRectangle((int) this.rect.getUpperLeft().getX(),
                (int) this.rect.getUpperLeft().getY(), (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }
    /**
     * this function gets a game and add this block to it.
     * @param g the game.
     */
    public void addToGame(Game g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    @Override
    public void timePassed() {
    }
    /**
     * this function gets another block and check if they are the same as this block.
     * @param block the other block.
     * @return "".
     */
    public boolean equals(Block block) {
        return this.getCollisionRectangle().equals(block.getCollisionRectangle()) && this.c == block.c;
    }

    /**
     * this method returns a String that is only this Geometry.Block string.
     * @return "".
     */
    public String toString() {
        return "upper left - " + this.rect.getUpperLeft() + ", width - " + this.rect.getWidth()
                + ", height - " + this.rect.getHeight() + ", color - " + this.c;
    }

    /**
     * this method gets a ball and returns true if the ball's color is the same as this color.
     * @param ball the ball.
     * @return "".
     */
    public boolean ballColorMatch(Ball ball) {
        return ball.getColor() == this.c;
    }

    /**
     * this method gets a game and removes this block from it while removing the block's
     listeners first.
      * @param game the game.
     */
    public void removeFromGame(Game game) {
        for (int i = 0; i < hitListeners.size(); i++) {
            hitListeners.remove(this.hitListeners.get(i));
        }
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * this method gets a Geometry.Ball and notify the listeners that a hit has happened.
     * @param hitter the ball.
     */
    public void notifyHit(Ball hitter) {
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        for (HitListener listener : listeners) {
            listener.hitEvent(this, hitter);
        }
    }

    /**
     * this method returns the hitListeners of the block.
     * @return "".
     */
    public ArrayList<HitListener> getHitListeners() {
        return hitListeners;
    }
}