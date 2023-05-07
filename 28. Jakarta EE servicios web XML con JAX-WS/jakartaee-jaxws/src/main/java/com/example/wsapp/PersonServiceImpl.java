package com.example.wsapp;

import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com.example.wsapp.PersonService")
public class PersonServiceImpl implements PersonService{

    List<Person> persons = new ArrayList<>();

    public PersonServiceImpl() {
        this.persons.add(new Person(1L, "person1", 20));
        this.persons.add(new Person(2L, "person2", 20));
        this.persons.add(new Person(3L, "person3", 20));
    }

    @Override
    public Person findById(Long id) {
        return persons.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst().orElseThrow();
    }

    @Override
    public List<Person> findAll() {
        return persons;
    }

    @Override
    public Person save(Person person) {
        this.persons.add(person);
        return person;
    }
}
