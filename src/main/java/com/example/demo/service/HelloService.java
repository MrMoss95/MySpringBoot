package com.example.demo.service;

import com.example.demo.dto.HelloResponse;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public HelloResponse sayHello(String name) {
        return new HelloResponse(
                "Hello " + name,
                "Spring Boot"
        );
    }
}