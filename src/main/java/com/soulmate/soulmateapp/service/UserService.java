package com.soulmate.soulmateapp.service;

import com.soulmate.soulmateapp.domain.SoulmateUser;

import java.util.List;

public interface UserService {

    SoulmateUser saveUser(SoulmateUser user);
    List<SoulmateUser> getAllUsers();
    SoulmateUser updateUser(Integer id, SoulmateUser user);
    void deleteUser(int id);
    List<SoulmateUser> getAllUsersbyGender(String gender);


}
