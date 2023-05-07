package com.example.jakartacdiejb.example3;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

@Alternative
@ApplicationScoped
public class AlternativeService implements Service{
    @Override
    public String hello() {
        return "alternative example3";
    }
}
