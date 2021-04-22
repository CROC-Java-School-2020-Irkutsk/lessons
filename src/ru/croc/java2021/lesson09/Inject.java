package ru.croc.java2021.lesson09;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {
    ElementType.TYPE,
    ElementType.CONSTRUCTOR,
    ElementType.FIELD,
    ElementType.METHOD,
    ElementType.TYPE_PARAMETER
})
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
    String value() default "default";
}