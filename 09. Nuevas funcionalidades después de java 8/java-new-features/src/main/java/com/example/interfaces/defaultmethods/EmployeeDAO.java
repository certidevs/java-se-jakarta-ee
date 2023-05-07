package com.example.interfaces.defaultmethods;

public interface EmployeeDAO {

    String saludo();

    default String despedida() {
        return "Hasta luego";
    }
}
