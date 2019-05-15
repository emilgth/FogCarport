package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String surname = request.getParameter("surname");
        String lastname = request.getParameter("lastname");
        int phone = Integer.parseInt(request.getParameter("phone"));

        {
            User user = LogicFacade.createUser(email, password, surname, lastname, phone);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.isAdmin());
            return "loggedInIndex";
        //} else {
         //   throw new LoginSampleException("the two passwords did not match");
        }
    }
}


