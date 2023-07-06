package org.missdirectory.viewcommands;

import org.missdirectory.EditorMode;
import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.model.Template;
import org.missdirectory.storage.TemplateManager;

import java.util.Scanner;

/**
 * Class represents the request to edit template structure.
 */
public class EditViewCommand extends ViewCommand {
    public static final String COMMAND = "edit";
    private String templateName;

    public EditViewCommand(String templateName) {
        this.templateName = templateName;
    }


    @Override
    public void execute(TemplateManager templateManager, Scanner reader)
            throws ExecuteException {
        Template selectedTemplate = templateManager.getTemplate(this.templateName);
        EditorMode em = new EditorMode(selectedTemplate);
        Template editedTemplate = em.run(reader);
        templateManager.setTemplate(editedTemplate.getTemplateName(), editedTemplate);
    }
}
