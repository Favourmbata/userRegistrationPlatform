package com.userRegistration.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data


public class AppUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private boolean isLogin;
    private LocalDateTime dateCreated;


    public void isLogin(boolean login) {

    }
}
