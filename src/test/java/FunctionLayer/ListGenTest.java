package FunctionLayer;

import DBAccess.Connector;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class ListGenTest {

    //<editor-fold defaultstate="collapsed" desc="Setup">
    //TODO: Tilføj til envvar, der er stadig potentielt sensitiv data i test DB
    private static Connection testConnection;
    private static String USER = "Fog_testuser";
    private static String USERPW = "1234";
    private static String DBNAME = "Fog_test";
    private static String HOST = "157.230.105.104";

    @Before
    public void setUp() {
        try {
            // avoid making a new connection for each test
            if (testConnection == null) {
                String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
                Class.forName("com.mysql.cj.jdbc.Driver");

                testConnection = DriverManager.getConnection(url, USER, USERPW);
                // Make mappers use test
                Connector.setConnection(testConnection);
            }
            // reset test database
            try (Statement stmt = testConnection.createStatement()) {
                stmt.execute("drop table if exists materials");
                stmt.execute("drop table if exists units");
                stmt.execute("create table materials like materials_test");
                stmt.execute("create table units like units_test");
                stmt.execute("insert into materials select * from materials_test");
                stmt.execute("insert into units select * from units_test");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    @Test
    public void testConnection() {
        assertNotNull(testConnection);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tests for getFasciaAmount()">
    @Test
    public void testGetFasciaAmount6000() {
        int amount = ListGen.getFasciaAmount(6000, 6000);
        assertEquals(2, amount);
    }

    @Test
    public void testGetFasciaAmount6001() {
        int amount = ListGen.getFasciaAmount(6001, 6000);
        assertEquals(4, amount);
    }

    @Test
    public void testGetFasciaAmount12001() {
        int amount = ListGen.getFasciaAmount(12002, 6000);
        assertEquals(6, amount);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tests for getLowerFascia()">
    @Test
    public void testGetLowerFasciaId4500() {
        int materialId = ListGen.getLowerFasciaId(4500);
        assertEquals(22, materialId);
    }

    @Test
    public void testGetLowerFasciaId4501() {
        int materialId = ListGen.getLowerFasciaId(4501);
        assertEquals(23, materialId);
    }

    @Test
    public void testGetLowerFasciaId6002() {
        int materialId = ListGen.getLowerFasciaId(6002);
        assertEquals(18, materialId);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tests for getUpperFascia()">
    @Test
    public void testGetUpperFasciaId4500() {
        int materialId = ListGen.getUpperFasciaId(4500);
        assertEquals(35, materialId);
    }

    @Test
    public void testGetUpperFasciaId4501() {
        int materialId = ListGen.getUpperFasciaId(4501);
        assertEquals(36, materialId);
    }

    @Test
    public void testGetUpperFasciaId6002() {
        int materialId = ListGen.getUpperFasciaId(6002);
        assertEquals(31, materialId);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tests for getPostAmount()">
    @Test
    public void testGetPostAmount4400() {
        int postAmount = ListGen.getPostAmount(4400);
        assertEquals(4, postAmount);
    }

    @Test
    public void testGetPostAmount4401() {
        int postAmount = ListGen.getPostAmount(4401);
        assertEquals(6, postAmount);
    }

    @Test
    public void testGetPostAmount7500() {
        int postAmount = ListGen.getPostAmount(7500);
        assertEquals(6, postAmount);
    }

    @Test
    public void testGetPostAmount7501() {
        int postAmount = ListGen.getPostAmount(7501);
        assertEquals(8, postAmount);
    }

    @Test
    public void testGetPostAmount8000() {
        int postAmount = ListGen.getPostAmount(8000);
        assertEquals(8, postAmount);
    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tests for getRafterSpacing()">
    @Test
    public void testGetRafterSpacing3200() {
        int rafterSpacing = ListGen.getRafterSpacing(3200);
        assertEquals(1200, rafterSpacing);
    }

    @Test
    public void testGetRafterSpacing3400() {
        int rafterSpacing = ListGen.getRafterSpacing(3400);
        assertEquals(1000, rafterSpacing);
    }

    @Test
    public void testGetRafterSpacing3600() {
        int rafterSpacing = ListGen.getRafterSpacing(3600);
        assertEquals(800, rafterSpacing);
    }

    @Test
    public void testGetRafterSpacing4000() {
        int rafterSpacing = ListGen.getRafterSpacing(4000);
        assertEquals(600, rafterSpacing);
    }

    @Test
    public void testGetRafterSpacing5000() {
        int rafterSpacing = ListGen.getRafterSpacing(5000);
        assertEquals(400, rafterSpacing);
    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tests for getRafterId()">
    @Test
    public void testGetRafterId5600() {
        int materialId = ListGen.getRafterId(4500);
        assertEquals(70, materialId);
    }

    @Test
    public void testGetRafterId5601() {
        int materialId = ListGen.getRafterId(4501);
        assertEquals(71, materialId);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tests for getRafterAmount()">
    @Test
    public void testGetRafterAmount() {
        int rafterAmount = ListGen.getRafterAmount(7800, 6000);
        assertEquals(19, rafterAmount);
    }
    //</editor-fold>
}