package com.example.jakartacdiejb.example3;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;

@Default
@ApplicationScoped
public class DefaultService implements Service {
    @Override
    public String hello() {
        return "default example3";
    }
}
