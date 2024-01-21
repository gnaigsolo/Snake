package graphic;

import config.SnakeGameConfig;
import foundation.Vector2;
import fruit.FruitInterface;
import game.SnakeGame;
import snake.SnakeInterface;

import java.awt.*;
import java.util.Iterator;

public class SnakeSimpleGUI implements SnakeGameGUI{

    public void set_graphic(PixelMapGraphic _graphic) {
        this._graphic = _graphic;
    }

    private PixelMapGraphic _graphic;

    @Override
    public void renderSnake(SnakeInterface snake) {
        Iterator<Vector2> head = snake.getSnakeBodyIterator();
        do {
            _graphic.drawPixel(head.next(), SnakeGameConfig.get_instance().get_snakeColor());
        } while (head.hasNext());
    }

    @Override
    public void renderFruit(FruitInterface fruit) {
        _graphic.drawPixel(fruit.getPosition(), SnakeGameConfig.get_instance().get_fruitColor());
    }

    @Override
    public void renderBackground() {
        Vector2 size = SnakeGameConfig.get_instance().get_mapSize();
        for(int x = 0; x < size.getX(); x++)
            for(int y = 0; y < size.getY(); y++) {
                _graphic.drawPixel(new Vector2(x, y),SnakeGameConfig.get_instance().get_backGroundColor());
            }
    }

    @Override
    public void render() {
        _graphic.push();
    }


    public void setGraphic(PixelMapGraphic graphic) {
        this._graphic = graphic;
    }
}
