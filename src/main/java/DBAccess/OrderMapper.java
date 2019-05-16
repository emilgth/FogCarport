package DBAccess;

import FunctionLayer.ListGen;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.User;

import java.sql.*;
import java.util.ArrayList;

public class OrderMapper {

    public static ArrayList<Order> getOrderList() {
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
                order.setComment(resultSet.getString("comment"));
                orderList.add(order);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    /**
     * @param order
     */
    public static void insertOrder(Order order) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Connector.connection();
            preparedStatement = connection.prepareStatement("insert into Fog.order " +
                    "(user_id, status, itemlist, price, roof_id, roof_angle, length, width, height, shed_length, shed_width, comment) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, order.getUser().getUserId());
            preparedStatement.setString(2, order.getStatus());
            preparedStatement.setString(3, "");
            preparedStatement.setDouble(4, order.getPrice());
            preparedStatement.setInt(5, order.getRoofId());
            preparedStatement.setInt(6, order.getAngle());
            preparedStatement.setInt(7, order.getLength());
            preparedStatement.setInt(8, order.getWidth());
            preparedStatement.setInt(9, order.getHeight());
            preparedStatement.setInt(10, order.getShedLength());
            preparedStatement.setInt(11, order.getShedWidth());
            preparedStatement.setString(12, order.getComment());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Order> getUserOrderList(User user) {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Fog.`order` WHERE user_id = ?");
            ps.setInt(1, user.getUserId());
            ResultSet resultSet = ps.executeQuery();
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
                order.setComment(resultSet.getString("comment"));
                orders.add(order);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public static ArrayList<Order> getAllOrders(Order order) {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Fog.`order` WHERE order_id = ?");
            ps.setInt(1, order.getOrderId());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                order.setOrderId(resultSet.getInt("order_id"));
                /*order.setUser(UserMapper.getUser(resultSet.getInt("user_id")));
                order.setStatus(resultSet.getString("status"));
                order.setOrderLineList(new ArrayList<>());
                order.setPrice(resultSet.getDouble("price"));
                order.setRoofId(resultSet.getInt("roof_id"));
                order.setAngle(resultSet.getInt("roof_angle"));
                order.setLength(resultSet.getInt("length"));
                order.setWidth(resultSet.getInt("width"));
                order.setHeight(resultSet.getInt("height"));
                order.setShedLength(resultSet.getInt("shed_length"));
                order.setShedWidth(resultSet.getInt("shed_width"));*/
                orders.add(order);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orders;
    }


    public static ArrayList<Order> getPendingOrders() {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM `order` where status = 'pending'");
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
                order.setComment(resultSet.getString("comment"));
                orders.add(order);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public static Order getSingleOrder(String orderId) {
        Order order = new Order();
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Fog.`order` WHERE order_id = ?");
            ps.setString(1, orderId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
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
                order.setComment(resultSet.getString("comment"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return order;
    }

    public static void setPrice(double newPrice, int orderId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Connector.connection();
            preparedStatement = connection.prepareStatement("UPDATE Fog.`order` SET price = ? WHERE order_id = ?");
            preparedStatement.setDouble(1, newPrice);
            preparedStatement.setInt(2, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setStatus(String newStatus, int orderId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Connector.connection();
            preparedStatement = connection.prepareStatement("UPDATE Fog.`order` set status = ? WHERE order_id = ?");
            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

