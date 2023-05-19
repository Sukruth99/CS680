package edu.umb.cs680.hw12.fs.util;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.fs.Link;
import edu.umb.cs680.hw12.fs.File;

public interface FSVisitor {

    public abstract void visit(Link link);

    public abstract void visit(Directory dir);

    public abstract void visit(File file);
}
