package com.example;

public class Reverse {

    public static void main(String[] args) {
        String text = "ABC";

        String reversed = reverseIterative(text);
        System.out.println(reversed);

        reversed = reverseRecursive(text);
        System.out.println(reversed);

        reversed = reverseRecursiveTail(text, "");
        System.out.println(reversed);
    }




    private static String reverseIterative(String text) {

        byte[] textBytes = text.getBytes();
        byte[] result = new byte[textBytes.length];

        for(int i = 0; i < textBytes.length; i++){
            result[i] = textBytes[textBytes.length - i - 1];
        }

        return new String(result);
    }

    /*
    reverseRecursive("ABC")
    reverseRecursive("BC") + 'A'
    (reverseRecursive("C") + 'B') + 'A'
    ("C" + 'B') + 'A'
    "CB" + 'A'
    "CBA"

     */
    private static String reverseRecursive(String text) {
        if(text.isEmpty())
            return text;
        return reverseRecursive(text.substring(1)) + text.charAt(0);
    }

    // recursión mejorada
    /*
    reverseRecursiveTail("ABC", "")
    reverseRecursiveTail("BC", "A")
    reverseRecursiveTail("C", "BA")
    reverseRecursiveTail("", "CBA")
    "CBA"
     */
    private static String reverseRecursiveTail(String text, String acumulador) {
        if(text.isEmpty())
            return acumulador;
        return reverseRecursiveTail(text.substring(1), text.charAt(0) + acumulador);
    }

}
