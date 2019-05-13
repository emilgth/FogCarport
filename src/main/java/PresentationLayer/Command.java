package PresentationLayer;

import FunctionLayer.LoginSampleException;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("builder", new Builder());
        commands.put("customerOrder", new CustomerOrderFlatRoof());
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("showCustomerOrder", new ShowCustomerOrder());

    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException;
}
