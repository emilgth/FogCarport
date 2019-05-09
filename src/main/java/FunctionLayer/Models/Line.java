package FunctionLayer.Models;

public class Line extends Svg {
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public String toString() {
        return "<line x1=\"" + getX1() + "\" y1=\"" + getY1() +
                "\" x2=\"" + x2 + "\" y2=\"" + y2 + "\" style=\"stroke:black; stroke-dasharray:5 5;\"/>";
    }
}
