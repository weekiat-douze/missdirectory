package org.missdirectory.model;

/**
 * Represents a single template directory structure.
 */
public class Template {
    private String templateName;
    private Directory rootDirectory;

    public Template(String templateName) {
        this.templateName = templateName;
        this.rootDirectory = new Directory("{@}");
    }

    public String getTemplateName() {
        return this.templateName;
    }


}
