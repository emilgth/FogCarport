package FunctionLayer.Models;

public class SvgEnd extends Svg{

    public SvgEnd(int x1, int y1) {
        super(x1, y1);
    }
    
    @Override
    public String getModel() {
        return "</svg>";
    }
}
