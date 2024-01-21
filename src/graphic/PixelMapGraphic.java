package graphic;

import foundation.Vector2;

import java.awt.*;

public interface PixelMapGraphic {
    void drawPixel(Vector2 point, Color color);
    void push();
    void setVisible(boolean isVisible);

}
