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
        int shedLength = order.getShedLength();
        int shedWidth = order.getShedWidth();

        //SVG START
        svgList.add(new SvgStart(0, 0, length, width));

        //RAMME (frame)
        svgList.add(new Rect(0, 0, length, width));

        int postAmount = ListGen.getPostAmount(length);
        int postSpacing = getPostSpacing(postAmount, length);

        //SKUR
        if (shedLength != 0 && shedWidth != 0) {
            addShedWalls(svgList, shedWidth, shedLength, width, length);
            addShedPosts(svgList, shedWidth, shedLength, width, length);
        }

        addPosts(svgList, width, postAmount, postSpacing);
        addBeams(length, svgList, width, postSpacing);

        //rafterSpacing is used by addArrows
        int rafterSpacing = addRaftersAndWindBracers(svgList, length, width);

        //SVG AFSLUT (indre tegning)
        svgList.add(new SvgEnd(0, 0));

        addArrows(svgList, length, width, postAmount, postSpacing, rafterSpacing);

        //SVG AFSLUT (ydre tegning)
        svgList.add(new SvgEnd(0, 0));

        return svgList;
    }

    private static void addShedWalls(ArrayList<Svg> svgList, int shedWidth, int shedLength, int width, int length) {
        int wallWidth = 50;
        int postXOffset = materialMap.get(84).getHeight() / 2;
        int postYOffset = materialMap.get(84).getWidth() / 2;

        //vertical
        svgList.add(new Rect((((length - overhangSides) - postXOffset) - shedLength) - wallWidth, (overhangSides - postYOffset) - wallWidth, wallWidth, (shedWidth + (postXOffset * 2)) + wallWidth * 2));
        svgList.add(new Rect((length - overhangSides) + postXOffset, (overhangSides - postYOffset) - wallWidth, wallWidth, (shedWidth + (postXOffset * 2)) + wallWidth * 2));

        //horizontal
        svgList.add(new Rect(((((length - overhangSides) - postXOffset) - shedLength) - wallWidth), (overhangSides - postYOffset) - wallWidth, (shedLength + (postXOffset * 2)) + wallWidth * 2, wallWidth));
        svgList.add(new Rect(((((length - overhangSides) - postXOffset) - shedLength) - wallWidth), ((overhangSides + (postYOffset))) + shedWidth, (shedLength + (postXOffset * 2)) + wallWidth * 2, wallWidth));
    }

    private static void addShedPosts(ArrayList<Svg> svgList, int shedWidth, int shedLength, int widtg, int length) {
        int postHeight = materialMap.get(84).getHeight(); //Materiale 84 er 3m. høje stolper. De eneste vi bruger pt.
        int postWidth = materialMap.get(84).getWidth();
        int postXOffset = materialMap.get(84).getHeight() / 2;
        int postYOffset = materialMap.get(84).getWidth() / 2;
        //der er altid 4 posts
        for (int i = 0; i < 4 / 2; i++) {
            svgList.add(new Rect((length - overhangSides - postXOffset - (shedLength * i)), (overhangSides - postYOffset), postHeight, postWidth));
            svgList.add(new Rect((length - overhangSides - postXOffset - (shedLength * i)), ((overhangSides - postYOffset) + shedWidth), postHeight, postWidth));
        }
    }

    private static void addPosts(ArrayList<Svg> svgList, int width, int postAmount, int postSpacing) {
        int postHeight = materialMap.get(84).getHeight(); //Materiale 84 er 3m. høje stolper. De eneste vi bruger pt.
        int postWidth = materialMap.get(84).getWidth();
        int postXOffset = materialMap.get(84).getHeight() / 2;
        int postYOffset = materialMap.get(84).getWidth() / 2;

        for (int i = 0; i < postAmount / 2; i++) {
            svgList.add(new Rect(((overhangFront - postXOffset) + (postSpacing * i)), (overhangSides - postYOffset), postHeight, postWidth));
            svgList.add(new Rect(((overhangFront - postXOffset) + (postSpacing * i)), (overhangSides - (postYOffset) + (width - (overhangSides * 2))), postHeight, postWidth));
        }
    }

    private static void addArrows(ArrayList<Svg> svgList, int length, int width, int postAmount, int postSpacing, int rafterSpacing) {
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
    }

    private static int addRaftersAndWindBracers(ArrayList<Svg> svgList, int length, int width) {
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
        return rafterSpacing;
    }

    private static void addBeams(int length, ArrayList<Svg> svgList, int width, int postSpacing) {
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
        int angle = order.getAngle();
        int roofHeight = 0; //roofHeight bruges til at forskyde carporten på Y-aksen, så der er plads til taget.
        int beamAngle = 0; //beamAngle er hælding på carport tag, hvis det er fladt, er pt statisk 2 grader.
        if (angle == 0) { //angle = 0 betyder fladt tag.
            beamAngle = 2; //Hældning på remme (vinkel A).
        } else {
            /*
            Hvis et tag opfattes som to retvinklede trekanter, med hældning = vinkel A
            og hosliggende katete (b) = det halve af carport bredden. Så kan højden på taget (a) findes ved:
            modstående katete = tan(V) * hosliggende katete, eller:
            a = tan(A) * b
            */
            double b = width / 2;
            double A = Math.toRadians(angle); //Math kan kun bruge sin/cos/tan med double og radianer.

            roofHeight += (int) (Math.tan(A) * b);
        }


        //SVG START
        svgList.add(new SvgStart(0, 0, length, width + roofHeight));


        //STOLPER
        Material beamMat = materialMap.get(ListGen.getRafterId(length));
        Material postMat = materialMap.get(84);
        int postAmount = ListGen.getPostAmount(length);
        int postSpacing = getPostSpacing(postAmount, length);

         /*
         Stolpe forskydning i forhold til hældning, bliver beregnet som højden (side a), i en retvinklet trekant
         med hældning = vinkel A.
         */
        for (int i = 0; i < postAmount / 2; i++) { //Beregner forskydning (side a) for hver stolpe.
            double A = Math.toRadians(beamAngle); //Java Math regner kun i radianer.
            double c = overhangFront + (postSpacing * i); //Hypertenusen er length til hver stolpe.
            double a = c * Math.sin(A);
            //Forskydning ligges til start x koordinat og trækkes fra længden på materialet.
            svgList.add(new Rect(50 + (int) c, (int) a + (beamMat.getHeight() / 2) + roofHeight, postMat.getWidth(), height - ((int) a + (beamMat.getHeight() / 2))));
        }


        //REMME
        /*
        Remme bliver flyttet 50 ind på x-aksen, da den ellers ville blive roteret delvis ud af viewboxen.
        Der bliver ikke taget højde for beam materialets max længde, så length bliver brugt i stedet for.
        */
        svgList.add(new AngledRect(50, roofHeight, length - 50, beamMat.getHeight(), beamAngle));


        //STERNBRÆDDER
        Material fasciaMat = materialMap.get(ListGen.getUpperFasciaId(length));
        svgList.add(new AngledRect(50, roofHeight, length - 50, fasciaMat.getWidth(), beamAngle));


        //TAG
        if (beamAngle == 0) {
            svgList.add(new Rect(50, 20, length - 50, roofHeight));
            svgList.add(new Rect(50, 0, 50 + fasciaMat.getHeight(), roofHeight + fasciaMat.getWidth()));
            svgList.add(new Rect(length - 50 - fasciaMat.getHeight(), 0, 50 + fasciaMat.getHeight(), roofHeight + fasciaMat.getWidth()));
        }

        //SVG AFSLUT (indre tegning)
        svgList.add(new SvgEnd(0, 0));


        //SVG PILE (arrows)
        //Total højde
        svgList.add(new Arrw(200, 500, 200, 500 + height + roofHeight, -90));

        //Højde på tag
        if (beamAngle == 0) {
            svgList.add(new Arrw(400, 500, 400, 500 + roofHeight + fasciaMat.getWidth(), -90));
        }
        
        //Stolpe afstand
        int heightLoss;
        if (beamAngle != 0) {
            double A = Math.toRadians(beamAngle); //Java Math regner kun i radianer.
            double c = overhangFront + (postSpacing * (postAmount / 2)); //Hypertenusen er length til hver stolpe.
            double a = c * Math.sin(A);
            heightLoss = (int) a - (fasciaMat.getWidth() / 2); //Det halve af sternbrættets bredde trækkes fra, da stolper starter midt på sternbrættet.

            svgList.add(new Arrw(200 + length + 500, 500 + heightLoss + roofHeight, 200 + length + 500, 500 + height + roofHeight, -90));
        }

        for (int i = 1; i < postAmount / 2; i++) {
            svgList.add(new Arrw(500 + overhangFront + (postSpacing * (i - 1)) + (beamMat.getHeight() / 2), 500 + height + 175 + roofHeight, 500 + overhangFront + (postSpacing * i) + (beamMat.getHeight() / 2), 500 + height + 175 + roofHeight, 0));
        }


        //SVG AFSLUT (ydre tegning)
        svgList.add(new SvgEnd(0, 0));

        return svgList;
    }
}