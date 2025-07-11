package com.innoxitsolution.spingbootproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/greetings")
    public String getGreeting(@RequestParam(defaultValue = "Guest")String name){
        return "Greetings ,"+ name +"!";
    }
}
