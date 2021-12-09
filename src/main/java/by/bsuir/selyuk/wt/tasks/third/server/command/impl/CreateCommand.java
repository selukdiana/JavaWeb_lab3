package by.bsuir.selyuk.wt.tasks.third.server.command.impl;

import by.bsuir.selyuk.wt.tasks.third.server.command.Command;
import by.bsuir.selyuk.wt.tasks.third.server.command.exception.CommandException;
import by.bsuir.selyuk.wt.tasks.third.server.model.AuthType;
import by.bsuir.selyuk.wt.tasks.third.server.service.ServiceFactory;

public class CreateCommand implements Command {
    public String complete(Object caller, String request) throws CommandException {
        String[] arguments = request.split(" ");
        if (arguments.length != 3) throw new CommandException("CREATE invalid syntax");

        if (ServiceFactory.getInstance().getAuthService().getAuthType(caller) != AuthType.MANAGER)
            return "Should be MANAGER";

        ServiceFactory.getInstance().getCaseService().addCase(arguments[1], arguments[2]);
        return "Success";
    }
}
