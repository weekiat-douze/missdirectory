package org.missdirectory.model;

/**
 * A reference to the current directory.
 */
public class CurrentDirectory {
    private Directory currentDirectory;

    public CurrentDirectory(Directory currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    /**
     * Make another Directory as the current directory.
     * @param newDirectory The Directory to be used as current directory.
     */
    public void setCurrentDirectory(Directory newDirectory) {
        this.currentDirectory = newDirectory;
    }

    /**
     * Retrieves the Directory representation of the current Directory
     * @return The current directory.
     */
    public Directory getDirectory() {
        return this.currentDirectory;
    }
}
