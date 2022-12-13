package com.brights.fml_final_project_spring.service;

import com.brights.fml_final_project_spring.model.Post;
import com.brights.fml_final_project_spring.repository.PostRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Getter
    @Setter
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post savePost(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    public void deletePostById(long id) {

    }

    @Override
    public List<Post> getAllPosts() {
        return (List<Post>) postRepository.findAll();
    }


}


