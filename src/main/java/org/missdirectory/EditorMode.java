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
     * @param reader Scanner object to read user input
     * @return The completed template.
     */
    public Template run(Scanner reader) {

        System.out.println("Currently editing: " + this.editingTemplate.getTemplateName());
        MissDirectory.warning("Note that template is only saved during `exit`");
        CurrentDirectory currentDir = new CurrentDirectory(this.editingTemplate.getTemplateRootDir());
        String userCmdStr;

        do {
            System.out.print(currentDir.getDirectoryPath());
            userCmdStr = reader.nextLine();
            if (userCmdStr.equals("exit")) {
                break;
            }
            try {
                Command cmd = Parser.parseEditorInput(userCmdStr);
                cmd.execute(currentDir, this.editingTemplate);
            } catch (ParseException | ExecuteException exception) {
                MissDirectory.warning(exception.getMessage());
            }
        } while(!userCmdStr.equals("exit"));


        return this.editingTemplate;
    }

}
