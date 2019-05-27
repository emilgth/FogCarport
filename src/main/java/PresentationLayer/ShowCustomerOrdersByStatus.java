package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Retrieves arrayList of all orders belonging to a specific user and with a specific status
 */
class ShowCustomerOrdersByStatus extends Command {
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
