package config;

import foundation.Vector2;
import graphic.SnakeGameGUI;

import java.awt.*;

public class SnakeGameConfig {
    private static SnakeGameConfig _instance;
    private Color _snakeColor;
    private Color _backGroundColor;
    private Color _fruitColor;
    private Vector2 _mapSize;
    private Vector2 _cellSize;
    private int _gameSpeed;

    public static SnakeGameConfig get_instance() {
        if(_instance == null)
            _instance = new SnakeGameConfig();
        return _instance;
    }

    public Color get_snakeColor() {
        return _snakeColor;
    }

    public Color get_backGroundColor() {
        return _backGroundColor;
    }

    public Color get_fruitColor() {
        return _fruitColor;
    }

    public Vector2 get_mapSize() {
        return _mapSize;
    }

    public Vector2 get_cellSize() {
        return _cellSize;
    }

    public static SnakeGameConfig getInstance() {
        if(_instance == null)
            _instance = new SnakeGameConfig();
        return _instance;
    }

    private SnakeGameConfig() {
        setDefault();
    }

    public int get_gameSpeed() {
        return _gameSpeed;
    }

    void setDefault() {
        _snakeColor = Color.GREEN;
        _backGroundColor = Color.BLACK;
        _fruitColor = Color.RED;
        _cellSize = new Vector2(15,15);
        _mapSize = new Vector2(50,50);
        _gameSpeed = 250;
    }

}
