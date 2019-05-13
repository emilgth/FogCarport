package FunctionLayer;

import DBAccess.MaterialMapper;
import FunctionLayer.Models.Material;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.OrderLine;

import java.util.ArrayList;
import java.util.HashMap;

public class ListGen {

    private static ArrayList<Material> dontUseThisList = MaterialMapper.getMaterialList();
    private static HashMap<Integer, Material> materialMap = getMaterialMap(dontUseThisList);
    private static ArrayList<Material> lowerFasciaList;
    private static ArrayList<Material> upperFasciaList;
    private static ArrayList<Material> rafterList;
    private static ArrayList<Material> waterboardList;
    private static ArrayList<Material> roofMaterialList;

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

    //<editor-fold defaultstate="collapsed" desc="List builders. Tryk på '+' for at udvide.">

    /*
    Følgenge lister er bevidst bygget manuelt fordi materialer i DB ikke nødvendigvis kommer foreløbende.
    Manuel konstruktion af lister kan erstattes med nye DB Mappers, der kun udvælger de pågældende materialer.
    */

    private static ArrayList<Material> getLowerFasciaList() {
        //Denne metode laver en liste med alle relevante materialer til understernbrædder

        if (lowerFasciaList == null) {
            lowerFasciaList = new ArrayList<>();

            //Alle 25x200 trykimp. brædder
            lowerFasciaList.add(materialMap.get(15));
            lowerFasciaList.add(materialMap.get(16));
            lowerFasciaList.add(materialMap.get(17));
            lowerFasciaList.add(materialMap.get(18));
            lowerFasciaList.add(materialMap.get(19));
            lowerFasciaList.add(materialMap.get(20));
            lowerFasciaList.add(materialMap.get(21));
            lowerFasciaList.add(materialMap.get(22));
            lowerFasciaList.add(materialMap.get(23));
            lowerFasciaList.add(materialMap.get(24));
            lowerFasciaList.add(materialMap.get(25));
            lowerFasciaList.add(materialMap.get(26));
            lowerFasciaList.add(materialMap.get(27));
        }
        return lowerFasciaList;
    }

    private static ArrayList<Material> getUpperFasciaList() {
        //Denne metode laver en liste med alle relevante materialer til oversternbrædder

        if (upperFasciaList == null) {
            upperFasciaList = new ArrayList<>();

            //Alle 25x125 trykimp. brædder
            upperFasciaList.add(materialMap.get(28));
            upperFasciaList.add(materialMap.get(29));
            upperFasciaList.add(materialMap.get(30));
            upperFasciaList.add(materialMap.get(31));
            upperFasciaList.add(materialMap.get(32));
            upperFasciaList.add(materialMap.get(33));
            upperFasciaList.add(materialMap.get(34));
            upperFasciaList.add(materialMap.get(35));
            upperFasciaList.add(materialMap.get(36));
            upperFasciaList.add(materialMap.get(37));
            upperFasciaList.add(materialMap.get(38));
            upperFasciaList.add(materialMap.get(39));
            upperFasciaList.add(materialMap.get(40));
        }
        return upperFasciaList;
    }

    private static ArrayList<Material> getRafterList() {
        //Denne metode laver en liste med alle relevante materialer til spær

        if (rafterList == null) {
            rafterList = new ArrayList<>();

            //Alle 45x195 ubh. spærtræ
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
        }
        return rafterList;
    }

    private static ArrayList<Material> getWaterboardList() {
        //Denne metode laver en liste med alle relevante materialer til vandbrædder

        if (waterboardList == null) {
            waterboardList = new ArrayList<>();

            //Alle 19x100 trykimp. brædder
            waterboardList.add(materialMap.get(89));
            waterboardList.add(materialMap.get(90));
            waterboardList.add(materialMap.get(91));
            waterboardList.add(materialMap.get(92));
            waterboardList.add(materialMap.get(93));
            waterboardList.add(materialMap.get(94));
            waterboardList.add(materialMap.get(95));
            waterboardList.add(materialMap.get(96));
            waterboardList.add(materialMap.get(97));
            waterboardList.add(materialMap.get(98));
            waterboardList.add(materialMap.get(99));
            waterboardList.add(materialMap.get(100));
            waterboardList.add(materialMap.get(101));
        }
        return waterboardList;
    }

    private static ArrayList<Material> getRoofMaterialList() {
        //Denne metode laver en liste med alle relevante materialer til fladttag
        if (roofMaterialList == null) {
            roofMaterialList = new ArrayList<>();

            //Alle fladt tag materialer
            roofMaterialList.add(materialMap.get(102));
            roofMaterialList.add(materialMap.get(103));
            roofMaterialList.add(materialMap.get(104));
            roofMaterialList.add(materialMap.get(105));
            roofMaterialList.add(materialMap.get(106));
            roofMaterialList.add(materialMap.get(135));
            roofMaterialList.add(materialMap.get(136));
        }
        return roofMaterialList;
    }

    // </editor-fold>

    //Stolpe og udhæng variable, som udgangspunkt statiske
    private static int overhangFront = 1000; //max 1000
    private static int overhangSides = 300; //max 300
    private static int postSpacing = 3100; //max 3100

    public static ArrayList<OrderLine> getOrderLinelist(Order order) {

        ArrayList<OrderLine> orderLineList = new ArrayList<>();

        //<editor-fold defaultstate="collapsed" desc="Test data til SCRUM præsentation 03/05. Tryk på '+' for at udvide.">
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

        //CARPORT MÅL
        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();

        /*
        Metoden vil nu tilføje materialer til orderLineList i form Orderline objekter. En orderline indeholder,
        et materiale, et antal og en beskrivelse.
        Ud fra orderLineList kan styklisten genereres på jsp siden.
        Materialerne bliver tilføjet til listen i samme rækkefølge som de optræder på listen.
        */

        //STERNBRÆDDER (fascia boards)
        String lowerFasciaFrontBackDesc = "understernbrædder til for & bag ende";
        Material tempMat01 = materialMap.get(getLowerFasciaId(width));
        //Amount ganges med 2 fordi det er både front og back, med skur er det kun front der har sternbrædder.
        orderLineList.add(new OrderLine(tempMat01, 2 * getFitAmount(width, tempMat01.getLength()), lowerFasciaFrontBackDesc));

        String lowerFasciaSidesDesc = "understernbrædder til siderne";
        Material tempMat02 = materialMap.get(getLowerFasciaId(length));
        //Amount ganges også her med 2, fordi det er amount for begge sider.
        orderLineList.add(new OrderLine(tempMat02, 2 * getFitAmount(length, tempMat02.getLength()), lowerFasciaSidesDesc));

        String upperFasciaFrontBackDesc = "oversternbrædder til for & bag ende";
        Material tempMat03 = materialMap.get(getUpperFasciaId(width));
        //Amount gange IKKE med 2 her, fordi der aldrig er oversternbræt på bagenden. Da vandet i så fald ikke ville kunne løbe af.
        orderLineList.add(new OrderLine(tempMat03, getFitAmount(width, tempMat03.getLength()), upperFasciaFrontBackDesc));

        String upperFasciaSidesDesc = "oversternbrædder til siderne";
        Material tempMat04 = materialMap.get(getUpperFasciaId(length));
        //Amount ganges med 2, fordi der skal oversternbræt på begge sider.
        orderLineList.add(new OrderLine(tempMat04, 2 * getFitAmount(length, tempMat04.getLength()), upperFasciaSidesDesc));

        //REMME (beams)
        //Remme er bygget af spærtræ så metoden bruger rafterList()
        String beamDesc = "Remme i sider, sadles ned i stolper";
        Material tempMat05 = materialMap.get(getRafterId(length));
        //Amount ganges med 2 fordi der er remme i begge sider
        orderLineList.add(new OrderLine(tempMat05, 2 * getFitAmount(length, tempMat05.getLength()), beamDesc));

        //SPÆR (rafters)
        String rafterDesc = "Spær, monteres på rem";
        orderLineList.add(new OrderLine(materialMap.get(getRafterId(width)), getRafterAmount(length, width), rafterDesc));

        //STOLPER (posts)
        String postDesc = "Stolper nedgraves 90 cm. i jord";
        //Stolper er som udgangspunkt altid 3m lange da højden ikke er variabel
        orderLineList.add(new OrderLine(materialMap.get(84), getPostAmount(length), postDesc));

        //VANDBRÆDDER (water boards)
        String waterboardSidesDesc = "vandbrædt på stern i sider";
        Material tempMat06 = materialMap.get(getWaterboardId(length));
        //Amount ganges med 2 fordi vandbrædder følger sternbrædder
        orderLineList.add(new OrderLine(tempMat06, 2 * getFitAmount(length, tempMat06.getLength()), waterboardSidesDesc));

        String waterboardFrontDesc = "vandbrædt på stern i forende";
        Material tempMat07 = materialMap.get(getWaterboardId(width));
        //Amount ganges ikke da det kun er til front
        orderLineList.add(new OrderLine(tempMat07, getFitAmount(width, tempMat07.getLength()), waterboardFrontDesc));

        //TAGBEKLÆDNING (roof material)
        int roofArea = length * width;
        int tileAmount = 1;
        Material roofMaterial = materialMap.get(findBestFit(length, getRoofMaterialList()));
        while (roofArea > (roofMaterial.getLength() - 200) * (roofMaterial.getWidth() - 100) * tileAmount) {
            tileAmount++;
        }
        String roofDesc = "tagplader monteres på spær";
        orderLineList.add(new OrderLine(roofMaterial, tileAmount, roofDesc));

        return orderLineList;
    }

    public static int getFitAmount(int size, int materialLength) {
        /*
        Denne metode bruger findFitFactor() til at bestemme hvor man sternbrædder der skal bruges til ÉN side.
        Der er altid 2 sternbrædder pr side pr sæt (i), med undtagelse af bagside hvis der er skur.

        while løkken i findFitfactor() kompensere for at nogen materialer er for korte til at strække hele size
        og derfor blev halveret i en af fasciaId metoderne.
        */
        return findFitFactor(size, materialLength);
    }

    public static int getLowerFasciaId(int size) {
        //Se findBestFit()
        return findBestFit(size, getLowerFasciaList());
    }

    public static int getUpperFasciaId(int size) {
        //Se findBestFit()
        return findBestFit(size, getUpperFasciaList());
    }

    public static int getPostAmount(int length) {
        /*
        Denne metode finder antallet af stolper der skal bruges, baseret på længden af carport

        i er antal stolpesæt tilføjet til start på 2 stolper
        i starter på 1 fordi en carport minimum har 4 stolper

        getDistance() beregner foreløbende length baseret på antal tilføjede stolpesæt (i)
        og størrelse på overhæng
        */
        int i = 1;
        while (length > getDistance(i)) {
            i++;
        }
        return 2 + i * 2;
    }

    private static int getDistance(int i) {
        //Se getPostAmount()
        return overhangFront + overhangSides + (postSpacing * i);
    }

    public static int getRafterId(int width) {
        //Se findBestFit()
        return findBestFit(width, getRafterList());
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

    public static int getRafterAmount(int length, int width) {
        /*
        Denne metode beregner hvor mange spær der skal bruges ud fra længden og bredden på carport.
        Metoden ligger 1 til, fordi integers altid runder ned ved division.
        Dette giver en minor bug ved præcise mål f.eks:
        Hvis carport bredde er 3300mm og længde 6000mm. Vil man i teorien kunne nøjes med 6 spær, men metoden
        returnerer 7.
        */
        return 1 + (length / getRafterSpacing(width));
    }

    private static int findBestFit(int size, ArrayList<Material> list) {
        /*
        Denne metode finder id på det materiale, der er mindst muligt for langt, til at opfylde en given længde
        ud fra en liste af materialer.

        *int size kan være både length eller width på carport, bruger navnet size for at undgå forvirring.
        **Metoden bruger altid length på materialerne, husk materialer kan være orienteret forskelligt.
        ***Læs om listerne under: List builders (default collapsed)

        Metoden bliver brugt af:
        getLowerFasciaId() til at finde understernbrædder
        getUpperFasciaId() til at finde oversternbrædder
        getRafterId() til at finde spær

        Mellem metoderne bliver brugt for overskuelighed og for at gøre koden mere testbar
        */
        int i = findMaxFromList(size, list);
        int tempResult = Integer.MAX_VALUE;
        int materialId = 0;
        for (Material material : list) {
            if (material.getLength() >= size / i && material.getLength() < tempResult) {
                tempResult = material.getLength();
                materialId = material.getMaterialId();
            }
        }
        return materialId;
    }

    public static int getWaterboardId(int size) {
        //Se findBestFit()
        return findBestFit(size, getWaterboardList());
    }

    private static int findMaxFromList(int size, ArrayList<Material> list) {
        /*
        Denne metode finder et max, som bruges af findFitFactor() til at finde en factor i som
        size delt med bliver mindre end (<=) det længste materiale i list

        Metoden bliver brugt af:
        findBestFit()
        */
        int max = Integer.MIN_VALUE;
        for (Material material : list) {
            if (material.getLength() > max) {
                max = material.getLength();
            }
        }
        return findFitFactor(size, max);
    }

    private static int findFitFactor(int size, int max) {
        /*
        Denne metode kompensere for at nogen materialer er for korte til at strække hele size
        og derfor blev halveret i en af Id metoderne.

        Metoden returnerer den factor size er delt med for at finde et materiale der kan strække længden.
        Factor bruges også af getFitAmount() til at gange amount op,
        så amount gange materiale længde er større end eller lig med size.
        */
        int i = 1;

        //Minor bug: 6001 / 2 = 3000 pga integers
        while (size / i > max) {
            i++;
        }
        return i;
    }
}