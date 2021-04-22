package ru.croc.java2021.lesson09;



import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationExample {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {

        final Class<User> userClass = User.class;

        final String name = userClass.getName();

        System.out.println("name = " + name);

        final User user = new User();

        final Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            final Class<?> type = field.getType();
            System.out.println("type = " + type);
        }

        final Field id = userClass.getDeclaredField("id");
        id.setAccessible(
            true
        );
        id.set(user, 1);

        final Field username = userClass.getDeclaredField("name");
        username.setAccessible(
            true
        );
        username.set(user, "John");


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