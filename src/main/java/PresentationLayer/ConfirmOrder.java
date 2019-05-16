package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.Models.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ConfirmOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        double newPrice = Double.parseDouble(request.getParameter("newPrice"));
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        LogicFacade.confirmOrder(newPrice, orderId);
        ArrayList<Order> orders = LogicFacade.getPendingOrders();
        request.setAttribute("orders", orders);
        return "/WEB-INF/newOrders";
    }
}
