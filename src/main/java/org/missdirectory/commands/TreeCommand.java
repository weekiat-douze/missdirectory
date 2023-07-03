package org.missdirectory.commands;

import org.missdirectory.exceptions.ExecuteException;
import org.missdirectory.model.CurrentDirectory;
import org.missdirectory.model.Template;

import java.io.PrintWriter;

public class TreeCommand extends Command {
    public static final String COMMAND = "tree";
    @Override
    public void execute(CurrentDirectory currentDirectory, Template editingTemplate) throws ExecuteException {
        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println(editingTemplate.getTemplateTree());
    }
}
