package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.Models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerPage extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user.isAdmin()) {
            return "/WEB-INF/adminPage";
        } else {
            return "/WEB-INF/customerPage";
        }
    }
}
