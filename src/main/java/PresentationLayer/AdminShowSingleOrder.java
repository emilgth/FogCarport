package PresentationLayer;

import FunctionLayer.ListGen;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.OrderLine;
import FunctionLayer.Models.Svg;
import FunctionLayer.SvgGen;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class AdminShowSingleOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String orderId = request.getParameter("orderId");
        Order order = LogicFacade.getSingleOrder(orderId);
        ArrayList<OrderLine> orderLineList = ListGen.getOrderLinelist(order);
        ArrayList<Svg> svgTopList = SvgGen.getSvgTopList(order);
        ArrayList<Svg> svgSideList = SvgGen.getSvgSideList(order);
        double suggestedPrice = order.getPrice() * 1.25;
        request.setAttribute("suggestedPrice", suggestedPrice);
        request.setAttribute("order", order);
        request.setAttribute("orderLineList", orderLineList);
        request.setAttribute("svgTopList", svgTopList);
        request.setAttribute("svgSideList", svgSideList);
        return "adminShowSingleOrder";
    }

}
