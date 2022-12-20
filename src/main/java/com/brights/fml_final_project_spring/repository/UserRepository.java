package com.brights.fml_final_project_spring.repository;

import com.brights.fml_final_project_spring.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@SuppressWarnings("unused")
public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    void deleteUserById(long id);
}
