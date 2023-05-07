package com.example.jakartacdiejb.example5;

import com.example.jakartacdiejb.example5.Service;
import com.example.jakartacdiejb.example5.qualifier.Service2;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Service2
public class Service2Impl implements Service {
    @Override
    public String hello() {
        return "example5 service2";
    }
}
