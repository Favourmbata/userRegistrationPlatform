package com.userRegistration.service.interfaces;


import com.userRegistration.dto.request.AppUserRequest;
import com.userRegistration.dto.response.AppUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class AppUserServiceTest {

    @Autowired
    private AppUserService appUserService;
    private AppUserRequest appUserRequest;
    private AppUserRequest appUserRequest1;

    @BeforeEach
    void setUp() {
        appUserRequest = new AppUserRequest();
        appUserRequest.setFirstname("debby");
        appUserRequest.setLastname("igwe");
        appUserRequest.setEmail("favour063@gmail.com");
        appUserRequest.setPassword("2023");


        appUserRequest1 = new AppUserRequest();
        appUserRequest1.setFirstname("lucky");
        appUserRequest1.setLastname("kelly");
        appUserRequest1.setEmail("shola123@gmail.com");
        appUserRequest1.setPassword("2001");

    }

    @Test
    public void registerUser() {
        assertDoesNotThrow(() -> {
            appUserService.registerUser(appUserRequest);
//            appUserService.registerUser(appUserRequest1);
        });


    }

    @Test
    public void loginUser_WithEmailsAndPassword() {
        assertTrue(appUserService.loginUser("2023", appUserRequest.getEmail()));

    }

    @Test
    public void loginUserTwo_WithEmailsAndPassword() {
        assertTrue(appUserService.loginUser("2001", appUserRequest1.getEmail()));

    }

    @Test

    public void delete_UserTwo() {
        assertTrue(appUserService.delete("favour063@gmail.com"));

    }




}


