package org.missdirectory.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TemplateTest {

    @Test
    void validTemplateName() {
        assertTrue(Template.isValidName("template-123_test"));
        assertTrue(Template.isValidName("template test")); //whitespace
    }

    @Test
    void invalidTemplateName() {
        assertFalse(Template.isValidName("template<test"));
        assertFalse(Template.isValidName("template?test"));
        assertFalse(Template.isValidName("template/test"));
        assertFalse(Template.isValidName("template*test*?/")); // multiple characters
    }

    @Test
    void constructorValidTemplateName() {
        // Constructor 1
        assertDoesNotThrow(() -> new Template("template-123_test"));
        assertDoesNotThrow(() -> new Template("template test"));
        // Constructor 2
        Directory testDir = new Directory("test_dir");
        assertDoesNotThrow(() -> new Template("template-123_test", testDir));
        assertDoesNotThrow(() -> new Template("template test", testDir));
    }

    @Test
    void getTemplateName() {
        // Constructor 1
        Template testTemplate = new Template("test_template");
        assertEquals("test_template", testTemplate.getTemplateName());

        // Constructor 2
        Directory testDir = new Directory("test_dir");
        Template testTemplateTwo = new Template("test_template", testDir);
        assertEquals("test_template", testTemplateTwo.getTemplateName());
    }

    @Test
    void getTemplateRootDirectory() {
        // Constructor 1
        Template testTemplate = new Template("test_template");
        assertEquals("@", testTemplate.getTemplateRootDir().getDirectoryName());
        // Constructor 2
        Directory testDir = new Directory("test_dir");
        Template testTemplateTwo = new Template("test_template", testDir);
        assertEquals("test_dir", testTemplateTwo.getTemplateRootDir().getDirectoryName());
    }

    @Test
    void getTemplateInPath() {
        // Constructor 1
        Template testTemplate = new Template("test_template");
        ArrayList<String> testPath = new ArrayList<>();
        testPath.add("@/");
        assertEquals(testPath, testTemplate.getTemplateInPath());
        // Constructor 2
        Directory testDir = new Directory("test_dir");
        Template testTemplateTwo = new Template("test_template", testDir);
        ArrayList<String> testPathTwo = new ArrayList<>();
        testPathTwo.add("test_dir/");
        assertEquals(testPathTwo, testTemplateTwo.getTemplateInPath());
    }
}
