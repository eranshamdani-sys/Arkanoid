package CollectionsAndRemovers;
import Interfaces.HitListener;
import Score.Counter;
import Geometry.Ball;
import Geometry.Block;
import Games.Game;
/**
 * @author Eran Shalev Hamdani
 * this class is a listener which checks whenever the ball hits the "death block"
 which is at the bottom of the screen, it can check how many balls are left and has
 the game as a field.
 */
public class BallRemover implements HitListener {
    private Game game;
    private Counter remainingBalls;

    /**
     * this is the builder which gets a game and a counter and build a ball remover.
     * @param game the game.
     * @param remainingBalls the counter.
     */
    public BallRemover(Game game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
