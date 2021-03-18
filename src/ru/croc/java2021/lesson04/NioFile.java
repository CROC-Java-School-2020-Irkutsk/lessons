package ru.croc.java2021.lesson04;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class NioFile {
    public static void main(String[] args) throws IOException {
        final Path a = Paths.get("a.txt");

        final List<String> lines = Files.readAllLines(a);

        for (String line : lines) {
            System.out.println(line);
        }
    }
}
