package org.missdirectory.commands;

import com.sun.source.tree.LiteralTree;
import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.model.CurrentDirectory;
import org.missdirectory.model.Directory;

import java.util.ArrayList;

public class ListCommand extends Command {
    public static final String COMMAND = "ls";
    public ListCommand() {

    }

    @Override
    public void execute(CurrentDirectory currentDirectory) throws ExecuteException {
        Directory curr = currentDirectory.getDirectory();
        ArrayList<Directory> subdir = curr.getSubdirectories();
        String dirNameList = "";
        for (Directory dir: subdir) {
            dirNameList += "\n" + dir.getDirectoryName();
        }
        System.out.println(dirNameList);
    }
}
