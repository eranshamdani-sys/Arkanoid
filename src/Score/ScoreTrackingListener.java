package Score;
import Geometry.Ball;
import Geometry.Block;
import Interfaces.HitListener;
/**
 * @author Eran Shalev Hamdani
 * this class tracks the score.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * the builder gets a counter which is the score.
     * @param scoreCounter the counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * in case of a hit the score goes up by 5 points.
     * @param beingHit the block.
     * @param hitter the ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}