package com.example.jakartacdiejb.example5;

import com.example.jakartacdiejb.example5.Service;
import com.example.jakartacdiejb.example5.qualifier.Service3;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Service3
public class Service3Impl implements Service {
    @Override
    public String hello() {
        return "example5 service3";
    }
}
