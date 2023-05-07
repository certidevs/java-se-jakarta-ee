package com.example.jakartacdiejb.example2;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/example2")
public class MainController {

    @Inject
    Service service; // tipo abstracto

    @GET
    @Produces("text/plain")
    public String hello(){
        return service.hello();
    }

}
