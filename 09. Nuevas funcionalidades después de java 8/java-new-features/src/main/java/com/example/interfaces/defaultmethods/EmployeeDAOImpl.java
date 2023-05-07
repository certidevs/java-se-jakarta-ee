package com.example.interfaces.defaultmethods;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public String saludo() {
        return "Hola mundo";
    }

    @Override
    public String despedida() {
//        return EmployeeDAO.super.despedida();
        return "Hasta nunca";
    }
}
