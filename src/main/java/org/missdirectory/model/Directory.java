package org.missdirectory.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a Directory.
 */
public class Directory {
    private String directoryName;
    private Directory parentDirectory;
    private HashMap<String, Directory> subDirectories;
    public static final String NAME_REGEX = "^[a-zA-Z0-9@_-]+$";

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.parentDirectory = null;
        this.subDirectories = new HashMap<>();
    }

    public Directory(String directoryName, Directory parentDirectory) {
        this.directoryName = directoryName;
        this.parentDirectory = parentDirectory;
        this.subDirectories = new HashMap<>();
    }

    /**
     * Returns the name of this Directory.
     * @return String name of this Directory.
     */
    public String getDirectoryName() {
        return this.directoryName;
    }

    /**
     * Returns the parent Directory.
     * @return Parent Directory
     */
    public Directory getParentDirectory() {
        return this.parentDirectory;
    }

    public String getDirectoryPath() {
        String parentPath = this.parentDirectory != null ? this.parentDirectory.getDirectoryPath() + "/" : "";
        return parentPath + this.directoryName;
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
        Directory newDir = new Directory(subDirName, this);
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

    public boolean removeSubdirectory(String subDirName) {
        boolean exists = this.subDirectories.containsKey(subDirName);
        if (!exists) {
            return false;
        }
        this.subDirectories.remove(subDirName);
        return true;
    }

    /**
     * Retrieve all subdirectories of current directory.
     * @return Array list of subdirectories.
     */
    public ArrayList<Directory> getSubdirectories() {
        return new ArrayList<Directory>(this.subDirectories.values());
    }

}
