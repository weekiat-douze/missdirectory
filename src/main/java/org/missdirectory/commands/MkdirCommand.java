package org.missdirectory.commands;

import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.model.CurrentDirectory;
import org.missdirectory.model.Directory;

/**
 * Class represents the request to create a directory.
 */
public class MkdirCommand extends Command{
    public static final String COMMAND = "mkdir";

    private String newDirectoryName;

    public MkdirCommand(String newDirectoryName) {
        this.newDirectoryName = newDirectoryName;
    }

    @Override
    public void execute(CurrentDirectory currentDirectory) throws ExecuteException{
        Directory curr = currentDirectory.getDirectory();
        boolean success = curr.addSubdirectory(this.newDirectoryName);
        if (!success) {
            throw new ExecuteException("The directory with that name already exists.");
        }
    }
}
