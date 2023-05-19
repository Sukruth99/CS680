package edu.umb.cs680.hw14.fs;

import edu.umb.cs680.hw14.fs.util.FSVisitor;

import java.time.LocalDateTime;

public class Link extends FSElement {

    private FSElement target;

    public Link(Directory parent, String name, LocalDateTime creationTime, FSElement target) {
        super(parent, name, 0, creationTime);
        this.target = target;
    }


    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
    }

    // getter methods
    public FSElement getTarget() {
        return target;
    }


    // returns false, as it's not a directory
    @Override
    public boolean isDirectory() {
        return false;
    }


}
