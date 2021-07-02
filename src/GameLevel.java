import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;


/**
 * class that hold the sprites and the collidables, game environment and gui, and charge of the animation.
 *
 */
public class GameLevel implements Animation {
    // use in constant for comfort and order:
    private static final int RADIUS = 5;
    private static final int WIDTH_SCREEN = 800;
    private static final int HEIGHT_SCREEN = 600;
    private static final int PADDLE_HEIGHT = 15; // According to the task approximately
    private static final int HEIGHT_BLOCK = 25; // According to the task approximately
    private static final int HEIGHT_SCORE_BLOCK = 20; // According to the task approximately

    // members
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter counterBlocks;
    private Counter counterBalls;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInfo;

    /**
     * constructor.
     *
     *
     * @param animationRunner is the animation runner.
     * @param levelInfo is the information about the level.
     * @param keyboardSens  is the keyboard.
     * @param c is the counter of the score.
     */
    public GameLevel(AnimationRunner animationRunner, LevelInformation levelInfo,
                     KeyboardSensor keyboardSens, Counter c) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.counterBlocks = new Counter(0);
        this.counterBalls = new Counter(0);
        this.score = new Counter(0);
        this.running = true;
        this.runner = animationRunner;
        this.keyboard = keyboardSens;
        this.levelInfo = levelInfo;
        this.score = c;
    }

    /**
     * the method add the Collidable that we get to the game.
     *
     * @param c the added Collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * the method add the Sprite that we get to the game.
     *
     * @param s the added Sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * the method remove the Collidable that we get to the game.
     *
     * @param c the removed Collidable.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * the method remove the Sprite that we get to the game.
     *
     * @param s the removed Sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * initialize a new game, create the Blocks, Ball, and add them to the game.
     *
     */
    public void initialize() {
        Sprite background = this.levelInfo.getBackground();
        this.addSprite(background);
        BlockRemover blockRemover = new BlockRemover(this, this.counterBlocks);
        BallRemover ballRemover = new BallRemover(this, this.counterBalls);
        ScoreTrackingListener scoreListener = new ScoreTrackingListener(this.score);
        Rectangle scoreRec = new Rectangle(new Point(0, 0), WIDTH_SCREEN, HEIGHT_SCORE_BLOCK);
        ScoreIndicator scoreIndicator = new ScoreIndicator(scoreRec, Color.LIGHT_GRAY, this.score);
        scoreIndicator.addToGame(this);
        //initialize the 4 edges
        Rectangle upperRec = new Rectangle(new Point(0, HEIGHT_SCORE_BLOCK), WIDTH_SCREEN, HEIGHT_BLOCK);
        Rectangle leftRec = new Rectangle(new Point(0, HEIGHT_BLOCK + HEIGHT_SCORE_BLOCK), HEIGHT_BLOCK,
                HEIGHT_SCREEN - HEIGHT_BLOCK);
        Rectangle bottomRec = new Rectangle(new Point(HEIGHT_BLOCK, HEIGHT_SCREEN),
                WIDTH_SCREEN - 2 * HEIGHT_BLOCK, HEIGHT_BLOCK);
        Rectangle rightRec = new Rectangle(new Point(WIDTH_SCREEN - HEIGHT_BLOCK,
                HEIGHT_BLOCK + HEIGHT_SCORE_BLOCK), HEIGHT_BLOCK,
                HEIGHT_SCREEN - HEIGHT_BLOCK);
        // create the block's edges and add each to the game
        Block upperEdge = new Block(upperRec, Color.GRAY);
        upperEdge.addToGame(this);
        Block bottomEdge = new Block(bottomRec, Color.GRAY);
        bottomEdge.addToGame(this);
        bottomEdge.addHitListener(ballRemover);
        Block rightEdge = new Block(rightRec, Color.GRAY);
        rightEdge.addToGame(this);
        Block leftEdge = new Block(leftRec, Color.GRAY);
        leftEdge.addToGame(this);
        // create balls:
        for (Velocity v : this.levelInfo.initialBallVelocities()) {
            Ball ball = new Ball(new Point((double) WIDTH_SCREEN / 2,
                    HEIGHT_SCREEN - HEIGHT_BLOCK - RADIUS), RADIUS, Color.WHITE, environment);
            this.counterBalls.increase(1);
            ball.setVelocity(v);
            ball.addToGame(this);
        }
        // according to the level
        for (Block block : this.levelInfo.blocks()) {
            block.addHitListener(blockRemover);
            block.addHitListener(scoreListener);
            this.counterBlocks.increase(1);
            block.addToGame(this);
        }
        LevelName levelName = new LevelName(this.levelInfo.levelName());
        levelName.addToGame(this);
    }

    /**
     * run the game - start the animation loop.
     */

    public void run() {
        this.createBallsOnTopOfPaddle(); // or a similar method
        this.runner.run(new CountdownAnimation(2, 3, this.sprites)); // countdown before
        this.running = true;
        // use our runner to run the current animation -- which is one turn of the game.
        this.runner.run(this);
    }

    /**
     * create ball on the top paddle.
     */
    private void createBallsOnTopOfPaddle() {
        // create a paddle with color and location, and add to the game.
        Rectangle paddleLocation = new Rectangle(new Point(((double) WIDTH_SCREEN / 2)
                - (double) this.levelInfo.paddleWidth() / 2 , HEIGHT_SCREEN - HEIGHT_BLOCK),
                this.levelInfo.paddleWidth(), PADDLE_HEIGHT);
        Paddle paddle = new Paddle(paddleLocation, keyboard, Color.YELLOW, this.levelInfo.paddleSpeed());
        paddle.addToGame(this);
    }

    /**
     * draw the current frame and update the animation.
     *
     * @param d  is the surface that we draw on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        // the logic from the previous run method goes here.
        // the `return` or `break` statements should be replaced with
        // this.running = false;
        if (this.counterBalls.getValue() == 0) {
            this.running = false;
        }
        if (this.counterBlocks.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(new PauseScreen(this.keyboard), this.keyboard));
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
    }

    /**
     * if the animation need to stop.
     *
     * @return false/true
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * get the number of the block.
     *
     * @return num of block.
     */
    public int getNumOfBlocks() {
        return this.counterBlocks.getValue();
    }

    /**
     * get the number of the balls.
     *
     * @return num of balls.
     */
    public int getNumOfBalls() {
        return this.counterBalls.getValue();
    }
}