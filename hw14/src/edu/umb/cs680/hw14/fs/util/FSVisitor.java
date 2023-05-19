package edu.umb.cs680.hw14.fs.util;

import edu.umb.cs680.hw14.fs.Directory;
import edu.umb.cs680.hw14.fs.File;
import edu.umb.cs680.hw14.fs.Link;

public interface FSVisitor {

    public abstract void visit(Link link);

    public abstract void visit(Directory dir);

    public abstract void visit(File file);
}
