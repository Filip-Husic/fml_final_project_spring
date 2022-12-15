package com.brights.fml_final_project_spring.service;


import com.brights.fml_final_project_spring.model.Comment;

public interface CommentService {
    Comment saveComment(Comment comment);
    Comment getCommentById(Long commentId);
    Comment updateCommentById(long commentId, Comment comment);
}
