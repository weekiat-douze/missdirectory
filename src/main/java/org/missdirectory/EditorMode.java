package org.missdirectory;

import org.missdirectory.model.CurrentDirectory;
import org.missdirectory.model.Template;

import java.util.Scanner;

/**
 * Class represents the directory template editing interface.
 */
public class EditorMode {
    private Template editingTemplate;

    public EditorMode(Template editingTemplate) {
        this.editingTemplate = editingTemplate;
    }

    /**
     * Start the editing interface to edit the provided Template.
     * @return The completed template.
     */
    public Template run() {
        System.out.println("Currently editing: " + this.editingTemplate.getTemplateName() + "\n");

        Scanner reader = new Scanner(System.in);
        String userCmdStr = reader.next();
        CurrentDirectory currentDir = new CurrentDirectory(editingTemplate.getTemplateRootDir());

        while(!userCmdStr.equals("exit")) {

        }


        return this.editingTemplate;
    }

}
