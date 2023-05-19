package edu.umb.cs680.hw14.fs.util;

import edu.umb.cs680.hw14.fs.Directory;
import edu.umb.cs680.hw14.fs.File;
import edu.umb.cs680.hw14.fs.Link;

import java.util.LinkedList;

public class FileSearchVisitor implements FSVisitor {

    private String targetFileName;

    private LinkedList<File> foundFiles;

    public FileSearchVisitor(String targetFileName) {
        this.targetFileName = targetFileName;
        this.foundFiles = new LinkedList<>();
    }

    @Override
    public void visit(Link link) {
        // do nothing for a link
        return;
    }

    @Override
    public void visit(Directory dir) {
        // do nothing for a directory
        return;
    }

    @Override
    public void visit(File file) {
        // if the current file matches the target file name, add it to the list of found files
        if (file.getName().equals(this.targetFileName)) {
            foundFiles.add(file);
        }
    }

    public LinkedList<File> getFoundFiles() {
        return foundFiles;
    }

    public String getTargetFileName() {
        return targetFileName;
    }
}
