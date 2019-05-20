package PresentationLayer;

import FunctionLayer.FogException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Logout method. Sends user back to index after invalidating session.
 */
class LogOut extends Command {
    /**
     * @param request servlet request
     * @param response servlet response
     * @return jsp address
     * @throws FogException see FogException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        session.invalidate();
        return "index";
    }
}
