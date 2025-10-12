package CollectionsAndRemovers;
import Interfaces.HitListener;
import Geometry.Ball;
import Geometry.Block;
import Games.Game;
import Score.Counter;

/**
 * @author Eran Shalev Hamdani.
 * a CollectionsAndRemovers.BlockRemover is in charge of removing blocks from the game,
 as well as keeping count of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private Game game;
    private Counter remainingBlocks;

    /**
     * this is the builder, it gets a game and the counter of the remaining blocks.
     * @param game the game.
     * @param remainingBlocks the counter.
     */
    public BlockRemover(Game game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * Blocks that are hit should be removed from the game that is being removed
     from the game.
     * @param beingHit the block that should be removed.
     * @param hitter the ball which hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(1);
    }
}
