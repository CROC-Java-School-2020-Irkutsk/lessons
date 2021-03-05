package ru.croc.java2021.lesson02;

public class Application {
    public static void main(String[] args) {
        Point point = new Point();
        point.print();

        PointLombokExample pointLombokExample = new PointLombokExample();
        System.out.println(pointLombokExample.getX());
    }
}
