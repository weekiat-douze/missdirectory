package org.missdirectory.parser;

import org.missdirectory.commands.MkdirCommand;
import org.missdirectory.exceptions.ParseException;

import java.util.regex.Pattern;

public class MkdirCommandParser {
    private static final String regex = "^[a-zA-Z0-9_-]+$";
    public static MkdirCommand parse(String args) throws ParseException{
        boolean validName = Pattern.matches(regex, args);
        if (!validName) {
            throw new ParseException("Invalid Directory Name.");
        }
        return new MkdirCommand(args);
    }

}
