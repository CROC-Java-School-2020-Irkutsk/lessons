package ru.croc.java2020.lesson08;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationExample {
    public static void main(String[] args) {
        /*final Reflections collect = Reflections.collect();

        collect.getAllTypes().forEach(System.out::println);*/

        final Class<User> userClass = User.class;

        final String name = userClass.getName();

        System.out.println("name = " + name);

        final Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            final Class<?> type = field.getType();
            System.out.println("type = " + type);
        }

        final Annotation[] annotations = userClass.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Inject) {
                final Inject inject = (Inject) annotation;
                final String value = inject.value();

                System.out.println("value = " + value);
            }
        }
    }
}
