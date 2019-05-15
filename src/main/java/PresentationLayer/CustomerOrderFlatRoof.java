package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.ListGen;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Models.Order;
import FunctionLayer.Models.OrderLine;
import FunctionLayer.Models.Svg;
import FunctionLayer.Models.User;
import FunctionLayer.SvgGen;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Emil
 */
class CustomerOrderFlatRoof extends Command {
    /**
     * @param request servlet request
     * @param response servlet response
     * @return
     * @throws LoginSampleException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String status = "pending";
        int roofId = Integer.parseInt(request.getParameter("Tag"));
        int angle = 0;
        int length = Integer.parseInt(request.getParameter("Carport_laengde"));
        int width = Integer.parseInt(request.getParameter("Carport_bredde"));
        int height = 2300;
        int shedLength = Integer.parseInt(request.getParameter("Redskabsrum_laengde"));
        int shedWidth = Integer.parseInt(request.getParameter("Redskabsrum_bredde"));
        String comment = request.getParameter("bemaerkninger");
        Order order = new Order(user, status, roofId, angle, length, width, height, shedLength, shedWidth, comment);

        //TODO: Skal gå over logicfacade
        ArrayList<OrderLine> orderLineList = ListGen.getOrderLinelist(order);
        ArrayList<Svg> svgTopList = SvgGen.getSvgTopList(order);
        ArrayList<Svg> svgSideList = SvgGen.getSvgSideList(order);

        FunctionLayer.LogicFacade.insertOrder(order);

        session.setAttribute("order", order);
        session.setAttribute("orderLineList", orderLineList);
        session.setAttribute("svgTopList", svgTopList);
        session.setAttribute("svgSideList", svgSideList);

        return "skitse";
    }
}
