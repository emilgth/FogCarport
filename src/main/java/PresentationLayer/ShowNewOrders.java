package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.Models.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ShowNewOrders extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        ArrayList<Order> orders = LogicFacade.getPendingOrders();
        request.setAttribute("orders", orders);
        return "newOrders";
    }
}
