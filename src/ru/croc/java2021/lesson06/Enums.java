package ru.croc.java2021.lesson06;

import java.util.Arrays;

public class Enums {

    public static void main(String[] args) {
        final DataTypes number = DataTypes.NUMBER;
        System.out.println(number);

        System.out.println(Arrays.toString(DataTypes.values()));

        final DataTypes string = DataTypes.valueOf("string");

        System.out.println(string);
    }

}

enum DataTypes {
    STRING,
    NUMBER
}
