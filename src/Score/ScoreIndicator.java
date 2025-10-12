package Score;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;
import Games.Game;
/**
 * @author Eran Shalev Hamdani
 * this class is the score indicator which prints the score, it has the score as a
 Score.Counter so if it changes in the classes game or Score.ScoreTrackingListener, it will also
 change here.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * the builder gets the score as a Score.Counter and builds a new Score.ScoreIndicator.
     * @param score the score.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    @Override
    public void timePassed() { }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(400, 18, "Score: " + this.score.getValue(), 16);
    }

    /**
     * this is a sprite which needs to be added to the game.
     * @param g the game.
     */
    public void addToGame(Game g) {
        g.addSprite(this);
    }
}
