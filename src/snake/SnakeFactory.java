package snake;

import snake.Snake;

public interface SnakeFactory {
    Snake createSnake(String type);
}
