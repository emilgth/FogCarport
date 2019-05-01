package DBAccess;

import FunctionLayer.Models.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderMapper {

    public static ArrayList<Order> getOrderList(){
        ArrayList<Order> orderList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM `order`");

            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("order_id"));
                order.setUser(UserMapper.getUser(resultSet.getInt("user_id")));
                order.setStatus(resultSet.getString("status"));
                order.setOrderLineList(new ArrayList<>());
                order.setPrice(resultSet.getDouble("price"));
                order.setRoofId(resultSet.getInt("roof_id"));
                order.setAngle(resultSet.getInt("roof_angle"));
                order.setLength(resultSet.getInt("length"));
                order.setWidth(resultSet.getInt("width"));
                order.setHeight(resultSet.getInt("height"));
                order.setShedLength(resultSet.getInt("shed_length"));
                order.setShedWidth(resultSet.getInt("shed_width"));
                orderList.add(order);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
