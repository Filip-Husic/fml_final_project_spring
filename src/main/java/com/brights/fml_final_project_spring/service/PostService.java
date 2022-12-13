package com.brights.fml_final_project_spring.service;

import com.brights.fml_final_project_spring.model.Post;

import java.util.List;

public interface PostService{
    Post savePost(Post post);
    void deletePostById (long id);

    List<Post> getAllPosts();
}
