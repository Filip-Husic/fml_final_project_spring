package com.brights.fml_final_project_spring.repository;

import com.brights.fml_final_project_spring.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
