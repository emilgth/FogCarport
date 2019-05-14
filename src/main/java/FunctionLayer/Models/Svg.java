package FunctionLayer.Models;

public abstract class Svg {
    private int x1;
    private int y1;

    public Svg(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public abstract String getModel();
}