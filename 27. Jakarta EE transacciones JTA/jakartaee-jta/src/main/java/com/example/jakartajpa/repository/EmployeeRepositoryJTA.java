package com.example.jakartajpa.repository;

import com.example.jakartajpa.entities.Employee;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.enterprise.inject.Default;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transactional;
import jakarta.transaction.UserTransaction;

import java.util.List;
import java.util.Optional;

/*
Cargar este bean por defecto cuando la unidad de persistencia
tenga asignado el tipo transaction-type="JTA"
 */
@Default
//@Alternative
@ApplicationScoped
public class EmployeeRepositoryJTA implements EmployeeRepository {

    @PersistenceContext(unitName = "default")
    EntityManager em;

    @Override
    public List<Employee> findAll() {
        String jpql = "select e from Employee e";
        return em.createQuery(jpql, Employee.class).getResultList();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(em.find(Employee.class, id));
    }

    // Opción 1 forma programática
//    @Resource
//    private UserTransaction userTransaction;
//
//    @Override
//    public Employee save(Employee employee) {
//        try {
//            userTransaction.begin();
//            em.persist(employee);
//            userTransaction.commit(); // hace efectivos los cambios
//        } catch(Exception e){
//            if(userTransaction != null) {
//                try {
//                    userTransaction.rollback(); // revierte los cambios
//                } catch (SystemException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        }
//        return employee;
//    }

    // opción 2 forma declarativa
//    @Transactional()
    @Transactional(rollbackOn = Exception.class)
    @Override
    public Employee save(Employee employee) {
        em.persist(employee);
        return employee;
    }
}
