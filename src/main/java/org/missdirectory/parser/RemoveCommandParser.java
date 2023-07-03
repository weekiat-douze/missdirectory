package org.missdirectory.parser;

import org.missdirectory.commands.MkdirCommand;
import org.missdirectory.commands.RemoveCommand;
import org.missdirectory.exceptions.ParseException;
import org.missdirectory.model.Directory;

import java.util.regex.Pattern;

public class RemoveCommandParser {

    public static RemoveCommand parse(String args) throws ParseException {
        if (args == null) {
            throw new ParseException("Provide a Directory Name");
        }
        boolean validName = Pattern.matches(Directory.NAME_REGEX, args);
        if (!validName) {
            throw new ParseException("Invalid Directory Name.");
        }
        return new RemoveCommand(args);
    }
}
