package com.userRegistration.service.implementations;

import com.userRegistration.data.model.AppUser;
import com.userRegistration.data.repository.AppUserRepository;
import com.userRegistration.dto.request.AppUserRequest;
import com.userRegistration.dto.response.AppUserResponse;
import com.userRegistration.service.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@Service
public class AppUserImplementation implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Override
    public AppUserResponse registerUser(AppUserRequest appUserRequest) {
        if (appUserRepository.existsByEmail(appUserRequest.getEmail()))
            throw new RuntimeException("Email already exist");
        AppUser appUser = new AppUser();
        appUser.setEmail(appUserRequest.getEmail());
        appUser.setFirstname(appUserRequest.getFirstname());
        appUser.setLastname(appUserRequest.getLastname());
        appUser.setPassword(appUserRequest.getPassword());
        appUser.setDateCreated(LocalDateTime.now());
        AppUser appSaver = appUserRepository.save(appUser);

        AppUserResponse appUserResponse = new AppUserResponse();
        appUserResponse.setFirstName(appSaver.getFirstname());
        appUserResponse.setLastname(appSaver.getLastname());
        appUserResponse.setEmail(appSaver.getEmail());

        return appUserResponse;
    }

    @Override
    public boolean loginUser(String password, String email) {
        AppUser foundUser = appUserRepository.findByEmail(email);
        if (foundUser.getPassword().equalsIgnoreCase(password)) {
            foundUser.setLogin(true);
            appUserRepository.save(foundUser);
        }

        return foundUser.isLogin();
    }

    @Override
    public boolean delete(String email) {
        AppUser oldUser = appUserRepository.findByEmail(email);
        appUserRepository.delete(oldUser);

        if(!appUserRepository.existsByEmail(email))return true;

        return false;
    }

}
