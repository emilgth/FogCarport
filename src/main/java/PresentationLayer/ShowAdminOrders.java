package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.Models.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ShowAdminOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        ArrayList<Order> orders = FunctionLayer.LogicFacade.getAllOrders();
        request.setAttribute("orders", orders);
        return "/WEB-INF/adminOrders";
    }
}
