package org.missdirectory;

import org.missdirectory.exceptions.ParseException;
import org.missdirectory.model.Template;
import org.missdirectory.storage.TemplateManager;

import java.util.Scanner;

public class Main {

    private static final String MD_MENU = "1. View/Modify Directory Templates" +
            "\n2. Create New Template" +
            "\n3. Generate Directory Structure" +
            "\n4. quit";
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        TemplateManager templateManager = TemplateManager.getTemplateManager();

        System.out.println(MissDirectory.AVATAR);
        System.out.println("Hello! I am MissDirectory!\n");


        String userInput;
        do {
            System.out.println("\nWhat would you like to do today?");
            System.out.println(MD_MENU);
            System.out.print("> ");
            userInput = reader.nextLine();
            switch (userInput) {
                case "1":
                    ViewMode vm = new ViewMode(templateManager);
                    vm.run(reader);
                    break;
                case "2":
                    createNewTemplate(reader, templateManager);
                    break;
                case "3":
                    new CreateMode(templateManager).run(reader);
                case "4":
                case "quit":
                    break;
                default:
                    MissDirectory.warning("Please select one of the options.");
            }
        } while (!userInput.equals("4") && !userInput.equals("quit"));


        reader.close();
        MissDirectory.speak("Good bye!");
    }

    private static void createNewTemplate(Scanner reader, TemplateManager templateManager) {
        String templateName;
        boolean notValidName = true;
        do {
            System.out.print("Template name: ");
            templateName = reader.nextLine();
            notValidName = !Template.isValidName(templateName);
            if (notValidName) {
                MissDirectory.warning("The name should be a valid file name.");
            }
        } while(notValidName);
        EditorMode em = new EditorMode(new Template(templateName));
        Template newTemplate = em.run(reader);
        if (newTemplate != null) {
            templateManager.setTemplate(newTemplate.getTemplateName(), newTemplate);
        }
    }
}
