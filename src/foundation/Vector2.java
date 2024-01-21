package foundation;

public class Vector2 {
    private Integer _x;
    private Integer _y;

    public static Vector2 UP;
    public static Vector2 DOWN;
    public static Vector2 RIGHT;
    public static Vector2 LEFT;

    static {
        UP = new Vector2(0, 1);
        DOWN = new Vector2(0, -1);
        RIGHT = new Vector2(1, 0);
        LEFT = new Vector2(-1, 0);
    }

    public Vector2(Integer x, Integer y) {
        this._x = x;
        this._y = y;
    }

    public Vector2(Vector2 other) {
        this._x = other._x;
        this._y = other._y;
    }

    public Integer getX() {
        return this._x;
    }

    public Integer getY() {
        return this._y;
    }

    public Vector2 clone() {
        return new Vector2(this);
    }

    @Override
    public boolean equals(Object object) {
        Vector2 other = (Vector2) object;
        if(other._x.equals(_x) && other._y.equals(_y))
            return true;
        return false;
    }

}
