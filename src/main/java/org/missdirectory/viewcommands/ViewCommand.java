package org.missdirectory.viewcommands;

import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.storage.TemplateManager;

import java.util.Scanner;

/**
 * Encapsulates a ViewMode command containing all the relevant actions/information.
 */
public abstract class ViewCommand {

    public abstract void execute(TemplateManager templateManager, Scanner reader)
            throws ExecuteException;

}
