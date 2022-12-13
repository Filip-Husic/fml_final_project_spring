package com.brights.fml_final_project_spring.service;

import com.brights.fml_final_project_spring.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long userId);

    User saveUser(User user);

    List<User> getAllUsers();
}
