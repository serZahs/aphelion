package com.aphelion.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AphelionRunner implements CommandLineRunner {

    @Autowired
    private RestService service;

    @Override
    public void run(String... args) throws Exception {
        service.getSolData();
    }
}
