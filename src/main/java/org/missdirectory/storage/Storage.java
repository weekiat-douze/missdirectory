package org.missdirectory.storage;

import org.missdirectory.Main;
import org.missdirectory.exceptions.InvalidTemplateException;
import org.missdirectory.model.Directory;
import org.missdirectory.model.Template;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Storage {

    private static final String TEMPLATES_DIR_NAME = "templates/";
    private String templates_dir_path;

    public Storage() {
        String jarLocation = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String ext = jarLocation.substring(Math.max(jarLocation.length() - 4, 0));
        if (ext.equals(".jar")) {
            String directory = Paths.get(jarLocation).getParent().toString();
            this.templates_dir_path = directory + "/" +  TEMPLATES_DIR_NAME;
        } else {
            this.templates_dir_path = TEMPLATES_DIR_NAME;
        }

    }
    private void checkDirectory() {

        File templatesDirectory = new File(this.templates_dir_path);
        if(!templatesDirectory.exists()) {
            templatesDirectory.mkdir();
        }
    }

    public HashMap<String, Template> loadTemplates() {
        checkDirectory();
        File templatesDirectory = new File(this.templates_dir_path);
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

    private Template fileToTemplate(File templateFile) throws FileNotFoundException, InvalidTemplateException,
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
            boolean isRoot = true;
            for(String dir: directories) {
                if (dir.equals(rootDirectory.getDirectoryName()) && isRoot) {
                    isRoot = false;
                    continue;
                }
                current.addSubdirectory(dir);
                current = current.getSubdirectory(dir);
            }
        }
        scan.close();
        return new Template(templateFile.getName(), rootDirectory);
    }

    public boolean saveTemplate(Template template) {
        checkDirectory();
        File templateFile = new File(this.templates_dir_path + template.getTemplateName());
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

    public boolean deleteTemplate(String templateName) {
        checkDirectory();
        File templateFile = new File(this.templates_dir_path + templateName);
        if (templateFile.exists()) {
            templateFile.delete();
            return true;
        }
        return false;
    }

}
