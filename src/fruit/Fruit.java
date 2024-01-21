package fruit;
import foundation.Vector2;

public class Fruit implements FruitInterface {
    private Vector2 _position;
    public Fruit(Vector2 _position) {
        this._position = _position;
    }
    public Vector2 getPosition() {
        return this._position;
    }
}
