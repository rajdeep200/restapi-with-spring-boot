package com.rajdeep.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(value = "/hello-world")
    public String helloWorld () {
        return "Hello World";
    }

    @GetMapping(value = "/hello-world/{name}")
    public HelloWorld helloWorldBean (@PathVariable String name) {
        return new HelloWorld(String.format("Hello! %s", name));
    }
}
