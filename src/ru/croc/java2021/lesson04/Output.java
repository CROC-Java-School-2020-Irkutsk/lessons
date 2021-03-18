package ru.croc.java2021.lesson04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Output {
    public static void main(String[] args) throws IOException {
        try (InputStream stream = new FileInputStream("a.txt");
             //Reader r = new InputStreamReader(stream, "WIN-1251");
             OutputStream ostream = new FileOutputStream("b.txt", true)
        ) {
            //stream.transferTo(ostream);

            final byte[] bytes = stream.readAllBytes();

            for (byte aByte : bytes) {
                ostream.write(aByte);
            }

            ostream.flush();
        }
    }
}
