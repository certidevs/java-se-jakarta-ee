package com.example.wsapp;

import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface PersonService {

    Person findById(Long id);

    List<Person> findAll();

    Person save(Person person);
}
