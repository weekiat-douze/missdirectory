package org.missdirectory.parser;

import org.missdirectory.commands.ChangeDirectoryCommand;
import org.missdirectory.exceptions.ParseException;
import org.missdirectory.model.Directory;

import java.util.regex.Pattern;

public class ChangeDirectoryCommandParser {
    public static ChangeDirectoryCommand parse(String args) throws ParseException {
        if (args == null) {
            throw new ParseException("Provide a Directory Name");
        }
        boolean validName = Pattern.matches(Directory.NAME_REGEX, args);
        if (!validName && !args.equals("..")) {
            throw new ParseException("Invalid Directory Name, currently MissDirectory can only cd 1 step");
        }
        return new ChangeDirectoryCommand(args);
    }
}
