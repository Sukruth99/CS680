package edu.umb.cs680.hw12.fs;

import edu.umb.cs680.hw12.fs.util.FSVisitor;

import java.time.LocalDateTime;

public class File extends FSElement{

    public File(Directory parent, String name, Integer size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }


    // getter methods
    @Override
    public Directory getParent() {
        return super.getParent();
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
    }

    @Override
    public Integer getSize() {
        return super.getSize();
    }

    @Override
    public LocalDateTime getCreationTime() {
        return super.getCreationTime();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    // returns false, as it's not a directory
    @Override
    public boolean isDirectory() {
        return false;
    }
}
