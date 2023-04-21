package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public abstract class FSElement {

    protected String name;
    protected Directory parent;
    protected Integer size;
    protected LocalDateTime creationTime;

    // constructor for fs element
    public FSElement(Directory parent, String name, Integer size, LocalDateTime creationTime) {
        this.name = name;
        this.parent = parent;
        this.creationTime = creationTime;
        this.size = size;
    }

    // checking is FS element is a directory or not
    public abstract boolean isDirectory();

    // getter method for parent
    public Directory getParent() {
        return parent;
    }

    // getter method for LocalDateTime
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    // getter method for name
    public String getName() {
        return name;
    }

    // getter method for size
    public Integer getSize() {
        return size;
    }

}

