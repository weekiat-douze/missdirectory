package org.missdirectory.parser;

import org.missdirectory.commands.*;
import org.missdirectory.exceptions.ParseException;
import org.missdirectory.viewcommands.*;

import java.util.ArrayList;

/**
 * Parser for user input.
 */
public class Parser {

    /**
     * Parse user input into the corresponding Command object.
     * @param userInput Input provided by user.
     * @return Command object representing user's intended action.
     */
    public static Command parseEditorInput(String userInput) throws ParseException {
        // cd, mkdir, rm
        String[] temp = userInput.split(" ", 2);

        String command = temp[0];
        String args = temp.length > 1 ? temp[1].trim() : null;


        switch (command) {
            case MkdirCommand.COMMAND:
                return MkdirCommandParser.parse(args);
            case ChangeDirectoryCommand.COMMAND:
                return ChangeDirectoryCommandParser.parse(args);
            case ListCommand.COMMAND:
                return ListCommandParser.parse(args);
            case RemoveCommand.COMMAND:
                return RemoveCommandParser.parse(args);
            case TreeCommand.COMMAND:
                return TreeCommandParser.parse(args);
            case HelpCommand.COMMAND:
                return new HelpCommand();
            default:
                throw new ParseException("Invalid Command!");
        }

    }

    public static ViewCommand parseViewInput(String userInput, ArrayList<String> templateListString) throws ParseException{
        String[] temp = userInput.split(" ", 2);

        String command = temp[0];
        String args = temp.length > 1 ? temp[1].trim() : null;

        switch (command) {
            case ShowViewCommand.COMMAND:
                return ShowViewCommandParser.parse(args, templateListString);
            case DeleteViewCommand.COMMAND:
                return DeleteViewCommandParser.parse(args, templateListString);
            case EditViewCommand.COMMAND:
                return EditViewCommandParser.parse(args, templateListString);
            case HelpViewCommand.COMMAND:
                return new HelpViewCommand();
            default:
                throw new ParseException("Invalid Action!");
        }
    }

}
