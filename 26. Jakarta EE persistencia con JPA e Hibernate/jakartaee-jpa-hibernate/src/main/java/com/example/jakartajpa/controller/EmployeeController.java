package com.example.jakartajpa.controller;

import com.example.jakartajpa.entities.Employee;
import com.example.jakartajpa.repository.EmployeeRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeController {

    @Inject
    EmployeeRepository repository;

    @GET
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Path("{id}")
    @GET
    public Response findById(@PathParam("id") Long id){
        return repository.findById(id)
                .map(employee -> Response.ok(employee).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response create(Employee employee){
        repository.save(employee);
        return Response.ok(employee).status(Response.Status.CREATED).build();
    }



}