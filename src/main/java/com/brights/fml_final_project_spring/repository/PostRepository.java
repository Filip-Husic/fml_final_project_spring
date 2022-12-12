package com.brights.fml_final_project_spring.repository;

import com.brights.fml_final_project_spring.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
