package com.brights.fml_final_project_spring.service;

import com.brights.fml_final_project_spring.model.Post;

public interface PostService{
    Post savePost(Post post);
    void deletePostById (long id);
}
