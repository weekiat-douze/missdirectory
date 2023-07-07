package org.missdirectory.parser;

import org.missdirectory.exceptions.ParseException;
import org.missdirectory.viewcommands.ShowViewCommand;

import java.util.ArrayList;

public class ShowViewCommandParser {
    public static ShowViewCommand parse(String args, ArrayList<String> templateListString) throws ParseException {
        try {
            int index = Integer.parseInt(args) - 1;
            String templateName = templateListString.get(index);
            return new ShowViewCommand(templateName);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new ParseException("Invalid index provided.");
        }


    }
}
