package org.missdirectory.parser;

import org.missdirectory.commands.MkdirCommand;
import org.missdirectory.exceptions.ParseException;
import org.missdirectory.model.Directory;

import java.util.regex.Pattern;

public class MkdirCommandParser {

    public static MkdirCommand parse(String args) throws ParseException{
        if (args == null) {
            throw new ParseException("Provide a Directory Name");
        }
        boolean validName = Pattern.matches(Directory.NAME_REGEX, args);
        if (!validName) {
            throw new ParseException("Invalid Directory Name.");
        }
        return new MkdirCommand(args);
    }

}
