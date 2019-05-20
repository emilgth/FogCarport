package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.FogException;
import FunctionLayer.ListGen;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.OrderLine;
import FunctionLayer.Models.Svg;
import FunctionLayer.SvgGen;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * This is a class used for demoing and it should be removed
 */
class Builder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        ArrayList<Order> orderList = OrderMapper.getOrderList();
        ArrayList<OrderLine> orderLineList = ListGen.getOrderLinelist(orderList.get(0));
        ArrayList<Svg> svgList = SvgGen.getSvgTopList(orderList.get(0));

        HttpSession session = request.getSession();
        session.setAttribute("orderList", orderList);
        session.setAttribute("orderLineList", orderLineList);
        session.setAttribute("svgList", svgList);

        return "/WEB-INF/skitse";
    }
}
