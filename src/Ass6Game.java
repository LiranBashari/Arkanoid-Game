// 313309114.

import biuoop.GUI;
import java.util.ArrayList;
import java.util.List;

/**
 * the class Create a game, initializes and runs it.
 */
public class Ass6Game {
    /**
     * The main function of the "game".
     *
     * @param args - is a array of strings that contain the numbers of the levels for the game.
     *             if is empty do the level: 1 2 3 4
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner ar = new AnimationRunner(gui);
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        GameFlow gameFlow = new GameFlow(ar, keyboard);
        List<LevelInformation> levels = new ArrayList<>();
        //initializes the game with the levels that the user choose
        for (String arg : args) {
            //if he choose level 1/2/3/4:
            if (arg.equals("1")) {
                levels.add(new Level1());
            } else if (arg.equals("2")) {
                levels.add(new Level2());
            } else if (arg.equals("3")) {
                levels.add(new Level3());
            } else if (arg.equals("4")) {
                levels.add(new Level4());
            }
        }
        //if we don't have any "correct" args in the args array initializes with the 4 levels.
        if (levels.size() == 0) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
            gameFlow.runLevels(levels);
        }
        gameFlow.runLevels(levels);
    }
}
