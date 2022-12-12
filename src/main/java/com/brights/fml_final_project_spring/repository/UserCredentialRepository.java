package com.brights.fml_final_project_spring.repository;

import com.brights.fml_final_project_spring.model.DTORegistration;
import com.brights.fml_final_project_spring.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCredentialRepository extends CrudRepository<DTORegistration,Long> {
    public DTORegistration findByUsername(String username);
    public DTORegistration findByUser(User user);
}
