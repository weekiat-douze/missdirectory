package org.missdirectory;

import org.missdirectory.model.Template;
import org.missdirectory.storage.TemplateManager;

import java.util.Scanner;

public class Main {

    private static final String MD_MENU = "1. View/Modify Directory Templates" +
            "\n2. Create New Template" +
            "\n3. Generate Directory Structure" +
            "\n4. quit\n";
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        TemplateManager templateManager = TemplateManager.getTemplateManager();

        System.out.println("Hello! I am MissDirectory!\n");

        System.out.println("What would you like to do today?");
        String userInput;
        do {
            System.out.println(MD_MENU);
            userInput = reader.nextLine();
            switch (userInput) {
                case "1":
                    ViewMode vm = new ViewMode(templateManager);
                    vm.run(reader);
                    break;
                case "2":
                    System.out.print("Template name: ");
                    String templateName = reader.nextLine();
                    EditorMode em = new EditorMode(new Template(templateName));
                    Template newTemplate = em.run(reader);
                    if (newTemplate != null) {
                        templateManager.setTemplate(newTemplate.getTemplateName(), newTemplate);
                    }
                    break;
                case "4":
                case "quit":
                    break;
                default:
                    System.out.println("Please select one of the options.");
            }
        } while (!userInput.equals("4") && !userInput.equals("quit"));


        reader.close();
        System.out.println("Good bye!");
    }
}
