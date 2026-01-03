package com.example.demo.controller;

import com.example.demo.dto.HelloRequest;
import com.example.demo.dto.HelloResponse;
import com.example.demo.service.HelloService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public HelloResponse getHello(
            @RequestParam(defaultValue = "World") String name
    ) {
        return helloService.sayHello(name);
    }

    @PostMapping
    public HelloResponse createHello(
            @Valid @RequestBody HelloRequest request
    ) {
        return helloService.sayHello(request.getName());
    }
}
