package org.missdirectory.commands;

import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.model.CurrentDirectory;
import org.missdirectory.model.Directory;

public class ChangeDirectoryCommand extends Command {
    public static final String COMMAND = "cd";

    private String relativePath;

    public ChangeDirectoryCommand(String relativePath) {
        this.relativePath = relativePath;
    }

    @Override
    public void execute(CurrentDirectory currentDirectory) throws ExecuteException {
        Directory curr = currentDirectory.getDirectory();
        Directory subDirectory = curr.getSubdirectory(this.relativePath);
        if (relativePath.equals("..")) {
            Directory parentDir = curr.getParentDirectory();
            currentDirectory.setCurrentDirectory(parentDir);
        }
        if (subDirectory == null) {
            throw new ExecuteException("Invalid Directory, currently cd only works for 1 directory moves");
        }
        currentDirectory.setCurrentDirectory(subDirectory);
    }

}
