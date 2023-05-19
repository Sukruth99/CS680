package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.Link;

import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor{

    // List to store files
    private LinkedList<File> fileList;

    // Constructor to initialize file list
    public FileCrawlingVisitor() {
        fileList = new LinkedList<>();
    }

    // Ignore links during file crawling
    @Override
    public void visit(Link link) {
        return;
    }

    // Ignore directories during file crawling
    @Override
    public void visit(Directory dir) {
        return;
    }

    // Add files to the list during file crawling
    @Override
    public void visit(File file) {
        fileList.add(file);
    }

    // Return the list of files
    public LinkedList<File> getFiles() {
        return fileList;
    }
}
