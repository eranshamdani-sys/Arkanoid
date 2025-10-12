package Games;
/**
 * @author Eran Shalev Hamdani
 * this class makes 3 balls, some blocks and a paddle, the balls jump around and
the paddle is controlled by the left and right keys, it also makes a score which counts
how many blocks have been destroyed.
 **/
public class Ass5Game {
    /**
     * this method makes 2 balls, some blocks and a paddle, the balls jump around and
     the paddle is controlled by the left and right keys.
     * @param args is useless.
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.initialize();
        game.run();
    }
}