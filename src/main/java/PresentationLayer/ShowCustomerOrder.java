package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ShowCustomerOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Order> orders = FunctionLayer.LogicFacade.getUserOrders(user);
        request.setAttribute("orders", orders);
        return "customerOrders";
    }
}
