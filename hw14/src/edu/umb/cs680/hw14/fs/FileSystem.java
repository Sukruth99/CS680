package edu.umb.cs680.hw14.fs;

import java.util.LinkedList;

public class FileSystem {

    private LinkedList<Directory> rootDirs;

    // FileSystem singleton object
    private static final FileSystem fs = new FileSystem();

    // private constructor method
    private FileSystem() {
        rootDirs = new LinkedList<>();
    }

    public static FileSystem getFileSystem() {
        return fs;
    }

    // getter method for root directories
    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }

    // adding new root directories
    public void appendRootDir(Directory root) {
        this.rootDirs.add(root);
    }

    public int countRootDir() {
        return this.getRootDirs().size();
    }

    public void clearRootDir() {
        this.rootDirs.clear();
    }

}
