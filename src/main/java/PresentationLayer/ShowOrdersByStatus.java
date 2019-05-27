package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.Models.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Shows all orders with a specific status
 */
class ShowOrdersByStatus extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        String status = request.getParameter("status");
        ArrayList<Order> orders = LogicFacade.getOrdersByStatus(status);
        request.setAttribute("orders", orders);
        return "/WEB-INF/newOrders";
    }
}
