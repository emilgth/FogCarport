package FunctionLayer.Models;

public class AngledRect extends Svg {

    private int length;
    private int width;
    private int angle;

    public AngledRect(int x1, int y1, int length, int width, int angle) {
        super(x1, y1);
        this.length = length;
        this.width = width;
        this.angle = angle;
    }

    @Override
    public String getModel() {
        int x = getX1() / 10;
        int y = getY1() / 10;
        int a = length / 10;
        int b = width / 10;
        return "<rect transform=\"rotate(" + angle + " " + x + " " + y + ")\" x=\"" + x + "\" y=\"" + y + "\" " +
                "height=\"" + b + "\" width=\"" + a + "\" style=\"stroke:black; fill:white;\"/>";
    }
}
