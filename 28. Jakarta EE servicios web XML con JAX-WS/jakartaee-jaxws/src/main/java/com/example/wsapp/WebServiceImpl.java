package com.example.wsapp;

import jakarta.jws.WebService;

//@WebService(endpointInterface = "com.example.wsapp.WebServiceInterface")
@WebService
public class WebServiceImpl implements WebServiceInterface{
    @Override
    public String helloWorld(String str) {
        return "Hello world from web service " + str;
    }
}
