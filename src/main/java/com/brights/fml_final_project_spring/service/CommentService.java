package com.brights.fml_final_project_spring.service;


import com.brights.fml_final_project_spring.model.Comment;
import com.brights.fml_final_project_spring.model.Post;

import java.util.List;

public interface CommentService {
    Comment saveComment(Comment comment);
}
