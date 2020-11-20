package ru.croc.java2020.lesson06.callbacks;

import java.io.File;
import java.io.FileFilter;

public class PredicateUsage {
    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(
                new FileFilter() {
                    public boolean accept(File file) {
                        return file.isHidden();
                    }
                }
        );
    }
}
