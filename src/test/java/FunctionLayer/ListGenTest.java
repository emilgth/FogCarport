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

    private static Connection testConnection;
    private static String USER = "Fog_testuser";
    private static String USERPW = "1234";
    private static String DBNAME = "Fog_test";
    private static String HOST = "157.230.105.104";

    @Before
    public void setUp() {
        try {
            // avoid making a new connection for each test
            if ( testConnection == null ) {
                String url = String.format( "jdbc:mysql://%s:3306/%s", HOST, DBNAME );
                Class.forName( "com.mysql.cj.jdbc.Driver" );

                testConnection = DriverManager.getConnection( url, USER, USERPW );
                // Make mappers use test
                Connector.setConnection( testConnection );
            }
            // reset test database
            try ( Statement stmt = testConnection.createStatement() ) {
                stmt.execute( "drop table if exists materials" );
                stmt.execute( "drop table if exists units" );
                stmt.execute( "create table materials like materials_test" );
                stmt.execute( "create table units like units_test" );
                stmt.execute( "insert into materials select * from materials_test" );
                stmt.execute( "insert into units select * from units_test" );
            }

        } catch ( ClassNotFoundException | SQLException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull( testConnection );
    }

    //<editor-fold defaultstate="collapsed" desc="Tests for getPostAmount()">
    @Test
    public void testGetPostAmount4400() {
        int postAmount = ListGen.getPostAmount(4400);
        assertEquals(4,postAmount);
    }

    @Test
    public void testGetPostAmount7500() {
        int postAmount = ListGen.getPostAmount(7500);
        assertEquals(6,postAmount);
    }

    @Test
    public void testGetPostAmount8000() {
        int postAmount = ListGen.getPostAmount(8000);
        assertEquals(8,postAmount);
    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tests for getRafterSpacing()">
    @Test
    public void testGetRafterSpacing3200() {
        int rafterSpacing = ListGen.getRafterSpacing(3200);
        assertEquals(1200,rafterSpacing);
    }

    @Test
    public void testGetRafterSpacing3400() {
        int rafterSpacing = ListGen.getRafterSpacing(3400);
        assertEquals(1000,rafterSpacing);
    }

    @Test
    public void testGetRafterSpacing3600() {
        int rafterSpacing = ListGen.getRafterSpacing(3600);
        assertEquals(800,rafterSpacing);
    }

    @Test
    public void testGetRafterSpacing4000() {
        int rafterSpacing = ListGen.getRafterSpacing(4000);
        assertEquals(600,rafterSpacing);
    }

    @Test
    public void testGetRafterSpacing5000() {
        int rafterSpacing = ListGen.getRafterSpacing(5000);
        assertEquals(400,rafterSpacing);
    }
    // </editor-fold>


    @Test
    public void testGetRafterId() {
        int materialId = ListGen.getRafterId(5600);
        assertEquals(74,materialId);
    }
}