package ru.croc.java2021.lesson04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Scanner;

public class SystemIn {
    public static void main(String[] args) throws IOException {
        try (InputStream stream = System.in;
             /*Reader r = new InputStreamReader(stream);
             BufferedReader br = new BufferedReader(r);*/
             Scanner sc = new Scanner(stream)
        ) {
            System.out.println("Введите строку:");
//            final String line = br.readLine();
            final String line = sc.nextLine();
            System.out.println("Введена строка: " + line);

        }
    }
}
