package FunctionLayer.Models;

public class SvgStart extends Svg {

    private int length;
    private int width;

    public SvgStart(int x1, int y1, int length, int width) {
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
        int lengthOffset = (length + 500) / 10;
        int widthOffset = (width + 500) / 10;
        int xOffset = (getX1() + 500) / 10;
        int yOffset = (getY1() + 500) / 10;
        return "<?xml version=\"1.0\"?><!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n" +
                "\n" +
                "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "       height=\"80%\" \n" +
                "       viewBox=\"" + x + " " + y + " " + lengthOffset + " " + widthOffset + "\"\n" +
                "       preserveAspectRatio=\"xMinYMin\">\n" +
                "\n" +
                "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "        x=\"" + xOffset + "\"\n" +
                "        y=\"" + yOffset + "\"\n" +
                "       width=\"" + a + "\" height=\"" + b + "\"\n" +
                "       viewBox=\"0 0 " + a + " " + b + "\"\n" +
                "       preserveAspectRatio=\"xMinYMin\">\n" +
                "\n" +
                "<defs>\n" +
                "    <marker id=\"beginArrow\" \n" +
                "    \tmarkerWidth=\"9\" markerHeight=\"9\" \n" +
                "    \trefX=\"0\" refY=\"4\" \n" +
                "    \torient=\"auto\">\n" +
                "        <path d=\"M0,4 L8,0 L8,8 L0,4\" style=\"fill: #000000s;\" />\n" +
                "    </marker>\n" +
                "    <marker id=\"endArrow\" \n" +
                "    \tmarkerWidth=\"9\" markerHeight=\"9\" \n" +
                "    \trefX=\"8\" refY=\"4\" \n" +
                "    \torient=\"auto\">\n" +
                "        <path d=\"M0,0 L8,4 L0,8 L0,0\" style=\"fill: #000000;\" />\n" +
                "    </marker>\n" +
                "</defs>";
    }
}
