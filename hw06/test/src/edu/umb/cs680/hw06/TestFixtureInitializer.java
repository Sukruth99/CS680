package edu.umb.cs680.hw06;

import java.time.LocalDateTime;

public class TestFixtureInitializer {

    public static FileSystem createFS() {
        FileSystem fs = FileSystem.getFileSystem();
        LocalDateTime date = LocalDateTime.of(2023, 4, 15, 12, 30, 0);
        fs.clearRootDir();

        //prjRoot Directory
        Directory prjRoot = new Directory(null ,"prjRoot", date);
        Directory src1 = new Directory(prjRoot, "src", date);
        Directory lib = new Directory(prjRoot, "lib", date);
        Directory test = new Directory(prjRoot, "test", date);
        File x = new File(prjRoot, "x", 10, date);
        prjRoot.appendChild(src1);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        prjRoot.appendChild(x);

        // src Directory
        File a = new File(src1, "a", 20, date);
        File b = new File(src1, "b", 20, date);
        src1.appendChild(a);
        src1.appendChild(b);

        // lib Directory
        File c = new File(lib, "c", 20, date);
        lib.appendChild(c);

        //test directory
        Directory src2 = new Directory(test, "src", date);
        test.appendChild(src2);

        // src directory
        File d = new File(src2,"d", 30, date);
        src2.appendChild(d);


        fs.appendRootDir(prjRoot);
        return fs;
    }

}
