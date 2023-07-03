package org.missdirectory.model;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Represents a single template directory structure.
 */
public class Template {
    private String templateName;
    private Directory rootDirectory;

    private char horizontal =  '\u2500';
    private char vertical = '\u2502';
    private char cross = '\u251C';

    public Template(String templateName) {
        this.templateName = templateName;
        this.rootDirectory = new Directory("@");
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

}
