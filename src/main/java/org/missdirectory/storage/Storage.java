package org.missdirectory.storage;

import org.missdirectory.exceptions.InvalidTemplateException;
import org.missdirectory.model.Directory;
import org.missdirectory.model.Template;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Storage {

    private static final String TEMPLATES_DIR_PATH = "templates/";
    private static void checkDirectory() {
        File templatesDirectory = new File(Storage.TEMPLATES_DIR_PATH);
        if(!templatesDirectory.exists()) {
            templatesDirectory.mkdir();
        }
    }

    public static HashMap<String, Template> loadTemplates() {
        checkDirectory();
        File templatesDirectory = new File(Storage.TEMPLATES_DIR_PATH);
        File[] allFiles = templatesDirectory.listFiles();
        HashMap<String, Template> allTemplates = new HashMap<>();
        for(File templateFile : allFiles) {
            if (!templateFile.isFile()) {
                continue;
            }
            try {
                Template template = fileToTemplate(templateFile);
                allTemplates.put(templateFile.getName(), template);
            } catch (FileNotFoundException | InvalidTemplateException | IllegalArgumentException e) {
                continue;
            }
        }
        return allTemplates;
    }

    private static Template fileToTemplate(File templateFile) throws FileNotFoundException, InvalidTemplateException,
            IllegalArgumentException {
        // Get only the last directory from each path
        Scanner scan = new Scanner(templateFile);
        if (!scan.hasNext()) {
            throw new InvalidTemplateException("Invalid File Type");
        }
        String[] directories = scan.nextLine().split("/");
        String dirOfInterest = directories[directories.length-1];
        Directory rootDirectory = new Directory(dirOfInterest);
        while (scan.hasNext()) {
            directories = scan.nextLine().split("/");
            Directory current = rootDirectory;
            for(String dir: directories) {
                if (dir.equals(rootDirectory.getDirectoryName())) {
                    continue;
                }
                current.addSubdirectory(dir);
                current = current.getSubdirectory(dir);
            }
        }
        scan.close();
        return new Template(templateFile.getName(), rootDirectory);
    }

    public static boolean saveTemplate(Template template) {
        checkDirectory();
        File templateFile = new File(Storage.TEMPLATES_DIR_PATH + template.getTemplateName());
        if (templateFile.exists()) {
            templateFile.delete();
        }
        try {
            templateFile.createNewFile();
            ArrayList<String> templatePaths = template.getTemplateInPath();
            FileWriter writer = new FileWriter(templateFile);
            for(String paths: templatePaths) {
                writer.write(paths + "\n");
            }
            writer.close();
        } catch (IOException io) {
            return false;
        }
        return true;
    }

    public static boolean deleteTemplate(String templateName) {
        checkDirectory();
        File templateFile = new File(Storage.TEMPLATES_DIR_PATH + templateName);
        if (templateFile.exists()) {
            templateFile.delete();
            return true;
        }
        return false;
    }

}
