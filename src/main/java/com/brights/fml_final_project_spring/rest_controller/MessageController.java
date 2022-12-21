package com.brights.fml_final_project_spring.rest_controller;

import com.brights.fml_final_project_spring.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {
    private final UserService userService;

    public MessageController(UserService userService) {
        this.userService = userService;
    }
}
