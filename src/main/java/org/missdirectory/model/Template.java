package org.missdirectory.model;

/**
 * Represents a single template directory structure.
 */
public class Template {
    private String templateName;
    private Directory rootDirectory;

    public Template(String templateName) {
        this.templateName = templateName;
        this.rootDirectory = new Directory("@");
    }

    /**
     * Returns the name of the Template.
     * @return Name of the Tempalte.
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


}
