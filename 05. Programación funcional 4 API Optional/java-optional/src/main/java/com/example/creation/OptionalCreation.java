package com.example.creation;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
of
ofNullable
findFirst
empty
 */
public class OptionalCreation {

    public static void main(String[] args) {

        // Método of
        Optional<String> textOpt = Optional.of("Hola mundo");

        // Métodos para comprobar si hay datos en el Optional:
        boolean isPresent = textOpt.isPresent();
        System.out.println(isPresent);

        boolean isEmpty = textOpt.isEmpty();
        System.out.println(isEmpty);

        // Método para extraer el dato del Optional
        String text = textOpt.get();
        System.out.println(text);

        Optional<String> javaHomeOpt = extractJavaHome();

        // findFirst
        List<String> texts = new ArrayList<>();
        texts.add("aaa1");
        texts.add("ccc1");
        texts.add("bbb1");
        texts.add("ddd1");
        texts.add("aaa2");

        Optional<String> strOpt = texts.stream()
                .filter(str -> str.startsWith("z"))
                .findFirst();

        System.out.println(strOpt.isEmpty());
//        System.out.println(strOpt != null); // queremos evitar trabajar directamente con null

        Optional<String> nameOpt = Optional.empty();
    }

    // Ejemplo ofNullable
    private static Optional<String> extractJavaHome() {
        String javaHome = System.getenv("INVENT");
//        return Optional.of(javaHome); // si el valor es nulo entonces of puede lanzar NullPointerException
        return Optional.ofNullable(javaHome); // ofNullable cuando el valor podría ser nulo
    }
}
