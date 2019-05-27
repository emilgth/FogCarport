package FunctionLayer.Models;

/**
 * Used for drawing SVG arrows
 */
public class Arrw extends Svg {
    private int x2;
    private int y2;
    private int angle;

    /**
     * @param x1 start coordinate
     * @param y1 start coordinate
     * @param x2 end coordinate
     * @param y2 end coordinate
     * @param angle arrow angle
     */
    public Arrw(int x1, int y1, int x2, int y2, int angle) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
        this.angle = angle;
    }

    /**
     * @return SVG element to be displayed on JSP
     */
    @Override
    public String getModel() {
        int x = getX1() / 10;
        int y = getY1() / 10;
        int xx = x2 / 10;
        int yy = y2 / 10;
        int textHoverDistance = -5;
        String text = "";
        if (angle == 0) { //text is vertical
            text = "<text x=\"" + (x + ((xx - x) / 2) - 25) + "\" y=\"" + (y + textHoverDistance) + "\">" + (x2 - getX1()) + "mm</text>";
        }
        if (angle == -90) { //text is horizontal
            text = "<text transform=\"rotate(" + angle + " " + (x + textHoverDistance) + "," + (y + ((yy - y) / 2) + 25) +
                    ")\" x=\"" + (x + textHoverDistance) + "\" y=\"" + (y + ((yy - y) / 2) + 25) + "\">" + (y2 - getY1()) + "mm</text>";
        }
        return "<line x1=\"" + x + "\"  y1=\"" + y +
                "\" x2=\"" + xx + "\"   y2=\"" + yy + "\" \n" +
                "\tstyle=\"stroke:black;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "   marker-end: url(#endArrow);\"/>" +
                text;
    }
}
