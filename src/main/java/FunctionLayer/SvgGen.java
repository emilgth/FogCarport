package FunctionLayer;

import DBAccess.MaterialMapper;
import FunctionLayer.Models.*;

import java.util.ArrayList;
import java.util.HashMap;

public class SvgGen {

    private static ArrayList<Material> dontUseThisList = MaterialMapper.getMaterialList();
    private static HashMap<Integer, Material> materialMap = getMaterialMap(dontUseThisList);

    private static HashMap<Integer, Material> getMaterialMap(ArrayList<Material> materialList) {
        /*
        Laver materiale arraylisten til et hashmap så jeg kan søge på materiale id.
        Gør det mere overskueligt at slå et materiale op i DB
        */
        HashMap<Integer, Material> map = new HashMap<>();
        for (Material material : materialList) {
            map.put(material.getMaterialId(), material);
        }
        return map;
    }

    //Stolpe og udhæng variable, som udgangspunkt statiske
    private static int overhangFront = 1000; //max 1000
    private static int overhangSides = 300; //max 300
    private static int maxPostSpacing = 3100; //max 3100

    public static ArrayList<Svg> getSvgTopList(Order order) {
        ArrayList<Svg> svgList = new ArrayList<>();

        //Carport mål
        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();

        //Svg start
        svgList.add(new SvgStart(0, 0, length, width));

        //Ramme
        svgList.add(new Rect(0, 0, length, width));

        //Stolper
        int postAmount = ListGen.getPostAmount(length);
        int postSpacing = getPostSpacing(postAmount, length);
        int postHeight = materialMap.get(84).getHeight();
        int postWidth = materialMap.get(84).getWidth();
        int postXOffset = materialMap.get(84).getHeight() / 2;
        int postYOffset = materialMap.get(84).getWidth() / 2;
        for (int i = 0; i < postAmount / 2; i++) {
            svgList.add(new Rect(((overhangFront - postXOffset) + (postSpacing * i)), (overhangSides - postYOffset), postHeight, postWidth));
            svgList.add(new Rect(((overhangFront - postXOffset) + (postSpacing * i)), (overhangSides - (postYOffset) + (width - (overhangSides * 2))), postHeight, postWidth));
        }

        //Svg afslut
        svgList.add(new SvgEnd(0, 0));

        //Svg Pile
        svgList.add(new Arrw(500, 100, 500 + length, 100, 0));

        //Svg afslut
        svgList.add(new SvgEnd(0, 0));

        return svgList;
    }

    private static int getPostSpacing(int postAmount, int length) {
        /*
        postAmount bliver først delt med 2, da længden postSpacing beskriver afstanden mellem stolper,
        på én side.
        postAmount bliver derefter reduceret med -1, fordi i = 0 gange postSpacing placerer første stolpe.
        Derfor skal resterende length fordeles på ét mindre interval.
        */
        return (((length - (overhangFront + overhangSides)) / ((postAmount / 2) - 1)));
    }
}
