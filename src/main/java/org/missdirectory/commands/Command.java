package org.missdirectory.commands;

import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.model.CurrentDirectory;
import org.missdirectory.model.Template;

/**
 * Encapsulates a command containing all the relevant actions/information.
 */
public abstract class Command {

    /**
     * Executes command and returns the latest representation of current directory
     * @return Current directory
     */
    public abstract void execute(CurrentDirectory currentDirectory, Template editingTemplate) throws ExecuteException;

}
