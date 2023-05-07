package com.example.jakartacdiejb.example5.qualifier;

import jakarta.inject.Qualifier;

import java.lang.annotation.*;

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface Service2 {
}
