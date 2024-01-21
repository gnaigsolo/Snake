package fruit;

import config.SnakeGameConfig;
import foundation.Vector2;
import fruit.Fruit;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FruitFactory {
    public FruitInterface createNewFruit(String type, Iterator<Vector2> snakebody) {

        if(type == "normal") {

            Vector2 fruitPosition = getFruitAvailblePosition(snakebody);
            return new Fruit(fruitPosition);
        }
        return null;

    }

    Vector2 getFruitAvailblePosition(Iterator snakebody) {
        while(true) {
            Random random = new Random();
            int x = random.nextInt() % SnakeGameConfig.get_instance().get_mapSize().getY();
            int y = random.nextInt() % SnakeGameConfig.get_instance().get_mapSize().getY();
            x = Math.abs(x);
            y = Math.abs(y);
            Vector2 fruitPosition = new Vector2(x, y);
            if(isAvailble(snakebody, fruitPosition))
                return fruitPosition;
        }

    }

    boolean isAvailble(Iterator<Vector2> snakebody, Vector2 point) {
        while( snakebody.hasNext()) {
            if(point.equals(snakebody.next()))
                return false;
        }
        return true;
    }
}
