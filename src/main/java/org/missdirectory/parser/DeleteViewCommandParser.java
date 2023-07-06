package org.missdirectory.parser;

import org.missdirectory.exceptions.ParseException;
import org.missdirectory.viewcommands.DeleteViewCommand;

import java.util.ArrayList;

public class DeleteViewCommandParser {

    public static DeleteViewCommand parse(String args, ArrayList<String> templateListString) throws ParseException {
        try {
            int index = Integer.parseInt(args) - 1;
            String templateName = templateListString.get(index);
            return new DeleteViewCommand(templateName);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new ParseException("Invalid index provided.");
        }


    }
}
