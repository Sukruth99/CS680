package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.*;
import edu.umb.cs680.hw08.fs.util.CountingVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingVisitorTest {

    public static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }

    // running counting visitor on src directory

    @Test
    public void srcTest() {
        Directory src = (Directory)fs.getRootDirs().get(0).getChildren().get(0);
        CountingVisitor v = new CountingVisitor();
        src.accept(v);
        assertEquals(2, v.getFileCount());
        assertEquals(1, v.getDirectoryCount());
        assertEquals(0, v.getLinkCount());
    }



}