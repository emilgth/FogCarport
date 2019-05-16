package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.Models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateUserData extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setEmail(request.getParameter("email"));
        user.setSurname(request.getParameter("surname"));
        user.setLastname(request.getParameter("lastname"));
        user.setPhone(Integer.parseInt(request.getParameter("phone")));
        user.setPassword(request.getParameter("password"));
        FunctionLayer.LogicFacade.updateUserData(user);
        session.setAttribute("user", user);
        return "loggedInIndex";
    }

}
