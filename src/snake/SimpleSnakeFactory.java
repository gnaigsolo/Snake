package snake;

import foundation.Vector2;
import snake.Snake;
import snake.SnakeFactory;

public class SimpleSnakeFactory implements SnakeFactory {

    @Override
    public Snake createSnake(String type) {
        if(type.equals("normal"))
            return new Snake(new Vector2(0,1), new Vector2(0, 0));
        return null;
    }
}
