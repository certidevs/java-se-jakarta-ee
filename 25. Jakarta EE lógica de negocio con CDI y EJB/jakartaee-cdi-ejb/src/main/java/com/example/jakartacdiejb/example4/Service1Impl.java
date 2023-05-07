package com.example.jakartacdiejb.example4;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("service1")
public class Service1Impl implements Service{
    @Override
    public String hello() {
        return "example4 service1";
    }
}
