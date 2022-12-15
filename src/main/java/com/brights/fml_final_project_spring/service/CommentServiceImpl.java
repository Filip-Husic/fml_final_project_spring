package com.brights.fml_final_project_spring.service;

import com.brights.fml_final_project_spring.model.Comment;
import com.brights.fml_final_project_spring.repository.CommentRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Getter
    @Setter
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment saveComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public Comment updateCommentById(long id, Comment comment) {
        Comment commentData = getCommentById(id);
        if(commentData != null) {
            commentData.setCommentContent(comment.getCommentContent());

            return commentData;
        }
        return null;
    }
}
