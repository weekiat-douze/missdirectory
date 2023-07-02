package org.missdirectory.commands;

import org.missdirectory.model.CurrentDirectory;

/**
 * Encapsulates a command containing all the relevant actions/information.
 */
public abstract class Command {

    /**
     * Executes command and returns the latest representation of current directory
     * @return Current directory
     */
    public abstract void execute(CurrentDirectory currentDirectory);

}
