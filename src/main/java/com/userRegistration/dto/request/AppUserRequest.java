package com.userRegistration.dto.request;

import lombok.Data;

@Data
public class AppUserRequest {
    private String firstname;
    private String lastname;
    private String password;
    private String email;
}
