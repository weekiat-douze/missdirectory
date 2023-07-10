package org.missdirectory;


import org.missdirectory.model.Directory;
import org.missdirectory.model.Template;
import org.missdirectory.storage.TemplateManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Class represents the directory generating interface.
 */
public class CreateMode {
    private TemplateManager templateManager;

    public CreateMode(TemplateManager templateManager) {
        this.templateManager = templateManager;
    }

    /**
     * Start the generation interface to create the directories.
     * @param reader Scanner object to read user input.
     */
    public void run(Scanner reader) {
        Template selectedTemplate = selectTemplate(reader);
        if (selectedTemplate == null) {
            return;
        }
        TreeSet<String> dirPaths = setPlaceholder(reader, selectedTemplate);
        if (dirPaths == null) {
            return;
        }
        String destinationPath = setDestination(reader);
        if (destinationPath == null) {
            return;
        }
        generateDirectories(dirPaths, destinationPath);
    }

    private Template selectTemplate(Scanner reader) {
        ArrayList<String> templateListString = this.templateManager.getTemplateList();
        String listFormatted = formatTemplateList(templateListString);
        String prompt = "Which template should I use?";
        String userInput;
        do {
            System.out.println(prompt);
            System.out.println(listFormatted);
            System.out.print("> ");
            userInput = reader.nextLine();
            if (userInput.equals("exit")) {
                return null;
            }
            try {
                int index = Integer.parseInt(userInput) - 1;
                String templateName = templateListString.get(index);
                Template selectedTemplate = this.templateManager.getTemplate(templateName);
                System.out.println(selectedTemplate.getTemplateTree());
                return selectedTemplate;
            } catch(NumberFormatException | IndexOutOfBoundsException exception) {
                MissDirectory.warning("Enter a valid index. `exit` to return to menu.");
            }
        } while(true);
    }

    private TreeSet<String> setPlaceholder(Scanner reader, Template selectedTemplate) {
        TreeSet<String> directoryPaths = new TreeSet<>();
        String prompt = "What should root directory & placeholders(@) be called? > ";
        String userInput;
        do {
            System.out.print(prompt);
            userInput = reader.nextLine();
            if (userInput.equals("exit")) {
                return null;
            }
            boolean validName = Pattern.matches(Directory.NAME_REGEX, userInput);
            if (!validName) {
                MissDirectory.warning("Invalid directory name.");
                continue;
            }
            boolean replaceComplete = true;
            for(String dir: selectedTemplate.getTemplateInPath()) {
                String replaced = dir.replace("@", userInput);
                if (directoryPaths.contains(replaced)) {
                    MissDirectory.warning("Provided name already used for another directory.");
                    replaceComplete = false;
                    break;
                }
                directoryPaths.add(replaced);
            }
            if (replaceComplete) {
                return directoryPaths;
            }

        } while(true);
    }

    private String setDestination(Scanner reader) {
        String prompt = "Where should the folder be placed?(enter to create in current directory)\n> ";
        String userInput;
        do {
            System.out.print(prompt);
            userInput = reader.nextLine();
            if (userInput.isEmpty()) {
               userInput = ".";
            } else if (userInput.equals("exit")) {
                return null;
            }
            File destination = new File(userInput);
            if(!destination.exists()) {
                MissDirectory.warning("Provided path does not exist.");
                continue;
            }
            return userInput;
        } while(true);
    }

    private void generateDirectories(TreeSet<String> directoryPaths, String destinationPath) {
        for(String path: directoryPaths) {
            String lastChar = destinationPath.substring(destinationPath.length()-1);
            String fullPath = lastChar.equals("/") ? destinationPath + path : destinationPath + "/" + path;
            File dir = new File(fullPath);
            if (dir.exists()) {
                MissDirectory.warning("There already exist a directory of the same name in destination");
                return;
            }
            dir.mkdir();
        }
        MissDirectory.speak("Directory generation has completed :)");
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
