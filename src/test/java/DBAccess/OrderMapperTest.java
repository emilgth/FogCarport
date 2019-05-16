package DBAccess;

import FunctionLayer.FogException;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class OrderMapperTest {

    private static Connection testConnection;
    private static String USER = "Fog_testuser";
    private static String USERPW = "1234";
    private static String DBNAME = "Fog_test";
    private static String HOST = "157.230.105.104";

    @Before
    public void setUp() throws Exception {
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
                stmt.execute("drop table if exists `order`");
                stmt.execute("create table `order` like `order_test`");
                stmt.execute("insert into `order` select * from `order_test`");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull( testConnection );
    }

    @Test
    public void getOrderList() throws FogException {
        ArrayList<Order> orderList = OrderMapper.getOrderList();
        assertEquals(2, orderList.size());
    }

    @Test
    public void insertOrder() throws FogException {
        User user = new User();
        user.setUserId(2);
        Order order = new Order(user,  "status", 1, 0, 5000, 6000, 3000, 2000, 1000, "comment");
        OrderMapper.insertOrder(order);
        ArrayList<Order> orderList = OrderMapper.getOrderList();
        assertEquals(3, orderList.size());
    }
}