package org.missdirectory.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    @Test
    void directoryNameIsValidCharacter() {
        assertDoesNotThrow(() -> {
            // Constructor 1
            new Directory("abcABC0123@_-");
            //  Constructor 2
            new Directory("abcABC0123@_-", new Directory("test_name"));
        });
    }

    @Test
    void directoryNameIsInvalidCharacter_throwsIllegalArgumentException() {
        String[] illegalCharactersList = {"/", "\\", "<", ">", "|", "\"", "\0", "*", "?"};
        // Constructor 1
        for(String character: illegalCharactersList) {
            assertThrows(IllegalArgumentException.class, () -> {new Directory(character);});
        }
        // Constructor 2
        Directory testParent = new Directory("test_name");
        for(String character: illegalCharactersList) {
            assertThrows(IllegalArgumentException.class, () -> {new Directory(character, testParent);});
        }
    }

    @Test
    void directoryNameGetterShouldReturnGivenName() {
        Directory test_dir = new Directory("test_name");
        assertEquals("test_name", test_dir.getDirectoryName());
    }

    @Test
    void directoryParentGetterShouldReturnSameParent() {
        Directory test_parent = new Directory("parent");
        Directory test_dir = new Directory("test_name", test_parent);
        assertEquals(test_parent, test_dir.getParentDirectory());
    }

    @Test
    void defaultParentShouldBeNull() {
        Directory test_dir = new Directory("test_name");
        assertNull(test_dir.getParentDirectory());
    }

    @Test
    void directoryPathWithoutParent() {
        Directory test_dir = new Directory("test_name");
        assertEquals("test_name", test_dir.getDirectoryPath());
    }

    @Test
    void directoryPathWithParent() {
        Directory test_parent = new Directory("parent");
        Directory test_dir = new Directory("test_name", test_parent);
        assertEquals("parent/test_name", test_dir.getDirectoryPath());
        Directory test_child = new Directory("child", test_dir);
        assertEquals("parent/test_name/child", test_child.getDirectoryPath());
    }

    @Test
    void addSubdirectorySuccess() {
        Directory test_dir = new Directory("test_name");
        assertTrue(test_dir.addSubdirectory("child"));
    }
    @Test
    void addSubdirectoryFail() {
        Directory test_dir = new Directory("test_name");
        test_dir.addSubdirectory("child");
        assertFalse(test_dir.addSubdirectory("child"));
    }

    @Test
    void getExistingSubdirectory() {
        Directory test_dir = new Directory("test_name");
        test_dir.addSubdirectory("child");
        assertEquals("child", test_dir.getSubdirectory("child").getDirectoryName());
    }

    @Test
    void getNonExistingSubdirectory() {
        Directory test_dir = new Directory("test_name");
        assertNull(test_dir.getSubdirectory("child"));
    }

    @Test
    void removeExistingSubdirectory() {
        Directory test_dir = new Directory("test_name");
        test_dir.addSubdirectory("child");
        assertTrue(test_dir.removeSubdirectory("child"));
    }

    @Test
    void removeNonExistingSubdirectory() {
        Directory test_dir = new Directory("test_name");
        assertFalse(test_dir.removeSubdirectory("child"));
    }

    @Test
    void getAllSubdirectories_Empty() {
        Directory test_dir = new Directory("test_name");
        assertEquals(test_dir.getSubdirectories(), new ArrayList<Directory>());
    }

    @Test
    void getAllSubdirectories_One() {
        Directory test_dir = new Directory("test_name");
        test_dir.addSubdirectory("child");
        Directory child = test_dir.getSubdirectory("child");
        ArrayList<Directory> test_arraylist = new ArrayList<>();
        test_arraylist.add(child);
        assertEquals(test_dir.getSubdirectories(), test_arraylist);
    }
}
