package com.example.generics.classes;

/*
Sin generics tendríamos que hacer casting continuamente
 */
public class RepositoryMain {

    public static void main(String[] args) {

        Repository<Customer> customerRepo = new Repository<Customer>();
        Customer customer1 = new Customer(1L, "customer1");
        customerRepo.setContent(customer1);
        customerRepo.getContent();


        Repository<Employee> employeeRepo = new Repository<Employee>();
        Employee employee1 = new Employee(1L, "customer1");
        employeeRepo.setContent(employee1);
        employeeRepo.getContent();
    }
}
