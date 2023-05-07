package com.example.jakartajpa.repository;

import com.example.jakartajpa.entities.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.enterprise.inject.Default;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;

import java.util.List;
import java.util.Optional;

/*
Cargar este bean por defecto cuando la unidad de persistencia
tenga asignado el tipo transaction-type="RESOURCE_LOCAL"
 */

@ApplicationScoped
public class EmployeeRepositoryImpl implements EmployeeRepository{

    // transaction-type="RESOURCE_LOCAL"
    @PersistenceUnit(name = "default")
    private EntityManagerFactory emf;

    @Override
    public List<Employee> findAll() {
        EntityManager em = emf.createEntityManager();
        String jpql = "select e from Employee e";
        List<Employee> employees = em.createQuery(jpql, Employee.class).getResultList();
        em.close();
        return employees;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        EntityManager em = emf.createEntityManager();
        var result = Optional.ofNullable(em.find(Employee.class, id));
        em.close();
        return result;
    }

    @Override
    public Employee save(Employee employee) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(employee);
            tx.commit(); // hace efectivos los cambios
        } catch(Exception e){
            if(tx != null && tx.isActive())
                tx.rollback(); // revierte los cambios
            throw e;
        } finally{
            if(em.isOpen())
                em.close();

        }
        return employee;
    }
}
