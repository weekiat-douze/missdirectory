package org.missdirectory.parser;

import org.missdirectory.commands.MkdirCommand;

/**
 * Parser for user input.
 */
public class Parser {

    /**
     * Parse user input into the corresponding Command object.
     * @param userInput Input provided by user.
     * @return Command object representing user's intended action.
     */
    public static void parseInput(String userInput) {
        // cd, mkdir, rm
        String[] temp = userInput.split(" ", 2);
        String command = temp[0];
        String args = temp[1];

        switch (command) {
            case MkdirCommand.COMMAND:
                break;
        }

    }
}
