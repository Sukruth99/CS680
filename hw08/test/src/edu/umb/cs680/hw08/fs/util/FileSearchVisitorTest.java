package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.*;
import edu.umb.cs680.hw08.fs.util.FileSearchVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSearchVisitorTest {

    public static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }


    // runs File Search Visitor on src directory
    // which should return an empty linked List
    @Test
    public void srcTest() {
        Directory src = (Directory)fs.getRootDirs().get(0).getChildren().get(0);
        FileSearchVisitor v = new FileSearchVisitor("x");
        src.accept(v);
        assertEquals(0, v.getFoundFiles().size());
    }

}