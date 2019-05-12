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
    public String getModel() {
        int x = getX1() / 10;
        int y = getY1() / 10;
        int a = length / 10;
        int b = width / 10;
        return "<rect x=\"" + x + "\" y=\"" + y + "\" " +
                "height=\"" + b + "\" width=\"" + a + "\" style=\"stroke:black; fill:white;\"/>";
    }
}
