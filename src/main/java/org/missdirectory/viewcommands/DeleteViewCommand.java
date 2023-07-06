package org.missdirectory.viewcommands;


import org.missdirectory.MissDirectory;
import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.storage.TemplateManager;

import java.util.Scanner;

/**
 * Class represents the request to delete template structure.
 */
public class DeleteViewCommand extends ViewCommand {
    public static final String COMMAND = "delete";

    private String templateName;

    public DeleteViewCommand(String templateName) {
        this.templateName = templateName;
    }

    @Override
    public void execute(TemplateManager templateManager, Scanner reader)
            throws ExecuteException {
        templateManager.deleteTemplate(this.templateName);
        MissDirectory.speak("Deleted " + this.templateName);
    }
}
