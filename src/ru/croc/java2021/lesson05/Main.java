package ru.croc.java2021.lesson05;

/**
 * Стартовый класс.
 */
public class Main {

    /**
     * Пример входной строки.
     */
    public static final String INPUT_STRING = "Невежество есть мать промышленности, как и суеверий." +
        " Сила размышления и воображения подвержена ошибкам; но привычка двигать рукой или ногой" +
        " не зависит ни от того, ни от другого. Поэтому мануфактуры лучше всего процветают там, где" +
        " наиболее подавлена духовная жизнь, так что мастерская может рассматриваться как машина," +
        " части которой составляют люди.";

    /**
     * Шаблон поиска символов в строке.
     */
    public static final String TEMPLATE = " ";

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {

        long current = System.currentTimeMillis();

        int sum = 0;
        for (int i = 0; i < INPUT_STRING.length(); i++) {
            if (Matcher.match(String.valueOf(INPUT_STRING.charAt(i)), TEMPLATE)) {
                sum++;
            }
        }
        System.out.println("Count of space: " + sum);

        System.out.println("Time: " + (System.currentTimeMillis() - current) / 1000 + " c.");
    }
}