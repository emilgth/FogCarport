package PresentationLayer;

import FunctionLayer.FogException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FlatRoofCheck extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "fladtTag";
        } else {
            return "/WEB-INF/fladtTagLoggedIn";
        }
    }
}
