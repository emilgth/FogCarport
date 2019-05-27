package PresentationLayer;

import FunctionLayer.Models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Checks if the user is an admin. Admins are sent to adminPage, regular users are sent to customerPage
 */
class CustomerPage extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user.isAdmin()) {
            return "/WEB-INF/adminPage";
        } else {
            return "/WEB-INF/customerPage";
        }
    }
}
