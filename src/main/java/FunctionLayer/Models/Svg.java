package FunctionLayer.Models;

/**
 * This abstract class is used for creating SVG objects
 */
public abstract class Svg {
    private int x1;
    private int y1;

    /**
     * @param x1 coordinate
     * @param y1 coordinate
     */
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
