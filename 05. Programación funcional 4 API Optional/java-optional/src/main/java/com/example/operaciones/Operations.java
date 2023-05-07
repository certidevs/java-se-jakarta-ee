package com.example.operaciones;

import java.util.Optional;

public class Operations {

    public static void main(String[] args) {

        Optional<String> nameOpt = Optional.of("Hola mundo");



        // map
        Optional<Integer> upperName = nameOpt
                .map(name -> name.toUpperCase())
                .map(name -> name.replace(" ", ""))
                .map(name -> name.length());

        System.out.println(upperName.get());

        // map + filter
        Optional<Integer> upperName0 = nameOpt
                .map(name -> name.toUpperCase())
                .filter(name -> name.length() > 3) // en caso de que no se cumpla el filtro entonces el Optional será empty
                .map(name -> name.replace(" ", ""))
                .map(name -> name.length());

        // ifPresent
        Optional<String> nameOpt2 = Optional.empty();
        Optional<Integer> upperName2 = nameOpt2
                .map(name -> name.toUpperCase())
                .map(name -> name.replace(" ", ""))
                .map(name -> name.length());

        if(upperName2.isPresent())
            System.out.println(upperName2.get());

            // equivalente en expresión funcional, es más sencillo
        upperName2.ifPresent(System.out::println);

        upperName2.ifPresentOrElse(System.out::println, () -> System.out.println("No hay valor"));

        // orElse: retorna el valor original si es que lo hay o devuelve un número por defecto
        Integer nameLength = upperName2.orElse(10);
        System.out.println(nameLength); // 10

        // or: utiliza Supplier para proporcional un Optional por defecto en caso de que el primero sea empty
        Optional<Integer> nameLengthOpt = upperName2.or(() -> Optional.of(10));

        // orElseThrow
        // Integer length = upperName2.orElseThrow(); // NoSuchElementException: No value present

        Integer length2 = upperName2.orElseThrow(() -> new NotFoundException("No hay texto"));
    }
}
