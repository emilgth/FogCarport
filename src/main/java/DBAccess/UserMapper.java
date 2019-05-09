package DBAccess;

import FunctionLayer.Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
