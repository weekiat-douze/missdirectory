package org.missdirectory.parser;

import org.missdirectory.commands.MkdirCommand;

import java.util.regex.Pattern;

public class MkdirCommandParser {
    private static final String regex = "^[a-zA-Z0-9_-]+$";
    public static MkdirCommand parse(String args) {
        boolean validName = Pattern.matches(regex, args);
        if (!validName) {

        }
        return new MkdirCommand(args);
    }

}
