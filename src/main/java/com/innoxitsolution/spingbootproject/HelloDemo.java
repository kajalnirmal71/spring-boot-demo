package com.innoxitsolution.spingbootproject;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDemo {
    @GetMapping("/hello")
    public String sayHello(){
        return"hello Spring Boot !";
    }

    }

