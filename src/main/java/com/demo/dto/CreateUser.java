package com.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateUser {
    private String email;
    private String firstName;
    private String lastName;
    private String exp;
    private String picture;
}
