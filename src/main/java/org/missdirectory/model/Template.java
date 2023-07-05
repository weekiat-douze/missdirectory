package org.missdirectory.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Represents a single template directory structure.
 */
public class Template {
    private String templateName;
    private Directory rootDirectory;
    private final char horizontal =  '\u2500';
    private final char vertical = '\u2502';
    private final char cross = '\u251C';

    private static final String FILE_NAME_REGEX = "^[^<>:\"/\\\\|?*\\x00-\\x1F]+$";

    public Template(String templateName) {
        if (!isValidName(templateName)) {
            throw new IllegalArgumentException("Template Name should be a valid file name.");
        }
        this.templateName = templateName;
        this.rootDirectory = new Directory("@");
    }

    public Template(String templateName, Directory rootDirectory) {
        if (!isValidName(templateName)) {
            throw new IllegalArgumentException("Template Name should be a valid file name.");
        }
        this.templateName = templateName;
        this.rootDirectory = rootDirectory;
    }

    /**
     * Checks if String is a valid File Name.
     * @param templateName Potential template name.
     * @return Boolean indicating whether name is valid.
     */
    public static boolean isValidName(String templateName) {
        boolean validName = Pattern.matches(FILE_NAME_REGEX, templateName);
        if (!validName) {
            return false;
        }
        return true;
    }

    /**
     * Returns the name of the Template.
     * @return Name of the Template.
     */
    public String getTemplateName() {
        return this.templateName;
    }

    /**
     * Get the root directory of the Template.
     * @return Root directory of the template.
     */
    public Directory getTemplateRootDir() {
        return this.rootDirectory;
    }

    /**
     * Builds an ASCII Tree of the Template directory structure.
     * @return String representation of the template directory structure.
     */
    public String getTemplateTree() {
        String tree = "";

        Stack<Directory> stack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        stack.push(rootDirectory);
        depth.push(-1);
        while(!stack.isEmpty()) {
            Directory currDir = stack.pop();
            String tempBranch = "";
            int currDepth = depth.pop();
            for (int i = 0; i < currDepth; i++) {
                tempBranch += "  " + vertical + "  ";
            }
            if (currDepth != -1) {
                tempBranch += "  " + cross + horizontal + " ";
            } else {
                tempBranch += "(" + templateName + ") ";
            }

            tree += tempBranch + currDir.getDirectoryName() + "/\n";

            ArrayList<Directory> subdirectories = currDir.getSubdirectories();
            for (Directory dir: subdirectories) {
                stack.push(dir);
                depth.push(currDepth+1);
            }

        }
        return tree;
    }

    /**
     * Returns a list of all directories in a list of path.
     * @return List of directories' path string.
     */
    public ArrayList<String> getTemplateInPath() {
        ArrayList<String> paths = new ArrayList<>();
        Stack<Directory> stack = new Stack<>();
        Stack<String> parent = new Stack<>();
        stack.push(this.rootDirectory);
        parent.push("");
        while(!stack.isEmpty()) {
            Directory currDir = stack.pop();
            String tempStringPath = parent.pop() + currDir.getDirectoryName() + "/";
            paths.add(tempStringPath);
            ArrayList<Directory> subdirectories = currDir.getSubdirectories();
            for (Directory dir: subdirectories) {
                stack.push(dir);
                parent.push(tempStringPath);
            }
        }
        return paths;
    }

}
