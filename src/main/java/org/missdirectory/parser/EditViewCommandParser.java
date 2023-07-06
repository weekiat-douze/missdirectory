package org.missdirectory.parser;

import org.missdirectory.exceptions.ParseException;
import org.missdirectory.viewcommands.DeleteViewCommand;
import org.missdirectory.viewcommands.EditViewCommand;
import org.missdirectory.viewcommands.ShowViewCommand;

import java.util.ArrayList;

public class EditViewCommandParser {
    public static EditViewCommand parse(String args, ArrayList<String> templateListString) throws ParseException {
        try {
            int index = Integer.parseInt(args) - 1;
            String templateName = templateListString.get(index);
            return new EditViewCommand(templateName);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new ParseException("Invalid index provided.");
        }


    }
}
