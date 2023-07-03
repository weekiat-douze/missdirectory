package org.missdirectory.parser;

import org.missdirectory.commands.TreeCommand;
import org.missdirectory.exceptions.ParseException;

public class TreeCommandParser {
    public static TreeCommand parse(String args) throws ParseException {

        if (args != null && !args.isEmpty()) {
            throw new ParseException("tree currently does not take any arguments.");
        }
        return new TreeCommand();
    }
}
