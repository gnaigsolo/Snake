package graphic;

import config.SnakeGameConfig;
import foundation.Vector2;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PixelMap2D extends JFrame implements PixelMapGraphic {
    private Color[][] colorMap;
    private boolean isVisible;
    private Vector2 _cellsize;
    private Vector2 _mapSize;
    public PixelMap2D(Vector2 _mapSize, Vector2 _cellsize) {
        this._cellsize = SnakeGameConfig.getInstance().get_cellSize();
        this._mapSize = _mapSize;
        this._cellsize = _cellsize;
        init();
        this.isVisible = false;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(_mapSize.getX() * _cellsize.getX() + 12, _mapSize.getY() * _cellsize.getY() + 36);
        setResizable(false);
        setTitle("Snake");
        setVisible(true);

    }

    public void drawPixel(Vector2 point, Color c) {
        int x = point.getX();
        int y = point.getY();
        y = SnakeGameConfig.get_instance().get_mapSize().getY() - y - 1;
        if (x >= 0 && x < _mapSize.getX() && y >= 0 && y < _mapSize.getY()) {
            if(colorMap[x][y].equals(c))
                return;
            colorMap[x][y] = c;
        }
    }

    void init() {
        colorMap = new Color[_mapSize.getX()][];
        for(int i = 0; i < _mapSize.getX(); ++i) {
            colorMap[i] = new Color[_mapSize.getY()];
            for(int j = 0; j < _mapSize.getY(); ++j) {
                colorMap[i][j] = SnakeGameConfig.get_instance().get_backGroundColor();
            }
        }
    }

    @Override
    public void push() {
        repaint();
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
        super.setVisible(isVisible);
    }

    @Override
    public void paint(Graphics g) {

        if (isVisible) {


            for (int i = 0; i < _mapSize.getX(); i++) {
                for (int j = 0; j < _mapSize.getY(); j++) {



                    int x = i * _cellsize.getX() + 5;
                    int y = j * _cellsize.getY() + 29;

                    g.setColor(colorMap[i][j]);
                    g.fillRect(x, y, _cellsize.getX(), _cellsize.getY());
                }
            }

            // Vẽ lưới ô vuông
//            g.setColor(Color.BLACK);
//            for (int i = 1; i < width; i++) {
//                int x = i * cellWidth;
//                g.drawLine(x, 0, x, getHeight());
//            }
//            for (int i = 1; i < height; i++) {
//                int y = i * cellHeight;
//                g.drawLine(0, y, getWidth(), y);
//            }
        }
    }

    public static void main(String[] args) {

            PixelMap2D pixelMap2D = new PixelMap2D(SnakeGameConfig.get_instance().get_mapSize(), SnakeGameConfig.get_instance().get_cellSize());
            pixelMap2D.drawPixel(new Vector2(0, 0), Color.RED);
            pixelMap2D.drawPixel(new Vector2(0,0 ), Color.BLUE);
            pixelMap2D.drawPixel(new Vector2(0, 0), Color.YELLOW);
            pixelMap2D.drawPixel(new Vector2(9,9 ), Color.BLUE);


    }
}
