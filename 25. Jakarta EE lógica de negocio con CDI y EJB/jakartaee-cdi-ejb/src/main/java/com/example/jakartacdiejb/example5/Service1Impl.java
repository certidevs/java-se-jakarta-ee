package com.example.jakartacdiejb.example5;

import com.example.jakartacdiejb.example5.Service;
import com.example.jakartacdiejb.example5.qualifier.Service1;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Service1
public class Service1Impl implements Service {
    @Override
    public String hello() {
        return "example5 service1";
    }
}
