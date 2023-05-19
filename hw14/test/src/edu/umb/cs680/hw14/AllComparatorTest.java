package edu.umb.cs680.hw14;

import edu.umb.cs680.hw14.fs.*;
import edu.umb.cs680.hw14.fs.util.FileSearchVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class AllComparatorTest {

    private static FileSystem fs;
    private static Directory prjRoot;
    private static Directory src;
    @BeforeAll
    public static void initialize() {
        fs = TestFixtureInitializer.createFS();
        prjRoot = fs.getRootDirs().get(0);
        src = prjRoot.getSubDirectories().get(1);
    }

    public static LinkedList<File> combine(LinkedList<File> one, LinkedList<File> two) {
        LinkedList<File> result = new LinkedList<>();
        for (File f : one) {
            result.add(f);
        }
        for (File f: two) {
            result.add(f);
        }
        return result;
    }

    @Test
    public void subDirecTestAplhaComp() {
        LinkedList<Directory> directories = src.getSubDirectories(
                (FSElement f1, FSElement f2) -> {
                    return f1.getName().compareTo(f2.getName());
                });
        LinkedList<Directory> expectation = new LinkedList<>();
        assertIterableEquals(expectation, directories);
    }

    @Test
    public void subFilesTestAplhaComp() {
        LinkedList<File> files = src.getSubFiles(
                (FSElement f1, FSElement f2) -> {
                    return f1.getName().compareTo(f2.getName());
                });
        FileSearchVisitor a = new FileSearchVisitor("a");
        FileSearchVisitor b = new FileSearchVisitor("b");
        prjRoot.accept(a);
        prjRoot.accept(b);
        LinkedList<File> expectation = combine(a.getFoundFiles(), b.getFoundFiles());
        assertIterableEquals(expectation, files);
    }

    @Test
    public void subFilesTestRevAplhaComp() {
        LinkedList<File> files = src.getSubFiles(
                (FSElement f1, FSElement f2) -> {
                    return f2.getName().compareTo(f1.getName());
                });
        FileSearchVisitor a = new FileSearchVisitor("a");
        FileSearchVisitor b = new FileSearchVisitor("b");
        prjRoot.accept(a);
        prjRoot.accept(b);
        LinkedList<File> expectation = combine(b.getFoundFiles(), a.getFoundFiles());
        assertIterableEquals(expectation, files);
    }

    @Test
    public void subFilesTestSizeComp() {
        LinkedList<File> files = src.getSubFiles(
                (FSElement f1, FSElement f2) -> {
                    return Integer.compare(f1.getSize(), f2.getSize());
                });
        FileSearchVisitor a = new FileSearchVisitor("a");
        FileSearchVisitor b = new FileSearchVisitor("b");
        prjRoot.accept(a);
        prjRoot.accept(b);
        LinkedList<File> expectation = combine(a.getFoundFiles(), b.getFoundFiles());
        assertIterableEquals(expectation, files);
    }

}