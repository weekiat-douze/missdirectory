package org.missdirectory.viewcommands;

import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.storage.TemplateManager;

import java.util.Scanner;

public class HelpViewCommand extends ViewCommand{

    public static final String COMMAND = "help";

    public static final String HINT = "Run `help` for summary of commands";

    public static final String HELP = "Example usage:\n"
            + "  `tree INDEX` — see the template's tree structure\n"
            + "  `delete INDEX` — delete the template\n"
            + "  `edit INDEX` — edit a template\n"
            + "  `exit` — go back to main menu\n"
            + "\nvisit https://github.com/weekiat-douze/missdirectory for more info";

    @Override
    public void execute(TemplateManager templateManager, Scanner reader) throws ExecuteException {
        System.out.println(HelpViewCommand.HELP);
    }
}
