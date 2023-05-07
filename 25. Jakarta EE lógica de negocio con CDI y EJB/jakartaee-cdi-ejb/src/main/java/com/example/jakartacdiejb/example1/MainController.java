package com.example.jakartacdiejb.example1;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/example1")
public class MainController {

    // inyección por campo
    @Inject
    DefaultService service;

    // inyección por constructor (facilitar el testing)
//    @Inject
//    public MainController(DefaultService service) {
//        this.service = service;
//    }

    @GET
    @Produces("text/plain")
    public String hello(){
        return service.hello();
    }

}
