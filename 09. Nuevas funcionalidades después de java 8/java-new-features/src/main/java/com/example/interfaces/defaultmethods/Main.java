package com.example.interfaces.defaultmethods;

public class Main {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        System.out.println(employeeDAO.saludo());
        System.out.println(employeeDAO.despedida());
    }
}
