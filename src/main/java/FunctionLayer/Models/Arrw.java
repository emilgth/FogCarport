package FunctionLayer.Models;

public class Arrw extends Svg {
    private int x2;
    private int y2;
    private int angle;

    public Arrw(int x1, int y1, int x2, int y2, int angle) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
        this.angle = angle;
    }

    @Override
    public String getModel() {
        int x = getX1() / 10;
        int y = getY1() / 10;
        int xx = x2 / 10;
        int yy = y2 / 10;
        String text = "";
        if (angle == 0) { //text is vertical
            text = "<text x=\"" + (xx / 2) + "\" y=\"" + (y + 15) + "\">" + (x2 - getX1()) + "</text>";
        }
        if (angle == -90) { //text is horizontal
            text = "<text transform=\"rotate(" + angle + " " + (x - 15) + "," + (yy / 2) +
                    ")\" x=\"" + (x - 15) + "\" y=\"" + (yy / 2) + "\">" + (y2 - getY1()) + "cm</text>";
        }
        return "<line x1=\"" + x + "\"  y1=\"" + y +
                "\" x2=\"" + xx + "\"   y2=\"" + yy + "\" \n" +
                "\tstyle=\"stroke:black;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "   marker-end: url(#endArrow);\"/>" +
                text;
    }
}
