package ru.croc.java2020.lesson06.callbacks;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CallbackUsage {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME;
        CompletableFuture
                .runAsync(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(LocalTime.now().format(formatter));
                    }
                })
                .get();
    }
}
