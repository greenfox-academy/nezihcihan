package com.greenfox.nezih.springproject.controller;

import com.greenfox.nezih.springproject.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloControllerTwo {

    @RequestMapping("/greeting")
    public List<Greeting> greeting() {
        return Arrays.asList(
                new Greeting("Hello world")
        );
    }
}
