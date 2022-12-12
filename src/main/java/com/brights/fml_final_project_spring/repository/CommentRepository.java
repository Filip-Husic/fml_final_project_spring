package com.brights.fml_final_project_spring.repository;

import com.brights.fml_final_project_spring.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment,Long> {
}
