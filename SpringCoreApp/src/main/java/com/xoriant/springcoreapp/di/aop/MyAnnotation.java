package com.xoriant.springcoreapp.di.aop;



import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD,ElementType.FIELD, ElementType.TYPE} )
public @interface MyAnnotation {

    String compare() default "";
    String xyz() default "";

}

