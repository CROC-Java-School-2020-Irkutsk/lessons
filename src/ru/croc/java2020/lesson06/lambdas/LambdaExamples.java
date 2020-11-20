package ru.croc.java2020.lesson06.lambdas;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaExamples {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi");
            }
        };

        Runnable r2 = () -> System.out.println("Hi");
        Runnable r3 = System.out::println;

        r.run();
        r3.run();
        r2.run();


        Supplier<String> s1 = () -> supply();

        System.out.println(s1.get());


        Consumer<String> stringConsumer = s -> System.out.println(s);
        Consumer<String> otherConsumer = stringConsumer.andThen(s -> System.out.println("and other " + s));

        otherConsumer.accept("consumer");

        Function<Integer, String> intFunction = (i) -> "" + (i + 1);

        String result = intFunction.apply(5);
        System.out.println(result);
    }


    public static String supply() {
        return "supplier";
    }
}
