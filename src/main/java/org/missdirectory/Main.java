package org.missdirectory;

import org.missdirectory.model.Template;
import org.missdirectory.storage.TemplateManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        TemplateManager templateManager = TemplateManager.getTemplateManager();

        System.out.println("Hello! I am MissDirectory!\n");
        String mdMenu = "\n1. View/Modify Directory Templates" +
                "\n2. Create New Template" +
                "\n3. Generate Directory Structure" +
                "\n4. quit\n";
        System.out.println("What would you like to do today?" + mdMenu);

        String userInput = reader.nextLine();
        while(!userInput.equals("4") && !userInput.equals("quit")) {
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
                default:
                    System.out.println("Please select one of the options.");
            }
            System.out.println(mdMenu);
            userInput = reader.nextLine();
        }

        reader.close();
        System.out.println("Good bye!");
    }
}
