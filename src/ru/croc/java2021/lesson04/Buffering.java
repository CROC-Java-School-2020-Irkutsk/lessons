package ru.croc.java2021.lesson04;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.SequenceInputStream;

public class Buffering {
    public static void main(String[] args) throws IOException {
        try (
            InputStream streamA = new FileInputStream("a.txt");
            InputStream streamB = new FileInputStream("b.txt");
            InputStream seq = new SequenceInputStream(streamA, streamB);

             Reader r = new InputStreamReader(seq);
             BufferedReader bufReader = new BufferedReader(r)
        ) {
            /*String line = null;
            while ((line = bufReader.readLine()) != null) {
                System.out.println(line);

            }*/

            bufReader
                .lines()
                .forEach(str -> {
                    System.out.println(str);
                });
        }
    }
}
