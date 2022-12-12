package com.brights.fml_final_project_spring.rest_controller;

import com.brights.fml_final_project_spring.model.DTORegistration;
import com.brights.fml_final_project_spring.model.User;
import com.brights.fml_final_project_spring.service.UserCredentialService;
import com.brights.fml_final_project_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final UserCredentialService userCredentialService;
    private final PasswordEncoder encoder;

    public UserController(UserService userService, PasswordEncoder encoder, UserCredentialService userCredentialService) {
        this.userService = userService;
        this.encoder = encoder;
        this.userCredentialService = userCredentialService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user, @RequestBody DTORegistration dtoRegistration) {
        try {
            dtoRegistration.setUser(userService.saveUser(new User(user.getFirstName(), user.getLastName(), user.getEmail())));
            dtoRegistration.setUsername(dtoRegistration.getUsername());
            dtoRegistration.setPassword1(encoder.encode(dtoRegistration.getPassword1()));
            dtoRegistration.setPassword2(encoder.encode(dtoRegistration.getPassword2()));
            dtoRegistration.setRoles("ROLE_USER");
            userCredentialService.saveUserCredential(dtoRegistration);

            return new ResponseEntity<>(dtoRegistration.getUser(), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
