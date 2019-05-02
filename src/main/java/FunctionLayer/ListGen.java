package FunctionLayer;

import FunctionLayer.Models.Order;
import FunctionLayer.Models.OrderLine;

import java.util.ArrayList;

public class ListGen {

    public static ArrayList<OrderLine> getOrderLinelist() {

        ArrayList<OrderLine> orderLineList = new ArrayList<>();

        orderLineList.add(new OrderLine(999,15));
        orderLineList.add(new OrderLine(998, 20));
        orderLineList.add(new OrderLine(997,25));
        orderLineList.get(0).setDescription("Test");

        Order order = new Order();

        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();

        int rafterSpacing = getRafterSpacing(width);

        return orderLineList;
    }

    private static int getRafterSpacing(int width) {

        int rafterSpacing = 0;

        if (width <= 3200) {
            rafterSpacing = 1200;
        }
        if (width > 3200 && width <= 3400) {
            rafterSpacing = 1000;
        }
        if (width > 3400 && width <= 3600) {
            rafterSpacing = 800;
        }
        if (width > 3600 && width <= 4000) {
            rafterSpacing = 600;
        }
        if (width > 4000) {
            rafterSpacing = 400;
        }

        return rafterSpacing;
    }
}
