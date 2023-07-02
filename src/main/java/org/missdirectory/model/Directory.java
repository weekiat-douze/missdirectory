package org.missdirectory.model;

import java.util.HashMap;

/**
 * Represents a Directory.
 */
public class Directory {
    private String directoryName;
    private HashMap<String, Directory> subDirectories;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.subDirectories = new HashMap<>();
    }

    /**
     * Create a subdirectory of this directory.
     * @param subDirName Name of new directory.
     * @return Whether adding of subdirectory is successful.
     */
    public boolean addSubdirectory(String subDirName) {
        boolean exists = this.subDirectories.containsKey(subDirName);
        if (exists) {
            return false;
        }
        Directory newDir = new Directory(subDirName);
        this.subDirectories.put(subDirName, newDir);
        return true;
    }

    /**
     * Retrieve subdirectory with the given name.
     * @param subDirName Name of the Directory to retrieve.
     * @return The Directory to retrieve.
     */
    public Directory getSubdirectory(String subDirName) {
        return this.subDirectories.get(subDirName);
    }

}
