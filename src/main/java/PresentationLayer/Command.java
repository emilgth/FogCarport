package PresentationLayer;

import FunctionLayer.FogException;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command factory
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("customerOrderRequest", new Success());
        commands.put("customerOrder", new CustomerOrder());
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("showCustomerOrder", new ShowCustomerOrder());
        commands.put("updateUserData", new UpdateUserData());
        commands.put("showAdminOrders", new ShowAdminOrders());
        commands.put("customerPage", new CustomerPage());
        commands.put("loggedInIndex", new LoggedInIndex());
        commands.put("showNewOrders", new ShowOrdersByStatus());
        commands.put("adminShowSingleOrder", new AdminShowSingleOrder());
        commands.put("confirmOrder", new ConfirmOrder());
        commands.put("flatRoofCheck", new FlatRoofCheck());
        commands.put("withRoofCheck", new WithRoofCheck());
        commands.put("logOut", new LogOut());
        commands.put("showOrdersByStatus", new ShowOrdersByStatus());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws FogException;
}
