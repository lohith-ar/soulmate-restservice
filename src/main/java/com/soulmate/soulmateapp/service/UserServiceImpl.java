package com.soulmate.soulmateapp.service;

import com.soulmate.soulmateapp.domain.SoulmateUser;
import com.soulmate.soulmateapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userrepo;

    @Autowired
    public UserServiceImpl(UserRepository userrepo) {
        this.userrepo = userrepo;
    }

    @Override
    public SoulmateUser saveUser(SoulmateUser user) {
        return userrepo.save(user);
    }

    @Override
    public List<SoulmateUser> getAllUsers() {
        return (List<SoulmateUser>) userrepo.findAll();
    }

    @Override
    public SoulmateUser updateUser(int id) {
        for (SoulmateUser suser: getAllUsers()) {
            if(suser.getId()== id){

                return suser;
            }
        }

        return null;
    }

    @Override
    public List<SoulmateUser> deleteUser(int id) {
        List<SoulmateUser> tempuser = getAllUsers();
        for (SoulmateUser suser: tempuser) {
            if(suser.getId()== id){
                tempuser.remove(suser);
                return tempuser;
            }
        }
        return null;
    }


}
