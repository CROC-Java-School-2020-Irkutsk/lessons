package ru.croc.java2021.lesson02;

import lombok.Data;

/* компилятор, увидев аннотацию @Data, сгенерирует методы hashCode, equals,
 toString, getX, setX, getY и setY для этого класса */
@Data
public class PointLombokExample {
    private int x;
    private int y;

    public PointLombokExample() {
        this(0, 0);
    }

    public PointLombokExample(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println(this.toString());
    }
}
