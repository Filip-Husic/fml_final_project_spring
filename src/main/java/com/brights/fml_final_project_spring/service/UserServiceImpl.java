package com.brights.fml_final_project_spring.service;

import com.brights.fml_final_project_spring.model.User;
import com.brights.fml_final_project_spring.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Getter
    @Setter
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUserById(long id, User user) {
        User userData = getUserById(id);
        if(userData != null) {
            userData.setEmail(user.getEmail());
            userData.setUsername(user.getUsername());
            userData.setPassword(user.getPassword());
            userData.setEnabled(user.isEnabled());
            return userData;
        }
        return null;
    }

    @Override
    public void deleteUserById(long id) {
        boolean exists = this.userRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("User with id " + id + " was not found.");
        }
        this.userRepository.deleteById(id);
    }
}
