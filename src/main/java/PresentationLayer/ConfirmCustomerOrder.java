package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.Models.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Changes the price and status of a specific order
 */
class ConfirmCustomerOrder extends Command {
    /**
     * @param request servlet request
     * @param response servlet response
     * @return jsp address
     * @throws FogException if an error occurs, most likely when connecting to the database
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        double newPrice = Double.parseDouble(request.getParameter("newPrice"));
        LogicFacade.confirmOrder(newPrice, orderId);
        ArrayList<Order> orders = LogicFacade.getOrdersByStatus("pending");
        request.setAttribute("orders", orders);
        return "/WEB-INF/customerNewOrders";
    }
}
