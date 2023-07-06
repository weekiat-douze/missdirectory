package org.missdirectory.viewcommands;

import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.model.Template;
import org.missdirectory.storage.TemplateManager;

import java.util.Scanner;

/**
 * Class represents the request to show template structure.
 */
public class ShowViewCommand extends ViewCommand {
    public static final String COMMAND = "tree";

    private String templateName;

    public ShowViewCommand(String templateName) {
        this.templateName = templateName;
    }

    @Override
    public void execute(TemplateManager templateManager, Scanner reader)
            throws ExecuteException {
        Template selectedTemplate = templateManager.getTemplate(this.templateName);
        System.out.println("\n" + selectedTemplate.getTemplateTree());
    }
}
