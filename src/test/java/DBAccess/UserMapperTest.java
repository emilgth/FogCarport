package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Models.User;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class UserMapperTest {

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
                stmt.execute( "drop table if exists user" );
                stmt.execute( "create table user like user_test" );
                stmt.execute( "insert into user select * from user_test" );
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

    @Test
    public void testGetUser() {
        // Can we find a user
        User user = UserMapper.getUser( 2);
        assertNotNull(user);
    }

    @Test
    public void testGetUserSpecificUser() {
        // Can we find the right user
        User user = UserMapper.getUser(2);
        assertEquals("anders@email.com",user.getEmail());
    }

    @Test
    public void login() throws LoginSampleException {
        int userID = 2;
        assertEquals(userID, UserMapper.login("anders@email.com", "1234").getUserId());
    }

    /*
    @Test( expected = LoginSampleException.class )
    public void testLogin02() throws LoginSampleException {
        // We should get an exception if we use the wrong password
        User user = UserMapper.login( "jens@somewhere.com", "larsen" );
    }

    @Test
    public void testLogin03() throws LoginSampleException {
        // Jens is supposed to be a customer
        User user = UserMapper.login( "jens@somewhere.com", "jensen" );
        assertEquals( "customer", user.getRole() );
    }

    @Test
    public void testCreateUser01() throws LoginSampleException {
        // Can we create a new user - Notice, if login fails, this will fail
        // but so would login01, so this is OK
        User original = new User( "king@kong.com", "uhahvorhemmeligt", "konge" );
        UserMapper.createUser( original );
        User retrieved = UserMapper.login( "king@kong.com", "uhahvorhemmeligt" );
        assertEquals( "konge", retrieved.getRole() );
    }

     */


}
