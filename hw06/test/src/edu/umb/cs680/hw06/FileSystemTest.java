package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    public static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void checkingIfSingleton () {
        FileSystem a = FileSystem.getFileSystem();
        FileSystem b = FileSystem.getFileSystem();
        assertSame(a, b);
    }

    @Test
    public void checkingIfInstanceIsNotNull () {
        assertNotNull(fs);
    }

    @Test
    public void countOfRootDirsTest() {
        setUpFS();
        assertEquals(1, fs.countRootDir());
    }

    @Test
    public void testForAppendRoot() {
        FileSystem a = FileSystem.getFileSystem();
        a.clearRootDir();

        Directory root1 = new Directory(null, "root1", LocalDateTime.now());
        Directory root2 = new Directory(null, "root2", LocalDateTime.now());
        Directory root3 = new Directory(null, "root3", LocalDateTime.now());

        a.appendRootDir(root1);
        a.appendRootDir(root2);
        a.appendRootDir(root3);


        List<Directory> expected = List.of(root1, root2, root3);
        assertIterableEquals(expected, a.getRootDirs());
    }

}