package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class HelloRequest {

    private String id;
    @NotBlank(message = "Name must not be blank")
    private String name;

    @Past(message = "dob must be in the past")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "dob must not be null please input yyyy-MM-dd")
    private LocalDate dob;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
