package FunctionLayer;

import DBAccess.MaterialMapper;
import FunctionLayer.Models.Material;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.OrderLine;

import java.util.ArrayList;
import java.util.HashMap;

public class ListGen {

    public static ArrayList<OrderLine> getOrderLinelist() {

        ArrayList<Material> materialList = MaterialMapper.getMaterialList();
        ArrayList<OrderLine> orderLineList = new ArrayList<>();

        /*Laver materiale arraylisten til et hashmap så jeg kan søge på materiale id.
          Gør det mere overskueligt at slå et materiale op i DB*/
        HashMap<Integer, Material> materialMap = new HashMap<>();
        for (Material material : materialList) {
            materialMap.put(material.getMaterialId(), material);
        }

        //Test data til SCRUM præsentation 03/05
        orderLineList.add(new OrderLine(materialMap.get(70), 15));
        orderLineList.add(new OrderLine(materialMap.get(84), 4));
        orderLineList.add(new OrderLine(materialMap.get(16), 4));
        orderLineList.add(new OrderLine(materialMap.get(16),2));
        orderLineList.get(0).setDescription("Remme i sider, sadles ned i stolper");
        orderLineList.get(1).setDescription("Stolper nedgraves 90 cm. i jord");
        orderLineList.get(2).setDescription("oversternbrædder til siderne");
        orderLineList.get(3).setDescription("oversternbrædder til forenden");

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
