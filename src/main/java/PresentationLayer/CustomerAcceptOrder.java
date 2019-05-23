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
class CustomerAcceptOrder extends Command {
    /**
     * @param request servlet request
     * @param response servlet response
     * @return jsp address
     * @throws FogException if an error occurs, most likely when connecting to the database
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        LogicFacade.customerAcceptOrder(orderId);
        ArrayList<Order> orders = LogicFacade.getOrdersByStatus("accepted");
        request.setAttribute("orders", orders);
        return "/WEB-INF/acceptedCustomerOrder";
    }
}
