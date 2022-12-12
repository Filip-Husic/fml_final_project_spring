package com.brights.fml_final_project_spring.service;

import com.brights.fml_final_project_spring.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Getter
    @Setter
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
