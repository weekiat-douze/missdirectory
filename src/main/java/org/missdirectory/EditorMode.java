package org.missdirectory;

import org.missdirectory.commands.Command;
import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.exceptions.ParseException;
import org.missdirectory.model.CurrentDirectory;
import org.missdirectory.model.Template;
import org.missdirectory.parser.Parser;

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
    public Template run(Scanner reader) {
        System.out.println("Currently editing: " + this.editingTemplate.getTemplateName() + "\n");

        CurrentDirectory currentDir = new CurrentDirectory(editingTemplate.getTemplateRootDir());
        System.out.print(currentDir.getDirectoryPath());
        reader = new Scanner(System.in);
        String userCmdStr = reader.nextLine();


        while(!userCmdStr.equals("exit")) {
            try {
                Command cmd = Parser.parseInput(userCmdStr);
                cmd.execute(currentDir, editingTemplate);
            } catch (ParseException pe) {
                System.out.println(pe.getMessage());
            } catch (ExecuteException ee) {
                System.out.println(ee.getMessage());
            }
            System.out.print(currentDir.getDirectoryPath());
            userCmdStr = reader.nextLine();
        }


        return this.editingTemplate;
    }

}
