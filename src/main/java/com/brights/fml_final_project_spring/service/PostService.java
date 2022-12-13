package com.brights.fml_final_project_spring.service;

import com.brights.fml_final_project_spring.model.Post;
import com.brights.fml_final_project_spring.model.User;

import java.util.List;

public interface PostService{
    Post savePost(Post post);
    Post updatePostById(long id, Post post);
    void deletePostById (long id);
    Post getPostById(Long postId);
    List<Post> getAllPosts();
}
