package org.missdirectory.commands;

import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.model.CurrentDirectory;
import org.missdirectory.model.Directory;

public class RemoveCommand extends Command {
    public static final String COMMAND = "rm";

    private String delDirectoryName;

    public RemoveCommand(String delDirectoryName) {
        this.delDirectoryName = delDirectoryName;
    }

    @Override
    public void execute(CurrentDirectory currentDirectory) throws ExecuteException {
        Directory curr = currentDirectory.getDirectory();
        boolean success = curr.removeSubdirectory(this.delDirectoryName);
        if (!success) {
            throw new ExecuteException("Specified Subdirectory does not exist");
        }
    }
}
