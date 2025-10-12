package Games;
import CollectionsAndRemovers.BallRemover;
import CollectionsAndRemovers.BlockRemover;
import CollectionsAndRemovers.GameEnvironment;
import CollectionsAndRemovers.SpriteCollection;
import Geometry.Ball;
import Geometry.Block;
import Geometry.Velocity;
import Geometry.Rectangle;
import Geometry.Paddle;
import Geometry.Point;
import Interfaces.Collidable;
import Interfaces.Sprite;
import Score.Counter;
import Score.ScoreIndicator;
import Score.ScoreTrackingListener;
import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;
import java.util.Collections;
/**
 * @author Eran Shalev Hamdani
 * this class have all the collidables and sprites and starts the game.
 */
public class Game {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    /**
     * builds new game.
     */
    public Game() {
        java.util.List<Collidable> collidables = new java.util.ArrayList<>(Collections.emptyList());
        this.environment = new GameEnvironment(collidables);
        this.sprites = new SpriteCollection();
    }
    /**
     * adds a collidable to the game.
     * @param c the collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**
     * adds a sprite to the game.
     * @param s the sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * builds a game like asked in Part 4.
     */
    @SuppressWarnings("checkstyle:EmptyStatement")
    public void initialize() {
        GUI gui = new GUI("Geometry.Ball", 800, 600);
        this.gui = gui;
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        Ball b1 = new Ball(new Point(10, 40), 5, Color.cyan);
        b1.setVelocity(new Velocity(4, 3));
        Ball b2 = new Ball(new Point(20, 50), 5, Color.black);
        b2.setVelocity(new Velocity(4, 3));
        Ball b3 = new Ball(new Point(40, 110), 5, Color.pink);
        b3.setVelocity(new Velocity(1, 2));
        b1.addToGame(this);
        b2.addToGame(this);
        b3.addToGame(this);
        Color c = Color.BLACK;
        Paddle p = new Paddle(new Rectangle(new Point(400, 550), 100, 10), keyboard);
        Rectangle right = new Rectangle(new Point(800, 20), 1, 600);
        Rectangle left = new Rectangle(new Point(-1, 20), 1, 600);
        Rectangle low = new Rectangle(new Point(0, 600), 800, 1);
        Rectangle up = new Rectangle(new Point(0, 19), 800, 1);
        Block right1 = new Block(right, c);
        Block left1 = new Block(left, c);
        Block low1 = new Block(low, c);
        Block up1 = new Block(up, c);
        this.remainingBalls = new Counter(3);
        this.remainingBlocks = new Counter(40);
        this.score = new Counter(0);
        ScoreIndicator sc = new ScoreIndicator(this.score);
        sc.addToGame(this);
        low1.addHitListener(new BallRemover(this, this.remainingBalls));
        Block[] blocks = new Block[12];
        Block newBlock;
        BlockRemover br = new BlockRemover(this, this.remainingBlocks);
        ScoreTrackingListener trackingListener = new ScoreTrackingListener(this.score);
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0 : c = Color.gray;
                break;
                case 1 : c = Color.red;
                break;
                case 2 : c = Color.yellow;
                break;
                case 3 : c = Color.blue;
                break;
                case 4 : c = Color.white;
                break;
                case 5 : c = Color.green;
                break;
                default: c = Color.BLACK;
            }
            int j;
            for (j = 0; j < 10 - i; j++) {
                newBlock = new Block(new Rectangle(new Point(200 + 60 * i + 60 * j, 220 + 20 * i), 60, 20), c);
                blocks[j] = newBlock;
            }
            for (j = 0; j < 10 - i; j++) {
                blocks[j].addToGame(this);
                blocks[j].addHitListener(br);
                blocks[j].addHitListener(trackingListener);
            }
        }
        right1.addToGame(this);
        left1.addToGame(this);
        up1.addToGame(this);
        low1.addToGame(this);
        p.addToGame(this);
        b1.setCollidables(this.environment);
        b2.setCollidables(this.environment);
        b3.setCollidables(this.environment);
    }
    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (true) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            d.setColor(Color.magenta);
            d.fillRectangle(0, 20, 800, 580);
            this.sprites.drawAllOn(d);

            gui.show(d);
            this.sprites.notifyAllTimePassed();
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                Sleeper sleeper = new Sleeper();
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
            if (this.remainingBlocks.getValue() == 0) {
                gui.close();
                this.score.increase(100);
                return;
            }
            if (this.remainingBalls.getValue() == 0) {
                gui.close();
                return;
            }
        }
    }

    /**
     * this method gets a collidable and removes it from the game.
     * @param c the collidable.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }
    /**
     * this method gets a sprite and removes it from the game.
     * @param s the sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }
}