package org.missdirectory;

import org.missdirectory.model.Template;
import org.missdirectory.storage.TemplateManager;

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

    public void run(Scanner reader) {
        System.out.println("Select via index to modify: ");

        ArrayList<String> templateListString = this.templateManager.getTemplateList();
        String listFormatted = formatTemplateList(templateListString);
        System.out.println(listFormatted);
        String userInput = reader.nextLine();


        while(!userInput.equals("exit")) {
            try {
                int index = Integer.parseInt(userInput) - 1;
                String templateName = templateListString.get(index);
                Template selectedTemplate = this.templateManager.getTemplate(templateName);
                EditorMode em = new EditorMode(selectedTemplate);
                Template editedTemplate = em.run(reader);
                this.templateManager.setTemplate(editedTemplate.getTemplateName(), editedTemplate);
            } catch (NumberFormatException | IndexOutOfBoundsException exception) {
                System.out.println("Please enter a valid index.");
            }
            System.out.println(listFormatted);
            userInput = reader.nextLine();
        }


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
