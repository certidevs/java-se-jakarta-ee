package com.example.generics.interfaces;

@FunctionalInterface
public interface Converter<T, R> {

    R convert(T from);
}
