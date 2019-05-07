package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.ListGen;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.OrderLine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Builder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        ArrayList<Order> orderList = OrderMapper.getOrderList();
        ArrayList<OrderLine> orderLineList = ListGen.getOrderLinelist(orderList.get(0));


        HttpSession session = request.getSession();
        session.setAttribute("orderList",orderList);
        session.setAttribute("orderLineList",orderLineList);

        return "skitse";
    }
}
