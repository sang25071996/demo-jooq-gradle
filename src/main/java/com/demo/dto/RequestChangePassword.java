package com.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestChangePassword {
    private String oldPassword;
    private String newPassword;
}
