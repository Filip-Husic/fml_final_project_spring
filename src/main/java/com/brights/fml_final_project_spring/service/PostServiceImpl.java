package com.brights.fml_final_project_spring.service;

import com.brights.fml_final_project_spring.repository.PostRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Getter
    @Setter
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
