package graphic;

import foundation.Vector2;
import fruit.Fruit;
import fruit.FruitInterface;
import snake.Snake;
import snake.SnakeInterface;

public interface SnakeGameGUI {
    void renderSnake(SnakeInterface snake);
    void renderFruit(FruitInterface fruit);
    void renderBackground();
    void render();

}
