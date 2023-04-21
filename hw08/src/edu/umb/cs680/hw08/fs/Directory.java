package edu.umb.cs680.hw08.fs;

import edu.umb.cs680.hw08.fs.util.FSVisitor;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{
    // this contains all the children of the directory
    private LinkedList<FSElement> children;

    //constructor of Directory
    public Directory(Directory parent, String name,LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
        this.children = new LinkedList<>();
    }


    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for (FSElement element: children) {
            element.accept(v);
        }
    }



    @Override
    public boolean isDirectory() {
        return true;
    }




    // getter method for all children of a directory
    public LinkedList<FSElement> getChildren() {
        return children;
    }




    // method to add a new children
    public void appendChild(FSElement child) {
        this.children.add(child);
    }




    // returns a LinkedList of all the sub directories for a directory
    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDirectories = new LinkedList<>();
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).isDirectory()) {
                subDirectories.add((Directory) children.get(i));
            }
        }
        return subDirectories;
    }




    // returns a LinkedList of all the sub files for a directory
    public LinkedList<File> getSubFiles() {
        LinkedList<File> subFiles = new LinkedList<>();
        for (int i = 0; i < children.size(); i++) {
            if (!children.get(i).isDirectory()) {
                subFiles.add((File) children.get(i));
            }
        }
        return subFiles;
    }




    // returns the size of the directory which is a sum of size of subFiles and subDirectories
    public int getTotalSize() {
        LinkedList<Directory> subDirectories = this.getSubDirectories();
        LinkedList<File> subFiles = this.getSubFiles();

        int totalSize = 0;
        for (File file: subFiles) {
            totalSize += file.getSize();
        }
        for (Directory directory: subDirectories) {
            totalSize += directory.getTotalSize();
        }

        return totalSize;
    }


    
}
