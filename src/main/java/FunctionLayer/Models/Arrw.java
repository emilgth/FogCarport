package FunctionLayer.Models;

public class Arrw extends Svg{
    private int x2;
    private int y2;
    private int angle;

    public Arrw(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public String toString() {
        return "<line x1=\"" + getX1() + "\"  y1=\"" + getY1() +
                "\" x2=\"" + x2 + "\"   y2=\"" + y2 + "\" \n" +
                "\tstyle=\"stroke:black;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "   marker-end: url(#endArrow);\"/>" +
                "<text transform=\"rotate(" + angle + " " + (getX1()-10) + "," + (getY1()/2) +
                ")\" x=\"" + (getX1()-10) + "\" y=\"" + (getY1()/2) + "\">" + getY1() + "cm</text>";
    }
}
