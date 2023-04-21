package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    public static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }

    public static String[] fileToStringArray(File file) {
        String parentName = "null";
        if (file.parent != null) {
            parentName = file.getParent().getName();
        }
        return new String[] {parentName, file.getName(), Integer.toString(file.getSize()),
                file.getCreationTime().toString()};
    }

    @Test
    public void fileXEquality() {
        File file = (File) fs.getRootDirs().get(0).getChildren().get(3);
        LocalDateTime date = LocalDateTime.of(2023, 4, 15, 12, 30, 0);
        String[] expected = {"prjRoot", "x", String.valueOf(10), date.toString()};
        assertArrayEquals(expected, fileToStringArray(file));
    }

    @Test
    public void fileAEquality() {
        Directory src = (Directory) fs.getRootDirs().get(0).getChildren().get(0);
        File file = (File) src.getChildren().get(0);
        LocalDateTime date = LocalDateTime.of(2023, 4, 15, 12, 30, 0);
        String[] expected = {"src", "a", String.valueOf(20), date.toString()};
        assertArrayEquals(expected, fileToStringArray(file));
    }

    @Test
    public void fileBEquality() {
        Directory src = (Directory) fs.getRootDirs().get(0).getChildren().get(0);
        File file = (File) src.getChildren().get(1);
        LocalDateTime date = LocalDateTime.of(2023, 4, 15, 12, 30, 0);
        String[] expected = {"src", "b", String.valueOf(20), date.toString()};
        assertArrayEquals(expected, fileToStringArray(file));
    }



    @Test
    public void fileCEquality() {
        Directory lib = (Directory) fs.getRootDirs().get(0).getChildren().get(1);
        File file = (File) lib.getChildren().get(0);
        LocalDateTime date = LocalDateTime.of(2023, 4, 15, 12, 30, 0);
        String[] expected = {"lib", "c", String.valueOf(20), date.toString()};
        assertArrayEquals(expected, fileToStringArray(file));
    }

    @Test
    public void fileDEquality() {
        Directory test = (Directory) fs.getRootDirs().get(0).getChildren().get(2);
        Directory src = (Directory) test.getChildren().get(0);
        File file = (File) src.getChildren().get(0);
        LocalDateTime date = LocalDateTime.of(2023, 4, 15, 12, 30, 0);
        String[] expected = {"src", "d", String.valueOf(30), date.toString()};
        assertArrayEquals(expected, fileToStringArray(file));
    }

    @Test
    public void TestingifFileXgivesFalseForIsDirectory() {
        FSElement element = fs.getRootDirs().get(0).getChildren().get(3);

        assertEquals(false, element.isDirectory());
    }




}