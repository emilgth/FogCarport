package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FlatRoofCheck extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "fladtTag";
        } else {
            return "/WEB-INF/fladtTagLoggedIn";
        }
    }
}
