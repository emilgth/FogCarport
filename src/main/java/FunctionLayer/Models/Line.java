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
    public String getModel() {
        int x = getX1() / 10;
        int y = getY1() / 10;
        int xx = x2 / 10;
        int yy = y2 / 10;
        return "<line x1=\"" + x + "\" y1=\"" + y +
                "\" x2=\"" + xx + "\" y2=\"" + yy + "\" style=\"stroke:black; stroke-dasharray:5 5;\"/>";
    }
}
