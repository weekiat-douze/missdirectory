package org.missdirectory;

import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.exceptions.ParseException;
import org.missdirectory.model.Template;
import org.missdirectory.parser.Parser;
import org.missdirectory.storage.TemplateManager;
import org.missdirectory.viewcommands.HelpViewCommand;
import org.missdirectory.viewcommands.ViewCommand;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class represents the directory template viewing interface.
 */
public class ViewMode {
    private TemplateManager templateManager;
    public ViewMode(TemplateManager templateManager) {
        this.templateManager = templateManager;
    }

    /**
     * Start the view interface to edit/view/delete templates.
     * @param reader Scanner object to read user input.
     */
    public void run(Scanner reader) {

        String userInput;
        do {
            System.out.println("\n[edit | delete | tree] {index}");
            ArrayList<String> templateListString = this.templateManager.getTemplateList();
            String listFormatted = formatTemplateList(templateListString);
            System.out.println(listFormatted);
            userInput = reader.nextLine();
            if (userInput.equals("exit")) {
                break;
            }
            try {
                ViewCommand command = Parser.parseViewInput(userInput, templateListString);
                command.execute(this.templateManager, reader);
            } catch (ParseException | ExecuteException exception) {
               MissDirectory.warning(exception.getMessage() + " " + HelpViewCommand.HINT);
            }

        } while(!userInput.equals("exit"));



    }

    private String formatTemplateList(ArrayList<String> templateListString) {
        String formattedString = "";
        for (int i = 0; i < templateListString.size(); i++) {
            formattedString += i+1 + ". " + templateListString.get(i);
            if (i+1 != templateListString.size()) {
                formattedString += "\n";
            }
        }
        return formattedString;
    }

}
