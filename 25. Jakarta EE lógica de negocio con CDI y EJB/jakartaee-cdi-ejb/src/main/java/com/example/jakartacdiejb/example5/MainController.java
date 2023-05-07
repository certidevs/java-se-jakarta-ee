package com.example.jakartacdiejb.example5;

import com.example.jakartacdiejb.example5.qualifier.Service3;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/example5")
public class MainController {

    @Inject
    @Service3
    Service service; // tipo abstracto

    @GET
    @Produces("text/plain")
    public String hello(){
        return service.hello();
    }

}
