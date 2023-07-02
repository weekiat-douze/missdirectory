package org.missdirectory.parser;

import org.missdirectory.commands.Command;
import org.missdirectory.commands.MkdirCommand;
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
        String args = temp[1];

        switch (command) {
            case MkdirCommand.COMMAND:
                return MkdirCommandParser.parse(args);
                break;
        }

    }
}
