package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Login method
 */
class Login extends Command {

    /**
     * @param request servlet request
     * @param response servlet response
     * @return jsp address
     * @throws FogException see FogException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LogicFacade.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        if (user.isAdmin()) {
            return "/WEB-INF/adminPage";
        } else {
            return "/WEB-INF/loggedInIndex";
        }
    }


}
