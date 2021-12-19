package com.example.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Student {
    private Integer id;

    @NotBlank
    private String name;

    private String phone;
    private Integer rollNo;
    private int age;
}
