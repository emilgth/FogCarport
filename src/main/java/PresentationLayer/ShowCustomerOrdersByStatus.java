package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ShowCustomerOrdersByStatus extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        String status = request.getParameter("status");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Order> orders = LogicFacade.getCustomerOrdersByStatus(status, user.getUserId());
        request.setAttribute("orders", orders);
        return "/WEB-INF/customerNewOrders";
    }
}
