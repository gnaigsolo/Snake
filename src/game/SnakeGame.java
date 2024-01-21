package game;

import config.SnakeGameConfig;
import foundation.Vector2;
import fruit.FruitFactory;
import fruit.FruitInterface;
import graphic.PixelMap2D;
import graphic.PixelMapGraphic;
import graphic.SnakeGameGUI;
import graphic.SnakeSimpleGUI;
import keyinput.Input;
import snake.SimpleSnakeFactory;
import snake.SnakeFactory;
import snake.SnakeInterface;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame implements KeyListener {
    private SnakeInterface _snake;
    private FruitInterface _fruit;
    private SnakeFactory _snakeFactory;
    private FruitFactory _fruitFactory;
    private SnakeGameGUI _gui;
    private boolean isGameOver;

    public void startNewGame() {
        if(_snakeFactory == null) {
            System.out.println("There is no snake factory");
            return;
        }
        if(_fruitFactory == null) {
            System.out.println("There is no fruit factory");
            return;
        }
        newGame();
    }

    public void set_gui(SnakeGameGUI _gui) {
        this._gui = _gui;
    }

    public void newGame() {
        isGameOver = false;
        _snake = _snakeFactory.createSnake("normal");
        _fruit = _fruitFactory.createNewFruit("normal", _snake.getSnakeBodyIterator());
    }


    public void Update() {
        if(!isGameOver) {
            gameRunning();
            render();
            delay(10000/SnakeGameConfig.get_instance().get_gameSpeed());
        }
    }

    public void set_snakeFactory(SnakeFactory _snakeFactory) {
        this._snakeFactory = _snakeFactory;
    }

    public void set_fruitFactory(FruitFactory _fruitFactory) {
        this._fruitFactory = _fruitFactory;
    }

    void gameRunning() {
        _snake.moveOneStep();
        if(_snake.isHitSelf()) {
            gameLost();
        }
        else if(_snake.getCurrentPosition().equals(_fruit.getPosition())) {
            _snake.upSize();
            _fruit = _fruitFactory.createNewFruit("normal", _snake.getSnakeBodyIterator());
        }
    }

    public void gameLost() {
        newGame();
    }



    public void render() {
        _gui.renderBackground();
        _gui.renderSnake(_snake);
        _gui.renderFruit(_fruit);
        _gui.render();

    }


    void delay(long time) {
        try {
            Thread.sleep(time);

        } catch (Exception e) {
            System.out.println(e);
        }
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }



    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP)
            _snake.changeDirection("up");
        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)
            _snake.changeDirection("down");
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT)
            _snake.changeDirection("right");
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
            _snake.changeDirection("left");
        if (e.getKeyCode() == KeyEvent.VK_SPACE && isGameOver)
            newGame();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
