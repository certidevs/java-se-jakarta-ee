package com.example.jakartacdiejb.example2;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Stateless
public class DefaultService implements Service{
    @Override
    public String hello() {
        return "example2";
    }
}
