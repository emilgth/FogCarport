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

        //CARPORT MÅL
        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();

        //SVG START
        svgList.add(new SvgStart(0, 0, length, width));

        //RAMME (frame)
        svgList.add(new Rect(0, 0, length, width));

        //STOLPER (posts)
        int postAmount = ListGen.getPostAmount(length);
        int postSpacing = getPostSpacing(postAmount, length);
        int postHeight = materialMap.get(84).getHeight(); //Materiale 84 er 3m. høje stolper. De eneste vi bruger pt.
        int postWidth = materialMap.get(84).getWidth();
        int postXOffset = materialMap.get(84).getHeight() / 2;
        int postYOffset = materialMap.get(84).getWidth() / 2;
        for (int i = 0; i < postAmount / 2; i++) {
            svgList.add(new Rect(((overhangFront - postXOffset) + (postSpacing * i)), (overhangSides - postYOffset), postHeight, postWidth));
            svgList.add(new Rect(((overhangFront - postXOffset) + (postSpacing * i)), (overhangSides - (postYOffset) + (width - (overhangSides * 2))), postHeight, postWidth));
        }

        //REMME (beams)
        //Da remme altid strækker den fulde længe af en given carport. Kan remme længden bestemmes ved antal remme.
        Material beamMat = materialMap.get(ListGen.getRafterId(length));
        int beamAmount = ListGen.getFitAmount(length, beamMat.getLength());
        int beamLong = length / beamAmount;
        int beamShort;

        /*
        beamShort bruges til at sikre at remme sammenføjninger altid sker over på stolper.
        Dette sker ved at beamLong tager fra beamShort indtil de begge ligger oven på en stolpe.
        */
        if (beamAmount > 1) {
            beamShort = beamLong;
            beamAmount--;
            while (beamLong < (overhangFront + (postSpacing * 2))) {
                //Denne break condition sikre at beamShort ikke bliver mindre end minimum én stolpe spacing + udhæng.
                if (beamShort < overhangSides + postSpacing) {
                    break;
                }
                beamLong++;
                beamShort--;
            }
            svgList.add(new Rect(beamLong, (overhangSides - (beamMat.getWidth() / 2)), beamShort, beamMat.getWidth()));
            svgList.add(new Rect(beamLong, (width - overhangSides - (beamMat.getWidth() / 2)), beamShort, beamMat.getWidth()));
        }
        for (int i = 0; i < beamAmount; i++) {
            svgList.add(new Rect((beamLong * i), (overhangSides - (beamMat.getWidth() / 2)), beamLong, beamMat.getWidth()));
            svgList.add(new Rect((beamLong * i), (width - overhangSides - (beamMat.getWidth() / 2)), beamLong, beamMat.getWidth()));
        }

        //SPÆR (rafters)
        Material rafterMat = materialMap.get(ListGen.getRafterId(width));
        int rafterWidth = rafterMat.getWidth();
        int rafterLength = rafterMat.getLength();

        int rafterAmount = ListGen.getRafterAmount(length, width);
        int rafterSpacing = 0;

        while (length - rafterWidth > (rafterAmount - 1) * rafterSpacing) {
            rafterSpacing++;
        }
        for (int i = 0; i < rafterAmount; i++) {
            svgList.add(new Rect(rafterSpacing * i, 0, rafterWidth, rafterLength));
        }

        //VINDKRYDS (Wind bracers)
        svgList.add(new Line(rafterSpacing, overhangSides, (rafterSpacing * (rafterAmount - 2)), width - overhangSides));
        svgList.add(new Line(rafterSpacing + 50, overhangSides, (rafterSpacing * (rafterAmount - 2)) + 50, width - overhangSides));
        svgList.add(new Line(rafterSpacing, width - overhangSides, (rafterSpacing * (rafterAmount - 2)), overhangSides));
        svgList.add(new Line(rafterSpacing + 50, width - overhangSides, (rafterSpacing * (rafterAmount - 2) + 50), overhangSides));

        //SVG AFSLUT (indre tegning)
        svgList.add(new SvgEnd(0, 0));

        //SVG PILE (arrows)
        //Total bredde
        svgList.add(new Arrw(500, 500 + width + 200, 500 + length, 500 + width + 200, 0));
        //Total højde
        svgList.add(new Arrw(200, 500, 200, 500 + width, -90));
        //Overhæng
        svgList.add(new Arrw(400, 500, 400, 500 + overhangSides, -90));
        svgList.add(new Arrw(500, 175, 500 + overhangFront, 175, 0));
        svgList.add(new Arrw(500 + length - overhangSides, 175, 500 + length, 175, 0));
        //Spær afstand
        svgList.add(new Arrw(500, 425, 500 + rafterSpacing, 425, 0));
        //Stolpe afstand
        for (int i = 1; i < postAmount / 2; i++) {
            svgList.add(new Arrw(500 + overhangFront + (postSpacing * (i - 1)), 175, 500 + overhangFront + (postSpacing * i), 175, 0));
        }

        //SVG AFSLUT (ydre tegning)
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

    public static ArrayList<Svg> getSvgSideList(Order order) {
        ArrayList<Svg> svgList = new ArrayList<>();

        //CARPORT MÅL
        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();

        //SVG START
        svgList.add(new SvgStart(0, 0, length, width));

        //STOLPER
        int postAmount = ListGen.getPostAmount(length);
        int postSpacing = getPostSpacing(postAmount, length);
        for (int i = 0; i < postAmount / 2; i++) {
            svgList.add(new Rect(overhangFront + (postSpacing * i), 90 + (materialMap.get(84).getLength() / 100) * (9 * i), materialMap.get(84).getHeight(), materialMap.get(84).getLength() - (140 * i)));
        }

        //REMME
        svgList.add(new AngledRect(50, 0, length - 100, 100, 5));

        return svgList;
    }
}
