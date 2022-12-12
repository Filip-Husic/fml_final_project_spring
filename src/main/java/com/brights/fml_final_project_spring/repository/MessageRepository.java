package com.brights.fml_final_project_spring.repository;

import com.brights.fml_final_project_spring.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message,Long> {
}
