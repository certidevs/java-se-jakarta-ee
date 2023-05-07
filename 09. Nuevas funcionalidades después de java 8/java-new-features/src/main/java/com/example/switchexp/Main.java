package com.example.switchexp;

public class Main {

    public static void main(String[] args) {

        String day = "Monday";
        switch(day){
            case "Monday":
                System.out.println("Hoy es monday!!");
                break;
            case "Tuesday":
                System.out.println("Hoy es tuesday!!");
                break;
            default:
                throw new IllegalArgumentException("");
        }

        switch (day){
            case "Monday" -> System.out.println("Hoy es monday!!");
            case "Tuesday" -> {
                System.out.println("Hoy es Tuesday1!!");
                System.out.println("Hoy es Tuesday2!!");
            }
            case "Wednesday" -> System.out.println("Hoy es Wednesday!!");
            default -> throw new IllegalArgumentException("");
        }


    }
}
