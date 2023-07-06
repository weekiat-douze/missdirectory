package org.missdirectory.storage;

import org.missdirectory.model.Template;

import java.util.ArrayList;
import java.util.HashMap;

public class TemplateManager {
 // Template Manger contains `Storage`
    private HashMap<String, Template> allTemplates;
    private Storage storage;
    private static TemplateManager templateManager;

    private TemplateManager() {
        // Call Storage method to get populate all templates
        this.storage = new Storage();
        this.allTemplates = this.storage.loadTemplates();
    }

    public static TemplateManager getTemplateManager() {
        if (templateManager == null) {
            templateManager = new TemplateManager();
        }
        return templateManager;
    }

    public ArrayList<String> getTemplateList() {
        return new ArrayList<>(this.allTemplates.keySet());
    }

    public Template getTemplate(String templateName) {
        return this.allTemplates.get(templateName);
    }

    public void setTemplate(String templateName, Template template) {
        // Call Storage method to store template to persistent
        boolean success = storage.saveTemplate(template);
        if (success) {
            this.allTemplates.put(templateName, template);
        }
    }

    public void deleteTemplate(String templateName) {
        // Call Storage method to delete template file
        if (!this.allTemplates.containsKey(templateName)) {
            return;
        }
        boolean success = storage.deleteTemplate(templateName);
        if (success) {
            this.allTemplates.remove(templateName);
        }
    }

}
