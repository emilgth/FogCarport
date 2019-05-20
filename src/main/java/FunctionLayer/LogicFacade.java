package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.OrderLine;
import FunctionLayer.Models.User;

import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {


    public static User login(String email, String password) throws FogException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password, String surname, String lastname, int phone) throws FogException {
        User user = new User(email, password, surname, lastname, phone);
        UserMapper.createUser(user);
        return user;
    }

    public static ArrayList<Order> getUserOrders(User user) throws FogException {
        return OrderMapper.getUserOrderList(user);
    }

    public static void updateUserData(User user) {
        UserMapper.updateUser(user);
    }


    public static ArrayList<Order> getAllOrders() throws FogException {
        return OrderMapper.getOrderList();

    }

    public static ArrayList<Order> getOrdersByStatus(String status) throws FogException {
        return OrderMapper.getOrdersByStatus(status);
    }

    public static void insertOrder(Order order) throws FogException {
        order.setPrice(order.priceCalc(ListGen.getOrderLinelist(order)));
        OrderMapper.insertOrder(order);
    }

    public static Order getSingleOrder(String orderId) throws FogException {
        return OrderMapper.getSingleOrder(orderId);
    }

    public static void confirmOrder(double newPrice, int orderId) throws FogException {
        OrderMapper.setPrice(newPrice, orderId);
        OrderMapper.setStatus("confirmed", orderId);
    }
}
