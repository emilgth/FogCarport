package FunctionLayer.Models;

public class Rect extends Svg {
    private int length;
    private int width;

    public Rect(int x1, int y1, int length, int width) {
        super(x1, y1);
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return "<rect x=\"" + getX1() + "\" y=\"" + getY1() +
                "\" height=\"" + length + "\" width=\"" + width + "\" style=\"stroke:black; fill:white;\"/>";
    }
}
