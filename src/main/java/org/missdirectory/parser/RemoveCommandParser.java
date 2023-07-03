package org.missdirectory.parser;

import org.missdirectory.commands.MkdirCommand;
import org.missdirectory.commands.RemoveCommand;
import org.missdirectory.exceptions.ParseException;

import java.util.regex.Pattern;

public class RemoveCommandParser {

    private static final String regex = "^[a-zA-Z0-9_-]+$";

    public static RemoveCommand parse(String args) throws ParseException {
        if (args == null) {
            throw new ParseException("Provide a Directory Name");
        }
        boolean validName = Pattern.matches(regex, args);
        if (!validName) {
            throw new ParseException("Invalid Directory Name.");
        }
        return new RemoveCommand(args);
    }
}
