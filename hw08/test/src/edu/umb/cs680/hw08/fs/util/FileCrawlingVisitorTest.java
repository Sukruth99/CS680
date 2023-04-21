package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.*;
import edu.umb.cs680.hw08.fs.util.FileCrawlingVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileCrawlingVisitorTest {

    public static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }


    // runs File Crawling Visitor on src directory
    // which should return a linked List of Files a, b
    @Test
    public void srcTest() {
        Directory src = (Directory)fs.getRootDirs().get(0).getChildren().get(0);
        FileCrawlingVisitor v = new FileCrawlingVisitor();
        src.accept(v);
        assertEquals(2, v.getFiles().size());
        assertIterableEquals(src.getSubFiles(), v.getFiles());
    }

}