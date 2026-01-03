package com.example.demo.dto;

import java.util.UUID;

public class HelloResponse {

    private String message;
    private String from;
    private String id;
    public HelloResponse(String message, String from) {
        this.message = message;
        this.from = from;
        this.id = UUID.randomUUID().toString();
    }

    public String getMessage() {
        return message;
    }

    public String getFrom() {
        return from;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
