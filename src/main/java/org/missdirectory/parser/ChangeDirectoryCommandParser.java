package org.missdirectory.parser;

import org.missdirectory.commands.ChangeDirectoryCommand;
import org.missdirectory.exceptions.ParseException;

import java.util.regex.Pattern;

public class ChangeDirectoryCommandParser {
    private static final String regex = "^[a-zA-Z0-9_-]+$";
    public static ChangeDirectoryCommand parse(String args) throws ParseException {
        boolean validName = Pattern.matches(regex, args);
        if (!validName) {
            throw new ParseException("Invalid Directory Name, currently MissDirectory can only cd 1 step");
        }
        return new ChangeDirectoryCommand(args);
    }
}
