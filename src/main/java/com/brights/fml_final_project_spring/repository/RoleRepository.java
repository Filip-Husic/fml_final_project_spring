package com.brights.fml_final_project_spring.repository;

import com.brights.fml_final_project_spring.model.ERole;
import com.brights.fml_final_project_spring.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
