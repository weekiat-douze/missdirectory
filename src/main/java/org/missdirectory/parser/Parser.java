package org.missdirectory.parser;

import org.missdirectory.commands.*;
import org.missdirectory.exceptions.ParseException;

/**
 * Parser for user input.
 */
public class Parser {

    /**
     * Parse user input into the corresponding Command object.
     * @param userInput Input provided by user.
     * @return Command object representing user's intended action.
     */
    public static Command parseInput(String userInput) throws ParseException {
        // cd, mkdir, rm
        String[] temp = userInput.split(" ", 2);

        String command = temp[0];
        String args = temp.length > 1 ? temp[1] : null;


        switch (command) {
            case MkdirCommand.COMMAND:
                return MkdirCommandParser.parse(args);
            case ChangeDirectoryCommand.COMMAND:
                return ChangeDirectoryCommandParser.parse(args);
            case ListCommand.COMMAND:
                return ListCommandParser.parse(args);
            case RemoveCommand.COMMAND:
                return RemoveCommandParser.parse(args);
            default:
                throw new ParseException("Invalid Command!");
        }

    }
}
