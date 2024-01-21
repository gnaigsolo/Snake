import config.SnakeGameConfig;
import fruit.FruitFactory;
import game.SnakeGame;
import graphic.PixelMap2D;
import graphic.SnakeSimpleGUI;
import snake.SimpleSnakeFactory;
import snake.SnakeFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        initGameAndRun();
    }

    static void initGameAndRun() {
        SnakeGame game = new SnakeGame();
        SnakeFactory snakeFactory = new SimpleSnakeFactory();
        FruitFactory fruitFactory = new FruitFactory();
        PixelMap2D pixelmap = new PixelMap2D(SnakeGameConfig.get_instance().get_mapSize(), SnakeGameConfig.getInstance().get_cellSize());
        SnakeSimpleGUI gui = new SnakeSimpleGUI();
        gui.set_graphic(pixelmap);
        game.set_gui(gui);
        game.set_fruitFactory(fruitFactory);
        game.set_snakeFactory(snakeFactory);
        pixelmap.addKeyListener(game);
        game.newGame();
        while(true) {
            game.Update();
        }

    }



}