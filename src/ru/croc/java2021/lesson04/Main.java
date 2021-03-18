package ru.croc.java2021.lesson04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        try (InputStream stream = new FileInputStream("a.txt");
             //Reader r = new InputStreamReader(stream, "WIN-1251");
             OutputStream ostream = new FileOutputStream("b.txt")
        ) {

            //final String file = args[0];
            //new FileInputStream(file);

            byte[] bytes = new byte[512];


            final int length = stream.read(bytes, 10, 50);

            System.out.println("length is " + length);


            for (int i = 0; i < length; i++) {
                System.out.print((char) bytes[i]);
            }
        }

        System.out.println();
        System.out.println(Arrays.toString(args));
    }
}

