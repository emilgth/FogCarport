package PresentationLayer;

import FunctionLayer.FogException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * checks if user is logged in and sends them to appropriate index page
 */
class LoggedInIndex extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "index";
        } else {
            return "/WEB-INF/loggedInIndex";
        }
    }
}
