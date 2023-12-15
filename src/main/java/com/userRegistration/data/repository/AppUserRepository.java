package com.userRegistration.data.repository;

import com.userRegistration.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository < AppUser , Long>  {


    boolean existsByEmail(String email);

    AppUser findByEmail(String email);

}