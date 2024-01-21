package snake;

import config.SnakeGameConfig;
import foundation.Vector2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Snake implements SnakeInterface {
    private List<Vector2> _snakeBody;
    private Vector2 _direction;
    private boolean ischangeable;

    public Snake(Vector2 initialDirection, Vector2 initialPosition) {
        this._direction = initialDirection;
        this._snakeBody = new LinkedList<>();
        this._snakeBody.add(initialPosition);
        ischangeable = true;
    }

    public void changeDirection(String newDirection) {
        if(isAvailableToChangeDirection(newDirection) && ischangeable) {
           this._direction = getDirectionVector(newDirection);
           ischangeable = false;
        }
    }


    private Boolean isAvailableToChangeDirection(String directionToChange) {
        Vector2 vectorDirectionToChange = getDirectionVector(directionToChange);
        Integer newX = vectorDirectionToChange.getX();
        Integer newY = vectorDirectionToChange.getY();
        Integer currentX = _direction.getX();
        Integer currentY = _direction.getY();
        if(newX == currentX || newY == currentY) {
            return false;
        }
        return true;
    }

    private Vector2 getDirectionVector(String direction) {
        HashMap<String, Vector2> directionVector = new HashMap<String, Vector2>();
        directionVector.put("up", Vector2.UP);
        directionVector.put("down", Vector2.DOWN);
        directionVector.put("left", Vector2.LEFT);
        directionVector.put("right", Vector2.RIGHT);
        return directionVector.get(direction);
    }

    public void moveOneStep() {
        int lastIndex = _snakeBody.size() - 1;
        Vector2 head = _snakeBody.get(lastIndex);
        Integer newHeadX = head.getX() + _direction.getX();
        Integer newHeadY = head.getY() + _direction.getY();
        newHeadX += SnakeGameConfig.get_instance().get_mapSize().getX();
        newHeadY += SnakeGameConfig.get_instance().get_mapSize().getY();
        newHeadX %= SnakeGameConfig.get_instance().get_mapSize().getX();
        newHeadY %= SnakeGameConfig.get_instance().get_mapSize().getY();
        Vector2 newHead = new Vector2(newHeadX, newHeadY);
        _snakeBody.add(newHead);
        _snakeBody.remove(0);
        ischangeable = true;
    }

    public void upSize() {
        Vector2 tail = _snakeBody.get(0);
        _snakeBody.add(0, tail);
    }

    public boolean isHitSelf() {
        Vector2 head = _snakeBody.getLast();
        for(var body : _snakeBody) {
            if(head != body && head.equals(body))
                return true;
        }
        return false;
    }


    public Vector2 getCurrentPosition() {
        Integer lastIndex = _snakeBody.size() - 1;
        return _snakeBody.get(lastIndex);
    }

    public Iterator<Vector2> getSnakeBodyIterator() {
        return this._snakeBody.iterator();
    }



}
