package com.example.jakartacdiejb.example3;

import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/example3")
public class MainController {

    @Inject
    Service service; // tipo abstracto

    @GET
    @Produces("text/plain")
    public String hello(){
        return service.hello();
    }

}
