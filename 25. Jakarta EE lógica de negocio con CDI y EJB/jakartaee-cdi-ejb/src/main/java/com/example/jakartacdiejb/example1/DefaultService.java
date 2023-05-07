package com.example.jakartacdiejb.example1;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

//@RequestScoped
@ApplicationScoped
public class DefaultService {

    @PostConstruct
    public void init(){
        System.out.println("Construido DefaultService");
    }

    public String hello() {
        return "example1";
    }
}
