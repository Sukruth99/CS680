package edu.umb.cs680.hw12.fs;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement f1, FSElement f2) {
        return f1.getName().compareTo(f2.getName());
    }
}
