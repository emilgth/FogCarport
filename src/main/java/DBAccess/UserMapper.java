package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Models.User;

import java.sql.*;

public class UserMapper {

    public static User getUser(int userId) {

        User user = new User();

        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE user_id = ?");
            ps.setInt(1, userId);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                user.setUserId(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setSurname(resultSet.getString("surname"));
                user.setLastname(resultSet.getString("lastname"));
                user.setPhone(resultSet.getInt("phone"));
                user.setAdmin(resultSet.getBoolean("admin"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User login(String email, String password) throws LoginSampleException {

        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                email = resultSet.getString("email");
                password = resultSet.getString("password");
                String surname = resultSet.getString("surname");
                String lastname = resultSet.getString("lastname");
                int phone = resultSet.getInt("phone");
                boolean admin = resultSet.getBoolean("admin");
                return new User(userId, email, password, surname, lastname, phone, admin);
            } else {
                throw new LoginSampleException("shit");
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new LoginSampleException("shit fuck");
        }
    }

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO user (email, password, surname, lastname, phone) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString(3, user.getSurname() );
            ps.setString(4, user.getLastname() );
            ps.setInt(5, user.getPhone() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setUserId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
}
