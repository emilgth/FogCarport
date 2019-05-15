package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ShowAdminOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        ArrayList<Order> orders = FunctionLayer.LogicFacade.getAllOrders();
        request.setAttribute("orders", orders);
        return "adminOrders";
    }
}
