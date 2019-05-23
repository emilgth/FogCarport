package DBAccess;

import FunctionLayer.Models.Material;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Handles CRUD operations relatied to the materials table
 */
public class MaterialMapper {

    /**
     * @return An arrayList with all the materials in the DB
     */
    public static ArrayList<Material> getMaterialList() {
        ArrayList<Material> materialList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM materials\n" +
                            "INNER JOIN units u \n" +
                            "ON materials.unit = u.unit_id;");

            while (resultSet.next()) {
                Material material = new Material();
                material.setMaterialId(resultSet.getInt("material_id"));
                material.setName(resultSet.getString("name"));
                material.setUnit(resultSet.getString("unit_name"));
                material.setPrice(resultSet.getDouble("price"));
                material.setWidth(resultSet.getInt("width"));
                material.setHeight(resultSet.getInt("height"));
                material.setLength(resultSet.getInt("length"));
                materialList.add(material);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return materialList;
    }
}
