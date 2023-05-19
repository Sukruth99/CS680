package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.Link;

/**
 A class that implements the FSVisitor interface and counts the number of directories, files, and links in a file system.
 */
public class CountingVisitor implements FSVisitor{
    private int directoryCount; // number of directories
    private int fileCount; // number of files
    private int linkCount; // number of links
    /**
     Creates a CountingVisitor object and initializes the counts to zero.
     */
    public CountingVisitor() {
        this.directoryCount = 0;
        this.fileCount = 0;
        this.linkCount = 0;
    }
    /**
     Increments the link count.
     @param link the link to be visited
     */
    @Override
    public void visit(Link link) {
        linkCount++;
    }
    /**
     Increments the directory count.
     @param dir the directory to be visited
     */
    @Override
    public void visit(Directory dir) {
        directoryCount++;
    }
    /**
     Increments the file count.
     @param file the file to be visited
     */
    @Override
    public void visit(File file) {
        fileCount++;
    }
    /**
     Returns the number of directories counted.
     @return the number of directories
     */
    public int getDirectoryCount() {
        return directoryCount;
    }
    /**
     Returns the number of files counted.
     @return the number of files
     */
    public int getFileCount() {
        return fileCount;
    }
    /**
     Returns the number of links counted.
     @return the number of links
     */
    public int getLinkCount() {
        return linkCount;
    }
}
