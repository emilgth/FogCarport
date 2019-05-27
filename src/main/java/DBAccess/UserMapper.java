package DBAccess;

import FunctionLayer.FogException;
import FunctionLayer.Models.User;

import java.sql.*;

/**
 * Handles CRUD operations for the user table in DB
 */
public class UserMapper {

    /**
     * @param userId used to select the correct user
     * @return returns User object
     * @throws FogException if there's problems with connecting to the database
     */
    static User getUser(int userId) throws FogException {

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

        } catch (SQLException e) {
            throw new FogException(e.toString(), "getSingleOrder(): SQL syntax fejl");
        } catch (ClassNotFoundException e) {
            throw new FogException(e.toString(), "getSingleOrder(): JDBC driver ikke fundet");
        }
        return user;
    }

    /**
     * @param email    user email
     * @param password user password
     * @return finds user in DB and returns all user data
     * @throws FogException if user is not found in database or password and email doesn't match
     */
    public static User login(String email, String password) throws FogException {

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
                throw new FogException("Login error", "User with this email and password combination could not be found");
            }

        } catch (SQLException e) {
            throw new FogException(e.toString(), "login(): SQL syntax");
        } catch (ClassNotFoundException e) {
            throw new FogException(e.toString(), "login(): JDBC driver ikke fundet");
        }
    }

    /**
     * @param user User object containing data to be inserted into database
     * @throws FogException see FE
     */
    public static void createUser(User user) throws FogException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO user (email, password, surname, lastname, phone) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSurname());
            ps.setString(4, user.getLastname());
            ps.setInt(5, user.getPhone());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setUserId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage());
        }


    }

    /**
     * @param user User object containing data to be inserted into database
     */
    public static void updateUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Connector.connection();
            preparedStatement = connection.prepareStatement("UPDATE Fog.user set email = ?, surname = ?, lastname = ?, " +
                    "phone = ?, password = ? WHERE user_id = ?");

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getLastname());
            preparedStatement.setInt(4, user.getPhone());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setInt(6, user.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
