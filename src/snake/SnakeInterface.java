package snake;

import foundation.Vector2;

import java.util.Iterator;

public interface SnakeInterface {
    void changeDirection(String s);
    void moveOneStep();
    boolean isHitSelf();
    void upSize();
    Vector2 getCurrentPosition();
    public Iterator<Vector2> getSnakeBodyIterator();
}
