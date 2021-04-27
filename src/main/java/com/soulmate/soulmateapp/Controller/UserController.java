package com.soulmate.soulmateapp.Controller;

import com.soulmate.soulmateapp.domain.SoulmateUser;
import com.soulmate.soulmateapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/adduser")
    public ResponseEntity<SoulmateUser> saveUSer(@RequestBody SoulmateUser smuser){
        SoulmateUser user = userService.saveUser(smuser);
        return new ResponseEntity<SoulmateUser>(user, HttpStatus.CREATED);
    }

    @GetMapping("/allusers/{age}")
    public ResponseEntity<List<SoulmateUser>> getUsers(@PathVariable(value="age") Integer age1){
        List<SoulmateUser> userAge = (List<SoulmateUser>) userService.getAllUsers().stream().filter( (user1) -> user1.getAge()==age1 );

        return new ResponseEntity<List<SoulmateUser>>(userAge ,HttpStatus.OK);
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<List<SoulmateUser>> updateUser(@PathVariable(value="id") Integer id1,
                                                         @RequestBody SoulmateUser user){
        SoulmateUser suser = userService.updateUser(id1);
        suser.setAge(user.getAge());
        suser.setGender(user.getGender());
        suser.setName(user.getName());
        return new ResponseEntity<List<SoulmateUser>>((List<SoulmateUser>) suser, HttpStatus.OK);
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<List<SoulmateUser>> deleteUser(@PathVariable(value="id") Integer id1){
       return new ResponseEntity<List<SoulmateUser>>( userService.deleteUser(id1), HttpStatus.OK);
    }
}
