package com.userRegistration.service.interfaces;

import com.userRegistration.dto.request.AppUserRequest;
import com.userRegistration.dto.response.AppUserResponse;

public interface AppUserService {


    AppUserResponse registerUser(AppUserRequest appUserRequest);





    boolean loginUser(String password, String email);

    boolean delete(String email);

}
