package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.User;

import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {


    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

     public static User createUser( String email, String password, String surname, String lastname, int phone ) throws LoginSampleException {
         User user = new User(email, password, surname, lastname, phone);
         UserMapper.createUser( user );
         return user;
     }

    public static ArrayList<Order> getUserOrders(User user) {
        return OrderMapper.getUserOrderList(user);
    }
}
