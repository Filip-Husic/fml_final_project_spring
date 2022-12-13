package com.brights.fml_final_project_spring.rest_controller;

import com.brights.fml_final_project_spring.model.User;
import com.brights.fml_final_project_spring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
//    private final PasswordEncoder encoder;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User user1 = userService.saveUser(new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.getUsername(), user.getPassword(),user.isEnabled()));

            return new ResponseEntity<>(user1, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> showAllUsers(){
        try {
            List<User> userList = userService.getAllUsers();
            if (userList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(userList,HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
