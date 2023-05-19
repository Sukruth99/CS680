package edu.umb.cs680.hw12.fs;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement f1, FSElement f2) {
        return Integer.compare(f1.getSize(), f2.getSize());
    }
}
