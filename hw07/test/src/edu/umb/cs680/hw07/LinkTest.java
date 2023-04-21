package edu.umb.cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    public static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }

    public static String[] linkToStringArray(Link link) {
        String parentName = "null";
        if (link.parent != null) {
            parentName = link.getParent().getName();
        }
        return new String[] {parentName, link.getName(), Integer.toString(link.getSize()),
                link.getCreationTime().toString(), link.getTarget().getName()};
    }

    @Test
    public void testingLinkYusingStringArray() {
        Link y = (Link) fs.getRootDirs().get(0).getChildren().get(4);

        String[] expected = {"prjRoot", "y", String.valueOf(0), LocalDateTime.of(2023, 4, 15, 12, 30, 0).toString(), "src"};

        assertArrayEquals(expected, linkToStringArray(y));
    }

    @Test
    public void testingLinkYreturnsFalseForIsDirectory() {
        Link y = (Link) fs.getRootDirs().get(0).getChildren().get(4);

        assertTrue(!y.isDirectory());
    }

}