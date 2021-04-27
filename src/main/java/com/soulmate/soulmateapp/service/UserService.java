package com.soulmate.soulmateapp.service;

import com.soulmate.soulmateapp.domain.SoulmateUser;

import java.util.List;

public interface UserService {

    SoulmateUser saveUser(SoulmateUser user);
    List<SoulmateUser> getAllUsers();
    SoulmateUser updateUser(int id);
    List<SoulmateUser> deleteUser(int id);


}
