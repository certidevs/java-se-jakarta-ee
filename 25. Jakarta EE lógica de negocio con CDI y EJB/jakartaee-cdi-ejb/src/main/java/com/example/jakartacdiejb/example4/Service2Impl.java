package com.example.jakartacdiejb.example4;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("service2")
public class Service2Impl implements Service{
    @Override
    public String hello() {
        return "example4 service2";
    }
}
