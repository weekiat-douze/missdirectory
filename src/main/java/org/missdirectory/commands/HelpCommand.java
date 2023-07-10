package org.missdirectory.commands;

import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.model.CurrentDirectory;
import org.missdirectory.model.Template;

public class HelpCommand extends Command{
    public static final String COMMAND = "help";

    public static final String HINT = "Run `help` for summary of commands";

    public static final String HELP = "Example usage:\n"
            + "  `ls` — see the directories in current directory\n"
            + "  `tree` — see the template's structure in tree form\n"
            + "  `mkdir NAME` — create a directory in current directory\n"
            + "  `cd [SUBDIRECTORY | .. ]` — change directory to sub, parent, or root directory\n"
            + "  `rm SUBDIRECTORY` — delete a subdirectory of current directory\n"
            + "  `exit` — save and exit template editor\n"
            + "\nvisit https://github.com/weekiat-douze/missdirectory for more info";

    @Override
    public void execute(CurrentDirectory currentDirectory, Template editingTemplate) throws ExecuteException {
        System.out.println(HelpCommand.HELP);
    }
}
