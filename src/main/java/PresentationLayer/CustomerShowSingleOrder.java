package PresentationLayer;

import FunctionLayer.ListGen;
import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.OrderLine;
import FunctionLayer.Models.Svg;
import FunctionLayer.SvgGen;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Gets an order specified by "orderId" from the database, generates an item list and SVG drawing
 */
class CustomerShowSingleOrder extends Command {
    /**
     * @param request servlet request
     * @param response servlet response
     * @return jsp address
     * @throws FogException if an error occurs
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        String orderId = request.getParameter("orderId");
        Order order = LogicFacade.getSingleCustomerOrder(orderId);
        ArrayList<OrderLine> orderLineList = ListGen.getOrderLinelist(order);
        ArrayList<Svg> svgTopList = SvgGen.getSvgTopList(order);
        ArrayList<Svg> svgSideList = SvgGen.getSvgSideList(order);
        double suggestedPrice = order.getPrice() * 1.25;
        request.setAttribute("suggestedPrice", suggestedPrice);
        request.setAttribute("order", order);
        request.setAttribute("orderLineList", orderLineList);
        request.setAttribute("svgTopList", svgTopList);
        request.setAttribute("svgSideList", svgSideList);
        return "/WEB-INF/customerShowSingleOrder";
    }
}
