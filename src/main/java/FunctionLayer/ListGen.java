package FunctionLayer;

import DBAccess.MaterialMapper;
import FunctionLayer.Models.Material;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.OrderLine;

import java.util.ArrayList;
import java.util.HashMap;

public class ListGen {

    private static ArrayList<Material> materialList = MaterialMapper.getMaterialList();
    private static HashMap<Integer, Material> materialMap = getMaterialMap(materialList);;

    private static HashMap<Integer, Material> getMaterialMap(ArrayList<Material> materialList){
        /*Laver materiale arraylisten til et hashmap så jeg kan søge på materiale id.
          Gør det mere overskueligt at slå et materiale op i DB*/
        HashMap<Integer, Material> map = new HashMap<>();
        for (Material material : materialList) {
            map.put(material.getMaterialId(), material);
        }
        return map;
    }

    public static ArrayList<OrderLine> getOrderLinelist(Order order) {

        ArrayList<OrderLine> orderLineList = new ArrayList<>();

        //<editor-fold defaultstate="collapsed" desc="Test data til SCRUM præsentation 03/05">
        /*
        orderLineList.add(new OrderLine(materialMap.get(70), 15));
        orderLineList.add(new OrderLine(materialMap.get(84), 4));
        orderLineList.add(new OrderLine(materialMap.get(16), 4));
        orderLineList.add(new OrderLine(materialMap.get(16),2));
        orderLineList.get(0).setDescription("Remme i sider, sadles ned i stolper");
        orderLineList.get(1).setDescription("Stolper nedgraves 90 cm. i jord");
        orderLineList.get(2).setDescription("oversternbrædder til siderne");
        orderLineList.get(3).setDescription("oversternbrædder til forenden");
        */
        // </editor-fold>

        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();

        int maxOverhangFront = 1000;
        int overhang = 300;
        int maxPostSpacing = 3100;

        //Antal stolper (stolpe længde er som udgangspunkt altid 3m)
        String postDesc = "Stolper nedgraves 90 cm. i jord";
        orderLineList.add(new OrderLine(materialMap.get(84), getPostAmount(length), postDesc));

        //Antal og længde på spær
        orderLineList.add(new OrderLine(materialMap.get(getRafterId(width)),14,""));

        return orderLineList;
    }

    public static int getPostAmount(int length) {
        //Denne metode finder antallet af stolper der skal bruges, baseret på længden af carport
        int postAmount = 0;

        if (length <= 4400) {
            postAmount = 4;
        }
        if (length > 4400 && length <= 7500) {
            postAmount = 6;
        }
        if (length > 7500) {
            postAmount = 8;
        }
        return postAmount;
    }

    public static int getRafterId(int width) {
        ArrayList<Material> rafterList = new ArrayList<>();
        /*
        rafterList er bevidst bygget manuelt fordi materialer i DB ikke nødvendigvis kommer foreløbende
        Manuel konstruktion af rafterList kan erstattes med en ny DB Mapper, der kun udvælger spær
        */
        rafterList.add(materialMap.get(67));
        rafterList.add(materialMap.get(68));
        rafterList.add(materialMap.get(69));
        rafterList.add(materialMap.get(70));
        rafterList.add(materialMap.get(71));
        rafterList.add(materialMap.get(72));
        rafterList.add(materialMap.get(73));
        rafterList.add(materialMap.get(74));
        rafterList.add(materialMap.get(75));
        rafterList.add(materialMap.get(76));
        rafterList.add(materialMap.get(77));
        rafterList.add(materialMap.get(78));
        rafterList.add(materialMap.get(79));

        //Denne foreach finder materialId på det spær der mindst muligt større end width
        int tempResult = Integer.MAX_VALUE;
        int rafterMaterialId = 0;
        for (Material material : rafterList) {
            if (material.getLength() >= width && material.getLength() < tempResult) {
                tempResult = material.getLength();
                rafterMaterialId = material.getMaterialId();
            }
        }
        return rafterMaterialId;
    }

    public static int getRafterSpacing(int width) {
        //Denne metode finder afstanden mellem spær, som er bestemt af bredden som spær spænder
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
