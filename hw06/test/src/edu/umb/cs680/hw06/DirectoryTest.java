package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    public static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }

    public static String[] dirToStringArray(Directory d) {
        String parentName = "null";
        if (d.parent != null) {
            parentName = d.getParent().getName();
        }
        return new String[] {parentName, d.getName(), Integer.toString(d.getSize()),
                                    d.getCreationTime().toString()};
    }

    @Test
    public void testRootEquality() {
        Directory d = fs.getRootDirs().get(0);
        LocalDateTime date = LocalDateTime.of(2023, 4, 15, 12, 30, 0);
        String[] expected = {"null", "prjRoot", String.valueOf(0), date.toString()};
        assertArrayEquals(expected, dirToStringArray(d));
    }

    @Test
    public void testsrcEquality() {
        Directory d = (Directory) fs.getRootDirs().get(0).getChildren().get(0);
        LocalDateTime date = LocalDateTime.of(2023, 4, 15, 12, 30, 0);
        String[] expected = {"prjRoot", "src", String.valueOf(0), date.toString()};
        assertArrayEquals(expected, dirToStringArray(d));
    }

    @Test
    public void testlibEquality() {
        Directory d = (Directory) fs.getRootDirs().get(0).getChildren().get(1);
        LocalDateTime date = LocalDateTime.of(2023, 4, 15, 12, 30, 0);
        String[] expected = {"prjRoot", "lib", String.valueOf(0), date.toString()};
        assertArrayEquals(expected, dirToStringArray(d));
    }

    @Test
    public void testdirEquality() {
        Directory d = (Directory) fs.getRootDirs().get(0).getChildren().get(2);
        LocalDateTime date = LocalDateTime.of(2023, 4, 15, 12, 30, 0);
        String[] expected = {"prjRoot", "test", String.valueOf(0), date.toString()};
        assertArrayEquals(expected, dirToStringArray(d));
    }

    @Test
    public void src2dirEquality() {
        Directory e = (Directory) fs.getRootDirs().get(0).getChildren().get(2);
        Directory d = (Directory) e.getChildren().get(0);
        LocalDateTime date = LocalDateTime.of(2023, 4, 15, 12, 30, 0);
        String[] expected = {"test", "src", String.valueOf(0), date.toString()};
        assertArrayEquals(expected, dirToStringArray(d));
    }


    @Test
    public void totalSizeTestOnRootDir() {
        Directory root = fs.getRootDirs().get(0);
        assertEquals(100 , root.getTotalSize());
    }

    @Test
    public void subFilesTestOnRootDir() {
         Directory prjRoot = fs.getRootDirs().get(0);
         File x = (File) prjRoot.getChildren().get(3);
         LinkedList<File> subFiles = new LinkedList<>();
         subFiles.add(x);
         assertIterableEquals(subFiles, prjRoot.getSubFiles());
    }

    @Test
    public void subDirsTestOnRootDir() {
        Directory prjRoot = fs.getRootDirs().get(0);
        Directory a = (Directory) prjRoot.getChildren().get(0);
        Directory b = (Directory) prjRoot.getChildren().get(1);
        Directory c = (Directory) prjRoot.getChildren().get(2);
        LinkedList<Directory> expected = new LinkedList<>();
        expected.add(a);
        expected.add(b);
        expected.add(c);

        assertIterableEquals(expected, prjRoot.getSubDirectories());
    }

    @Test
    public void testingIsDirectoryOnRootDir() {
        Directory prjRoot = fs.getRootDirs().get(0);
        assertSame(true, prjRoot.isDirectory());
    }


}