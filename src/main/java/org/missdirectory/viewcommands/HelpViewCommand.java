package org.missdirectory.viewcommands;

import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.storage.TemplateManager;

import java.util.Scanner;

public class HelpViewCommand extends ViewCommand{

    public static final String COMMAND = "help";

    public static final String HINT = "Run `help` for summary of commands";

    public static final String HELP = "Example usage:\n"
            + "`tree {index}` to see the template's tree structure\n"
            + "`delete {index}` to delete the template\n"
            + "`edit {index}` to edit a template\n"
            + "`exit` to go back to main menu";

    @Override
    public void execute(TemplateManager templateManager, Scanner reader) throws ExecuteException {
        System.out.println(HELP);
    }
}
