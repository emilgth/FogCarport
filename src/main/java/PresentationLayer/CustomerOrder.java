package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.ListGen;
import FunctionLayer.LogicFacade;
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
 * Handles when a customer orders a new car port. It handles both types of carport.
 * It pulls the order parameters from request, and user information from session.
 * Generates item list with the ListGen.getOrderLinesList method, and generates an svg drawing with SvgGen.
 * Finally the order is inserted into the database and the user is sent to a success page
 */
class CustomerOrder extends Command {
    /**
     * @param request  servlet request
     * @param response servlet response
     * @return jsp address
     * @throws FogException see FogException class
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        //checks if user is logged in
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            request.setAttribute("status", "ikke ok");
            request.setAttribute("message", "Log venligst ind for at bestille");
            request.getRequestDispatcher("fladtTag.jsp");
            return "fladtTag";
        }

        User user = (User) session.getAttribute("user");
        String status = "pending";
        int angle;
        if (request.getParameter("Taghaeldning") == null) {
            angle = 0;
        } else {
            angle = Integer.parseInt(request.getParameter("Taghaeldning"));
        }
        int length = Integer.parseInt(request.getParameter("Carport_laengde"));
        int width = Integer.parseInt(request.getParameter("Carport_bredde"));
        int height = 2300;
        int shedLength = Integer.parseInt(request.getParameter("Redskabsrum_laengde"));
        int shedWidth = Integer.parseInt(request.getParameter("Redskabsrum_bredde"));
        String comment = request.getParameter("bemaerkninger");
        Order order = new Order(user, status, 1, angle, length, width, height, shedLength, shedWidth, comment);

        ArrayList<OrderLine> orderLineList = LogicFacade.getOrderLinelist(order);
        ArrayList<Svg> svgTopList = LogicFacade.getSvgTopList(order);
        ArrayList<Svg> svgSideList = LogicFacade.getSvgSideList(order);

        //TODO lav om til request
        session.setAttribute("order", order);
        session.setAttribute("orderLineList", orderLineList);
        session.setAttribute("svgTopList", svgTopList);
        session.setAttribute("svgSideList", svgSideList);

        return "/WEB-INF/skitse";
    }
}
