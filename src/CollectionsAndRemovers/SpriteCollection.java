package CollectionsAndRemovers;
import java.util.Collections;
import Interfaces.Sprite;
import biuoop.DrawSurface;
/**
 * this class is a Collection of sprites, it can add a sprite, notify to all of them that time has passed
 and draw all of them.
 */
public class SpriteCollection {
    private java.util.List<Sprite> spriteColl = new java.util.ArrayList<>(Collections.emptyList());
    /**
     * adds a sprite.
     * @param s the sprite.
     */
    public void addSprite(Sprite s) {
        this.spriteColl.add(s);
    }
    /**
     * notify all sprites time has passed.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.spriteColl.size(); i++) {
            spriteColl.get(i).timePassed();
        }
    }
    /**
     * draw all sprites on a given surface.
     * @param d the surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.spriteColl.size(); i++) {
            this.spriteColl.get(i).drawOn(d);
        }
    }

    /**
     * gets a sprite and removes it from the collection.
     * @param s the sprite.
     */
    public void removeSprite(Sprite s) {
        spriteColl.remove(s);
    }
}