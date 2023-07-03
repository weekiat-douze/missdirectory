package org.missdirectory.parser;

import org.missdirectory.commands.ListCommand;
import org.missdirectory.exceptions.ParseException;

public class ListCommandParser {
    public static ListCommand parse(String args) throws ParseException {

        if (args != null && !args.isEmpty()) {
            throw new ParseException("ls currently does not take any arguments.");
        }
        return new ListCommand();
    }
}
